package fr.ibformation.batailleNavale.models;


import java.util.ArrayList;
import java.util.List;

import fr.ibformation.batailleNavale.factories.GameFactory;

public class Player {
	private int idPlayer;
	private String nickname;
	private List<Boat> boats;
	private List<Missile> missiles;
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
	
	public void sendMissile(int x, int y, Map map){
		this.missiles.add( new Missile(new Position(x, y, false, true)));
		for(int i =0; i<map.getPositions().size();i++){
			if(map.getPositions().get(i).getAbscisse() == x && map.getPositions().get(i).getOrdonnee() == y){
				if(map.getPositions().get(i).isOccupe() == true){
					map.setMissileOnMap(new Position(x, y, true, true));
					this.missiles.add( new Missile(new Position(x, y, true, true)));
					System.out.println("Touché");
				}else{
					this.missiles.add( new Missile(new Position(x, y, false, true)));
					map.setMissileOnMap(new Position(x, y, false, true));
					System.out.println("plouf");
				}
			}
		}
		
		
	}
	
	public void addBoats(){
		Boat boat = new AircraftCarrier();
		boat.generateBoat();
		this.boats.add(boat);
	}
	
	public Game createGame(){
		Game game = GameFactory.createGame(this);
		addBoats();
		game.setOwnMap(new Map());
		game.setAttackMap(new Map());
		game.setNbTour(0);
		Map ownMap = game.getOwnMap();
		for(Boat boat :this.getBoats()){
			for(Position pos :boat.getPositions()){
				ownMap.setBoatOnMap(pos);
				game.setOwnMap(ownMap);
			}
		}
		return game;
	}
	
	public void joinGame(Game game){
		Map attackMap = game.getAttackMap();
		addBoats();
		for(Boat boat :this.getBoats()){
			for(Position pos :boat.getPositions()){
				attackMap.setBoatOnMap(pos);
				game.setAttackMap(attackMap);
			}
		}
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
