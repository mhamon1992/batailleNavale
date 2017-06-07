package fr.ibformation.batailleNavale.models;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private List<Position> positions;
	/**
	 * @param positions
	 */
	public Map() {
		super();
		this.positions = new ArrayList<Position>();
		for(int i = 0; i<Parameter.maxWitdth;i++){
			for(int j = 0; j< Parameter.maxWitdth;j++){
				Position pos = new Position(i,j,false,false);
				this.positions.add(pos);
			}
		}
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	public void setBoatOnMap(Position pos){
		for(int i =0; i<positions.size();i++){
			if(positions.get(i).getAbscisse() == pos.getAbscisse() && positions.get(i).getOrdonnee() == pos.getOrdonnee()){
				positions.set(i, pos);
			}
		}
	}
	public void setMissileOnMap(Position pos){
		for(int i =0; i<positions.size();i++){
			if(positions.get(i).getAbscisse() == pos.getAbscisse() && positions.get(i).getOrdonnee() == pos.getOrdonnee()){
				positions.set(i, pos);
			}
		}
	}
}
