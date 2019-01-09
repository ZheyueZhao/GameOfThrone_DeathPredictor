package Project3;
import java.util.*;
import java.io.File;

import java.io.FileNotFoundException;

import Project3.FamilyTree.CharacterNode;
import Project3.sLinkedList.sllNode;
import java.math.*;
public class GameOfThrones {
	
	public static <E> void main(String[] args) {
		
			
			
			
			//open datasets
		 String deathName = "data/predictions.csv";
		 String battleName = "data/battles.csv";
		 String charName = "data/characters_lineage.csv";
		 File battles_base = new File(battleName);
		 File char_base = new File(charName);
		 File death_base = new File(deathName);
		 
		 Scanner inputFile = null;
		 Scanner inputFile2 = null;
		 Scanner inputFile3 = null;
		 	//battles.csv data recording
		 try {
			 inputFile2 = new Scanner(char_base);
			 inputFile = new Scanner(battles_base);
			 inputFile3 = new Scanner(death_base);
		 } catch (FileNotFoundException e) {

			 	System.err.printf("Error: cannot read "
			 			+ "data from file %s" ,battleName);
			 	System.exit(1);
			 	//return an error if dile can not be found or read in general
		 }
		 
		sLinkedList<Battle> allBattles = new sLinkedList<Battle>(); 
		//list for all battles
		List<String> allAlligation = new ArrayList<String>();
		
		pqLinkedList<Prediction> predictionsLL = new pqLinkedList<Prediction>();
		pqMyArrayList<Prediction> predictionsAL = new pqMyArrayList<Prediction>();
		pqMyArrayList<Prediction> predictionsRunTime = new pqMyArrayList<Prediction>();
		//list for allifations
		 
		
		 allBattles.first = allBattles.mergeSort(allBattles.first);
		 allBattles.displayList();
		 // create a list to include all battles
		
		 while (inputFile.hasNextLine()) {
			 String data = inputFile.nextLine();
			 String[] values = data.split(","); // split string into arrays
			
			 allBattles.insertFirst(new Battle(values[0],values[1],values[2],values[3],values[4],values[5],values[6]));
			 	//instantiate a battle for each line of datas
			 
		 }
		 
		 
		 allBattles.first = allBattles.mergeSort(allBattles.first);
		 //merge sort all battles
		 
		 sLinkedList allChars = new sLinkedList();
		 
		 	//manage characters information
		 ArrayList newList = new ArrayList<>();
		 
		 while(inputFile2.hasNextLine()) {		
			 

			 String data = inputFile2.nextLine();
			 //data = data.toLowerCase();
			 
			 String[] values = data.split(",");
			
	
			
			 
			 
			 if(newList.contains(values[3])) {
					
				}else {
					
					
					newList.add(values[3]);
				}
			 
			 
			 
			 sLinkedList participated_battles = search(values[0],allBattles);
			 Character newChar = new Character(values[0],values[3],participated_battles);
			 //instantiation of character, name, allegence and list of battles
			 if(values[1].toLowerCase().equals("patriarch")) {
				 //if patriarh name is equal, then we set that character to patri
				 newChar.setPatri();
				 
			 }
			 if(values[2].toLowerCase().equals("matriarch")) {
				 newChar.setMatri();
				 //same concept but with matriarch
			 }
			 
			 newChar.setfather(values[1]);
			 //since the second spot of data sheet is father name, we can use that to set father of our character
			 newChar.setmother(values[2]);
			//since the third spot of data sheet is father name, we can use that to set father of our character
			 allChars.insertFirst(newChar);
			 			 			 		//character is a member of all the characters, so we add then
			 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 String data = inputFile3.nextLine();
		
		 while(inputFile3.hasNextLine()) {
			 data = inputFile3.nextLine();
			 String[] values = data.split(",");
			 Character newChar = new Character(values[1],null,null);
			
			 Prediction newPrediction = new Prediction(Float.parseFloat(values[0]),newChar);
			 predictionsLL.insert(newPrediction);
			 predictionsAL.insert(newPrediction);
		 }
		 
		 
		 
		
		
		
		 
		
			// System.out.println(predictionsAL.size());
			
		//	 System.out.println(predictionsAL.remove());
		//	 System.out.println(predictionsAL.remove());
		 
			// System.out.println(predictionsAL.remove());
		 
		//	 System.out.println(predictionsAL.remove());
			 
		//	 System.out.println(predictionsAL.size());
		 //
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 allChars.first = allChars.mergeSort(allChars.first);
		 
		
		
		 
		 sLinkedList<House> allAlly = new sLinkedList<House>();
		
		 for(int i=1;i<newList.size();i++) {
			 House newHouse = new House((String) newList.get(i));
			 allAlly.insertFirst(newHouse);
		 }
		
		 sLinkedList<House> allAllies = whereismysister(allChars,allAlly);
		 
		
		
		Character newChar = new Character("eddard stark",null,null,null,null,false,false);
		predictionsRunTime = predictionsAL; // keep a record of original arraylist
		
		boolean sLinkedList_trigger = false;
		boolean MyArrayList_trigger = false;
		
		while(true) {
			
			sLinkedList.sllNode current = allChars.first;
			
			
			
			 // take in userinputs
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a character name (or type \"all\" for all characters, \"family tree\" for a family tree of all houses,\r\n" + 
					"\"remove all\" to remove all characters, \"remove next\" to remove the next character,\r\n" + 
					"\"use sLinkedList\" to use the linked list heap, \"use MyArrayList\" to use the MyArrayList heap,\r\n" + 
					"\"LLTD\" to see which character is the least likely to die,\r\n" + 
					"or \"exit\" to exit):");
			String input = reader.nextLine();	
			input = input.toLowerCase();
				//make sure input is case insensitive
			if(input.equals("exit")) {
				System.out.println("System exiting");
				break;
			}else
			if(input.equals("use slinkedlist")) {
				
				System.out.println("Now using sLinkedList!");
				System.out.println();//empty space
				sLinkedList_trigger = true;
				MyArrayList_trigger = false;//if choose linkedlist, set linkedlist trigger to true, arraylist trigger to false
				
			}else if(input.equals("use myarraylist")) {
				System.out.println("Now using MyArrayList!");
				System.out.println();//empty space
				MyArrayList_trigger = true;
				sLinkedList_trigger = false;//vise versa
				
			}else
			if(input.equals("remove all")) {//remove all operation
				
				if(sLinkedList_trigger == true) {//if the user inputted they want linkelist, use linklist
					
				 for(int i=0;i<predictionsLL.length;i++) {//loop through the prediction linkedlist
					 
					 if(predictionsLL.get(i).getCharacter().name.equals(null)) {//if the character if null, that means the list is exausted, therefore break
						 
						 break;
					 }
					 System.out.print(i+" Removed: ");
					 System.out.print(predictionsLL.get(i).getCharacter().name +" with PLOD of ");
					 System.out.print(predictionsLL.get(i).getPlod());
					 System.out.println(); //output the values by pulling the ith digit and then pop it off the data structure
					
				 }
				}else
				if(MyArrayList_trigger == true) {//if user inputed they want arraylist, use arraylist
					
					int i=0;
					while(predictionsAL.size()>0) {
						System.out.print(i+" Removed: ");
						System.out.print(predictionsAL.peek()+" with PLOD of ");//peek the name first, so the name matches their plod
						
						System.out.print(predictionsAL.remove().getPlod());//pop the data when trying to get plod values
						
						System.out.println();
						i++;
					}
					
					
					
				}else {
					
					
					System.out.println("noob, choose linkedlist or arraylist first");//if the user tries this before picking linkedlist or arraylist, make them go back to beginning
					System.out.println();
				}
				
			}
			else if(input.equals("remove next")) {//operation to remove the next value of the data structure
				
				
				
				if(sLinkedList_trigger == true) {
					predictionsLL.length--;//keep the length of linkedlist managed
					
				 System.out.print("Removed: ");
				 System.out.print(predictionsLL.get(0).getCharacter().name +" with PLOD of ");
				 System.out.print(predictionsLL.get(0).getPlod());
				 System.out.println();
				 predictionsLL.pop(); //basically the samething as the remove all function but this time without the loop
				
				
				}else
				if(MyArrayList_trigger == true) {
					if(predictionsAL.size()>0) {
					System.out.print("Removed: ");
					System.out.print(predictionsAL.peek()+" with PLOD of "); // peek for name of character
					System.out.print(predictionsAL.remove().getPlod()); // pop to get the PLOD value
					System.out.println();//if user picked arraylist, do this part basically the same with remove all but without loop
					}else {
						System.out.println("No Character Left");
					}
					
					
				}else {
					
					System.out.println("noob, pick arraylist or linkedlist first");
				}
				
				
			}else if(input.equals("lltd")) {
				//output the smallest value
				if(sLinkedList_trigger == true) {
					System.out.print("Removed: ");
					 System.out.print(predictionsLL.get(0).getCharacter().name +" with PLOD of ");
					 System.out.print(predictionsLL.get(0).getPlod());//this time we only get the values out but do not pop the datas so we are only peeking
					 
					 
					 System.out.println();
				}else if(MyArrayList_trigger == true) {
					
					System.out.print("Removed: ");
					System.out.print(predictionsAL.peek()+" with PLOD of ");
					System.out.print(predictionsAL.peek().getPlod());//again, peeks only without poping any datas
					
					
					System.out.println();
					
				}else {
					System.out.println("Noob, pick arraylist or linkedlist first");
				}
			}
			else if(input.equals("all")) {
			 
			 while(current.next!=null) {
					System.out.println(current.data.toString());
					current = current.next;
				} //if the user want all information, invoke all method to print everything
		 }else if(input.equals("family tree")){
			 //if user types in family tree
			 FamilyTree Tree = new FamilyTree();
			 //create a family tree
			 for(int i=0;i<allAllies.length;i++) {
				 Tree = Tree.buildFamilyTree(allAllies.get(i));
				 //populate tree with every house
				 Tree.printTree(Tree.getPatriarch());
				 //use the patriarch getter to invoke printtreemethod
				 Tree.printTreeMat(Tree.getMatriarch());
				 //use Matriarch method to invoke printtree
			 }
			 
			 
			 	
				
			 
		 }else{
			 
			 boolean watcher = allChars.contains(input); 
		 		// locate the location of userinput with respect to our dataset
		 		//didn't use binary search bc we would have to sort the list
		 		//which defeats its purpose since the software is single use
		 	if(watcher==false) {
			 System.err.println("Character or command now found");
			 	
		 	}else {
		 		
		 		
		 		
		 		System.out.println(allChars.get(input));
		 		
		 		String ally = null;
		 		
		 		for(int i=0;i<allChars.length;i++) {
		 			//loop though all characters to find the character that matches out user input
		 			Character newChar2 = (Character) allChars.get(i);
		 			if(newChar2.name.toLowerCase().equals(input)) {
		 				
		 				ally = newChar2.allegiances;
		 				//if we find a char that matches, we record his allegtion
		 				
		 			}
		 		}
		 		
		 		
		 		House myHouse = findhouse(ally,allAlly);
		 		//invoke findhouemthod to located which house we are working with 
		 		FamilyTree Tree = new FamilyTree();
		 		//create tree
		 		Tree.resetNumber();
		 		Tree.buildFamilyTree(myHouse);
		 		//use the house that we located to build a tree
		 	
		 		Character myChar = new Character(input,null,null,null,null,false,false);
		 		//create a character with our userinput
		 		CharacterNode myNodes = new CharacterNode(myChar);
		 		//further making that character a charatcerNode
		 		Tree.findCharacterNode(Tree.getPatriarch(),myNodes);
		 		//invoke find node method, purpose is to print our lineage as required
		 		
		 			if(Tree.getNumber()==0) {
		 				//if static variable is 0. which means not in patriarch tree, we invoke findchar on matri
				 		Tree.findCharacterNode2(Tree.getMatriarch(),myNodes);
						
		 			}
		 			
		 			
		 			
		 			
		 		
		 			
		 		
		 		
		 		//Tree.findCharacterNode(Tree.getPatriarch(), myNodes);
		 		//Tree.findCharacterNode(Tree.getMatriarch(), myNodes);
		 		
		 		
		 }
		 	}}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 } 
	
		public static House findhouse(String ally, sLinkedList<House>allHouses) {
			//find house method
			for(int i=0;i<allHouses.length;i++) {
	 			if(allHouses.get(i).getName().equals(ally)) {
	 				//loop through all houses, if the name of a house mathces alligation of userinput
	 				//we hit jackpot
	 				return allHouses.get(i);
	 				//return that house.
	 			}
	 		}
			return null;
			
		}
		
		
		
		public static sLinkedList search(String name, sLinkedList<Battle> allbattles) {
			//search for a battle in the allbattle linked list
			sLinkedList<Battle> given_Battles = new sLinkedList();
			sLinkedList.sllNode current = allbattles.first;
			while(current.next != null) {
				
				if(current.data.toString().toLowerCase().contains(name.toLowerCase())) {
					//convert everything to lowercase to make sure case insensitivity
					given_Battles.insertFirst((Battle) current.data);
					
				}
				current = current.next;
			}
			
			return given_Battles;
		}
		
		public static sLinkedList<House> whereismysister(sLinkedList<Character> allChars, sLinkedList<House> allAlly) {
			//method to population house with a linkedlist of all CHaracters and a list of all allys
			int checker = 0;
			int checker2 = 0;
			
			
			
			while(checker < allAlly.length) {
				//use a nested loop, determine whether a character's alligation is to 
				//the house we are currently on, if yes, that character is added to that house
				//that is currently driving the loop
				// in the process, we also check for patriarch or matriarch
				//if it is a match, we populate the patriarch and matriarch field of house class
					checker2 = 0;
					House currentHouse = allAlly.get(checker);
					String name = currentHouse.getAlly();
					
					sLinkedList<Character> sisters = new sLinkedList<Character>();
					while(checker2 < allChars.length) {
						Character currentCharacter = allChars.get(checker2);
						String alliegence = currentCharacter.allegiances;
						//alliegence of our current character
						if(alliegence.equals(name)) {
							//if character's allegence is equal to the name of house, then we can
							//say he is a member of that house
							sisters.insertFirst(currentCharacter);
						
						}
						
						if(currentCharacter.getPatri()==true) {
							currentHouse.setPat(currentCharacter);
							//set patriarch
						}
						if(currentCharacter.getMatri()==true) {
							currentHouse.setMat(currentCharacter);
							//set matriarch
						}
						checker2++;
					}
					
					
					currentHouse.members = sisters;
					
					checker++;
			}
			
			return allAlly;
		}
		
		

		
		
		

}
