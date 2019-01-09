package Project3;

public class Prediction implements Comparable<Prediction>{
	private float plod;
	private Character character;
	@Override
	public int compareTo(Prediction sample){
		// TODO Auto-generated method stub
		if(sample.plod<this.plod) {
			return -1;
		}else if(sample.plod>this.plod) {
			return 1;
		}else {
			return 0;
		}
	}
	Prediction(float plod,Character character){
		this.plod = plod;
		this.character = character;
	}
	public Character getCharacter() {
		return character;
	}
	public float getPlod() {
		return plod;
	}
	public String toString() {
		return character.name;
	}
	
	
}
