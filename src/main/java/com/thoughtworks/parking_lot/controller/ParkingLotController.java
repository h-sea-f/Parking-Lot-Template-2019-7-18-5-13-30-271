package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping("/parkinglots")
    public List<ParkingLot> findAll() {
        return parkingLotService.findAll();
    }

    @PostMapping("/parkinglots")
    public ParkingLot create(@RequestBody ParkingLot parkingLot){
        return parkingLotService.save(parkingLot);
    }

    @GetMapping("/parkinglots/{page}")
    public List<ParkingLot> getByPage(@PathVariable int page){
        return parkingLotService.getByPage(page);
    }

}
