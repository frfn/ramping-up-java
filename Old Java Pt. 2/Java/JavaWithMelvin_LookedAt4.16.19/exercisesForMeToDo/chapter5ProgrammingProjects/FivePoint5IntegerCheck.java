package chapter5ProgrammingProjects;
import java.util.Scanner;
public class FivePoint5IntegerCheck {
	
	static Scanner scan;
	static String string;
	
	/*
	 These variables were initialized as I worked on the code
	 How? I understood the problem first and executed these on the go
	 */
	static int evenCounter = 0, oddCounter = 0, zeroCounter = 0;
	static int parseInt = 0;
	static int test = 0;
	
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		
		
		System.out.println("Enter an integer and I will produce how many 0s, odd's, and even's: ");
		string = scan.nextLine();
		
		
		
		for(int i = 0; i <= string.length() - 1; i++) {
			
			/*
			 My thought process.
			 If I can parse every integer, number by number, I can compare it to the operators
			 and see if the number is 0, divisible by 2 (meaning its even), if its not divisible by 2 ( meaning its odd )
			 */
			
			 parseInt = Integer.parseInt(String.valueOf(string.charAt(i)));
			 
			
			 //Integer.parseInt ( string ) transforms a string into an integer
			 	//part of the Integer class
			 
			//String.valueOf( char c )   returns the string representation of the of the Character
			 	//part of the String class
			 
			 //string.charAt(i) returns the char value of the specified index
			 
			 
			 //that line represent – Integer Parsing a String Value with a parameter of a Char
			
			
			 
			 
			 
			 
			if(parseInt == 0) {
				zeroCounter++;	//if the number is equals to 0, it will register and increment the counter
			}
			else if (parseInt % 2 == 0) {
				evenCounter++;	//if it is divisible by two, it will increment evenCounter
			}
			else if (parseInt % 2 != 0) {
				oddCounter++;	//if it is divisible by one, it will increment oddCounter
			}
				 
		}
		
		
		
	System.out.println("Zero number occurred: " + zeroCounter);
	System.out.println("Odd number occurred: " + oddCounter);
	System.out.println("Even number occurred: " + evenCounter);
	
	}
	
}
