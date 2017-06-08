package fr.ibformation.batailleNavale.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gameId;
	@OneToOne
	private Player player1;
	@OneToOne
	private Player player2;
	@OneToOne
	private Map ownMap;
	@OneToOne
	private Map attackMap;
	private int nbTour;
	
	/**
	 * 
	 */
	public Game(Player player) {
		super();
		this.player1 =  player;
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Map getOwnMap() {
		return ownMap;
	}

	public void setOwnMap(Map ownMap) {
		this.ownMap = ownMap;
	}

	public Map getAttackMap() {
		return attackMap;
	}

	public void setAttackMap(Map attackMap) {
		this.attackMap = attackMap;
	}
	

	public int getNbTour() {
		return nbTour;
	}

	public void setNbTour(int nbTour) {
		this.nbTour = nbTour;
	}

	public void incrementTour(){
		nbTour++;
	}
	
}
