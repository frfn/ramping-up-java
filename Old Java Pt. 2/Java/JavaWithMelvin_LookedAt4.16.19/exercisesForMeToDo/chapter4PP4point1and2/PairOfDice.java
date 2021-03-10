package chapter4PP4point1and2;

/*
 * Design a class called PairOfDice – has two die objects
 * Create another class called BoxCars that will role the pair
 * 1000 times, counting the number of BoxCars
 */

/*
 * I can either call on the Math class for a random with 
 * Math.random() <-- note that this is a double, casting needed,
 * 
 * OR I can make a random generator with = new Random()
 */

/*
 * 1. First step was to look at the RollClassConstructor to gather ideas and re-cap on how it is done
 * 
 * 2. Declared maxNum with value 6, note private and final!
 * 
 * 3. valueOfDie has been declared so that we have a reference to the die! something we can use
 * 
 * 4. valueOfDie is initialized to one so that it will have face value of 1
 */

public class PairOfDice {
	
	private final int maxNum = 6;
	/*
	 * 1. private variable – different from private class, means that you can only access this variable in this class!
	 * 2. final – value cannot change
	 */
	
	private int die1;
	
	private int die2;
	
	
	/*
	 * Making it so that we have a reference to the die
	 */
	
	public PairOfDice() {
		
		
		roll();
		/*
		 * value will be one for valueOfDice when object is created in "main" class
		 */
		
	}
	/*
	 * EXAMPLE: Overloading
	 * Not needed but a great way to experiment
	 * May be needed for future endeavors
	 
	public PairOfDice(int num) {
		
		System.out.print(num);
		
		die1 = 10;
		die2 = 20;
		
	}
	
	*
	*/
	public void roll() {
		
		die1 = (int)(Math.random() * maxNum) + 1;
		
		die2 = (int)(Math.random() * maxNum) + 1;
		
	}
	
	public int getDie1Value() {
		
		return die1;
		
	}
	
	public int getDie2Value() {
		
		return die2;
		
	}
	
	public int totalOfDice() {
		
		return die1 + die2;
		
	}
	
	public String toString() {
		/*
		 * So it does matter!
		 * It matters HEAVILY what the name of this should be
		 * if it is not "toString()" , it will not print out correctly!
		 * Syntax is important
		 */
		
		return ("Die 1 value: " + Integer.toString(die1) + "\nDie 2 value: " + Integer.toString(die2));
		
	}

}
