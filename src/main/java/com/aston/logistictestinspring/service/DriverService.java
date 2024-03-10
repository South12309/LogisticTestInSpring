package com.aston.logistictestinspring.service;


import com.aston.logistictestinspring.model.DriverEntity;

import java.util.List;

public interface DriverService {
    DriverEntity save(DriverEntity driverEntity);

    DriverEntity findById(Integer id);

    void delete(Integer id);

    List<DriverEntity> findAll();
}
