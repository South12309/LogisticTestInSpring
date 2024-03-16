package com.aston.logistictestingspring.servlet;

import com.aston.logistictestingspring.model.TruckEntity;
import com.aston.logistictestingspring.service.TruckService;
import com.aston.logistictestingspring.servlet.dto.TruckDto;

import com.aston.logistictestingspring.servlet.mapper.TruckMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class TruckServletTest {
    private static TruckServlet servlet;
    @Mock
    private static TruckService service;
    private static TruckMapper mapper;
    private static TruckEntity truckEntity1;
    private static TruckEntity truckEntity2;
    private static List<TruckEntity> truckEntities;
    private static TruckDto truckDto1;

    @BeforeAll
    static void beforeAll() {
        servlet = new TruckServlet(service, mapper);
        truckEntity1 = new TruckEntity();
        truckEntity1.setModel("Man1");
        truckEntity1.setNumber("A009AA09");

        truckEntity2 = new TruckEntity();
        truckEntity1.setModel("Man2");
        truckEntity1.setNumber("A900AA09");

        truckEntities = List.of(truckEntity1, truckEntity2);

        truckDto1 = new TruckDto();
        truckDto1.setModel("Man1");
        truckDto1.setNumber("A009AA09");
    }

    @Test
    void getById() {
        when(service.findById(1)).thenReturn(truckEntity1);
        TruckDto truckDto = servlet.getById(1);
        Assertions.assertEquals(truckDto.getId(), truckEntity1.getId());
        Assertions.assertEquals(truckDto.getModel(), truckEntity1.getModel());
        Assertions.assertEquals(truckDto.getNumber(), truckEntity1.getNumber());
        Mockito.verify(mapper, times(1)).entityToDto(truckEntity1);
        Mockito.verify(service, times(1)).findById(1);
    }

    @Test
    void getAll() {
        when(service.findAll()).thenReturn(truckEntities);
        List<TruckDto> truckDtos = servlet.getAll();
        Mockito.verify(service, times(1)).findAll();
        Mockito.verify(mapper, times(1)).entityToDtoList(truckEntities);
        Assertions.assertEquals(2, truckDtos.size());
        Assertions.assertEquals(truckDtos.get(0).getId(), truckEntity1.getId());
        Assertions.assertEquals(truckDtos.get(1), truckEntity2.getId());
    }

    @Test
    void save() {
        when(service.save(any(TruckEntity.class))).thenReturn(truckEntity1);
        TruckDto saved = servlet.save(truckDto1);
        Mockito.verify(service, times(1)).save(any(TruckEntity.class));
        Mockito.verify(mapper, times(1)).dtoToEntity(any(TruckDto.class));
        Mockito.verify(mapper, times(1)).entityToDto(any(TruckEntity.class));
        Assertions.assertEquals(saved.getId(), truckEntity1.getId());
    }

    @Test
    void doDelete() {
        Mockito.verify(service, times(1)).delete(anyInt());
    }

}