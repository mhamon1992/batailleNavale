package fr.ibformation.batailleNavale.models;

public class Map {
	private Position positions[][];
	/**
	 * @param positions
	 */
	public Map() {
		super();
		this.setPositions(new Position[Parameter.maxWitdth][Parameter.maxWitdth]);
	}
	public Position[][] getPositions() {
		return positions;
	}
	public void setPositions(Position positions[][]) {
		this.positions = positions;
	}
	
	public void setBoatOnMap(Position pos){
		this.positions[pos.getAbscisse()][pos.getOrdonnee()] = pos;
	}
}
