package com.skilldistillery.golftracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.golftracker.entities.Round;
import com.skilldistillery.golftracker.repositories.RoundRepository;

@Service
public class RoundServiceImpl implements RoundService {
	
	@Autowired
	private RoundRepository roundRepo; //replacing entity manager
	
	@Override
	public List<Round> listAllRounds() {
		return roundRepo.findAll();
	}

	@Override
	public Round showRound(int roundId) {
		Optional<Round> opRound = roundRepo.findById(roundId); //Optional opRound gets the entity from repo findById from the round Id
		Round r = null; //instantiate a null round
		if(opRound.isPresent()) {
			r = opRound.get(); // if the opRound is present it should replace the null round, otherwise r round will remain null
		}
		return r;
	}

	@Override
	public Round create(Round round) {
		return roundRepo.saveAndFlush(round);
	}

	@Override
	public Round update(Round round, int roundId) {
		Round managed = showRound(roundId); //instantiate a round named managed which reps the round sent in
		managed.setCourse(round.getCourse());
		managed.setHolesPlayed(round.getHolesPlayed());
		managed.setNumPlayers(round.getNumPlayers());
		managed.setPlayer(round.getPlayer());
		managed.setScore(round.getScore());
		return roundRepo.save(managed);
	}

	@Override
	public boolean delete(int roundId) {
		roundRepo.deleteById(roundId);
		return !roundRepo.existsById(roundId);
	}

}
