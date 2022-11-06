package com.skilldistillery.golftracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private Course course;

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAGolfingTracker");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
		
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		course = em.find(Course.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		course = null;
		
	}
	
	@Test
	void test_Course_entity_mapping() {
		assertNotNull(course);
		assertEquals("City Park", course.getName());
	}
	
	@Test
	void test_Course_MTO_Round() {
		assertNotNull(course);
		assertTrue(course != null && course.getRounds().size()>0);
	}

}
