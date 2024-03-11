package com.aston.logistictestingspring.repository;


import com.aston.logistictestingspring.model.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TruckEntityRepository extends JpaRepository<TruckEntity, Integer> {
    List<TruckEntity> findByParkingId(Integer parkingId);
}

