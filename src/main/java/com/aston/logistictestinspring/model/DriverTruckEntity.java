package com.aston.logistictestinspring.model;


import javax.persistence.*;

@Entity
public class DriverTruckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int driverId;
    private int truckId;

    public DriverTruckEntity() {
    }

    public DriverTruckEntity(int id, int driverId, int truckId) {
        this.id = id;
        this.driverId = driverId;
        this.truckId = truckId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }
}
