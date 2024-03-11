package com.aston.logistictestingspring.service;


import com.aston.logistictestingspring.model.ParkingEntity;

import java.util.List;

public interface ParkingService {
    ParkingEntity save(ParkingEntity parkingEntity);

    ParkingEntity findById(Integer id);
    void delete(Integer id);

    List<ParkingEntity> findAll();
}
