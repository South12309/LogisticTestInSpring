package com.aston.logistictestingspring.servlet;

import com.aston.logistictestingspring.model.DriverEntity;
import com.aston.logistictestingspring.model.ParkingEntity;
import com.aston.logistictestingspring.service.ParkingService;
import com.aston.logistictestingspring.servlet.dto.DriverDto;
import com.aston.logistictestingspring.servlet.dto.ParkingDto;
import com.aston.logistictestingspring.servlet.mapper.ParkingMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ParkingServletTest {

    private static ParkingServlet servlet;
    @Mock
    private static ParkingService service;
    private static ParkingMapper mapper;
    private static ParkingEntity parkingEntity1;
    private static ParkingEntity parkingEntity2;
    private static List<ParkingEntity> parkingEntities;
    private static ParkingDto parkingDto1;

    @BeforeAll
    static void beforeAll() {
        servlet = new ParkingServlet(service, mapper);
        parkingEntity1 = new ParkingEntity();
        parkingEntity1.setAddress("Minvodi");
        parkingEntity1.setSquare(40);

        parkingEntity2 = new ParkingEntity();
        parkingEntity1.setAddress("Zheleznovodsk");
        parkingEntity1.setSquare(50);

        parkingEntities = List.of(parkingEntity1, parkingEntity2);

        parkingDto1 = new ParkingDto();
        parkingDto1.setAddress("Minvodi");
        parkingDto1.setSquare(40);
    }

    @Test
    void getById() {
        when(service.findById(1)).thenReturn(parkingEntity1);
        ParkingDto parkingDto = servlet.getById(1);
        Assertions.assertEquals(parkingDto.getId(), parkingEntity1.getId());
        Assertions.assertEquals(parkingDto.getAddress(), parkingEntity1.getAddress());
        Assertions.assertEquals(parkingDto.getId(), parkingEntity1.getSquare());
        Mockito.verify(mapper, times(1)).entityToDto(parkingEntity1);
        Mockito.verify(service, times(1)).findById(1);
    }

    @Test
    void getAll() {
        when(service.findAll()).thenReturn(parkingEntities);
        List<ParkingDto> parkingDtos = servlet.getAll();
        Mockito.verify(service, times(1)).findAll();
        Mockito.verify(mapper, times(1)).entityToDtoList(parkingEntities);
        Assertions.assertEquals(2, parkingDtos.size());
        Assertions.assertEquals(parkingDtos.get(0).getId(), parkingEntity1.getId());
        Assertions.assertEquals(parkingDtos.get(1), parkingEntity2.getId());
    }

    @Test
    void save() {
        when(service.save(any(ParkingEntity.class))).thenReturn(parkingEntity1);
        ParkingDto saved = servlet.save(parkingDto1);
        Mockito.verify(service, times(1)).save(any(ParkingEntity.class));
        Mockito.verify(mapper, times(1)).dtoToEntity(any(ParkingDto.class));
        Mockito.verify(mapper, times(1)).entityToDto(any(ParkingEntity.class));
        Assertions.assertEquals(saved.getId(), parkingEntity1.getId());
    }

    @Test
    void doDelete() {
        Mockito.verify(service, times(1)).delete(anyInt());
    }
}