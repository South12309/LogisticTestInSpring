package com.aston.logistictestinspring.service.impl;


import com.aston.logistictestinspring.model.TruckEntity;
import com.aston.logistictestinspring.repository.TruckEntityRepository;
import org.example.service.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TruckServiceImpl implements TruckService {
    private TruckEntityRepository repository;

    public TruckServiceImpl() {
        repository = TruckEntityRepositoryImpl.getINSTANCE();
    }

    public TruckServiceImpl(TruckEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public TruckEntity save(TruckEntity truckEntity) {
        if (repository.findById(truckEntity.getId()).isEmpty()) {
            return repository.save(truckEntity);
        }
        return repository.update(truckEntity);
    }

    @Override
    public TruckEntity findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Integer id) {
        return repository.deleteById(id);
    }

    @Override
    public List<TruckEntity> findAll() {
        return repository.findAll().orElse(null);
    }
}
