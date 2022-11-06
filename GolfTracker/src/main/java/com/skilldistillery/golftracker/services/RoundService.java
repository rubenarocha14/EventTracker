package com.skilldistillery.golftracker.services;

import java.util.List;

import com.skilldistillery.golftracker.entities.Round;

public interface RoundService {

	List<Round> listAllRounds();
	Round showRound (int roundId);
	Round create(Round round);
	Round update(Round round, int roundId);
	boolean delete(int roundId);
}
