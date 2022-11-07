package com.skilldistillery.golftracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.golftracker.entities.Course;

@Transactional
@Service
public class CourseDaoImpl implements CourseDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Course> findAll() {
		String jpql = "SELECT c from Course c";
		return em.createQuery(jpql, Course.class).getResultList();
	}

	@Override
	public Course findById(int id) {
		return em.find(Course.class, id);
	}

	@Override
	public Course create(Course course) {
		em.persist(course);
		return course;
	}

	@Override
	public Course update(int courseId, Course course) {
		Course existing = em.find(Course.class, courseId);
		if(existing != null) {
			existing.setCity(course.getCity());
			existing.setName(course.getName());
			existing.setState(course.getState());
		}
		
		em.flush();
		return existing;
	}

	@Override
	public boolean deleteById(int courseId) {
		boolean deleted = false;
		Course courseToDelete = em.find(Course.class, courseId);
		if(courseToDelete != null) {
			em.remove(courseToDelete);
			deleted = true;
		}
		return deleted;
	}

}
