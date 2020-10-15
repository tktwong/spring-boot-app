package com.appswalker.nplusone.example;

import java.util.HashSet;
import java.util.Set;

import com.appswalker.nplusone.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appswalker.nplusone.example.model.Door;
import com.appswalker.nplusone.example.model.House;
import com.appswalker.nplusone.example.repository.HouseRepository;

@SpringBootApplication
public class EntitygraphApplication implements CommandLineRunner {

	@Autowired
	HouseRepository houseRepository;

	public static void main(String[] args) {
		SpringApplication.run(EntitygraphApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		House house = new House();
		Set<Door> doors = new HashSet<>();
		doors.add(new Door());
		doors.add(new Door());
		doors.add(new Door());
		for (Door door : doors) {
			door.setHouse(house);
		}
		house.setDoors(doors);
		Set<Room> rooms = new HashSet<>();
		rooms.add(Room.builder().roomNum("101").build());
		rooms.add(Room.builder().roomNum("102").build());
		rooms.add(Room.builder().roomNum("103").build());
		for (Room room : rooms) {
			room.setHouse(house);
		}
		house.setRooms(rooms);
		houseRepository.save(house);
	}
}