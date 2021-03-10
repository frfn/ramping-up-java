package chapter5;
import java.util.Scanner;
/*
 * THIS SEEMS LIKE THIS IS THE TEST FILE. A PROTOTYPE.
 * 
 * This WAS a prototype, we were trying to solve it with the OR operator,
 * logically, it is IMPOSSIBLE!
 */
public class HotColdGame2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HotCold randomNumber = new HotCold();
		System.out.println(randomNumber.getNumber()); //so we can see
		
		int guessMe = randomNumber.getNumber();
		
		System.out.println("The guessing game, I\'ll tell you if you\'re hot, warm or cold");
		int myGuess = scan.nextInt();
		
		boolean keepOn = true;
		boolean youWon = false;
		
		while(keepOn) {
			
			if(myGuess == guessMe) {
				System.out.println("You have won!");
				keepOn = youWon;
			}
			
			else if(( (guessMe - myGuess) <= 10 )|| ((myGuess - guessMe) <= 10 )) {
				//50	-  40  <= 10 		...		40 - 50 <= 10
				System.out.print("You\'re hot, keep guessing: ");
				myGuess = scan.nextInt();
			}
			else{
				System.out.println("You\'re cold, keep guessing: ");
				myGuess = scan.nextInt();
			}
			
			
			
		}
		
		System.out.println("Thanks for playing the game. #codingIsLife");
		
	}

}
