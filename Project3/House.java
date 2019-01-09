package Project3;

public class House implements Comparable<House>{
	private String name;
	protected sLinkedList<Character> members;
	private Character patriarch;
	private Character matriarch;
	public FamilyTree familyTree;
	
	public House(String name) {
		this.name = name;
	}
	
	public void setPat(Character Pat) {
		this.patriarch = Pat;
	}
	public Character getPat() {
		return patriarch;
	}
	public Character getMat() {
		return matriarch;
	}
	public void setMat(Character Mat) {
		this.matriarch = Mat;
	}
	public void setList(sLinkedList<Character> members) {
		
		members = this.members;
	}
	public String getAlly() {
		return name;
	}


	public int compareTo(House other) {
		// TODO Auto-generated method stub
		return name.compareTo(other.name);
	}
	public void bark() {
		System.out.println("Hi");
	}
	
	
	
	
}
