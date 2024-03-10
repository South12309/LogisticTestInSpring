package com.aston.logistictestinspring.service;


import com.aston.logistictestinspring.model.ParkingEntity;

import java.util.List;

public interface ParkingService {
    ParkingEntity save(ParkingEntity parkingEntity);

    ParkingEntity findById(Integer id);
    void delete(Integer id);

    List<ParkingEntity> findAll();
}
