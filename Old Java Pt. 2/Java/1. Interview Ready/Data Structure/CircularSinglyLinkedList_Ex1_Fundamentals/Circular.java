package CircularSinglyLinkedList_Ex1_Fundamentals;

public class Circular {
	
	Node last; int length;
	
	public Circular() {
		last = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return last==null;
	}
	
	public int length() {
		return length;
	}
	
	public void deleteFront() {
		if(isEmpty()) {
			return;
		}
		
		if(last.next == last) {
			last = null;
			return;
		}
		
		Node first = last.next;
		last.next = first.next;
		
		first.next = null;  
		length--;
	}
	
	public void addInFront(Node node) {
		if(isEmpty()) {
			last = node;
			last.next = last;
			//length++;
		}
		else {
		node.next = last.next;
		}
		last.next = node; // this is what makes it the "first"
		
		length++; 
				
	}
	
	public void addToLast(Node node) {
		if(isEmpty()) {
			last = node;
			last.next = last;
		}
		else {
		node.next = last.next;
		}
		last.next = node;
		last = node; // this makes the new node, the "last" node
		length++;
	}
	
	public String toString() {
		Node first = last.next;
		String str = "";
		while(first != last) {
			str += first + " --> ";
			first = first.next;	
		}
		str += first + " --> " + first.next + ": Last Node" + " - Length: " + length;
		return str;
	}

}
