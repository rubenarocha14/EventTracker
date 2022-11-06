package com.skilldistillery.golftracker.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Round {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "holes_played")
	private int holesPlayed;
	
	@Column (name = "num_players")
	private int numPlayers;
	
	private int score;
	
	@ManyToOne
	@JoinColumn(name="player_id")
	private Player player;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	public Round() {
		super();
	}
	
	public Round(int id, int holesPlayed, int numPlayers, int score,  Player player, Course course) {
		super();
		this.id = id;
		this.holesPlayed = holesPlayed;
		this.numPlayers = numPlayers;
		this.player = player;
		this.course = course;
		this.score = score;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHolesPlayed() {
		return holesPlayed;
	}

	public void setHolesPlayed(int holesPlayed) {
		this.holesPlayed = holesPlayed;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Round other = (Round) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Round [id=" + id + ", holesPlayed=" + holesPlayed + ", numPlayers=" + numPlayers + ", score=" + score
				+ ", player=" + player + ", course=" + course + "]";
	}


	
	

}
