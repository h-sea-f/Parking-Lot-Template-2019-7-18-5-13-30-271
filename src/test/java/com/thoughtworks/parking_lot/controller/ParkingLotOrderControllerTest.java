package com.thoughtworks.parking_lot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
public class ParkingLotOrderControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void should_create_order() throws Exception {
        ParkingLotOrder parkingLotOrder =new ParkingLotOrder();
        parkingLotOrder.setId(1);
        parkingLotOrder.setCreateTime(2019071822);
        parkingLotOrder.setState(1);
        parkingLotOrder.setCarNumber("123456");
        when(orderService.save(ArgumentMatchers.any(ParkingLotOrder.class))).thenReturn(parkingLotOrder);
        ResultActions result = mvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(parkingLotOrder)));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void should_return_order_when_takeCar() throws Exception {
        ParkingLotOrder parkingLotOrder =new ParkingLotOrder();
        parkingLotOrder.setId(1);
        parkingLotOrder.setCreateTime(2019071822);
        parkingLotOrder.setState(1);
        parkingLotOrder.setCarNumber("123456");
        when(orderService.takeCar(anyString())).thenReturn(parkingLotOrder);
        ResultActions result = mvc.perform(put("/orders/{carNumber}", parkingLotOrder.getCarNumber()));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.carNumber").value("123456"));
    }
}
