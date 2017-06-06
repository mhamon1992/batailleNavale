package fr.ibformation.batailleNavale.factories;

import fr.ibformation.batailleNavale.models.Game;
import fr.ibformation.batailleNavale.models.Player;


public abstract class GameFactory {
	public static Game createGame(Player player){
		Game game = new Game(player);
		return game;
	}
	
	
}
