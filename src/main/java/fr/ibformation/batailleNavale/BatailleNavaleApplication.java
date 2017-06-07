package fr.ibformation.batailleNavale;

import java.util.Scanner;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.ibformation.batailleNavale.factories.PlayerFactory;
import fr.ibformation.batailleNavale.models.Game;
import fr.ibformation.batailleNavale.models.Parameter;
import fr.ibformation.batailleNavale.models.Player;

@SpringBootApplication
public class BatailleNavaleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BatailleNavaleApplication.class, args);
		Player player1 = PlayerFactory.createPlayer("KIRITO");
		Player player2 = PlayerFactory.createPlayer("MAX");
		Game game = player1.createGame();
		player2.joinGame(game);
		for(int nbTour = game.getNbTour(); nbTour<Parameter.maxRound; nbTour++){
			System.out.println("nombre de tour"+game.getNbTour());
			player1.displayBoat(game.getOwnMap());
			player1.displayAttacks(game.getAttackMap());
			System.out.println();
			player2.displayBoat(game.getAttackMap());
			player2.displayAttacks(game.getOwnMap());
			System.out.println();
			Scanner scan = new Scanner(System.in);
			System.out.println("position du tir en x");
			int x = scan.nextInt();
			System.out.println("position du tir en y");
			int y = scan.nextInt();
			player1.sendMissile(x, y, game.getAttackMap(),player2);
			
			System.out.println("position du tir en x");
			int x1 = scan.nextInt();
			System.out.println("position du tir en y");
			int y1 = scan.nextInt();
			player2.sendMissile(x1, y1, game.getOwnMap(),player1);
			game.incrementTour();
		}
		if(player1.getScore()>player2.getScore()){
			System.out.println(player1.getNickname()+" a gagné");
			player1.setNbvictory(player1.getNbvictory()+1);
		}else if(player1.getScore() == player2.getScore()){
			System.out.println("égalité");
		}else{
			System.out.println("victoire de:"+player2.getNickname());
			player2.setNbvictory(player2.getNbvictory()+1);
		}
		
		
	}
}
