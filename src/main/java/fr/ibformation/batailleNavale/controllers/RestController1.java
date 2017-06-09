package fr.ibformation.batailleNavale.controllers;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import fr.ibformation.batailleNavale.models.*;
import fr.ibformation.batailleNavale.repositories.PlayerRepository;

@Controller
@RequestMapping("/appli")
public class RestController1 {
	
	@Autowired
	PlayerRepository player;
	@RequestMapping(value ="/index", method=RequestMethod.GET)
	public @ResponseBody ModelAndView playerForm(){
		ModelAndView mav = new ModelAndView("index","player", new Player());
		return mav;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public @ResponseBody String loginPlayer(@RequestParam String nickname){
		Player player1;
		if(player.findByNickname(nickname)!=null){
			player1 = player.findByNickname(nickname); 
		}else{
			player1 = new Player(nickname);
			player.save(player1);
		}
		
		
		return "menu";
	}
	
	@RequestMapping(value ="/menu", method=RequestMethod.GET)
	public @ResponseBody ModelAndView menu(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menu");
		return mav;
		
	}
//	
//	@RequestMapping("/game")
//	public Game gaming(){
//		Game game = new Game(null);
//		return game;
//	}

}
