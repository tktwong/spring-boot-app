package com.appswalker.nplusone.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.appswalker.nplusone.example.model.Door;
import com.appswalker.nplusone.example.model.House;
import com.appswalker.nplusone.example.model.Room;
import com.appswalker.nplusone.example.repository.HouseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseRepositoryTest {

	@Autowired
	private HouseRepository houseRepository;

	@Test
	public void entityGraph_test() {
		List<House> houses = houseRepository.customQuery();
		assertNotNull(houses);
		assertEquals(3, houses.get(0).getDoors().size());
		assertEquals(3, houses.get(0).getRooms().size());
		for (House house : houses) {
			System.out.println(house);
			for (Room room : house.getRooms()) {
				System.out.println(room);
			}
			for (Door door : house.getDoors()) {
				System.out.println(door);
			}
		}
	}
}