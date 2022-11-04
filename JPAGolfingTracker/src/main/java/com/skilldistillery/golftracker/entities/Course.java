package com.skilldistillery.golftracker.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String city;
	
	private String state;

//	@ManyToMany
//	@JoinTable(name="round",
//	 joinColumns=@JoinColumn(name="course_id"),
//	 inverseJoinColumns=@JoinColumn(name="player_id")
//	 private List<Player> players;
//	
}
