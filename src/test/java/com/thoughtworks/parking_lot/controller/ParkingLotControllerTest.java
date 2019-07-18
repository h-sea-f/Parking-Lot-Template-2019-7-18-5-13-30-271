package com.thoughtworks.parking_lot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingLotController.class)
class ParkingLotControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ParkingLotRepository parkingLotRepository;

    @Test
    void should_add_and_return_parkinglot() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ZHA PARK");
        parkingLot.setAddress("ZHA");
        parkingLot.setCapacity(50);
        when(parkingLotRepository.save(ArgumentMatchers.any(ParkingLot.class))).thenReturn(parkingLot);
        ResultActions result = mvc.perform(post("/parkinglots")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(parkingLot)));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("ZHA PARK"));
    }
}