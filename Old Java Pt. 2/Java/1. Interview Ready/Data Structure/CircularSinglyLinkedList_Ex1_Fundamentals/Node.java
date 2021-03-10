package CircularSinglyLinkedList_Ex1_Fundamentals;

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
