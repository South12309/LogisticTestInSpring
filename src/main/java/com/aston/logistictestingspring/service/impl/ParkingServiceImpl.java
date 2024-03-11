package com.aston.logistictestingspring.service.impl;

import com.aston.logistictestingspring.model.ParkingEntity;
import com.aston.logistictestingspring.repository.ParkingEntityRepository;

import com.aston.logistictestingspring.service.ParkingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingServiceImpl implements ParkingService {
    private final ParkingEntityRepository repository;


    public ParkingServiceImpl(ParkingEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public ParkingEntity save(ParkingEntity parkingEntity) {
        return repository.save(parkingEntity);
    }

    @Override
    public ParkingEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ParkingEntity> findAll() {
        return repository.findAll();
    }
}
