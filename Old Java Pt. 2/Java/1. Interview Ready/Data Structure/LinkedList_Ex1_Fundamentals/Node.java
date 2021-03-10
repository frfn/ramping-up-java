package LinkedList_Ex1_Fundamentals;

/**
 * 
 * @author Flexer
 *
 * Creating a linked list with only numbers!
 *
 */

public class Node {
	
	int data;
	
	// Note: This "next" is an object. Don't be fooled.
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public String toString() {
		// To string implementation
		// Note: uses Integer class to cast int to String
		return Integer.toString(data);
	}
	
}
