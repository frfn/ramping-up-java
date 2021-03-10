package chapter5ProgrammingProjects;
import java.util.Scanner;

/*
 A program that will read a string from the user and prints its characters line by line
 */

public class FivePoint4OutputCharLineByLine {
	
	//I initialized two variables first, the string object and the scanner object
	
	static String string;
	static Scanner scan;
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		System.out.print("Input string and I will display them line by line: ");
		string = scan.nextLine();
		
		System.out.println(); //spacing it out
		
		for(int i = 0; i <= string.length() - 1; i++) {	//going through 
			
			/*
			 So here, I found that if you use JUST < , you will not need the equality
			 but if the the comparison operator is <= , you will need ( - 1 )
			 */
			
			System.out.println(string.charAt(i));
			
		}
		
		System.out.println(string.length());
		//the length tester!, now you know why you have to subtract 1!
		
		
	}

}
