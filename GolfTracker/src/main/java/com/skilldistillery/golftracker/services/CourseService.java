package com.skilldistillery.golftracker.services;

import java.util.List;

import com.skilldistillery.golftracker.entities.Course;

public interface CourseService {

	List<Course> listAllCourses();
	Course showCourse (int courseId);
	Course create(Course course);
	Course update(Course course, int courseId);
	boolean delete(int courseId);
}
