package com.appswalker.nplusone.example.repository;

import java.util.List;

import com.appswalker.nplusone.example.model.House;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

//	@EntityGraph(attributePaths = { "rooms", "doors" })
//  EntityGraph needs to implement Set for @OneToMany
	@Query("SELECT ho FROM House ho")
	List<House> customQuery();
}