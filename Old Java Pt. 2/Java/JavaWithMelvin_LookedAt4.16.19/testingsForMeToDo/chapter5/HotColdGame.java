package chapter5;
import java.util.Scanner;
/*
 * Game of Hot-Cold, guess between 100!
 */

public class HotColdGame {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		HotCold number = new HotCold();
		int random = number.getNumber();
		
		boolean keepGuessing = true;
		boolean correctGuess = false;
		

		
		
		
		System.out.println("This is the random number: " + random);
		System.out.print("Please enter number that you think number is: ");
		String input = scan.nextLine();
		
		//WORK ON THIS VALIDATION CODE
		
		while(input.matches("[a-zA-Z]+")) {
			System.out.print("Please input again, not valid answer: ");
			input = scan.nextLine();
		}
					
		int userInput = Integer.parseInt(input); 
		
		while(keepGuessing) {
			/*
			 * Number is in the range of 10 = hot
			 * 
			 * Number is in the range of 11-25 = warm
			 * 
			 * Number is in the range of 26-... = cold
			 */
			
			//( (random - userInput) <= 10 )|| ((userInput - random) <= 10 )
			
			
			
			//(20 - 40) <= 10 ) || ((40 - 20) <= 10 )
			//	-20	<= 10	||	20 <= 10
			
			
			
			//random 
			//userinput
			
			/*
			 * T	T	= T
			 * T	F	= T
			 * F	T	= T
			 * F	F	= F
			 */
			
			if( (userInput <= random + 10) || (userInput >= random - 10) ) {
				
				
				//(userInput <= random + 10) && (userInput >= random - 10) – original
				
				
			//	random - 10-------------------userInput---------------------random + 10
					// it is between the range
			
				
				// STUDY LATER **
				
				/*
				 * I first had it like this:
				 * 
				 * userInput = 44;
				 * random = 54; 
				 * 
				 * (userInput <= random - 10) && (userInput >= random + 10)
				 * 
				 *  userInput ----- – 10 ---random--- + 10 ----- userInput
				 * 
				 * **this IS outside the range,
				 * 		This line of code works like this:
				 * 		If userInput is less than the random number MINUS 10!
				 * 		It means that it is less than the value after subtracting 10!
				 * 		Random is 54, userInput is 44.
				 * 		If userInput(44), is less than Random(54) - 10 = 44
				 * 		THIS does make sense, it really does.
				 * 		But it does not work here, I had to use the OR logical operator
				 * 		For it to make sense, and for it to only output the correct answer
				 * 		for only one condition
				 * 
				 * THIS CODE IS WRONG, look above in the "if" statement
				 * 
				 */
				
				System.out.print("You are hot, keep guessing!: ");
				userInput = scan.nextInt();
			}
			
			else if((userInput <= random + 25) && (userInput >= random - 25)) {
				
				System.out.print("You are warm, keep guessing!: ");
				userInput = scan.nextInt();
				
			}else {
				System.out.print("You are cold, keep guessing!: ");
				userInput = scan.nextInt();
			}
			
			if(userInput == random) {
				keepGuessing = correctGuess;
			}
			
				
			}//while loop end
			
		System.out.print("Congratulations! You have guessed the correct number!: " + random);
			
		}
		
		
		
		
}


