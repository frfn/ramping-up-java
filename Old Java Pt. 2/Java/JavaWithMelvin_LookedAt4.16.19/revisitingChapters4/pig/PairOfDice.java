package pig;
import java.util.Random; //using this may be a little better than math, 
				//based on the other codes I did.

/*
 * Comment from now on,
 * this will solidify.
 * 
 * I know you, you passively write
 * comments. Stop.
 * 
 * In this constructor, it will RETURN
 * two values, hence pair of dice.
 * 
 * It will be random numbers 1 through 6, so plus one
 */

/*
 * You can NOT return two values.
 * Very intriguing – look at roll(); its a void.
 * Hmm.
 */
public class PairOfDice {
	
	private static final int maxNum = 6; //not needed, using maxNum as the variable for the value of 6
	
	private static int die;		//declared die
	private static int die2;	//declared die 2
	
	private static Random random = new Random();
	
	public PairOfDice() { //Constructor PairOfDice
		roll(); //invoking roll() function
	}
	
	public void roll() { //mmm, I am SETTING them a value. 
		//Makes sense. 
		die = random.nextInt(6) + 1; //values from 1-6
		die2 = random.nextInt(6) + 1; //and not from 0-5
	}
	
	public int getDieValue() { //a service method
		return die;	//returning the value of Die 1
	}
	
	public int getDie2Value() {
		return die2; //returning the value of Die 2
	}
	
	public int totalOfDieValues() {
		return die+die2; //returning the values of the two Dice
	} //will be needed for the upcoming programs
	 // BoxCars, if 12, snake eyes ;)
	
	public String toString() {
		return "Your die values: \nDie 1: " + die + "\nDie 2: " + die2;
	}

}
