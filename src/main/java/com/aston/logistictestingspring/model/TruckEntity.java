package com.aston.logistictestingspring.model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "trucks")
public class TruckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "number")
    private String number;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "drivers_trucks",
    joinColumns = @JoinColumn(name = "truck_id"),
    inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private List<DriverEntity> drivers;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parking_id")
    private ParkingEntity parking;

    public TruckEntity() {
    }

    public TruckEntity(int id, String model, String number, List<DriverEntity> drivers, ParkingEntity parking) {
        this.id = id;
        this.model = model;
        this.number = number;
        this.drivers = drivers;
        this.parking = parking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<DriverEntity> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverEntity> drivers) {
        this.drivers = drivers;
    }

    public ParkingEntity getParking() {
        return parking;
    }

    public void setParking(ParkingEntity parking) {
        this.parking = parking;
    }
}
