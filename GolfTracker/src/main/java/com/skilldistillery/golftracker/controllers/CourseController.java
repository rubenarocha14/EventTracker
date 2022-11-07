package com.skilldistillery.golftracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.golftracker.data.CourseDAO;
import com.skilldistillery.golftracker.entities.Course;
import com.skilldistillery.golftracker.services.CourseService;

@RestController
@RequestMapping("api")
public class CourseController {
	
	//, HttpServletRequest req, HttpServletResponse resp
	
	@Autowired
	CourseDAO courseDao;
	
	@Autowired
	CourseService courseServ;
	
	@GetMapping("courses")
	public List<Course> listCourses(){
		return courseServ.listAllCourses();
	}
	
	@GetMapping("course/{courseId}")
	public Course findCourseById(@PathVariable Integer courseId) {
		return courseServ.showCourse(courseId);
	}
	
	@PostMapping("courses")
	public Course createCourse(@RequestBody Course course, HttpServletRequest req, HttpServletResponse resp) {
		try {
			course = courseDao.create(course);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(course.getId());
			resp.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			course = null;
		}
		return course;
		
	}
	
	@PutMapping("courses/{courseId}")
	public Course updateCourse(@PathVariable Integer courseId, @RequestBody Course course, HttpServletResponse resp) {
		try {
			course = courseDao.update(courseId, course);
			if(course == null) {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			course = null;
		}
		
		return course;
	}
	
	@DeleteMapping("courses/{courseId}")
	public void deleteCourse(@PathVariable Integer courseId, HttpServletResponse resp) {
		try {
			if(courseDao.deleteById(courseId)) {
				resp.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		
	}
//	
//	

}
