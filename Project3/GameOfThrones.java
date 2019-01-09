package Project3;
import java.util.*;
import java.io.File;

import java.io.FileNotFoundException;

import Project3.sLinkedList.sllNode;

public class GameOfThrones {
	interface Transformer<I, O> {
	    O transform(I input);
	}
	public static <E> void main(String[] args) {
			
			//open datasets
		 String battleName = "data/battles.csv";
		 String charName = "data/characters_lineage.csv";
		 File battles_base = new File(battleName);
		 File char_base = new File(charName);
		 
		 Scanner inputFile = null;
		 Scanner inputFile2 = null;
		 
		 	//battles.csv data recording
		 try {
			 inputFile2 = new Scanner(char_base);
			 inputFile = new Scanner(battles_base);
		 } catch (FileNotFoundException e) {

			 	System.err.printf("Error: cannot read "
			 			+ "data from file %s" ,battleName);
			 	System.exit(1);
		 }
		 
		sLinkedList<Battle> allBattles = new sLinkedList<Battle>(); 
		List<String> allAlligation = new ArrayList<String>();
		 
		
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
		 
		 
		 sLinkedList<Character> allChars = new sLinkedList<Character>();
		 
		 	//manage characters information
		 ArrayList newList = new ArrayList<>();
		 
		 while(inputFile2.hasNextLine()) {		
			 

			 String data = inputFile2.nextLine();
			 data = data.toLowerCase();
			 String[] values = data.split(",");
			
	
			
			 
			 
			 if(newList.contains(values[3])) {
					
				}else {
					
					newList.add(values[3]);
				}
			 
			 
			 
			 sLinkedList participated_battles = search(values[0],allBattles);
			 Character newChar = new Character(values[0],values[3],participated_battles);
			 
			 if(values[1].equals("patriarch")) {
				 
				 newChar.setPatri();
				 
			 }
			 if(values[2].equals("matriarch")) {
				 newChar.setMatri();
			 }
			 
			 newChar.setfather(values[1]);
			 newChar.setmother(values[2]);
			 allChars.insertFirst(newChar);
			 			 			 		 
			 
		 }
		 
		 
		 
		 allChars.first = allChars.mergeSort(allChars.first);
		 
		
		
		 
		 sLinkedList<House> allAlly = new sLinkedList<House>();
		
		 for(int i=0;i<newList.size();i++) {
			 House newHouse = new House((String) newList.get(i));
			 allAlly.insertFirst(newHouse);
		 }
		 
		 sLinkedList<House> allAllies = whereismysister(allChars,allAlly);
		
		//Character newChar = allAllies.get(0).getMat();
		//System.out.println(newChar.toString());
		 
		 /*
		 sLinkedList.sllNode current1 = allAlly.first;
		 while(current1.next!=null) {
				System.out.println(current1.data.toString());
				current1 = current1.next;
			}
		 
		 */
		 
		 while(true) {
			sLinkedList.sllNode current = allChars.first;
			
			
			 // take in userinputs
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a character name (or type \"all\" for all characters, or \"exit\" to exit):");
			String input = reader.nextLine();	
			input = input.toLowerCase();
				//make sure input is case insensitive
			if(input.equals("exit")) {
				System.out.println("System exiting");
				break;
			}
			if(input.equals("all")) {
			 
			 while(current.next!=null) {
					System.out.println(current.data.toString());
					current = current.next;
				} //if the user want all information, invoke all method to print everything
		 }else {
			 Character newChar = new Character(input);
			 boolean watcher = allChars.contains(newChar); 
		 		// locate the location of userinput with respect to our dataset
		 		//didn't use binary search bc we would have to sort the list
		 		//which defeats its purpose since the software is single use
		 	if(watcher==false) {
			 System.err.println("Character does not exist");
			 	
		 	}else {
		 		
		 		
		 		
		 		System.out.println(allChars.get(newChar));
		 		
			 
		 }
		 	}}
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
			int checker = 0;
			int checker2 = 0;
			
			
			
			while(checker < allAlly.length) {
					checker2 = 0;
					House currentHouse = allAlly.get(checker);
					String name = currentHouse.getAlly();
					
					sLinkedList<Character> sisters = new sLinkedList<Character>();
					while(checker2 < allChars.length) {
						Character currentCharacter = allChars.get(checker2);
						String alliegence = currentCharacter.allegiances;
						if(alliegence.equals(name)) {
							sisters.insertFirst(currentCharacter);
						
						}
						
						if(currentCharacter.getPatri()==true) {
							currentHouse.setPat(currentCharacter);
						}
						if(currentCharacter.getMatri()==true) {
							currentHouse.setMat(currentCharacter);
						}
						checker2++;
					}
					
					
					currentHouse.members = sisters;
					
					checker++;
			}
			
			return allAlly;
		}
		
		

		
		
		

}
