package com.appswalker.nplusone.example.service;

import com.appswalker.nplusone.example.model.House;
import com.appswalker.nplusone.example.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public List<House> getHouseList() {
        return houseRepository.findAll();
    }

    public List<House> getHouses() {
        return houseRepository.customQuery();
    }
}
