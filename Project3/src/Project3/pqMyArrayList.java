package Project3;
import java.util.*;
public class pqMyArrayList <E extends Comparable<E>> {
	
	private MyArrayList<E> heap = new MyArrayList<E>();
	public boolean isempty() {
		return heap.size()==0;//check if our array is empty, if it is return true
		
		
		//was not used in implementation of this class
	}
	public int size() {
		//get the size of our array
		return heap.size();
	}
	
	public void upHeap(int index) {
		//move index higher and restore the heap once that is done
		while(index>0) { //keep looping until reached root
			int p = (index-1)/2;
			if(heap.get(index).compareTo(heap.get(p))<=0) {
				break; // if the heap is not broken
			}
			swap(index,p); //swap places when items are not in their right place
			index = p; //continue from parent's location
			
		}
	}
	public void swap(int i,int j) {//swap method
		
		E e = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, e);
		
		
	}
	public void downHeap(int index) {
		//move index items lower, and then restore heap property
		while(2*index+1 < heap.size()) { // keep looping until hit bottom
			int left = 2*index +1;
			int child = left;
			if(2*index+2<heap.size()) {
				int right = 2*index+2;
				if(heap.get(left).compareTo(heap.get(right))<0) {
					child = right; // right child is smaller
				}
			}
			if(heap.get(child).compareTo(heap.get(index))<=0) {
				break; //heap is now a heap again
			}
			swap(index,child);
			index = child; // keep going at position of child
		}
	}
	
	public void insert(E e) {
		E new_data = e;//create our new input
		
		heap.add(new_data); //add the new input into our array
		
		upHeap(heap.size()-1);//upheap
		
	}
	
	public E remove() {
		//basically a pop method
		
		if(heap.size()==0) {return null;}//if array is empty we return nothing
		
		E e = heap.get(0);
		swap(0,heap.size()-1); //we swap the first item with the last
		
		heap.remove(heap.size()-1); //we remove the new last item
		
		downHeap(0);//downheap
		
		return e;
		
		
	}
	
	public E peek() {
		
		
		
		return heap.get(0);	//we look at who is first guy 
	}
	
}
