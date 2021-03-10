package foods;

public class Pizza extends Food {

	/**
	 * -- Two fields --
	 * @param type
	 * @param fatGrams
	 * 
	 * super call sets the preset value
	 *  - "Pizza"
	 *  - 8
	 */
	public Pizza(String type, int fatGrams) {
		super("Pizza", type, fatGrams, 8);
	}
	
	public void eatMe() {
		System.out.println("I'm pizza");
		
		super.eatMe(); //calling the superclass's eatMe() method
	}
	
}
