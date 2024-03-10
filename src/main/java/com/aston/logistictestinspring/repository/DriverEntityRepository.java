package com.aston.logistictestinspring.repository;


import com.aston.logistictestinspring.model.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverEntityRepository extends JpaRepository<DriverEntity, Integer> {
}

