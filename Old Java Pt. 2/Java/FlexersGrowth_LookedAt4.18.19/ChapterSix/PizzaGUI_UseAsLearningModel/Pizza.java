package PizzaGUI_UseAsLearningModel;

import java.util.ArrayList;

public class Pizza {
	
	private String size, sauce, crust;
	private String[] topping;
	
	public Pizza(String size, String sauce, String crust, String... topping) {
		this.size = size;
		this.sauce = sauce;
		this.crust = crust;
		this.topping = topping;
	}
	
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

}
