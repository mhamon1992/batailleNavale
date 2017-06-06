package fr.ibformation.batailleNavale.factories;


import fr.ibformation.batailleNavale.models.Player;

public abstract class PlayerFactory {
	
	public Player createPlayer(String nom){
		Player player = new Player(nom);
		return player;
	}
	
	
}
