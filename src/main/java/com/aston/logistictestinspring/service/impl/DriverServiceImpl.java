package com.aston.logistictestinspring.service.impl;


import com.aston.logistictestinspring.model.DriverEntity;
import com.aston.logistictestinspring.repository.DriverEntityRepository;
import org.example.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverServiceImpl implements DriverService {
    private final DriverEntityRepository repository;

    public DriverServiceImpl() {
        repository = DriverEntityRepositoryImpl.getINSTANCE();
    }

    public DriverServiceImpl(DriverEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public DriverEntity save(DriverEntity driverEntity) {
        if (repository.findById(driverEntity.getId()).isEmpty()) {
            return repository.save(driverEntity);
        }
        return repository.update(driverEntity);
    }

    @Override
    public DriverEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Integer id) {
        return repository.deleteById(id);
    }

    @Override
    public List<DriverEntity> findAll() {
        return repository.findAll().orElse(null);
    }
}
