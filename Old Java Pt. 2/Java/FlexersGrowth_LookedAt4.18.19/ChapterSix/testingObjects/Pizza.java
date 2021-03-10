package testingObjects;

import java.util.ArrayList;

public class Pizza {
	
	private String topping = "";
	private String sauce, crust;
	
	// default constructor
	public Pizza() {
		this.sauce = "Choose sauce...";
		this.crust = "Choose crust...";
		this.topping = "Choose topping...";
	}
	
	// constructor w/ parameters
	public Pizza(String sauce, String crust, ArrayList<String> topping) {
		this.sauce = sauce;
		this.crust = crust;
		//this.topping = topping;
		for(int i=0; i < topping.size(); i++) {
			this.topping += topping.get(i) + ", ";
		}
	
	}
	
	public String toString() {
		return	"Crust: " +crust+ 
				"\nSauce: " +sauce+ 
				"\nTopping: " +topping ;
	}

}

