package chapter3;
import java.util.Random;

/*
 * Print random phone number – 
 * 	in the form of xxx - xxx - xxxx
 * 
 * 	The first three digits will not contain an 8 or 9
 * 
 * 	The second set of digits will not be greater than 742
 * 
 *  the four digits, does not matter
 */

public class ThreePoint4RandomPhoneNumber {
	
	static String firstThreeDigits = "", convert = "", secondThreeDigits = ""; //I thought using a for loop would be a new idea
	static int random;
	static Random generator = new Random();
	
	public static void main(String[] args) {
		
		for(int i = 0; i <= 2; i++) { //remind yourself, that <= will be the proper run for a for loop, 0, 1, 2
			//if it is just the sign, <, then it would only be 0, 1
			
			random = generator.nextInt(7); //random numbers from 0-7
			convert = String.valueOf(random); //converting integer to a String
			
			firstThreeDigits = firstThreeDigits + convert; //adding the string to the firstThreeDigits object
		}
		
		random = generator.nextInt(642) + 100; //add 100 so that the number will not 100 and above
		convert = String.valueOf(random);
		
		secondThreeDigits = convert;
		
		random = generator.nextInt(9999);
		convert = String.valueOf(random);
		
		System.out.println(firstThreeDigits + "-" + secondThreeDigits + "-" + convert);
		
		
	}

}
