package fr.ibformation.batailleNavale.models;

public class Missile {
	private int idMissile;
	private Position position;
	/**
	 * @param numero
	 * @param position
	 */
	
	
	public Missile( Position position) {
		super();
		this.position = position;
	}
	/**
	 * 
	 */
	public Missile() {
		super();
	}
	
	public int getIdMissile() {
		return idMissile;
	}
	public void setIdMissile(int idMissile) {
		this.idMissile = idMissile;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
}
