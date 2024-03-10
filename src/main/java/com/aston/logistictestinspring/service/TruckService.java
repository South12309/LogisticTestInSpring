package com.aston.logistictestinspring.service;


import com.aston.logistictestinspring.model.TruckEntity;

import java.util.List;
import java.util.UUID;

public interface TruckService {
    TruckEntity save(TruckEntity truckEntity);
    TruckEntity findById(Integer id);
    void delete(Integer id);
    List<TruckEntity> findAll();
}
