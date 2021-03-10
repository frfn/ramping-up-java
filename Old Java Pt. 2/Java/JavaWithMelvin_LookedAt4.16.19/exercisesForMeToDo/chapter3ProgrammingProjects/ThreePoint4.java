package chapter3ProgrammingProjects;
import java.util.Random;
import java.text.DecimalFormat;
/*
 * Write an application that generates random phone numbers
 * and prints in the form of xxx-xxx-xxxx
 * Conditions are that do not let the first three digits have an 8 or 9
 * The second three digits does not go over 742
 * Third four digits does not matter
 */

public class ThreePoint4 {
	
	public static void main(String[] phoneNumber) {
		
		//Creating the first three digits
		//Not above 8 or 9
		
		int firstDigit, secondDigit, thirdDigit;
		
		String first, second, third;
		
		Random object = new Random();		//random Generator
		
		DecimalFormat numFormat = new DecimalFormat("000");	///format of how the number should look
		
		/*
		 * First block should not contain 8 or 9
		 * Individually seemed to be the most appropriate way to do so
		 */
		firstDigit = object.nextInt(8);
		secondDigit = object.nextInt(8);
		thirdDigit = object.nextInt(8);
		
		/*
		 * Four codes below was made so that I can put the
		 * three digits together
		 */
		first = Integer.toString(firstDigit);
		second = Integer.toString(secondDigit);
		third = Integer.toString(thirdDigit);
		
		String firstBlock = first + second + third;	//firstBlock now contains the xxx number
		
		
		//System.out.println(firstBlock);
		
		//Creating the second block for the phone number
		int secondBlock;
		
		secondBlock = object.nextInt(743);
		String secondBlock2 = numFormat.format(secondBlock);
		
		
		//Creating the third block for the phone number
		int thirdBlock;
		
		thirdBlock = object.nextInt(10000);
		String thirdBlock2 = numFormat.format(thirdBlock);
		
		System.out.println("Random phone number generated below: ");
		System.out.print(firstBlock + "-" + secondBlock2 + "-" + thirdBlock2);
		
	}

}
