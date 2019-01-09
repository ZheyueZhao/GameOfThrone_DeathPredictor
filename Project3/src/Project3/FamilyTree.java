package Project3;

import java.util.ArrayList;

import Project3.FamilyTree.CharacterNode;
import Project3.sLinkedList.sllNode;
import java.lang.*;
public class FamilyTree {
	//family tree class
	 static class CharacterNode implements Comparable<CharacterNode>{
		 //nested CharacterNode class
		 //contains datafield for Character, father, mother and a list of CHildren
		private Character character;
		private CharacterNode father;
		private CharacterNode mother;
		public sLinkedList<CharacterNode> children;
		@Override
		public int compareTo(CharacterNode o) {
			// TODO Auto-generated method stub
			return character.compareTo(o.character);
		}
		//CompareTo method 
		public CharacterNode(Character Char) {
			character = Char;
		}
		//Constructor for CharacterNode
		public CharacterNode() {
			
		}
		
	}
	private static int number = 0;
		//a static variable to use in findNode method
		//determine whether node was found after running though tree of patriarch
	private CharacterNode patriarch;
	private CharacterNode matriarch;
	
	public int getNumber() {
		return number;
	}
		//get the value of our static int
	public void resetNumber() {
		number = 0;
	}
		//reset the value of static int back to zero
	public CharacterNode getPatriarch() {
		return patriarch;
		
	}
		//getter to retrieve our value for patriarch
	public CharacterNode getMatriarch() {
		return matriarch;
	}
		//getter to retrieve value for matriarch
	
	public FamilyTree buildFamilyTree(House h){
		ArrayList<CharacterNode> CharacterNodeList = new ArrayList<CharacterNode>();
		
		for(int i=0;i<h.members.length;i++) {
			CharacterNode newChar = new CharacterNode(h.members.get(i));
			CharacterNodeList.add(newChar);
			//create a list of CharacterNodes and then append all values of member to it
			//so we have a list of characterNode that includes all our family members
			
		}
		for(CharacterNode outerNode: CharacterNodeList) {
			Character PatriarchNode = new Character("Patriarch",null,null,null,null,false,false);
			Character MatriarchNode = new Character("Matriarch",null,null,null,null,false,false);
				//default node for matriarch and patriarchs
				//father/mother node of matriarch and patriarch will be this
				//easier for lineage to String method
			if(outerNode.character.getPatri()==true) {
				patriarch = outerNode;
				patriarch.father = new CharacterNode(PatriarchNode);
				patriarch.mother = new CharacterNode(MatriarchNode);
				//set father to default patriarch
				//set mother to default matriarch
			}
			else if(outerNode.character.getMatri()==true) {
				matriarch = outerNode;
				matriarch.father = new CharacterNode(PatriarchNode);
				matriarch.mother = new CharacterNode(MatriarchNode);
				//set father to default patriarch
				//set mother to default matriarch
			}
		}
		
		
		for(CharacterNode outerNode: CharacterNodeList) {
			Character NoFather = new Character(null,null,null,null,null,false,false);
				//dafault node for orphans with missing mother or father
			if(outerNode.character.getfather().equals("")) {
				outerNode.father = new CharacterNode(NoFather);
				//give orphans a new father of NoFather
			}
			if(outerNode.character.getmother().equals("")) {
				outerNode.mother = new CharacterNode(NoFather);
				//give orphans a new mother of NoFather
			}
		
		}
		
		for(CharacterNode outerNode: CharacterNodeList) {
			Character mother = new Character(outerNode.character.getmother(),null,null,null,null,false,false);
			Character father = new Character(outerNode.character.getfather(),null,null,null,null,false,false);
			//temperory mother/father Node
			//a nested loop through the members' list from House class. if the current member of the outer loop has some sort
			//of a relationship with a current member of the inner loop, I linked them up
			for(CharacterNode innerNode: CharacterNodeList) {
				
				
				if(innerNode.character.name.equals(father.name)) {
					
					outerNode.father = innerNode;
					
					//checker if outerNode is innerNode's father, if yes, hook them up
					
				}else if(innerNode.character.name.equals(mother.name)) {
					
				
					outerNode.mother = innerNode;
					//checker if outerNode is innerNode's mother, if yes, hook them up
					
				}
				
				
			}
			
			
		}
		
		
		
		
		
		for(CharacterNode outerNode: CharacterNodeList) {
			sLinkedList<CharacterNode> CurrentChildren = new sLinkedList<CharacterNode>();
			//create a linkedlist of children
			for(CharacterNode innerNode: CharacterNodeList) {
				if(innerNode.father == outerNode ) {
					CurrentChildren.insertFirst(innerNode);
					//again. with a nested loop, I check if inner node is a children of outerNode
					//if yes, I add innernode to the list
				}
				if(innerNode.mother == outerNode) {
					CurrentChildren.insertFirst(innerNode);
					//same procedute for mother
				}
			}
			outerNode.children = CurrentChildren;
				//after all children has been added to our temperory linkedlist
				//we set children list to our temp list
		}
		
		for(int i=0;i<CharacterNodeList.size();i++) {
			if(CharacterNodeList.get(i).mother == null && h.members.get(i).getmother()!="") {
				Character newChar = new Character(h.members.get(i).getmother(),null,null,null,null,false,false);
				CharacterNode newCharNode = new CharacterNode(newChar);
				CharacterNodeList.get(i).mother = newCharNode;
			}
		}
		return this;
	
	}
	
