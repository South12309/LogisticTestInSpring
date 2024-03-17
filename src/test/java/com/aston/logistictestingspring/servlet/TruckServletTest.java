package com.aston.logistictestingspring.servlet;

import com.aston.logistictestingspring.model.TruckEntity;
import com.aston.logistictestingspring.service.TruckService;
import com.aston.logistictestingspring.servlet.dto.TruckDto;
import com.aston.logistictestingspring.servlet.mapper.TruckMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class TruckServletTest {
    private static TruckService service;
    private static TruckMapper mapper;
    private static TruckEntity truckEntity1;
    private static TruckEntity truckEntity2;
    private static List<TruckEntity> truckEntities;
    private static TruckDto truckDto1;
    private static TruckDto truckDto2;
    private static List<TruckDto> truckDtos;
    private MockMvc mockMvc;
    private static ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() {
        objectMapper = new ObjectMapper();

        truckEntity1 = new TruckEntity();
        truckEntity1.setModel("Man1");
        truckEntity1.setNumber("A009AA09");

        truckEntity2 = new TruckEntity();
        truckEntity2.setModel("Man2");
        truckEntity2.setNumber("A900AA09");

        truckEntities = List.of(truckEntity1, truckEntity2);

        truckDto1 = new TruckDto();
        truckDto1.setModel("Man1");
        truckDto1.setNumber("A009AA09");

        truckDto2 = new TruckDto();
        truckDto2.setModel("Man2");
        truckDto2.setNumber("A900AA09");

        truckDtos = List.of(truckDto1, truckDto2);
    }

    @BeforeEach
    void setUp() {
        service = mock(TruckService.class);
        mapper = mock(TruckMapper.class);
        mockMvc = standaloneSetup(new TruckServlet(service, mapper)).build();

        when(mapper.entityToDto(any(TruckEntity.class))).thenReturn(truckDto1);
        when(mapper.dtoToEntity(any(TruckDto.class))).thenReturn(truckEntity1);
        when(mapper.entityToDtoList(truckEntities)).thenReturn(truckDtos);

    }

    @Test
    void getById() throws Exception {
        when(service.findById(1)).thenReturn(truckEntity1);
        String driverDtoAsString = objectMapper.writeValueAsString(truckDto1);
        mockMvc.perform(get("/trucks/{id}", 1))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDtoAsString));
        verify(mapper, times(1)).entityToDto(truckEntity1);
        verify(service, times(1)).findById(1);
    }

    @Test
    void getAll() throws Exception {
        when(service.findAll()).thenReturn(truckEntities);
        String driverDtosAsString = objectMapper.writeValueAsString(truckDtos);
        mockMvc.perform(get("/trucks"))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDtosAsString));
        verify(service, times(1)).findAll();
        verify(mapper, times(1)).entityToDtoList(truckEntities);
    }

    @Test
    void save() throws Exception {
        when(service.save(any(TruckEntity.class))).thenReturn(truckEntity1);
        String driverDto1AsString = objectMapper.writeValueAsString(truckDto1);
        mockMvc.perform(post("/trucks")
                        .content(driverDto1AsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDto1AsString));
        verify(service, times(1)).save(any(TruckEntity.class));
        verify(mapper, times(1)).dtoToEntity(any(TruckDto.class));
        verify(mapper, times(1)).entityToDto(any(TruckEntity.class));
    }

    @Test
    void doDelete() throws Exception {
        mockMvc.perform(delete("/trucks").param("id", "1"))
                .andExpectAll(status().isOk());
        verify(service, times(1)).delete(anyInt());

    }

}