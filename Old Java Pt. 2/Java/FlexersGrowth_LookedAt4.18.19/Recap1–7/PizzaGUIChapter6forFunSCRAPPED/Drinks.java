package PizzaGUIChapter6forFunSCRAPPED;

public class Drinks extends Food {
	
	/**
	 * Two Fields:
	 *  - drinkFlavor
	 *  - drinkSize
	 */
	
	private String drinkFlavor, drinkSize;
	
	/**
	 * Utilizing the Food class, calling super to super impose the respective method in Food class.
	 */
	
	public Drinks(String drinkSize, String drinkFlavor) {
		super(drinkSize, drinkFlavor);
	}
	
	/**
	 * Outputting drinks
	 */
	
	public String toString() {
		String str = "";
		
		str += "Drink Size: " + drinkSize +
			   "Drink Flavor: " + drinkFlavor;
		
		return str;
	}

}
