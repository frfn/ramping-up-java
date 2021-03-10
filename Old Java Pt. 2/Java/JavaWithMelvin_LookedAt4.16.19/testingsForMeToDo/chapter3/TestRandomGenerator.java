package chapter3;
import java.util.Random; //importing the service from java.util

/*
 * A random generator that showcases the different ways of implementing them!
 * 5 ways to show how the Random class works,
 * run to see how they look!
 */

public class TestRandomGenerator {

	public static void main(String[] randomGenerator) {
		
		Random generator = new Random();		//instantiating the Random generator, creating object generator
		
		int randomNumber;	//declaring randomNumber variable;
		
		randomNumber = generator.nextInt();		//giving randomNumber a value from the generator
		System.out.println("Just a random number: " + randomNumber);
		
		randomNumber = generator.nextInt(10);	//giving randomNumber a value from 0 to 9
		System.out.println("From 0 to 9: " + randomNumber);
		
		randomNumber = generator.nextInt(10) + 1; //by adding "+ 1", values are moved up, 1 to 10
		System.out.println("From 1 to 10: " + randomNumber);
		
		randomNumber = generator.nextInt(13) + 20; //"+ 20", starts at 20, .nextInt(13) determines, 20 to 32
		System.out.println("From 20 to 32: " + randomNumber);
		
		randomNumber = generator.nextInt(10) - 10; //"- 10" starts at -10, ...int(10) determines -10 to -1
		System.out.print("From -10 to -1:" + randomNumber);
			
		
	}
	
}
