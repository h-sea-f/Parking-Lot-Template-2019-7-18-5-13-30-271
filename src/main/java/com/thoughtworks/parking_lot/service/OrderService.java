package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.NoSpareSpaceException;
import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import javafx.beans.value.ObservableBooleanValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;

    public Order save(Order order) throws NoSpareSpaceException {
        int exist = (int) parkingLotRepository.findByName(order.getName()).getOrders()
                .stream().filter(order1 -> order1.getState() == 1).count();
        int capacity = parkingLotRepository.findByName(order.getName()).getCapacity();
        if (capacity > exist) {
            return orderRepository.save(order);
        } else {
            throw new NoSpareSpaceException();
        }

    }

    public Order takeCar(String carNumber) {
        if (orderRepository.findByCarNumber(carNumber) != null) {
            Order order = orderRepository.findByCarNumber(carNumber);
            order.setState(0);
            order.setFinishTime(System.currentTimeMillis());
            return orderRepository.save(order);
        } else {
            return null;
        }
    }
}
