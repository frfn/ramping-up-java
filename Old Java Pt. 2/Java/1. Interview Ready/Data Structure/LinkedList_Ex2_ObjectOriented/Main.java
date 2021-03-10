package LinkedList_Ex2_ObjectOriented;

public class Main {

	public static void main(String[] args) {
		
		Car honda = new Car("Honda", 11000);
		Car nissan = new Car("Nissan", 6000);
		Car infiniti = new Car("Infiniti", 8000);
		
		Node node1 = new Node(honda);
		Node node2 = new Node(nissan);
		Node node3 = new Node(infiniti);
		
		LinkedList list = new LinkedList(node1);
		list.add(node2);
		list.add(node3);
		
		System.out.println(list.toString());
		
	}
	
}
