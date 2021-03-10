package flexerDoublyLinkedList;

public class Main {
	
	public static void main(String[] args) {
		
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.addFirstNode(1);
		dll.append(3);
		dll.append(5);
		dll.append(7);
		dll.append(9);
		
		dll.insertBehindNextValue(4, 5);
		
		dll.display();
	}

}
