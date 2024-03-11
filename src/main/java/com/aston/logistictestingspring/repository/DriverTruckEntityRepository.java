package com.aston.logistictestingspring.repository;


import com.aston.logistictestingspring.model.DriverEntity;
import com.aston.logistictestingspring.model.TruckEntity;

import java.util.List;

public interface DriverTruckEntityRepository {
    List<TruckEntity> findTrucksByDriverId(Integer driverId);
    List<DriverEntity> findDriversByTruckId(Integer truckId);
}

