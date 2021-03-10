package CD;

public class Main {
	
	public static void main(String[] args) {
		
		LL list = new LL();
		
		list.add("A", "A", 1, 10);
		list.add("B", "B", 2, 10);
		list.add("C", "C", 3, 10);
		list.add("E", "E", 5, 10);
		list.add("D", "D", 4, 10);
		
		System.out.println(list);
		
		System.out.println();
		
		list.insertAtIndex("F", "F", 6, 10, 5);
		
		System.out.println(list);
		
	}

}
