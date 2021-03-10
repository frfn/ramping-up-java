package Pizza;

public class PizzaTester {
	
	public static void main(String[] args) {
		
		/**
		 * 1 - small
		 * 2 - medium
		 * 3 - large
		 * 
		 * Validation is in Pizza class...
		 * 
		 * Scanner scan = new Scanner(System.in)
		 * 
		 * Knowing that it just takes in my variables, hard coded for testing. :)
		 */
		
		Pizza p1 = new Pizza(1, 3, 1);
		Pizza p2 = new Pizza(4, 0, 2);
		
		PizzaOrder order1 = new PizzaOrder("123", p1, p2);
		
		System.out.println("Receipt of Order Number: " + order1.orderNum + "\n");
		System.out.println(order1 + "\n");
		System.out.println(p1 + "\n" + p2);
		
	}

}
