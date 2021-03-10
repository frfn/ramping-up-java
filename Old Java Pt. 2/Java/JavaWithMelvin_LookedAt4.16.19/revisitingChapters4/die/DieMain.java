package die;

public class DieMain {
	
	public static void main(String[] args) {
		for(int i = 1; i < 5; i++) {
		System.out.println("New roll...");
		/*
		 * A sysout just printing out new roll
		 */
		
		Die die1 = new Die();
		/* Created new object
		 * Since inside loop, I conducted experiment
		 * it will create new object every time it is
		 * looped!
		 */ 
		
		System.out.println(die1);
		/*
		 * Checking initial value
		 */
		
		die1.roll();
		System.out.println(die1);
		/*
		 * Checking value after roll() has been invoked
		 */
		
		die1.setFaceValue(10);
		System.out.println(die1);
		/*
		 * Setting value to 10, should change
		 * the variable to 10
		 */
		System.out.println();
		
		}
		
		/*
		 * 5 iterations has been made
		 * so we can see the changes that are
		 * made when roll() is called
		 */
	}

}
