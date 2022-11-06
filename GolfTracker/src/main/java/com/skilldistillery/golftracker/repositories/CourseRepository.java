package com.skilldistillery.golftracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.golftracker.entities.Course;


//this gives us access to all of the CRUD methods without having to define them
//remember findById returns an optional, so we will need to define an opt
//var that holds our entity
public interface CourseRepository extends JpaRepository <Course, Integer> {

}
