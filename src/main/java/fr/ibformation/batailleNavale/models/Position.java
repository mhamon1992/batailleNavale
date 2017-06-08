package fr.ibformation.batailleNavale.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int positionId;
	private int abscisse;
	private int ordonnee;
	private boolean occupe;
	private boolean shooted;
	@ManyToOne
	private Map map;
	@ManyToOne
	private Missile missile;
	@ManyToOne
	private Boat boat;
	
	/**
	 * 
	 */
	public Position() {
		super();
	}
	/**
	 * @param abscisse
	 * @param ordonnee
	 */
	public Position(int abscisse, int ordonnee, boolean occupe,boolean shooted) {
		super();
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.setOccupe(occupe);
		this.setShooted(shooted);
	}
	public int getAbscisse() {
		return abscisse;
	}
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	public int getOrdonnee() {
		return ordonnee;
	}
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	public boolean isOccupe() {
		return occupe;
	}
	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}
	public boolean isShooted() {
		return shooted;
	}
	public void setShooted(boolean shooted) {
		this.shooted = shooted;
	}
	
	
}
