package Project3;

public class House implements Comparable<House>{
	private String name;
	//name of house
	protected sLinkedList<Character> members;
	private Character patriarch;
	private Character matriarch;
	//private field of patri and matri
	public FamilyTree familyTree;
	
	public House(String name) {
		this.name = name;
	}
	//constructor for house, just requires name
	//we can populate members down the line
	public void printmembers() {
		for(int i=0;i<members.length;i++) {
			//print the members of houses, mostly used for personal testing
			System.out.println(members.get(i).getfather());
		}
		
	}
	public String getName() {
		//getter for the name of house
		return name;
	}
	public void setPat(Character Pat) {
		this.patriarch = Pat;
		//setter for patriarch
	}
	public Character getPat() {
		return patriarch;
		//getter for patriarch
	}
	public Character getMat() {
		return matriarch;
		//getter for matriarch
	}
	public void setMat(Character Mat) {
		this.matriarch = Mat;
		//setter for matriarch
	}
	public void setList(sLinkedList<Character> members) {
		//setter for members list
		members = this.members;
	}
	public String getAlly() {
		return name;
		//getter for name of house
	}

	
	public int compareTo(House other) {
		// TODO Auto-generated method stub
		return name.compareTo(other.name);
	}
	//compare to method
	private void bark() {
		System.out.println("Hi");
	}
	//useless method
	
	
	
}
