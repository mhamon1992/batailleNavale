package fr.ibformation.batailleNavale.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Missile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMissile;
	@OneToOne
	private Position position;
	@ManyToOne
	private Player player;
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
