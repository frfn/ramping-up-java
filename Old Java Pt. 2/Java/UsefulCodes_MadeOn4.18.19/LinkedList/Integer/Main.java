package Integer;

public class Main {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.add(3);
		list.add(1);
		list.add(3);
		list.add(6);
		list.add(100);
		list.add(43);
		
		list.selectionSort();
		//list.deleteAtIndex(3);
		//list.delete(5);
		
		System.out.println(list);
	
		
	}

}
