package Doubly_LinkedList_Ex1_Fundamentals;

public class DoublyLinkedList {
	
	// Tail is new compared to a singly linked list
	Node head, tail; int length;
	
	///////////////////// UTILITY METHODS /////////////////////
	
	// Set head and tail to null for constructor
	public DoublyLinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	public boolean isEmpty() {
		return head == null;
	}
	
	// LOL use StringBuilder!!
	public String displayForward() {
		if(head==null) {
			return "Empty List...";
		}
		Node current = head;
		String string = "";
		while(current.next != null) {
			string += current + " --> ";
			current = current.next;
		}
		string += current + " --> " + current.next;
		return string;
	}
	
	// yup, same as display forward but start at the tail, USE StringBuilder
	public String displayReverse() {
		if(tail==null) {
			return "Empty List...";
		}
		Node current = tail;
		String string = "";
		while(current.prev != null) {
			string += current + " --> ";
			current = current.prev;
		}
		string += current + " --> " + current.prev;
		return string;
	}
	
	///////////////////// ADD METHODS /////////////////////
	public void insertFirst(Node node) {
		/**
		 * When adding to an empty list, node.next = head, points to null, then is reassigned because of head = node; right below to current element!
		 * When adding to a list with elements, you're keeping track of prev now too, THEN doing node.next = head; head = node;
		 */
		
		if(isEmpty()) {
			tail = node;
		}
		
		/**
		 * Considering we have a tail node already, we're only adding on to head, so we only keep track of the head node!
		 */
		else {
			head.prev = node;
		}
		node.next = head;
		head = node;
		++length;
	}
	
	public void insertLast(Node node) {
		if(isEmpty()) {
			head = node;
		}
		
		/**
		 * Considering we have a head node already, we're only keeping track of the tail node!
		 */
		else {
			tail.next = node;
			node.prev = tail;
		}
		tail = node;
		length++;
	}
	
	///////////////////// DELETE METHODS /////////////////////
	public Node deleteFirst() {
		if(isEmpty()) {
			System.out.println("Empty list...");
			return null;
		}
		
		Node current = head;
		if(head == tail) {
			tail = null;
		}
		else {
			/**
			 * this NEEDS to be done so it can BREAK the chain of doubly linked list
			 */
			head.next.prev = null;  
		}
		head = head.next;
		/**
		 * Note: current.next (current head's next) is STILL chained to the list, set to null to break it
		 */
		current.next = null;
		--length;
		return current;
		
	}
	
	public Node deleteLast() {
		if(isEmpty()) {
			System.out.println("Empty list...");
			return null;
		}
		Node current = tail;
		if(head == tail) {
			head = null;
		}
		else {
			tail.prev.next = null;
		}
		tail = tail.prev;
		current.prev = null;
		--length;
		return current;
	}
}
