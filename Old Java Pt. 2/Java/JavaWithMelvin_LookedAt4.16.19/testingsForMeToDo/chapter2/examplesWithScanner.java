package chapter2;
import java.util.*;
//a package that we need to import, so we can use scanner

public class examplesWithScanner {
	
	public static void main(String[] scanner) {
		
		Scanner scanObject = new Scanner(System.in);
		// we just created a scan object
		
		System.out.print("Enter your age: ");
		//printing out "Enter your age: ", since no println, will not enter next line
		
		int yourAge;
		//declared a variable called 'yourAge'
		
		yourAge = scanObject.nextInt();
		//yourAge will take keyboard input only consisting of numbers
		
		/*
		 * you can combine making it simple and straight forward
		 * 
		 * **important**
		 * 		int yourAge = scanObject.nextInt();
		 * 
		 * one line, instead of two
		 */
		
		System.out.print("Your age is: " + yourAge);
		
		scanObject.close();
	}

}
