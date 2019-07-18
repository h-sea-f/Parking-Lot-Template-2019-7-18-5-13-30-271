package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ParkingLotController {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @GetMapping("/parkinglots")
    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }

    @PostMapping("/parkinglots")
    public ParkingLot create(@RequestBody ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }

}
