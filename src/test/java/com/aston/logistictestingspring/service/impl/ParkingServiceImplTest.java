package com.aston.logistictestingspring.service.impl;

import com.aston.logistictestingspring.model.ParkingEntity;
import com.aston.logistictestingspring.repository.ParkingEntityRepository;
import com.aston.logistictestingspring.service.ParkingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ParkingServiceImplTest {
    @Mock
    private static ParkingEntityRepository repository;
    private static ParkingService service;
    @BeforeAll
    static void beforeAll() {
        service = new ParkingServiceImpl(repository);
    }

    @Test
    void save() {
        ParkingEntity parkingEntity = mock(ParkingEntity.class);
        when(repository.save(parkingEntity)).thenReturn(parkingEntity);
        service.save(parkingEntity);
        verify(repository, times(1)).save(parkingEntity);
    }

    @Test
    void findById() {
        ParkingEntity parkingEntity = mock(ParkingEntity.class);
        when(repository.findById(anyInt())).thenReturn(Optional.ofNullable(parkingEntity));
        service.findById(anyInt());
        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    void delete() {
        service.delete(anyInt());
        verify(repository, times(1)).deleteById(anyInt());
    }

    @Test
    void findAll() {
        List<ParkingEntity> parkings = mock(List.class);
        when(repository.findAll()).thenReturn(parkings);
        service.findAll();
        verify(repository, times(1)).findAll();
    }
}