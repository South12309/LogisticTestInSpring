package com.aston.logistictestingspring.service.impl;

import com.aston.logistictestingspring.model.DriverEntity;
import com.aston.logistictestingspring.repository.DriverEntityRepository;
import com.aston.logistictestingspring.service.DriverService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class DriverServiceImplTest {
    private static DriverEntityRepository repository;
    private static DriverService service;

    @BeforeAll
    static void beforeAll() {
        repository = mock(DriverEntityRepository.class);
        service = new DriverServiceImpl(repository);
    }

    @Test
    void save() {
        DriverEntity driverEntity = mock(DriverEntity.class);
        when(repository.save(driverEntity)).thenReturn(driverEntity);
        service.save(driverEntity);
        verify(repository, times(1)).save(driverEntity);
    }

    @Test
    void findById() {
        DriverEntity driverEntity = mock(DriverEntity.class);
        when(repository.findById(anyInt())).thenReturn(Optional.ofNullable(driverEntity));
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
        List<DriverEntity> drivers = mock(List.class);
        when(repository.findAll()).thenReturn(drivers);
        service.findAll();
        verify(repository, times(1)).findAll();
    }
}