package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping(value = "/parkinglots",params = "page")
    public List<ParkingLot> getByPage(@RequestParam int page){
        return parkingLotService.getByPage(page);
    }

    @DeleteMapping("/parkinglots/{name}")
    public String deleteByName(@PathVariable String name){
        return parkingLotService.deleteByName(name);
    }

    @PutMapping("/parkinglots/{name}")
    public ParkingLot update(@PathVariable String name,@RequestBody ParkingLot parkingLot){
        return parkingLotService.update(name,parkingLot);
    }

    @GetMapping("/parkinglots/{name}")
    public ParkingLot findByName(@PathVariable String name){
        return parkingLotService.findByName(name);
    }


}
