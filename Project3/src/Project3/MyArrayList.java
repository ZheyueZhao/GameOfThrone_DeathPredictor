package Project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class  MyArrayList<E extends Comparable<E>> extends ArrayList<E> {

	
	
	
	public void sort() {
		Collections.sort(this);// Why do we want to do this?
		
	}
	
	public boolean isSorted() {
		for(int i=0;i<this.size()-1;i++) {
			
			if(this.get(i).compareTo(this.get(i+1))==1) {
				
				return false;
			}
		}
		
		return true;
		
	}
	
	public boolean contains(E o) {
		if(this.isSorted() == true) {
			
			return binarysearch(o);
		}else {
			
			return super.contains(o);
		}
		
		
		
	}
	
	public boolean binarysearch(E o) {
		
		int i = this.size()-1;
		int p = 0;
		while(p<=i) {
			int q = (p+i)/2;
			if(this.get(q)==o) {
				
				return true;
			}else if(this.get(q).compareTo(o)>1 ) {
				i=q-1;
				
			}else {
				
				p=q+1;
			}
			
		}
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		
	}
	
		//checks method functionaity
		//returns true
	
	
	
}
