package Project3;

import javax.xml.soap.Node;

public class pqLinkedList<E extends Comparable<E>> extends sLinkedList<E> {
	public void insert(E String) {//insert method
	
			
			
				sllNode current;
				sllNode newNode = new sllNode();
				newNode.data = String;
				if(first == null || first.data.compareTo(String)<=0) {//if list is empty or first data is greater than new input we just set the new input to be the first
					
					
					newNode.next = first;
					first = newNode;
					this.length++;
				}else {
					current = first;
					
					while(current.next != null && current.next.data.compareTo(String)>0) {//otherwise we loop through entire list to find a place where the item in list is greater than our new inpute
						current = current.next;
					}
					
					
					newNode.next = current.next;//then we put our newinput in front of it
					current.next = newNode;
					this.length++; //since we are adding stuff, we add 1 to length to keep linkedlist size managed
					
				}
			
			
		
	}
	
	public boolean compareing(E data) {
		//compare mathod, was not used in the implementation of this class
		if(this.first.data.compareTo(data)<0){//if out data is less than input, return true
			
			return true;
		}else {
			return false;//else return false
			
		}
	}
	
	public sllNode pop() {
		//pop, return the value of the first item which should be the guy that is least likly to die, pop him out after we got his info
		
		sllNode temp = first;
		(first) = (first).next; //dude is poped
		
		return temp;
		
		
	}
	public sllNode peek() {
		//similar method, get the values of our first guy
		
		sllNode temp = first;
		return temp;//but do not pop him
	}
			
}
	
	


