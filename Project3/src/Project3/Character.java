package Project3;

public class Character implements Comparable<Character>{
	//character class
	public String name;
	public String allegiances;
	public sLinkedList<Battle> battles;
	private String fatherName;
	private String motherName;
	//new field for name of mother and father
	private boolean isPatriarch;
	private boolean isMatriarch;
	//ispatri/ is matri field
		//battle linkedlist in every character
	
	
	public Character(String name, String allegiances, sLinkedList<Battle> battles) {
		this.name=name;
		this.allegiances = allegiances;
		this.battles = battles;
			//constructor for characters
		
	}
	public Character(String name, String allegiances, sLinkedList<Battle> battles,String fatherName,String motherName,boolean isPatriarch, boolean isMatriarch) {
		this.name=name;
		this.allegiances = allegiances;
		this.battles = battles;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.isPatriarch = false;
		this.isMatriarch = false;
			//constructor for characters
		
	}
	public void setfather(String name) {
		fatherName = name;
	}
	public void setmother(String name) {
		motherName= name;
	}
	//setter for mother
	public String getfather() {
		return fatherName;
	}
	//getter for father
	public String getmother() {
		return motherName;
	}
	//getter for mothers
	public void setPatri() {
		isPatriarch = true;
	}
	//setter for patriarch
	public boolean getPatri() {
		return isPatriarch;
	}
	//getter for patriarch
	public void setMatri() {
		isMatriarch = true;
	}
	//setter for matriarch
	public boolean getMatri() {
		return isMatriarch;
	}
	//getter for matriarch
	public Character(String name) {
		this.name = name;
	}
	//constructor of characters
	
	public int compareTo(Character other) {
		return name.toLowerCase().compareTo(other.name.toLowerCase());
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
