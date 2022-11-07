package com.skilldistillery.golftracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.golftracker.entities.Course;
import com.skilldistillery.golftracker.entities.Player;
import com.skilldistillery.golftracker.entities.Round;

@Transactional
@Service
public class RoundDaoImpl implements RoundDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Round> findAll() {
		String jpql = "SELECT r from Round r";
		return em.createQuery(jpql, Round.class).getResultList();
	}

	@Override
	public Round findById(int id) {
		return em.find(Round.class, id);
	}

	@Override
	public Round create(Round round) {
		if(round.getCourse() == null) {
			round.setCourse(em.find(Course.class, 1));
		}
		if(round.getPlayer() == null) {
			round.setPlayer(em.find(Player.class, 1));
		}
		em.persist(round);
		return round;
	}

	@Override
	public Round update(int roundId, Round round) {
		Round roundToUpdate = em.find(Round.class, roundId);
		if(roundToUpdate != null) {
			roundToUpdate.setHolesPlayed(round.getHolesPlayed());
			roundToUpdate.setNumPlayers(round.getNumPlayers());
			roundToUpdate.setPlayer(round.getPlayer());
			roundToUpdate.setScore(round.getScore());
			if(round.getCourse() != null) {
				roundToUpdate.setCourse(round.getCourse());
			}
			if(round.getPlayer() != null) {
				roundToUpdate.setPlayer(round.getPlayer());
			}
		}
	
		em.flush();
		return roundToUpdate;
	}

	@Override
	public boolean deleteById(int roundId) {
		boolean deleted = false;
		Round roundToDelete = em.find(Round.class, roundId);
		if(roundToDelete != null) {
			em.remove(roundToDelete);
			deleted = true;
		}
		return deleted;
	}

}
