package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.NoSpareSpaceException;
import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/orders")
    public Order save(@RequestBody Order order) throws NoSpareSpaceException {
        return orderService.save(order);
    }

    @PutMapping("/orders/{carNumber}")
    public Order takeCar(@PathVariable String carNumber){
        return orderService.takeCar(carNumber);
    }
}
