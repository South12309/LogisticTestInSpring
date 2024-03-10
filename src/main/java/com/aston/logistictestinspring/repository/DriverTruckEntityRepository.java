package com.aston.logistictestinspring.repository;


import com.aston.logistictestinspring.model.DriverEntity;
import com.aston.logistictestinspring.model.TruckEntity;

import java.util.List;

public interface DriverTruckEntityRepository {
    List<TruckEntity> findTrucksByDriverId(Integer driverId);
    List<DriverEntity> findDriversByTruckId(Integer truckId);
}

