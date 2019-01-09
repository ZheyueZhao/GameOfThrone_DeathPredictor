package Project3;

public class Character implements Comparable<Character>{
	//character class
	public String name;
	public String allegiances;
	public sLinkedList<Battle> battles;
	private String fatherName;
	private String motherName;
	private boolean isPatriarch;
	private boolean isMatriarch;
		//battle linkedlist in every character
	
	
	public Character(String name, String allegiances, sLinkedList<Battle> battles) {
		this.name=name;
		this.allegiances = allegiances;
		this.battles = battles;
			//constructor for characters
		
	}
	public void setfather(String name) {
		fatherName = name;
	}
	public void setmother(String name) {
		motherName= name;
	}
	public String getfather() {
		return fatherName;
	}
	public String getmother() {
		return motherName;
	}
	public void setPatri() {
		isPatriarch = true;
	}
	public boolean getPatri() {
		return isPatriarch;
	}
	public void setMatri() {
		isMatriarch = true;
	}
	public boolean getMatri() {
		return isMatriarch;
	}
	public Character(String name) {
		this.name = name;
	}
	
	public int compareTo(Character other) {
		return name.compareTo(other.name);
		}
	
	public String collecter() {
		//method to convert the battle list of characters to a string
		String collector = "";
		if(this.battles.length != 0) {
			
			sLinkedList.sllNode current = battles.first;
			while(current!=null) {
				
				collector = collector + current.data.toString();
				current = current.next;
			}
		}else {
			collector = " - No data for character" + "\n";
		}
		return collector;
		
	}
	
	public void bark() {
		System.out.println("6");
	}
	public String toString() {
		// convert all information to a string
		
		return name + " with alleigance to "+allegiances + "\n" + this.collecter();
			
	}
}
