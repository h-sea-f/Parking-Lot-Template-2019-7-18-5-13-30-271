package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class ParkingLotRepositoryTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    public void should_save_and_fetch_parkinglot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress("ZHA");
        parkingLot.setName("ZHA PARK");
        parkingLot.setCapacity(50);
        parkingLotRepository.save(parkingLot);
        ParkingLot fetchParkingLot = parkingLotRepository.findByName(parkingLot.getName());
        assertThat(fetchParkingLot.getName()).isEqualTo("ZHA PARKER");
        assertThat(fetchParkingLot.getAddress()).isEqualTo("ZHA");
        assertThat(fetchParkingLot.getCapacity()).isEqualTo(50);
    }

}