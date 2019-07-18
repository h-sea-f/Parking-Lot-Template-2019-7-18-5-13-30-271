package com.thoughtworks.parking_lot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parkinglot")
public class ParkingLot {
    @Id
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int capacity;

    public List<Order> getOrders() {
        return orders;
    }

    @OneToMany
    @JoinColumn(name="name")
    List<Order> orders;

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

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
