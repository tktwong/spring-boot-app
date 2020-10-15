package com.appswalker.nplusone.example.controller;

import com.appswalker.nplusone.example.model.House;
import com.appswalker.nplusone.example.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping("/houseList")
    public List<House> getHouseList() {
        return houseService.getHouseList();
    }

    @GetMapping("/houses")
    public List<House> getHouses() {
        return houseService.getHouses();
    }
}
