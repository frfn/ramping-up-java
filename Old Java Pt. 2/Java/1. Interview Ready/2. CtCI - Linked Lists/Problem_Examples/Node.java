package Problem_Examples;

public class Node {
	
	Node next;
	int data;
	
	public Node() {
		/**
		 * data =  0 
		 * next = null
		 */
	}
	public Node(int data) {
		this.data = data;
	}
	
	public String toString() {
		return Integer.toString(data);
	}

}
