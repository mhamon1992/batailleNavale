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
	
	public void sendMissile(int x, int y){
		this.missiles.add( new Missile(new Position(x, y, false, true)));
	}
	
	public void addBoats(){
		Boat boat = new AircraftCarrier();
		boat.generateBoat();
		this.boats.add(boat);
	}
	
	public void createGame(){
		Game game = GameFactory.createGame(this);
		Map ownMap = game.getOwnMap();
		for(Boat boat :this.getBoats()){
			for(Position pos :boat.getPositions()){
				ownMap.setBoatOnMap(pos);
				game.setOwnMap(ownMap);
			}
		}
	}
	
	public void joinGame(Game game){
		Map attackMap = game.getAttackMap();
		for(Boat boat :this.getBoats()){
			for(Position pos :boat.getPositions()){
				attackMap.setBoatOnMap(pos);
				game.setAttackMap(attackMap);
			}
		}
	}
	
}
