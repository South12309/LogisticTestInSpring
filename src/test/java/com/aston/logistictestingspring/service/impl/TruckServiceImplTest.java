package com.aston.logistictestingspring.service.impl;

import com.aston.logistictestingspring.model.TruckEntity;
import com.aston.logistictestingspring.repository.TruckEntityRepository;
import com.aston.logistictestingspring.service.TruckService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class TruckServiceImplTest {
    private static TruckEntityRepository repository;
    private static TruckService service;
    @BeforeAll
    static void beforeAll() {
        repository = mock(TruckEntityRepository.class);
        service = new TruckServiceImpl(repository);
    }

    @Test
    void save() {
        TruckEntity truckEntity = mock(TruckEntity.class);
        when(repository.save(truckEntity)).thenReturn(truckEntity);
        service.save(truckEntity);
        verify(repository, times(1)).save(truckEntity);
    }

    @Test
    void findById() {
        TruckEntity truckEntity = mock(TruckEntity.class);
        when(repository.findById(anyInt())).thenReturn(Optional.ofNullable(truckEntity));
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
        List<TruckEntity> trucks = mock(List.class);
        when(repository.findAll()).thenReturn(trucks);
        service.findAll();
        verify(repository, times(1)).findAll();
    }
}