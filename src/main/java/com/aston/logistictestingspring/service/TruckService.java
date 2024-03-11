package com.aston.logistictestingspring.service;


import com.aston.logistictestingspring.model.TruckEntity;

import java.util.List;

public interface TruckService {
    TruckEntity save(TruckEntity truckEntity);
    TruckEntity findById(Integer id);
    void delete(Integer id);
    List<TruckEntity> findAll();
}
