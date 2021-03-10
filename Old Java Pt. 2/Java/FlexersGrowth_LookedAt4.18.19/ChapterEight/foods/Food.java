package foods;

public class Food {
	
	/**
	 * Fully document this, great use of inheritance and using methods as arguments
	 * 	- Look at caloriesPerServing body
	 *  - Pizza will extend and use super
	 */
	
	protected String name, type;
	private int fatGrams;
	final private int CALORIES_PER_GRAM = 9;
	protected int servings;
	
	/**
	 * -- Four Fields --
	 * @param name
	 * @param type
	 * @param numFatGrams
	 * @param numServings
	 */
	
	//constructor
	public Food(String name, String type, int numFatGrams, int numServings) {
		this.name = name;
		this.type = type;
		fatGrams = numFatGrams;
		servings = numServings;
	}
	
	public void eatMe() {
		System.out.println("I'm food.");
	}
	
	public int calories() {
		return fatGrams * CALORIES_PER_GRAM;
	}
	
	public int caloriesPerServing() {
		return(calories() / servings);
	}
	
	/**
	 * Outputting
	 *  - Will output string representation
	 */
	
	public String toString() {
		String str = "";
		
		str += "Food name: " + name + "\nType: " + type +
			   "\nCalories: " + calories() + 
			   "\nCalories per serving: " + caloriesPerServing();
		
		return str;
	}

}
