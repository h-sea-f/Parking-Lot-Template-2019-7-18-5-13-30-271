package com.thoughtworks.parking_lot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingLotController.class)
class ParkingLotControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ParkingLotService parkingLotService;

    @Test
    void should_add_and_return_parkinglot() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ZHA PARK");
        parkingLot.setAddress("ZHA");
        parkingLot.setCapacity(50);
        when(parkingLotService.save(ArgumentMatchers.any(ParkingLot.class))).thenReturn(parkingLot);
        ResultActions result = mvc.perform(post("/parkinglots")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(parkingLot)));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("ZHA PARK"));
    }

    @Test
    void should_return_parkinglots_when_getByPage_given_page() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ZHA PARK");
        parkingLot.setAddress("ZHA");
        parkingLot.setCapacity(50);
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.setAddress("ZHA");
        parkingLot1.setName("ZHA PARK1");
        parkingLot1.setCapacity(20);
        List<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot,parkingLot1));
        when(parkingLotService.getByPage(anyInt())).thenReturn(parkingLots);
        ResultActions result = mvc.perform(get("/parkinglots?page={page}",1));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("ZHA PARK"));
    }

    @Test
    void should_delete_parkinglot_when_deleteByName_given_name() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ZHA PARK");
        parkingLot.setAddress("ZHA");
        parkingLot.setCapacity(50);
        when(parkingLotService.deleteByName(anyString())).thenReturn("success");
        ResultActions result = mvc.perform(delete("/parkinglots/{name}",parkingLot.getName()));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").value("success"));
    }

    @Test
    void should_update_when_update() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ZHA PARK");
        parkingLot.setAddress("ZHA");
        parkingLot.setCapacity(50);
        when(parkingLotService.update(anyString(),ArgumentMatchers.any(ParkingLot.class))).thenReturn(parkingLot);
        ResultActions result = mvc.perform(put("/parkinglots/{name}",parkingLot.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(parkingLot)));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.capacity").value(50));
    }

    @Test
    void should_return_parkinglot_when_findByName_given_name() throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ZHA PARK");
        parkingLot.setAddress("ZHA");
        parkingLot.setCapacity(50);
        when(parkingLotService.findByName(anyString())).thenReturn(parkingLot);
        ResultActions result = mvc.perform(get("/parkinglots/{name}",parkingLot.getName()));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("ZHA PARK"));
    }
}