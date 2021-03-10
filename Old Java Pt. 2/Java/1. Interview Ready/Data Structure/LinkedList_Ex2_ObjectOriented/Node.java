package LinkedList_Ex2_ObjectOriented;

public class Node {
	
	Car data;
	Node next;
	
	public Node(Car data) {
		this.data = data;
	}
	
	public String toString() {
		return data.toString();
	}

}
