package hotCold;
import java.util.Scanner;
/*
 * User guesses a number, program will tell it if it is close
 * 
 * cold warm and hot are the output so it will help user know 
 * what number
 * 
 * 
 */

/* Steps I took
 * 
 * 1.) Created the scanner variable and created some variables
 * 		that I think I will need
 * 
 * 2.) Setting up the output
 * 
 * 3.) Remembered to use the RandomNumber class
 * 
 * 4.) Thought about how it the app works
 * 		We will need a loop mechanism, since
 * 		we know that user will guess COUNTLESS times,
 * 		it will be the while loop.
 * 
 * 5.) Created a counter to see how many times we
 * 		guessed
 */

public class HotColdGame {
	
	static Scanner scan = new Scanner(System.in);
	static private int userInput;
	static private int counter;
	
	public static void main(String[] args) {
		
		RandomNumber random = new RandomNumber();
		//System.out.println(random.toString() + "\n");
		
		System.out.println("Welcome! Please guess a number! We will tell you if you are cold, warm or hot!");
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.print("Please enter a number, -1 to quit: ");
		userInput = scan.nextInt();
		
		while(userInput != -1) {
			
			/*
			 * Three stages, hot, warm, and cold
			 * 
			 * so if, if else, and else
			 * 
			 * hot will be 10 away from number
			 * warm will be 20 away from number
			 * cold is anything else, print "cold"
			 */
			
			/* Logic:
			 * 
			 * RandomNumber = 30
			 * 
			 * userInput = 28
			 * 
			 * 
			 * 
			 * 
			 *
			 * 
			 */
			if(userInput == random.getNumber()) {
				System.out.println("You have guessed the number " + random.getNumber() + "!");
				userInput = -1;
			}
			else if(userInput > random.getNumber() - 2 && userInput < random.getNumber() + 2) {
				System.out.print("You\'re there!! Keep guessing: ");
				userInput = scan.nextInt();
			}
			else if(userInput > random.getNumber() - 5 && userInput < random.getNumber() + 5) {
				System.out.print("Super Hot! Keep guessing: ");
				userInput = scan.nextInt();
			}
			else if(userInput > random.getNumber() - 10 && userInput < random.getNumber() + 10) {
				System.out.print("Hot! Keep guessing: ");
				userInput = scan.nextInt();
			}
			else if (userInput > random.getNumber() - 20 && userInput < random.getNumber() + 20) {
				System.out.print("Warm! Keep guessing: ");
				userInput = scan.nextInt();
			}
			else {
				System.out.print("Cold! Keep guessing: ");
				userInput = scan.nextInt();
			}
			
			
			counter++;
		}//end of while
		
		counter--;
		
		System.out.println("Congratulations! Attempts: " + counter
				+ "\nThank You for playing!");
		
	}

}
