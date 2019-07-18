package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingLot save(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }

    public List<ParkingLot> getByPage(int page) {
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        return parkingLots.stream().skip((page-1)*15).limit(15).collect(Collectors.toList());
    }

    public String deleteByName(String name) {
        parkingLotRepository.deleteById(name);
        return "success";
    }

    public ParkingLot update(String name,int capacity) {
       ParkingLot parkingLot = parkingLotRepository.findByName(name);
       parkingLot.setCapacity(capacity);
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot findByName(String name) {
        return parkingLotRepository.findByName(name);
    }
}
