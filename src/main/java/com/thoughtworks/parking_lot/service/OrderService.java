package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.execption.NoSpareSpaceException;
import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;

    public ParkingLotOrder save(ParkingLotOrder parkingLotOrder) throws NoSpareSpaceException {
        int exist = (int) parkingLotRepository.findByName(parkingLotOrder.getName()).getParkingLotOrders()
                .stream().filter(order1 -> order1.getState() == 1).count();
        int capacity = parkingLotRepository.findByName(parkingLotOrder.getName()).getCapacity();
        if (capacity > exist) {
            return orderRepository.save(parkingLotOrder);
        } else {
            throw new NoSpareSpaceException();
        }

    }

    public ParkingLotOrder takeCar(String carNumber) {
        if (orderRepository.findByCarNumber(carNumber) != null) {
            ParkingLotOrder parkingLotOrder = orderRepository.findByCarNumber(carNumber);
            parkingLotOrder.setState(0);
            parkingLotOrder.setFinishTime(System.currentTimeMillis());
            return orderRepository.save(parkingLotOrder);
        } else {
            return null;
        }
    }
}