		public void printTree(CharacterNode c) {
			//wrapper for print tree method, because instruction only says one input
			//so I write a second class as a helper
			//the integer passed in records how many time a recursion is called
			//therefore it knows how many empty spaced to print
			System.out.println();
				System.out.println(c.character.allegiances+":");
				printTree(0,c);
			
			
		}
		public void printTreeMat(CharacterNode c) {
			//same idea, another wrapper. does the same thing 
			//but the easier for me to test.
			System.out.println();
			printTree(0,c);
		
		
	}
		
		  public void printTree(int g, CharacterNode c) {
				
				//System.out.print(c.character.name + "-father: "+c.father.character.name+"-mother: "+c.mother.character.name);
				String str = "     ";
				//a string of 5 empty spaces
				//empty spaces compound with times a recursion is called
				for(int i=0;i<g;i++) {
					System.out.print(str);
				}
				
				System.out.print(c.character.name + " -father: "+c.father.character.name + "-mother: "+c.mother.character.name);
				System.out.println("     ");
				
				
				if(c.children.length>0) {
					
					for(int i=0;i<c.children.length;i++) {
						
						System.out.print("     ");
						printTree(g+1,c.children.get(i));
						//call the recursion with one added to our integer
						//and c.children passed in as new node
					}
				}
			
			
		}
		public void findCharacterNode(CharacterNode startingPoint, CharacterNode ch) {
			//find Character method, works in conjunction with lineageToString to print our lineage
			
			if(ch.character.name.toLowerCase().equals(startingPoint.character.name.toLowerCase())) {
				//if startingpoint character name is identical to what we are searching fot
				number++;
				lineageToString(startingPoint);
				//we pass the starting point node to lineage method, therefore printing out the lineage of that char
				
				return;
				
			}else {
				
				for(int i=0;i<startingPoint.children.length;i++) {
					//other wise, loop through the children linklist, and call recursion on every one of its children
					 findCharacterNode(startingPoint.children.get(i),ch);
					 //same process repreats until found, or until list exaustion
					 //this is where number comes into play, if number is zero, that means list exhausted
					 //thus we try to pass in the matriarch see if it can be found there
				}
				
				
			}
			
			
			
		}
		
public void findCharacterNode2(CharacterNode startingPoint, CharacterNode ch) {
	//same method as previous one however this one specifically for matriarch,
	//since we not adding to static variable
	CharacterNode newNode = new CharacterNode();
			if(ch.character.name.toLowerCase().equals(startingPoint.character.name.toLowerCase())) {
				
				
				lineageToString(startingPoint);
				
				
				return;
				
			}else {
				
				for(int i=0;i<startingPoint.children.length;i++) {
					
					 findCharacterNode(startingPoint.children.get(i),ch);
				}
				
				
			}
			
			
			
		}
		
