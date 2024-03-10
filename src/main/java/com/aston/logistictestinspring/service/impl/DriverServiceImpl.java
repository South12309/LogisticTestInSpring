package com.aston.logistictestinspring.service.impl;


import com.aston.logistictestinspring.model.DriverEntity;
import com.aston.logistictestinspring.repository.DriverEntityRepository;

import com.aston.logistictestinspring.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverServiceImpl implements DriverService {
    private final DriverEntityRepository repository;

    public DriverServiceImpl(DriverEntityRepository repository) {
        this.repository = repository;
    }


    @Override
    public DriverEntity save(DriverEntity driverEntity) {
        return repository.save(driverEntity);
    }

    @Override
    public DriverEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<DriverEntity> findAll() {
        return repository.findAll();
    }
}
