package LinkedList_StackImplementation;

public class Main {

	public static void main(String[] args) {
		
		StackLinkedList sll = new StackLinkedList();
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node thr = new Node(3);
		Node fou = new Node(4);
		Node fiv = new Node(5);
		
		sll.push(one);
		sll.push(two);
		sll.push(thr);
		sll.push(fou);
		sll.push(fiv);
		
		// System.out.println(sll.isLoop());
		
		System.out.println(sll);
		
		sll.reverse();
		
		System.out.println(sll);

	}
	
}
