package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Test
    public void should_return_order_when_findByCarNumber(){
        Order order = new Order();
        order.setCarNumber("123");
        order.setState(1);
        order.setCreateTime(System.currentTimeMillis());
        order.setFinishTime(System.currentTimeMillis());
        order.setName("ZHA PARK");
        orderRepository.save(order);
        Order fetchOrder = orderRepository.findByCarNumber(order.getCarNumber());
        assertThat(fetchOrder.getCarNumber()).isEqualTo("123");
    }
}