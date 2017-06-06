package fr.ibformation.batailleNavale.models;


public class Boat {
	private String boatName;
	private int boatWidth;
	private Position positions[];
	/**
	 * 
	 */
	protected Boat() {
		super();
	}
	/**
	 * @param nomBateau
	 * @param tailleBateau
	 * @param positions
	 */
	protected Boat(String boatName, int boatWidth) {
		super();
		this.boatName = boatName;
		this.boatWidth = boatWidth;
		this.positions = new Position[boatWidth];
	}
	public String getNomBateau() {
		return boatName;
	}
	public void setNomBateau(String boatName) {
		this.boatName = boatName;
	}
	public int getTailleBateau() {
		return boatWidth;
	}
	public void setTailleBateau(int boatWidth) {
		this.boatWidth = boatWidth;
	}
	public Position[] getPositions() {
		return positions;
	}
	public void setPositions(Position[] positions) {
		this.positions = positions;
	}
	public void generateBoat(){
		int value = (int) Math.random();
		int initPositionX = (int) Math.random()*9;
		int initPositionY = (int) Math.random()*9;
		
		if(value == 0){
			for(int i = 0; i<this.getTailleBateau();i++){
					this.positions[i].setOccupe(true);
					this.positions[i].setShooted(false);
					this.positions[i].setOrdonnee(initPositionY);
				if(initPositionX + this.getTailleBateau() >= Parameter.maxWitdth){
					this.positions[i].setAbscisse(initPositionX-i);
				}else{
					this.positions[i].setAbscisse(initPositionX+i);
				}
			}
		}else{
			for(int i = 0; i<this.getTailleBateau();i++){
				this.positions[i].setOrdonnee(initPositionX);
				if(initPositionY + this.getTailleBateau() >= Parameter.maxWitdth){
					this.positions[i].setAbscisse(initPositionY-i);
				}else{
					this.positions[i].setAbscisse(initPositionY+i);
				}
			}
		}
	}
	
	
	
}


