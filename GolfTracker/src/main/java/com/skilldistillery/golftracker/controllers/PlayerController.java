package com.skilldistillery.golftracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.golftracker.data.PlayerDAO;
import com.skilldistillery.golftracker.entities.Player;
import com.skilldistillery.golftracker.services.PlayerService;

@RestController
@RequestMapping("api")
public class PlayerController {
	
	@Autowired
	private PlayerDAO playerDao;

	@Autowired 
	private PlayerService playerServ;
	
	@GetMapping("players")
	public List<Player> listPlayers(){
		return playerServ.listAllPlayers();
	}
	
	@GetMapping("players/{playerId}")
	public Player playerById(@PathVariable Integer playerId) {
		return playerServ.showPlayer(playerId);
	}
	
	@PostMapping("players")
	public Player createPlayer(@RequestBody Player player, HttpServletResponse resp, HttpServletRequest req) {
		return player;
		
	}
	
}
