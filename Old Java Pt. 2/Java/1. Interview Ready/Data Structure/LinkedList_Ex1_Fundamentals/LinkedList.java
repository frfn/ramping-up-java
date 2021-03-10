package LinkedList_Ex1_Fundamentals;
/**
 * 
 * @author Flexer
 *
 * Think of lists as visual thing, not just by code.
 * It is a CONCEPT.
 * 
 * Node head; 
 * 
 * head is the beginning of our list. 
 * 
 * head
 *   o --> o --> o --> null
 * 
 * Note: making, Node current = head; is useful.
 * This is by convention, to make it easy for you,
 * also useful so our main head variable does not change
 * 
 * Note: do NOT forget to iterate linked list with: current = current.next;
 * 
 */

public class LinkedList {
	
	// Initialize head, this doesn't do anything yet :)
	// Note: length is global!
	Node head;
	int length = 0;
	
	
	//////////////////// UTILITIES ////////////////////
	
	
	// returns if head is null, prints Empty list
	// Note: very useful, can be used everywhere in this class!
	public boolean isEmpty() {
		return (head==null);
	}
	
	
	
	
	// toString to represent AND print our linked list
	// Note: added ... current.next; so it will print "null"
	
	// use string builder!
	public String toString() {
		Node current = head;
		String string = "Head: ";
		
		while(current.next != null) {
			string += current.toString() + " --> ";
			
			// IMPORTANT
			// Note: do NOT forget to iterate linked list with: current = current.next;
			current = current.next;
		}
		string += current.toString() + " --> " + current.next;
		return string;
	}
	
	
	
	/**
	 * 
	 * @param node
	 *  
	 * length() scrapped because of length variable. Easier to keep track. 
	 * Note: if deleting or adding, implement ++length; or --length; to add or subtract respectively.
	 * 
	 */
	
	// the length of linked lists!
//	public int length() {
//		if(isEmpty()) {
//			System.out.println("Empty list...");
//			return 0;
//		}
//		else {
//			Node current = head;
//			while(current.next != null) {
//				// Note: do NOT forget to iterate linked list with: current = current.next;
//				current = current.next;
//				++length;
//			}
//		}
//		return length;
//	}
	
	
	//////////////////// CONSTRUCTOR && METHODS ////////////////////
	
	
	// Need this... make a new list, start with a value!
	public LinkedList(Node node) {
		//head = new Node(node.data);
		head = node;
		++length;
	}
	
	
	//////////////////// ADDING METHODS ////////////////////
	
	
	// Adding to the front
	public void prepend(Node node) {
		node.next = head;
		head = node;
		++length;
	}
	
	
	
	
	// Adding to the last 
	// Note: iterate through all of the list, then add at the end!
	public void add(Node node) {
		if(isEmpty()) {
			System.out.println("Empty list, adding node...");
			head = new Node(node.data);
		}
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		//current.next = new Node(node.data);
		current.next = node;
		++length;
	}
	
	
	//////////////////// DELETING METHODS ////////////////////
	
	
	public void delete(int num) {
		if(isEmpty()) {
			System.out.println("Empty list, can't delete...");
			return;
		}
		
		// special case!
		if(num == head.data) {
			head = head.next;
			--length;
			return;
		}
		
		// skip!
		Node current = head;
		while(current != null) {
			if(num == current.next.data) {
				current.next = current.next.next;
				--length;
				return;
			}
			current = current.next;
			
		}
		
	}
	
	
	
	
	// Note: Garbage collection collects the shit that's been "skipped".
	public void delete(Node node) {
		if(isEmpty()){
			System.out.println("Empty list, can't delete...");
			return;
		}
		
//		// First Iter
//		if(node.data == head.data) {
//			head = head.next;
//			return;
//		}
		
		if(node == head) {
			head = head.next;
			--length;
			return;
		}
		
		// First Iter
//		Node current = head;
//		while(current != null) {
//			if(node.data == current.next.data) {
//				current.next = current.next.next;
//				return;
//			}
//			current = current.next;
//		}
		
		Node current = head;
		while(current != null) {
			if(node == current.next) {
				current.next = current.next.next;
				--length;
				return;
			}
			current = current.next;
		}
		
	}

}
