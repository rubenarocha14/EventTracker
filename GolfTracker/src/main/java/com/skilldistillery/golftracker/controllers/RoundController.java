package com.skilldistillery.golftracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.golftracker.data.RoundDAO;
import com.skilldistillery.golftracker.entities.Player;
import com.skilldistillery.golftracker.entities.Round;
import com.skilldistillery.golftracker.services.RoundService;

@RestController
@RequestMapping("api")
public class RoundController {
	
	@Autowired
	private RoundDAO roundDao;
	
	@Autowired
	private RoundService roundServ;

	@GetMapping("rounds")//working
	public List<Round> listRounds(){
		return roundServ.listAllRounds();
	}
	
	@GetMapping("rounds/{roundId}")//working
	public Round roundById(@PathVariable Integer roundId) {
		return roundServ.showRound(roundId);
	}
	
	@PostMapping("rounds")//working
	public Round createRound(@RequestBody Round round, HttpServletResponse resp, HttpServletRequest req) {
		try {
			round = roundDao.create(round);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL(); //ReqURL only returns StrBuffer, cannot use normal string concat
			url.append("/").append(round.getId());
			resp.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			round = null;
		}
		return round;
		
	}
	
	@PutMapping("rounds/{roundId}")
	public Round updateRound(@PathVariable Integer roundId, @RequestBody Round round, HttpServletResponse res) {
		try {
			round = roundDao.update(roundId, round);
			if(round == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			round = null;
		}
		return round;
		
	}
	
	@DeleteMapping("rounds/{roundId}")
	public void deleteRound(@PathVariable Integer roundId, HttpServletResponse res) {
		try {
			if(roundDao.deleteById(roundId)) {//returns a boolean, if true deleted false if not
				res.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	
}
