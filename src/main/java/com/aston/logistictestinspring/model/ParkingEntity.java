package com.aston.logistictestinspring.model;

import java.util.List;

public class ParkingEntity {
    private int id;
    private String address;
    private int square;
    private List<TruckEntity> trucks;

    public ParkingEntity() {
    }

    public ParkingEntity(int id, String address, int square, List<TruckEntity> trucks) {
        this.id = id;
        this.address = address;
        this.square = square;
        this.trucks = trucks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public List<TruckEntity> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<TruckEntity> trucks) {
        this.trucks = trucks;
    }
}
