package com.appswalker.nplusone.example;

import java.util.ArrayList;
import java.util.List;

import com.appswalker.nplusone.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.appswalker.nplusone.example.model.Door;
import com.appswalker.nplusone.example.model.House;
import com.appswalker.nplusone.example.repository.HouseRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	@Autowired
	HouseRepository houseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		House house = new House();
		List<Door> doors = new ArrayList<>();
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		for (Door door : doors) {
			door.setHouse(house);
		}
		house.setDoors(doors);
		List<Room> rooms = new ArrayList<>();
		rooms.add(Room.builder().roomNum(101).build());
		rooms.add(Room.builder().roomNum(102).build());
		rooms.add(Room.builder().roomNum(103).build());
		for (Room room : rooms) {
			room.setHouse(house);
		}
		house.setRooms(rooms);
		houseRepository.save(house);
	}
}