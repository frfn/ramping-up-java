package chapter5ProgrammingProjects;
import java.util.Scanner;
import java.util.Random;

public class FivePoint8HiLo {
	static Scanner scan;
	static int userInput;
	static int randomNumber;
	//boolean flag = false;
	
	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		
		randomNumber = random.nextInt(100) + 1;
		System.out.println(randomNumber);
		
		System.out.print("Enter a number between 1 - 100 or -1 to quit: ");
		userInput = scan.nextInt();
		
		while(userInput != -1) {
		
		
		while(userInput > 100 || userInput < 0) {
			System.out.println("Enter value again from 1 - 100: ");
			userInput = scan.nextInt();
		}//end of validator
		
		if(userInput < randomNumber) {
			System.out.print("Low, keep inputting or -1 to quit: ");
			userInput = scan.nextInt();
		}
		else if(userInput > randomNumber) {
			System.out.print("High, keep inputting or -1 to quit: ");
			userInput = scan.nextInt();
		}
		else if(userInput == randomNumber) {
			System.out.println("You won!");
			userInput = -1;
			
		}
		
		
	}//end of while loop
		
		System.out.println("Thanks for playing!");

}//end of main
}//end of class
