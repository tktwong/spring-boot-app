package com.appswalker.nplusone.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.*;

import java.util.List;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude={"rooms", "doors"})
@ToString(exclude={"rooms", "doors"})
@Entity
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonManagedReference
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<Room> rooms;

	@JsonManagedReference
	@OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<Door> doors;
}