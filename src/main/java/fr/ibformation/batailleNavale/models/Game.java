package fr.ibformation.batailleNavale.models;

public class Game {
	private Player player1;
	private Player player2;
	private Map ownMap;
	private Map attackMap;
	private int nbTour;
	
	/**
	 * 
	 */
	public Game(Player player) {
		super();
		this.player1 =  player;
		this.player2 = null;
		this.ownMap = new Map();
		this.attackMap = new Map();
		this.nbTour = 0;
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

	public void incrementTour(){
		nbTour++;
	}
	
}
