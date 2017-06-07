package fr.ibformation.batailleNavale.models;

public class Position {
	private int abscisse;
	private int ordonnee;
	private boolean occupe;
	private boolean shooted;
	
	
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
