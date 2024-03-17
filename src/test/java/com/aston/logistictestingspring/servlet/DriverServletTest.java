package com.aston.logistictestingspring.servlet;

import com.aston.logistictestingspring.model.DriverEntity;
import com.aston.logistictestingspring.service.DriverService;
import com.aston.logistictestingspring.servlet.dto.DriverDto;
import com.aston.logistictestingspring.servlet.mapper.DriverMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class DriverServletTest {
    private DriverService service;
    private DriverMapper mapper;
    private static DriverEntity driverEntity1;
    private static DriverEntity driverEntity2;
    private static List<DriverEntity> driverEntities;
    private static List<DriverDto> driverDtos;
    private static DriverDto driverDto1;
    private static DriverDto driverDto2;
    private  MockMvc mockMvc;
    private static ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() {
        objectMapper = new ObjectMapper();

        driverEntity1 = new DriverEntity();
        driverEntity1.setSurname("Surname1");
        driverEntity1.setName("Name1");
        driverEntity1.setPatronymic("Patronymic1");

        driverEntity2 = new DriverEntity();
        driverEntity2.setSurname("Surname2");
        driverEntity2.setName("Name2");
        driverEntity2.setPatronymic("Patronymic2");

        driverEntities = List.of(driverEntity1, driverEntity2);

        driverDto1 = new DriverDto();
        driverDto1.setSurname("Surname1");
        driverDto1.setName("Name1");
        driverDto1.setPatronymic("Patronymic1");

        driverDto2 = new DriverDto();
        driverDto2.setSurname("Surname2");
        driverDto2.setName("Name2");
        driverDto2.setPatronymic("Patronymic2");

        driverDtos = List.of(driverDto1, driverDto2);
    }

    @BeforeEach
    void setUp() {
        service = mock(DriverService.class);
        mapper = mock(DriverMapper.class);
        mockMvc = standaloneSetup(new DriverServlet(service, mapper)).build();

        when(mapper.entityToDto(any(DriverEntity.class))).thenReturn(driverDto1);
        when(mapper.dtoToEntity(any(DriverDto.class))).thenReturn(driverEntity1);
        when(mapper.entityToDtoList(driverEntities)).thenReturn(driverDtos);
    }

    @Test
    void getById() throws Exception {
        when(service.findById(1)).thenReturn(driverEntity1);
        String driverDtoAsString = objectMapper.writeValueAsString(driverDto1);
        mockMvc.perform(get("/drivers/{id}", 1))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDtoAsString));
        verify(mapper, times(1)).entityToDto(driverEntity1);
        verify(service, times(1)).findById(1);
    }

    @Test
    void getAll() throws Exception {
        when(service.findAll()).thenReturn(driverEntities);
        String driverDtosAsString = objectMapper.writeValueAsString(driverDtos);
        mockMvc.perform(get("/drivers"))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDtosAsString));
        verify(service, times(1)).findAll();
        verify(mapper, times(1)).entityToDtoList(driverEntities);
    }

    @Test
    void save() throws Exception {
        when(service.save(any(DriverEntity.class))).thenReturn(driverEntity1);
        String driverDto1AsString = objectMapper.writeValueAsString(driverDto1);
        mockMvc.perform(post("/drivers")
                    .content(driverDto1AsString)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDto1AsString));
        verify(service, times(1)).save(any(DriverEntity.class));
        verify(mapper, times(1)).dtoToEntity(any(DriverDto.class));
        verify(mapper, times(1)).entityToDto(any(DriverEntity.class));
    }

    @Test
    void doDelete() throws Exception {
        mockMvc.perform(delete("/drivers").param("id", "1"))
                .andExpectAll(status().isOk());
        verify(service, times(1)).delete(anyInt());
    }
}