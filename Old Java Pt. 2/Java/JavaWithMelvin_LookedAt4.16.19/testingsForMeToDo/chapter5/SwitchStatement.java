package chapter5;
import java.util.Scanner;
public class SwitchStatement {
	
	public static void main(String[] args) {
		
		Scanner object = new Scanner(System.in);
		
		System.out.println("Why hello there, you have won, you have three choices to pick from!");
		System.out.print("Please input 1, 2 or 3: ");
		
		int userChoice = object.nextInt();
		
		while(userChoice < 0 || userChoice > 4) {
			System.out.println("Please input correct choice: ");
			userChoice = object.nextInt();
		}
		
		switch(userChoice) {
		case 1: 
			System.out.println("Wow, cool! You get nothing!");
			break;
		case 2:
			System.out.println("Wow, cool! You won 50,000,000 dollars!");
			break;
		case 3:
			System.out.println("Wow, cool! You get a flight back to your house!");
		}
		
		System.out.println("Thanks for playing!");
		
	}

}
