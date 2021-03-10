package CD;

public class LL {

	Node head;
	
	public boolean isEmpty() {
		return(head==null);
	} // end of isEmpty
	
	public int length() {
		int count = 0;
		if(isEmpty()) {
			return 0;
		}
		else {
			Node current = head;
			while(current.next != null) {
				count++;
				current = current.next;
			}
		}
		return count;
	} // end of length
	
	public void add(String s, String a, int t, double c) {
		CD data = new CD(s, a, t, c);
		if(isEmpty()) {
			head = new Node(data);
		}
		else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
		}
	}
	
	public void insertAtIndex(String s, String a, int t, double c, int position) {
		CD data = new CD(s, a, t, c);  // creates a CD data
		int count = 1;
		if(isEmpty()) {
			head = new Node(data);
			return;
		}
		else if(position==0) {  // prepending
			//adding new head
			Node newNode = new Node(data); 
			newNode.next = head;
			newNode = head;
			return;
		}
		else {
			//adding at chosen position
			Node current = head;
			while(current.next != null) {
				count++;  // might have to go up
				if(count==position) {  // if position is found
					Node newNode = new Node(data);	// create new node
					
				
					newNode.next = current.next;
					current.next = newNode;
					
				
					return;
				}
				current = current.next;
				
			}
		}
	}// end of insertAtIndex
	
	public void delete(int position) {
		int count = 1;
		
		if(isEmpty()) {
			return;
		}
		else if(position==0) {
			//deleting head
			head = head.next;  // pointer shifts over, head is a candidate for garbage collection
			return;
		}
		else {
			//deleting chosen position
			Node current = head;
			while(current.next != null) {
				if(count==position) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
				count++;
			}
		}
	}
	
	public void delete(Node cd) {
		if(isEmpty()) return;
		if(cd.data == head.data) {
			head = head.next;
			return;
		}
		Node current = head;
		while(current.next != null) {
			if(current.next.data == cd.data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public String toString() {
		String str = "";
		Node current = head;
		while(current != null) {
			str += current.toString() + " --> \n";
			current = current.next;
		}
		str += current;
		return str;
	}
	
}
