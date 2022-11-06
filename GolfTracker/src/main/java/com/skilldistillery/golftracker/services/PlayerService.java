package com.skilldistillery.golftracker.services;

import java.util.List;

import com.skilldistillery.golftracker.entities.Player;

public interface PlayerService {
	
	List<Player> listAllPlayers();
	Player showPlayer (int playerId);
	Player create(Player player);
	Player update(Player player, int playerId);
	boolean delete(int playerId);

}
