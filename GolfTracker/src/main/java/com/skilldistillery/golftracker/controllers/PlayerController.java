package com.skilldistillery.golftracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.golftracker.data.PlayerDAO;
import com.skilldistillery.golftracker.entities.Player;
import com.skilldistillery.golftracker.services.PlayerService;

@CrossOrigin({"*", "http://localhost/"})
@RequestMapping("api")
@RestController
public class PlayerController {
	
	@Autowired
	private PlayerDAO playerDao;

	@Autowired 
	private PlayerService playerServ;
	
	@GetMapping("players")//working
	public List<Player> listPlayers(){
		return playerServ.listAllPlayers();
	}
	
	@GetMapping("players/{playerId}")//working
	public Player playerById(@PathVariable Integer playerId) {
		return playerServ.showPlayer(playerId);
	}
	
	@PostMapping("players")//working
	public Player createPlayer(@RequestBody Player player, HttpServletResponse resp, HttpServletRequest req) {
		try {
			player = playerDao.create(player);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL(); //ReqURL only returns StrBuffer, cannot use normal string concat
			url.append("/").append(player.getId());
			resp.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			player = null;
		}
		return player;
		
	}
	
	@PutMapping("players/{playerId}")
	public Player updatePlayer(@PathVariable Integer playerId, @RequestBody Player player, HttpServletResponse res) {
		try {
			player = playerDao.update(playerId, player);
			if(player == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			player = null;
		}
		return player;
		
	}
	
	@DeleteMapping("players/{playerId}")
	public void deletePlayer(@PathVariable Integer playerId, HttpServletResponse res) {
		try {
			if(playerDao.deleteById(playerId)) {//returns a boolean, if true deleted false if not
				res.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
}
