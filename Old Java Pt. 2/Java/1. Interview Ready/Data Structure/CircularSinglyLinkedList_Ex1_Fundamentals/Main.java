package CircularSinglyLinkedList_Ex1_Fundamentals;

public class Main {

	public static void main(String[] args) {
		
		Circular LL = new Circular();
		LL.addInFront(new Node(1));
		LL.addInFront(new Node(2));
		LL.addInFront(new Node(3));
		
		System.out.println(LL);
		
		LL.deleteFront();
		
		System.out.println(LL);
		
	}
	
}
