package fr.ibformation.batailleNavale.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.ibformation.batailleNavale.factories.GameFactory;
@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPlayer;
	private String nickname;
	@OneToMany
	private List<Boat> boats;
	@OneToMany
	private List<Missile> missiles;
	private int score;
	private int nbvictory;
	@OneToOne
	private Game game;

	/**
	 * @param idPlayer
	 * @param nickname
	 * @param boats
	 */
	public Player( String nickname) {
		super();
		//		this.idPlayer = idPlayer;
		this.nickname = nickname;
		this.boats = new ArrayList<Boat>();
		this.missiles = new ArrayList<Missile>();
		this.setNbvictory(0);
		
	}
	/**
	 * 
	 */
	public Player() {
		super();
	}
	public int getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public List<Boat> getBoats() {
		return boats;
	}
	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	}
	public List<Missile> getMissiles() {
		return missiles;
	}
	public void setMissiles(List<Missile> missiles) {
		this.missiles = missiles;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getNbvictory() {
		return nbvictory;
	}
	public void setNbvictory(int nbvictory) {
		this.nbvictory = nbvictory;
	}
	
	public void sendMissile(int x, int y, Map map,Player player){
		this.missiles.add( new Missile(new Position(x, y, false, true)));
		for(int i =0; i<map.getPositions().size();i++){
			if(map.getPositions().get(i).getAbscisse() == x && map.getPositions().get(i).getOrdonnee() == y){
				if(map.getPositions().get(i).isOccupe() == true){
					map.setMissileOnMap(new Position(x, y, true, true));
					this.missiles.add( new Missile(new Position(x, y, true, true)));
					this.score++;
					System.out.println("Touché");
				}else{
					this.missiles.add( new Missile(new Position(x, y, false, true)));
					map.setMissileOnMap(new Position(x, y, false, true));
					System.out.println("plouf");
				}
			}
		}
		int i = 0;
		for(Boat boat: player.boats){
			boolean verif = boat.verification(map,player);
			if(verif == true){
				i++;
			}
		}
		System.out.println(player.boats.size());
		System.out.println("i:"+i);
		if(i == player.boats.size()){
			System.exit(1);
		}
	}

	public void addBoats(Map map, Boat boat1) throws InterruptedException{
		boolean res = false;
		while(res == false){
			Thread.sleep(500);
			Boat boat = boat1;
			boat.generateBoat();
			res = boat.Collision(map);
			boat1 = boat;
			System.out.println(res);
		}
		this.boats.add(boat1);
		for(Position pos :boat1.getPositions()){
			map.setBoatOnMap(pos);
//			game.setOwnMap(map);
		}
	}
	
	public Map boatsList(Map map) throws InterruptedException{
		for(int i =0;i<Parameter.nbAircraftCarrier;i++){
			addBoats(map, new AircraftCarrier());
			Thread.sleep(500);
		}
		for(int i =0;i<Parameter.nbBattleship;i++){
			addBoats(map, new Battleship());
			Thread.sleep(500);
		}
		for(int i =0;i<Parameter.nbCruiser;i++){
			addBoats(map, new Cruiser());
			Thread.sleep(500);
		}
		for(int i =0;i<Parameter.nbInterceptionSpeedBoat;i++){
			addBoats(map, new InterceptionSpeedBoat());
			Thread.sleep(500);
		}
		return map;
	}

	public Game createGame() throws InterruptedException{
		this.score = 0;
		Game game = GameFactory.createGame(this);
		game.setOwnMap(new Map());
		game.setAttackMap(new Map());
		game.setNbTour(0);
		Map ownMap = game.getOwnMap();
		ownMap = boatsList(ownMap);
		game.setOwnMap(ownMap);
		return game;
	}

	public void joinGame(Game game) throws InterruptedException{
		Map attackMap = game.getAttackMap();
		attackMap = boatsList(attackMap);
		game.setAttackMap(attackMap);
	}

	public void displayBoat(Map map){
		List<Position> positions = map.getPositions();
		int temp = 0;
		System.out.println();
		for(int i = 0;i<positions.size();i++){
			if(positions.get(i).getOrdonnee() == 0){
				if(positions.get(i).getAbscisse() != temp){
					//					System.out.println(positions.get(i).getAbscisse()+positions.get(i).getOrdonnee());
					//					System.out.println(positions.get(i).getOrdonnee());
					System.out.println();				
					temp = positions.get(i).getOrdonnee();
				}
				System.out.print("|");
			}


			if(positions.get(i).isOccupe()){
				System.out.print(1+"|");
			}else{
				System.out.print(0+"|");
			}
		}
	}

	public void displayAttacks(Map map){
		List<Position> positions = map.getPositions();
		int temp = 0;
		System.out.println();
		for(int i = 0;i<positions.size();i++){
			if(positions.get(i).getOrdonnee() == 0){
				if(positions.get(i).getAbscisse() != temp){
					System.out.println();
					temp = positions.get(i).getOrdonnee();
				}
				System.out.print("|");
			}
			if(positions.get(i).isShooted()){
				System.out.print("X|");
			}else{
				System.out.print("I|");
			}
		}
	}
	

}
