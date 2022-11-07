package com.skilldistillery.golftracker.data;

import java.util.List;

import com.skilldistillery.golftracker.entities.Course;

public interface CourseDAO {

	public List<Course> findAll();
	
	public Course findById(int id);
	
	public Course create(Course course);
	
	public Course update(int courseId, Course course);
	
	public boolean deleteById(int courseId);

}
