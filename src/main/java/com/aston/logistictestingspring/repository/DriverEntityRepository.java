package com.aston.logistictestingspring.repository;


import com.aston.logistictestingspring.model.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverEntityRepository extends JpaRepository<DriverEntity, Integer> {
}

