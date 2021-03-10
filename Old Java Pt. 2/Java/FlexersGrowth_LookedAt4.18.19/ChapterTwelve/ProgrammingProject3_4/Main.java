package ProgrammingProject3_4;

public class Main {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.append(1);
		//list.append(10);
		list.append(3);
		list.append(5);
		list.append(11);
		list.append(2);
		
		list.selectionSort();
		
		System.out.println(list);
		
	}
	
}
