package com.aston.logistictestinspring.service.impl;

import com.aston.logistictestinspring.model.ParkingEntity;
import com.aston.logistictestinspring.repository.ParkingEntityRepository;
import org.example.service.ParkingService;
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
        if (repository.findById(parkingEntity.getId()).isEmpty()) {
            return repository.save(parkingEntity);
        }
        return repository.update(parkingEntity);
    }

    @Override
    public ParkingEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Integer id) {
        return repository.deleteById(id);
    }

    @Override
    public List<ParkingEntity> findAll() {
        return repository.findAll().orElse(null);
    }
}
