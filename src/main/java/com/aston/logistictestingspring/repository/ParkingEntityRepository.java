package com.aston.logistictestingspring.repository;


import com.aston.logistictestingspring.model.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingEntityRepository extends JpaRepository<ParkingEntity, Integer> {
}

