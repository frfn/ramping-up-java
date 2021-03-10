package Integer;

public class LinkedList {
	
	Node head;
	
	//returns true if empty
	public boolean isEmpty() {
		return (head==null);
	}
	
	// returns length
	public int length() {
		int count = 0;
		if (isEmpty()) {
			return 0;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
	//adding on to list
	public void add(int data) {
		if (isEmpty()) {
			head = new Node(data);
		}
		else {
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
		}
	}
	
	//deleting from list, remember, you're just skipping
	public void delete(int data) {
		if(isEmpty()) return;
		if(head.data == data) {
			head = head.next;
			return;
		}
		Node current = head;
		while(current != null) {
			if(current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	//prepend, remember, you're just changing the pointer to a new head
	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	//delete index
	public void deleteAtIndex(int i) {
		int count = 0;
		if(isEmpty()) {
			return;
		}
		if(i == 0) {
			head = head.next;
			return;
		}
		else {
			Node current = head;
			while (current.next != null) {
				count++;
				if(count == i) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
		}
	}
	
	public void selectionSort() {  // the head node 
		
		Node min;
		Node temp;
		
		for(Node i = head; i != null; i = i.next) {
			
			min = i;  // min is current node head
			
			for(Node j = i; j != null; j = j.next) {
				
				if(j.data < i.data) {  // if j value is less than i value
					
					min = j;
				}
				
				temp = new Node(i.data);
				i.data = min.data;
				min.data = temp.data;
				
			}// end of second for loop
		}// end of first for loop
	
	}
	
	public void insertionSort() {
		
		// needs to be a doubly linked list | .prev is needed
	
	}
	
	public String toString() {
		String str = "";
		Node current = head;
		while (current != null) {
			str += current.toString() + " --> ";
			current = current.next;
		}
		str += current;
		return str;
	}
	
}
