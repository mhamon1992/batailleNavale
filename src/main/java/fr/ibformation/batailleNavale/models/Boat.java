package fr.ibformation.batailleNavale.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Boat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int boatId;
	private String boatName;
	private int boatWidth;
	@OneToMany
	private List<Position> positions;
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
		this.positions = new ArrayList<Position>();
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
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	public void generateBoat(){
		Random random = new Random();
		int value = random.nextInt(2);
		System.out.println("orientation"+value);
		int initPositionX = random.nextInt(9);
		int initPositionY = random.nextInt(9);
		if(value == 0){
			for(int i = 0; i<this.getTailleBateau();i++){
				Position pos = new Position();
				pos.setOccupe(true);
				pos.setShooted(false);
				pos.setOrdonnee(initPositionY);
				if(initPositionX + this.getTailleBateau() >= Parameter.maxWitdth){
					pos.setAbscisse(initPositionX-i);
				}else{
					pos.setAbscisse(initPositionX+i);
				}
				this.positions.add(pos);
			}
		}else if(value == 1){
			for(int i = 0; i<this.getTailleBateau();i++){
				Position pos = new Position();
				pos.setOccupe(true);
				pos.setShooted(false);
				pos.setAbscisse(initPositionX);
				if(initPositionY + this.getTailleBateau() >= Parameter.maxWitdth){
					pos.setOrdonnee(initPositionY-i);
				}else{
					pos.setOrdonnee(initPositionY+i);
				}
				this.positions.add(pos);
			}
		}
	}

	public boolean verification(Map map, Player player){
		int x;
		int y;
		int value = 0;
		boolean res = false;
		for(int i =0 ; i<positions.size();i++){
			x = this.positions.get(i).getAbscisse();
			y = this.positions.get(i).getOrdonnee();
			int index = (x*Parameter.maxWitdth)+y;
			if(map.getPositions().get(index).isShooted()){
				value++;
			}
			System.out.println(map.getPositions().get(index).isShooted());
		}
		System.out.println(value);
		if( value == positions.size()){
			System.out.println(this.getNomBateau()+" de "+player.getNickname()+" coulé ");
			res = true;

		}
		return res;
	}

	public boolean Collision(Map map){
		boolean res = true;
		for(Position pos: this.getPositions()){
			int index = (pos.getAbscisse()*10+pos.getOrdonnee());
			if(map.getPositions().get(index).isOccupe()){
				res = false;
			}
		}
		return res;
	}


}


