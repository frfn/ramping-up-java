package LinkedList_Ex3_NewMethods;

/**
 * 
 * @author Flexer
 * 
 * Was testing to see if Node current = head;
 * 
 * would be different, and not alter head. In linked lists, since they're linked, it does alter it.
 * 
 */

public class Test_AffecedVariables {
	
	public static void main(String[] args) {
		
		int number = 10;
		
		int holder = number;
		
		holder = 5;
		
		System.out.println(number);
		System.out.println(holder);
		
		
		
	}

}
