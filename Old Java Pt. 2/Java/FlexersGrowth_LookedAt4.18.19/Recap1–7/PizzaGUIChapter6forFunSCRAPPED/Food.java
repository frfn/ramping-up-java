package PizzaGUIChapter6forFunSCRAPPED;

/**
 * 
 * @author Flexer
 * 
 * Food object:
 * 	- Will assist in handling different object types
 *  - I'll try to incorporate it into code
 *
 */

public class Food {
	
	/**
	 * Pizza Creation:
	 * 	- 4 Parameters
	 */
	private String pizzaSize, pizzaSauce, pizzaCrust;
	private String[] pizzaTopping;
	
	/**
	 * Drink Creation:
	 *  - 2 Parameters
	 */
	private String drinkSize, drinkFlavor;
	
	
	public Food(String pizzaSize, String pizzaSauce, String pizzaCrust, String... pizzaTopping) {
		this.pizzaSize = pizzaSize;
		this.pizzaSauce = pizzaSauce;
		this.pizzaCrust = pizzaCrust;
		this.pizzaTopping = pizzaTopping;
	}
	
	public Food(String drinkSize, String drinkFlavor) {
		this.drinkFlavor = drinkFlavor;
		this.drinkSize = drinkSize;
	}
	
	public String toStringForPizza() {
	String t = "";
		
		for(String toppings: pizzaTopping) {
			t += toppings + ", ";
		}
		
		return "\n\nSize: " +pizzaSize+ 
				"\nCrust: " +pizzaCrust+ 
				"\nSauce: " +pizzaSauce+ 
				"\nTopping: " +  t;
	}
	
	public String toString() {
		String t = "";
		
		for(String toppings: pizzaTopping) {
			t += toppings + ", ";
		}
		
		return "\n\nSize: " +pizzaSize+ 
				"\nCrust: " +pizzaCrust+ 
				"\nSauce: " +pizzaSauce+ 
				"\nTopping: " +  t;
		
		//return "Food Object. Please Overwrite respective class.";
	}

}
