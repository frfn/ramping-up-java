package CompareObjects;

public class Node implements Comparable {

	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public int getValue() {
		return data;
	}
	
	public String toString() {
		return data + "";
	}

	@Override
	public int compareTo(Object o) {
		int result;  // either -1, 0, 1
		
		Node other = ((Node)o);
		
		if(this.data < other.data) {
			result = -1;
		}
		else if(this.data == other.data) {
			result = 0;
		}
		else {
			result = 1;
		}
		
		return result;
	}

	
}
