package com.aston.logistictestingspring.service;


import com.aston.logistictestingspring.model.DriverEntity;

import java.util.List;

public interface DriverService {
    DriverEntity save(DriverEntity driverEntity);

    DriverEntity findById(Integer id);

    void delete(Integer id);

    List<DriverEntity> findAll();
}
