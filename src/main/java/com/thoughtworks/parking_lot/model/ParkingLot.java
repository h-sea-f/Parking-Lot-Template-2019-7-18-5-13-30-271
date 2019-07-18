package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
@Table(name="parkinglot")
public class ParkingLot {
    @Id
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
