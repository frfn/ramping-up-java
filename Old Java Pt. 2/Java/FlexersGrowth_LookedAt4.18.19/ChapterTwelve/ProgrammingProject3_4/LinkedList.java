package ProgrammingProject3_4;

public class LinkedList {
	
	Node head;  // head of the linked list
	
	public boolean isEmpty() {  // if empty return true
		return(head==null);
	}
	
	public int length() {  // length of the linked list
		int count = 0;
		Node current = head;
		while(current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
	public void append(int data) {  // appending to the list
		if(isEmpty()) {
			head = new Node(data);  // if empty make it to new head
		}
		else {
			Node current = head;  // current variable holds head for ease of use
			while(current.next != null) {
				current = current.next;  // walk through
			}
			current.next = new Node(data);  // last node's next will hold new reference
		}
	}

	public void selectionSort() {  // the head node 
		
		Node min;
		Node temp;
		
		for(Node i = head; i != null; i = i.next) {
			
			min = i;  // min is current node head
			
			for(Node j = i; j != null; j = j.next) {
				
				if(j.compareTo(i) < 0) {  // if j value is less than i value
					
					min = j;
				}
				
				temp = new Node(i.getValue());
				i.data = min.data;
				min.data = temp.data;
			}// end of second for loop
		}// end of first for loop
	
	}
	
	public void insertionSort(LinkedList nodeHead) {
		
		// will be RecapForAllFiles
		
	}
	
	public String toString() {
		String str = "";
		
		Node current = head;
		while(current != null) {
			str += current + " --> ";
			current = current.next;
		}
		str += current;
		return str;
	}
	
}


/**
 * MY TRY FOR SELECTION SORT FOR NODES -- FAILED.
 * Node min; for(Node i = list.head; i != null; i = i.next) { min = i; // min is
 * the first value for(Node j = i.next; j != null; j = j.next) { if
 * (j.compareTo(i) < 0) { min = j; // if current2 value is less than min, set
 * min to current 2 value } Node temp = min; min = i; i = temp; } }
 */