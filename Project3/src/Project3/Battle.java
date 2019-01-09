package Project3;

public class Battle implements Comparable<Battle>{
	//Battles class
		public String name;
		public String attackerKing;
		public String defenderKing;
		public String attackerOutcome;
		public String battleType;
		public String location;
		public String region;
		
		public Battle(String name, String attackerKing, String defenderKing, String attackerOutcome, String battleType, String location, String region) {
			this.name = name;
			this.attackerKing = attackerKing;
			this.defenderKing = defenderKing;
			this.attackerOutcome = attackerOutcome;
			this.battleType = battleType;
			this.location = location;
			this.region = region;
			//Constructor for Battles
		}
		
		public Battle(String name) {
			
			this.name = name;
			//Constructor for Battle with limited information
		}

		@Override
		public int compareTo(Battle other) {
			return name.toLowerCase().compareTo(other.name.toLowerCase());
			//Compate to method implemented 
			}
		
		/* 	Test Class for compareTo method
		 * 	outputs 1
		 * 
		 * 
		 * public static void main(String args[]) {
			Battle newBattle = new Battle("abc");
			Battle secBattle = new Battle("bcd");
			System.out.println(secBattle.compareTo(newBattle));
			
		}
		*/
		
		public String toString() {
			// Prints out battle information according to professor 
			return((" - "+name+", when "+ attackerKing+" attacked "+ defenderKing+", resulting in a "+ attackerOutcome+", through a"
					
					
					+ battleType+", at "+ location+", in the region of "+ region+"\n"));
			
			}
}
