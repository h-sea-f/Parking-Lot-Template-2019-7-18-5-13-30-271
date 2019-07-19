package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.execption.NoSpareSpaceException;
import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/orders")
    public ParkingLotOrder save(@RequestBody ParkingLotOrder parkingLotOrder) throws NoSpareSpaceException {
        return orderService.save(parkingLotOrder);
    }

    @PutMapping("/orders/{carNumber}")
    public ParkingLotOrder takeCar(@PathVariable String carNumber){
        return orderService.takeCar(carNumber);
    }

}
