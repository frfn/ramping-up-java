package PizzaGUIChapter6forFunSCRAPPED;

public class Pizza extends Food{
	
	/**
	 * Four fields:
	 *  - Size
	 *  - Sauce
	 *  - Crust
	 *  - Topping
	 */
	
	private String size, sauce, crust;
	private String[] topping = new String[6];
	private int pizzaID;
	private static int pizzaIDCounter = 0;
	
	/**
	 * Constructor will build pizza using parameters below: 
	 * 
	 * @param size
	 * @param sauce
	 * @param crust
	 * @param topping
	 */
	public Pizza(String size, String sauce, String crust, String... topping) {
		super(size, sauce, crust, topping);
		
		pizzaID = pizzaIDCounter++;
		
	}
	
	/**
	 * Nicely written code, easy to understand
	 *  - Using enhanced for loop to get values from toppings array
	 */
	
	/*
	public String toString() {
		
		String t = "";
		
		for(String toppings: topping) {
			t += toppings + ", ";
		}
		
		return "\n\nSize: " +size+ 
				"\nCrust: " +crust+ 
				"\nSauce: " +sauce+ 
				"\nTopping: " +  t;
	}
	*/
}
