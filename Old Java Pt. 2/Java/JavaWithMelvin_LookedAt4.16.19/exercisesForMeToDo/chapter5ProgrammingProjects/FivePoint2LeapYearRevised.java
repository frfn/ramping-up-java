package chapter5ProgrammingProjects;
import java.util.Scanner;


public class FivePoint2LeapYearRevised {
	
	static Scanner scan;
	static int YEAR;
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		System.out.println("Leap Year!");
		System.out.print("Please enter a value greater than 1582 or -1 to quit: ");
		
		YEAR = scan.nextInt();
		
		while(YEAR != -1) { //sentinel value, if user inputs -1, quit, if not -1 keep going
			
			while(YEAR < 1582) {	//input validation, if YEAR is less than 1582, keep inputting
			System.out.print("Please enter higher value than 1582: ");
			YEAR = scan.nextInt();
			}
			
			//this is the LEAP YEAR logic, understand this with Melvin!
			
			if(YEAR % 4 == 0 && (YEAR % 100 != 0 || YEAR % 400 == 0)) {
				System.out.println("It is a Leap Year!");
			}else {
				System.out.println("It is not a Leap Year!");
			}
			
			//this will prompt the user if they want to try more years to see if it is a leap year!
			System.out.print("Try more years? -1 to quit: ");
			YEAR = scan.nextInt();
		}
		
		System.out.print("Thank you for using!"); //once it exits the while loop, it will prompt thank you!
		
	}

}
