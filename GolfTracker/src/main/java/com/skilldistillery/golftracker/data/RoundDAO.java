package com.skilldistillery.golftracker.data;

import java.util.List;

import com.skilldistillery.golftracker.entities.Round;

public interface RoundDAO {
	
	
	public List<Round> findAll();
	
	public Round findById(int id);
	
	public Round create(Round round);
	
	public Round update(int roundId, Round round);
	
	public boolean deleteById(int roundId);


}
