package Project3;

public class sLinkedList<E extends Comparable<E>> {
	class sllNode<E extends Comparable<E>>{
		//Nested Node class for linked list
		E data;
		sllNode next = null;
		
		public E getData() {
			return data;
			//getter
		}

		public void setData(E data) {
			this.data = data;
			//setter
		}
		public void displayNode() {
			
			System.out.println("{"+data+"}");
			
		}
		
		
	}
	
	public sllNode first;
		//head of the linked list
	public int length;
	public sLinkedList() {
		//constructor
		
	}
	
	public E get(int i){
	    sllNode current = this.first;
	    
	    while(i>0){
	        
	        current = current.next;
	        i--;
	    }
	     return (E) current.getData();
	    
	}
	
	sllNode mergeSort(sllNode h) {
		if(h == null || h.next == null) {
			//if the list is nothing, return the first node
			return h;
		}
		sllNode middle = getMiddle(h);
		//find the mid node
		sllNode nextMiddle = middle.next;
		//Let nextMiddle points to the next node of middle
		middle.next = null;
		//sever the link between the first half of list and seconf half
		sllNode left = mergeSort(h);
		//repeat process for first half
		sllNode right = mergeSort(nextMiddle);
		//repear process for second half
		sllNode sortedList = sortedMerge(left,right);
		//merge the first half and second half
		return sortedList;
	}
	sllNode getMiddle(sllNode h) {
		if(h == null)
			return h;
		
		sllNode f = h.next;
		//f is the next node of the node we passed in
		sllNode s = h;
		//s is the node we passed in
		while(f!= null) {
			f = f.next;
			if(f!=null) {
				s = s.next;
				f = f.next;
			}
		}
		return s;
	}
	sllNode sortedMerge(sllNode l, sllNode r) {
		sllNode res = null;
		if(l ==null)
			//if no left element
			return r;
		if(r == null)
			//if no right element
			return l;
		if(l.data.compareTo(r.data)<0) {
			//if left is greater than right
			res = l;
			//set res to left
			res.next = sortedMerge(l.next, r);
			//do the same comparison with l's next element and r
		}
		else {
			//same operation but for the right 
			res = r;
			res.next = sortedMerge(l, r.next);
			
		}
		return res;
	}
	public String get(E o) {
		//retrieve an element base on its value
		sllNode current = first;
		
		for(int i=0;i<length;i++) {
			if(current.getData().toString().toLowerCase().startsWith(o.toString())) {
				return current.getData().toString();
			}else {
				current = current.next;
			}
		}
		return null;
		
		
	}
public boolean contains(E o) {
		//Check if the linkedlist contains an element
		sllNode current = first;
		for(int i=0;i<length;i++) {
			
			if(current.getData().toString().toLowerCase().contains(o.toString())) {
				return true;
			}else {
				current = current.next;
			}
		}
		return false;
		
		
	}
	
	
	public boolean isEmpty() {
		//check if list is empty
		return(first == null);
		
	}
	
	
		
	public void insertFirst(E string) {
		//add element to the beginning of list
		sllNode temp = new sllNode();
		temp.data = string;
        temp.next = first;
        first = temp;
		length++;
	}
	
	
	
	public void displayList() {
		//display everything in a list
		sllNode h = first;
		while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println();
		
	}
	
	
}

