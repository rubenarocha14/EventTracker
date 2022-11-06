package com.skilldistillery.golftracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.golftracker.entities.Player;
import com.skilldistillery.golftracker.repositories.PlayerRepository;

@Service //replaces Dao
public class PlayerServiceImpl implements PlayerService {
	//servImpls is where all logic is performed for methods, we do not do them in the DAO and DAO impls for security reasons, we want those to be minimal 
	//methods that sole job is to CRUD the db

	@Autowired
	private PlayerRepository playerRepo; //replacing entity manager
	
	@Override
	public List<Player> listAllPlayers() {
		// TODO Auto-generated method stub
		return playerRepo.findAll();
	}

	@Override
	public Player showPlayer(int playerId) {
		Optional<Player> opPlayer = playerRepo.findById(playerId);
		Player p = null;
		if(opPlayer.isPresent()) {
			p = opPlayer.get();
		}
		return p;
	}

	@Override
	public Player create(Player player) {
		return playerRepo.saveAndFlush(player);
	}

	@Override
	public Player update(Player player, int playerId) {
		Player managed = showPlayer(playerId);
		managed.setFirstName(player.getFirstName());
		managed.setLastName(player.getLastName());
		managed.setCity(player.getCity());
		managed.setState(player.getState());
		return playerRepo.save(managed);
	}

	@Override
	public boolean delete(int playerId) {
		playerRepo.deleteById(playerId);
		return !playerRepo.existsById(playerId);
	}

}
