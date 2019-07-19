package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
@Table(name = "parkinglotorder")
public class ParkingLotOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String carNumber;
    @Column(nullable = false)
    private long createTime;
    private long finishTime;
    @Column(columnDefinition = "int default 1")
    private int state;//private boolean state;
    private String name;

    public String getCarNumber() {
        return carNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
