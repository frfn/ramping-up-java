package LinkedList_Ex2_ObjectOriented;

public class LinkedList {
	
	int length = 0;
	Node head;
	
	public LinkedList(Node node) {
		head = node;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public String toString() {
		String str = "";
		Node current = head;
		while(current.next != null) {
			str += current.toString() + "\n\n";
			current = current.next;
		}
		str += current.toString() + "\n\n" + current.next;
		return str;
	}
	
	public void add(Node node) {
		if(isEmpty()) {
			System.out.println("Empty list... adding...");
			head = node;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = node;
		++length;
	}
	
	public void delete(Node node) {
		if(isEmpty()) {
			System.out.println("Empty list... returning...");
			return;
		}
		if(head == node) {
			head.next = head;
			--length; return;
		}
		Node current = head;
		while(current != null) {
			if(current.next == node) {
				current.next = current.next.next;
				--length;
				return;
			}
			current = current.next;
		}
	}

}
