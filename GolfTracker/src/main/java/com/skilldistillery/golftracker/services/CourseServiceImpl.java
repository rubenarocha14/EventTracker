package com.skilldistillery.golftracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.golftracker.entities.Course;
import com.skilldistillery.golftracker.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	//servImpls is where all logic is performed for methods, we do not do them in the DAO and DAO impls for security reasons, we want those to be minimal 
	//methods that sole job is to CRUD the db
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Course> listAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public Course showCourse(int courseId) {
		Optional<Course> opCourse = courseRepo.findById(courseId);
		Course c = null;
		if(opCourse.isPresent()) {
			c = opCourse.get();
		}
		return c;
	}

	@Override
	public Course create(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public Course update(Course course, int courseId) {
		Course managed = showCourse(courseId);
		managed.setCity(course.getCity());
		managed.setName(course.getName());
		managed.setState(course.getState());
		return courseRepo.save(managed);
	}

	@Override
	public boolean delete(int courseId) {
		courseRepo.deleteById(courseId);
		return !courseRepo.existsById(courseId);
	}

}
