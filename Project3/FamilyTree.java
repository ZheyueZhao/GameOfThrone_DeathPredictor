package Project3;

import Project3.sLinkedList.sllNode;

public class FamilyTree {
	class CharacterNode implements Comparable<CharacterNode>{
		private Character character;
		private CharacterNode father;
		private CharacterNode mother;
		public sLinkedList<CharacterNode> children;
		@Override
		public int compareTo(CharacterNode o) {
			// TODO Auto-generated method stub
			return character.compareTo(o.character);
		}
		
		
	}
	
	private CharacterNode patriarch;
	private CharacterNode matriarch;
	
	public void buildFamilyTree(House h){
		sllNode index = h.members.first;
		while(index.next != null) {
			CharacterNode newChar = new CharacterNode();
			
		}
		
		
	}
}
