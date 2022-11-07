package com.skilldistillery.golftracker.data;

import java.util.List;

import com.skilldistillery.golftracker.entities.Player;

public interface PlayerDAO {

	public List<Player> findAll();
	
	public Player findById(int id);
	
	public Player create(Player player);
	
	public Player update(int playerId, Player player);
	
	public boolean deleteById(int playerId);

}
