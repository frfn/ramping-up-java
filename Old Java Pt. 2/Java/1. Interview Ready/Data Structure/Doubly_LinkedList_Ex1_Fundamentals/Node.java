package Doubly_LinkedList_Ex1_Fundamentals;

/**
 * 
 * @author Flexer
 *
 * The only different from a linked list is that is also keeps track of the previous data!
 * 
 * Node prev is new :)
 *
 */

public class Node {
	int data;
	Node prev, next;
	public Node(int data) {
		this.data = data;
	}
	public String toString() {
		return Integer.toString(data);
	}
}
