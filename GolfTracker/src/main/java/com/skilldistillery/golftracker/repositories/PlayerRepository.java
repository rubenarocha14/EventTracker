package com.skilldistillery.golftracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.golftracker.entities.Player;

public interface PlayerRepository extends JpaRepository <Player, Integer> {

}
