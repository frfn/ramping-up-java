package LinkedList_Ex1_Fundamentals;

public class Main {
	
	public static void main(String[] args) {

		// New nodes
		Node node = new Node(1); 
		Node node2 = new Node(10);
		Node node3 = new Node(5);
		Node node4 = new Node(7);
		Node node5 = new Node(-2);
		
		// This creates the first head
		LinkedList list = new LinkedList(node);  // 1
		
		// Adding the nodes to the list
		list.add(node2);  // 10
		list.add(node3);  // 5
		list.add(node4);  // 7
		list.prepend(node5);
		
		//list.delete();
		
		System.out.println(list + "\n");
		System.out.println("Head: "+list.head);
		
		System.out.println("Length: "+list.length);
		
		
		
	}

}
