package chapter3ProgrammingProjects;

/*
 * Same exercise but I wanted to try the String formatting that I saw on the
 * internet. As said, the DecimalFormat is an older way of implementing 
 * the format!
 */

import java.util.Random;

public class ThreePoint4Revised {

	public static void main(String[] phoneNumber) {
		
		Random generator = new Random();
		
		int num, num2, num3;
		String numOne; //, numTwo, numThree;
		
		num = generator.nextInt(8);
		num2 = generator.nextInt(8);
		num3 = generator.nextInt(8);
		numOne = Integer.toString(num);		
		//numTwo = Integer.toString(num2);
		//numThree = Integer.toString(num3);
		
		/*
		 * So it looks like to make them into a string, the first
		 * variable has to be a String data type and rest does not matter
		 * After experimenting, it looks like it is possible to create 
		 * as code below proves it!
		 */
		
		String firstBlock = numOne + num2 + num3;
		
		/*
		 * Second block of numbers!
		 */
		
		int secondBlockNum = generator.nextInt(743);
		String secondBlock = String.format("%03d", secondBlockNum);
		
		/*
		 * In this example the formatting instructions mean:
		 * 1. % means the start of a formatting instruction
		 * 2. 0 means the number that will get "padded"(added) to the number
		 * 3. 3 means how many 0's will get padded
		 * 4. d is for decimal which means the args should be of integral value
		 */
		
		int thirdBlockNum = generator.nextInt(10000);
		String thirdBlock = String.format("%04d", thirdBlockNum);
		
		System.out.print(firstBlock + "-" + secondBlock + "-" + thirdBlock);
	}
	
}
