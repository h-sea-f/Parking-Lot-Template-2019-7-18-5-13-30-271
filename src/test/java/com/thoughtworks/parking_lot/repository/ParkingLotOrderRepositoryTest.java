package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class ParkingLotOrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Test
    public void should_return_order_when_findByCarNumber(){
        ParkingLotOrder parkingLotOrder = new ParkingLotOrder();
        parkingLotOrder.setCarNumber("123");
        parkingLotOrder.setState(1);
        parkingLotOrder.setName("ZHA PARK");
        parkingLotOrder.setCreateTime(System.currentTimeMillis());
        orderRepository.save(parkingLotOrder);
        ParkingLotOrder fetchParkingLotOrder = orderRepository.findByCarNumber(parkingLotOrder.getCarNumber());
        assertThat(fetchParkingLotOrder.getCarNumber()).isEqualTo("123");
    }
}