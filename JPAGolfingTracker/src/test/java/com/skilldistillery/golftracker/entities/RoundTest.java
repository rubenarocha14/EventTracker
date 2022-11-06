package com.skilldistillery.golftracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoundTest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private Round round;

	
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
		round = em.find(Round.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		round = null;
		
	}
	
	@Test
	void test_Equipment_Type_entity_mapping() {
		assertNotNull(round);
		assertEquals(90, round.getScore());
	}
	
	@Test
	void test_Round_MTO_Player() {
		assertNotNull(round);
		assertEquals("Ruben", round.getPlayer().getFirstName());
	}

	@Test
	void test_Round_MTO_Course() {
		assertNotNull(round);
		assertEquals("City Park", round.getCourse().getName());
	}
	

}
