package ProgrammingProject1;

public class CDLinkedList {
	
	CDNode head;  // the main head of the list
	
	public boolean isEmpty() {
		return(head==null);  // returns true
	}
	
	public void append(String t, String a, int track, double c) {
		
		CD data = new CD(t, a, track, c);
		
		if(isEmpty()) {
			head = new CDNode(data);
		}
		else {
			CDNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new CDNode(data);
		}
	}
	
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
			CDNode current = head;
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
	
	public void insert(String t, String a, int track, double c, int position) {
		
		CD data = new CD(t, a, track, c);  // creates a CD data
	
		int count = 1;
		
		if(isEmpty()) {
			head = new CDNode(data);
			return;
		}
		
		else if(position==0) {
			//adding new head
			CDNode newNode = new CDNode(data);
			newNode.next = head;
			newNode = head;
			return;
		}
		
		else {
			//adding at chosen position
			CDNode current = head;
			while(current.next != null) {
				if(count==position) {
					CDNode newNode = new CDNode(data);
					newNode.next = current.next;
					current.next = newNode;
					return;
				}
				current = current.next;
				count++;
			}
		}
	}
	
	public int length() {
		int count = 1;
		if(isEmpty()) {
			return 0;
		}
		else {
			CDNode current = head;
			while (current.next != null) {
				current = current.next;
				count++;
			}
			return count;
		}
		
	}
	
	public String toString() {
		String str = "";
		if (isEmpty()) {
			return "List is empty...";
		}
		else {
			CDNode current = head;
			while (current.next != null) {
				str += current.toString() + "\n";
				current = current.next;
			}
			str += current.toString();
		}
		return str;
	}

}
