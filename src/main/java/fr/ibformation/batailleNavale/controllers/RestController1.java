package fr.ibformation.batailleNavale.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.batailleNavale.models.Game;

@RestController
@RequestMapping("/appli")
public class RestController1 {
	@RequestMapping("/game")
	public Game gaming(){
		Game game = new Game(null);
		return game;
	}

}
