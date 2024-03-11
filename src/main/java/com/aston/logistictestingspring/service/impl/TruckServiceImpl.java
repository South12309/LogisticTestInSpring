package com.aston.logistictestingspring.service.impl;


import com.aston.logistictestingspring.model.TruckEntity;
import com.aston.logistictestingspring.repository.TruckEntityRepository;
import com.aston.logistictestingspring.service.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TruckServiceImpl implements TruckService {
    private final TruckEntityRepository repository;

    public TruckServiceImpl(TruckEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public TruckEntity save(TruckEntity truckEntity) {
        return repository.save(truckEntity);
    }

    @Override
    public TruckEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<TruckEntity> findAll() {
        return repository.findAll();
    }
}
