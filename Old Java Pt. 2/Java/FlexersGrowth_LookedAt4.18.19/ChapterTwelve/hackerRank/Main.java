package hackerRank;

public class Main {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.append(4);
		list.append(45);
		list.append(5);
		
		System.out.println(LinkedList.countNodes(list.head));
		
	}
	
}
