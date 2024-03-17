package com.aston.logistictestingspring.servlet;

import com.aston.logistictestingspring.model.ParkingEntity;
import com.aston.logistictestingspring.service.ParkingService;
import com.aston.logistictestingspring.servlet.dto.ParkingDto;
import com.aston.logistictestingspring.servlet.mapper.ParkingMapper;
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

class ParkingServletTest {
    private static ParkingService service;
    private static ParkingMapper mapper;
    private static ParkingEntity parkingEntity1;
    private static ParkingEntity parkingEntity2;
    private static List<ParkingEntity> parkingEntities;
    private static List<ParkingDto> parkingDtos;
    private static ParkingDto parkingDto1;
    private static ParkingDto parkingDto2;
    private MockMvc mockMvc;
    private static ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() {
        objectMapper = new ObjectMapper();

        parkingEntity1 = new ParkingEntity();
        parkingEntity1.setAddress("Minvodi");
        parkingEntity1.setSquare(40);

        parkingEntity2 = new ParkingEntity();
        parkingEntity2.setAddress("Zheleznovodsk");
        parkingEntity2.setSquare(50);

        parkingEntities = List.of(parkingEntity1, parkingEntity2);

        parkingDto1 = new ParkingDto();
        parkingDto1.setAddress("Minvodi");
        parkingDto1.setSquare(40);

        parkingDto2 = new ParkingDto();
        parkingDto2.setAddress("Zheleznovodsk");
        parkingDto2.setSquare(50);

        parkingDtos = List.of(parkingDto1, parkingDto2);
    }

    @BeforeEach
    void setUp() {
        service = mock(ParkingService.class);
        mapper = mock(ParkingMapper.class);
        mockMvc = standaloneSetup(new ParkingServlet(service, mapper)).build();

        when(mapper.entityToDto(any(ParkingEntity.class))).thenReturn(parkingDto1);
        when(mapper.dtoToEntity(any(ParkingDto.class))).thenReturn(parkingEntity1);
        when(mapper.entityToDtoList(parkingEntities)).thenReturn(parkingDtos);
    }

    @Test
    void getById() throws Exception {
        when(service.findById(1)).thenReturn(parkingEntity1);
        String driverDtoAsString = objectMapper.writeValueAsString(parkingDto1);
        mockMvc.perform(get("/parkings/{id}", 1))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDtoAsString));
        verify(mapper, times(1)).entityToDto(parkingEntity1);
        verify(service, times(1)).findById(1);

    }

    @Test
    void getAll() throws Exception {
        when(service.findAll()).thenReturn(parkingEntities);
        String driverDtosAsString = objectMapper.writeValueAsString(parkingDtos);
        mockMvc.perform(get("/parkings"))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDtosAsString));
        verify(service, times(1)).findAll();
        verify(mapper, times(1)).entityToDtoList(parkingEntities);

    }

    @Test
    void save() throws Exception {
        when(service.save(any(ParkingEntity.class))).thenReturn(parkingEntity1);
        String driverDto1AsString = objectMapper.writeValueAsString(parkingDto1);
        mockMvc.perform(post("/parkings")
                        .content(driverDto1AsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().string(driverDto1AsString));
        verify(service, times(1)).save(any(ParkingEntity.class));
        verify(mapper, times(1)).dtoToEntity(any(ParkingDto.class));
        verify(mapper, times(1)).entityToDto(any(ParkingEntity.class));

    }

    @Test
    void doDelete() throws Exception {
        mockMvc.perform(delete("/parkings").param("id", "1"))
                .andExpectAll(status().isOk());
        verify(service, times(1)).delete(anyInt());
    }
}