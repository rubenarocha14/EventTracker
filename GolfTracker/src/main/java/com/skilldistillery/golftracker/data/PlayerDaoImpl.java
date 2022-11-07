package com.skilldistillery.golftracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.golftracker.entities.Player;

@Service
@Transactional
public class PlayerDaoImpl implements PlayerDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Player> findAll() {
		String jpql = "SELECT p from Player p";
		return em.createQuery(jpql, Player.class).getResultList();
	}

	@Override
	public Player findById(int id) {
		return em.find(Player.class, id);
	}

	@Override
	public Player create(Player player) {
		em.persist(player);
		return player;
	}

	@Override
	public Player update(int playerId, Player player) {
		Player updating = em.find(Player.class, playerId);
		if(updating != null){
			updating.setFirstName(player.getFirstName());
			updating.setLastName(player.getLastName());
			updating.setCity(player.getCity());
			updating.setState(player.getState());
		}
		
		em.flush();
		return updating;
	}

	@Override
	public boolean deleteById(int playerId) {
		boolean deleted = false;
		Player toDelete = em.find(Player.class, playerId);
		if(toDelete != null) {
			em.remove(toDelete);
			deleted = true;
		}
		return deleted;
	}

}
