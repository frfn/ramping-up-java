package Doubly_LinkedList_Ex1_Fundamentals;

public class Main {
	
	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		
		list.insertLast(one);
		list.insertLast(two);
		list.insertLast(three);
		list.insertLast(four);
		list.insertLast(five);
		
		System.out.println(list.displayForward());
		System.out.println(list.displayReverse());
		
	}

}
