package LinkedList_Ex3_NewMethods;

public class Main {
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		LinkedList ll = new LinkedList();
		
		ll.add(one);
		ll.add(two);
		ll.add(three);
		ll.add(four);
		
		
		System.out.println(ll);
		
		ll.reverseWithRecursion(ll.head);
		
		System.out.println(ll);
	}
}

		