		/*public CharacterNode findCharacterNode(CharacterNode startingPoint, CharacterNode ch) {
			if(ch == startingPoint) {
				System.out.println("Node found");
				return startingPoint;
			}else {
				for(int i=0;i<startingPoint.children.length;i++) {
					return findCharacterNode(startingPoint.children.get(i),ch);
				}
				
				
			}
			return null;
		}*/
		public void lineageToString (CharacterNode c) {
			//preorder traversal, we print out information for ourself first
			System.out.println(c.character.name + " -father: "+c.father.character.name + "-mother: "+c.mother.character.name);
			
			
			//and then move on to the father'side, if he is a patriarch, we sat he is a patriarch and expect to get nothing else
			System.out.println("Father's Side");
			if(c==patriarch) {
				System.out.println("Dude is Patriarch");
			}
			lineageToString2(c.father);
			//call lineagetoString helper class recusively, to continue traversal
			//use a helper class because the existance of some key words such as "father's side"
		
			System.out.println();
			
			System.out.println("Mother's Side");
			//same process but for mothers
			if(c==matriarch) {
				System.out.println("Lady is Matriarch");
			}
			lineageToString2(c.mother);
			System.out.println();
		}
		public void lineageToString2(CharacterNode c) {
			//helper class for lineage
			if(c!=null && c.father!=null&&c.mother!=null) {
				//if we are not null, our mother or father are not null
				//Since I given orphans a father called Nofather
				//orphans or single parents will still get a null for the c.mother.char.name field
				
				System.out.println(" "+c.character.name + " -father: "+c.father.character.name + "-mother: "+c.mother.character.name);
							
			}else {
				return;
			}
			lineageToString2(c.father);
			lineageToString2(c.mother);
			//keep calling recusion until can't base case kicks in
		}
		
		
		/*
		public void lineagefatherhelper(CharacterNode c) {
			System.out.println("  "+c.character.name + " -father: "+c.father.character.name + "-mother: "+c.mother.character.name);
			if(c.father.character.name!=null&&c!=patriarch) {
				
				lineagefatherhelper(c.father);
			}
			if(c.mother.character.name!=null&&c!=matriarch) {
				lineagefatherhelper(c.mother);
			}
			
			
		}
		
		public void lineagemotherhelper(CharacterNode c) {
			System.out.println("  "+c.character.name + " -father: "+c.father.character.name + "-mother: "+c.mother.character.name);
			if(c.mother!=null) {
				if(c == matriarch) {
					return;
				}
				lineagemotherhelper(c.mother);
			}
		}*/
		
	}


/*
int checker = 0; 
                    // index to iterate through members list
while(checker < h.members.length) {
	
	CharacterNode newChar = new CharacterNode();
                               //create a new CharacterNode to store information
	newChar.character = h.members.get(checker);
                               //set the character information to the character of our current index
	if(h.members.get(checker).getPatri() == true) {
		this.patriarch = newChar;
                               //if this member is patriarch, set patriarch to this character
	}else if(h.members.get(checker).getMatri() == true) {
		this.matriarch = newChar;
                               //if this member is matriarch, set patriarch to this character
	}
	
	String fatherName = h.members.get(checker).getfather();
								//father's name
	String motherName = h.members.get(checker).getmother();
								//mother's name
	if(fatherName.equals(patriarch.character.name)) {
		newChar.father = patriarch;
                               //if the father of this character is the patriarch, set his father to patriarch
	}
	if(motherName.equals(matriarch.character.name)) {
		newChar.mother = matriarch;
                               //if the mother of this character is the matriarch, set his father to matriarch
	}
	
	int warden = 0;
	while(warden < h.members.length) {
		if(h.members.get(warden).name.equals(fatherName)) {
			CharacterNode newChar_father = new CharacterNode();
			newChar_father.character = h.members.get(warden);
			newChar.father = newChar_father;
		}
		
		
	}
								//If the name of father is found in the members list, create that Node
	while(warden < h.members.length) {
		if(h.members.get(warden).name.equals(motherName)) {
			CharacterNode newChar_mother = new CharacterNode();
			newChar_mother.character = h.members.get(warden);
			newChar.mother = newChar_mother;
		}
		
		
	}
								//If the name of mother is found in the members list, create that Node
	CharacterNode tempNode = new CharacterNode();
	
	checker++;
	      //add to checker to traverse through entire member list.
	*/