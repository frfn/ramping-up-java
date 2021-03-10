package pig;
import java.util.Scanner;
/*
 * Pig Application – uses AI behaviors.
 * 
 * Goal is to reach 100 points. Win by getting 100.
 * 
 * 1. Player can give turn away
 * 2. Player can keep rolling if they want to
 * 		If user rolls a ONE, lose points that turn – give turn to computer
 * 		If user rolls two ONES, lose ALL POINTS – give turn to computer
 * 3. If computer accumulates more than 20 points – turn will be yours
 */

public class Pig {
	
	private static final int winningScore = 100;
	static Scanner object = new Scanner(System.in);
	static PairOfDice dice; //two values
	
	private static int player1score = 0;
	private static int player2score = 0;
	
	/*
	 * 
	 * Key tip, return key word,
	 * 
	 * NOT ONLY breaks out of any loop, but the whole entire
	 * FUNCTION/METHOD
	 * 
	 */
	
	/*
	 * Here, I will make the other methods first.
	 * 
	 * That will help me more in my opinion.
	 * 
	 * Will be doing the the computerTurn 
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Game of Pig ");
		System.out.println("------------");
		
		while(player1score < winningScore && player2score < winningScore) {
			
			player1score += playerTurn();
			System.out.println("Current score for player 1: " + player1score);
			
			if(player1score > winningScore) {
				break;
			}
			
			player2score += computerTurn();
			System.out.println("Current score for computer: " + player2score);
			
			
			
		}
		
		if(player1score > winningScore) {
		System.out.println("Player 1 wins!");
		}
		
		
		
		if(player2score > winningScore) {
			System.out.println("Computer wins!");
		}
		
		System.out.println("Thank you for playing!");
			
	}//end of main
	
	private static int computerTurn() {
		
		System.out.println("Computer's Turn");
		System.out.println("----------------");
		
		// initializing the boolean variable for the while loop
		/*
		 * This was where I found using boolean variables
		 * is SO useful in a while loop
		 */
		// starts underneath, ALSO
		// we need to make a variable that will return a value!
		int scoreForThisRound = 0;
		
		
		boolean keepRolling = true;
		// initializing only one variable – i can set to false
		// if need be! – will use it if  user wants to stop
		while(keepRolling) {
			
			dice = new PairOfDice(); //instantiated new dice object
			
			/*
			 * If user gets a 1 during their roll
			 * return 0, user "loses" his turn 
			 * (in reality, the return function
			 * kicks us out!)
			 */
			
			if(dice.getDieValue() == 1 || dice.getDie2Value() == 1) {
				System.out.println("Computer rolled a one! ");
				return 0;
			}
			else if(dice.totalOfDieValues() == 2) {
				System.out.println("Computer rolled two one's! All points lost!");
				return scoreForThisRound = 0;
			}
			else {
				scoreForThisRound += dice.totalOfDieValues();
			}
			
			if(scoreForThisRound >= 20) {
				System.out.println("Computer reached 20 points! Users turn...");
				keepRolling = false;
			}
			
		}//end of while loop
		System.out.println("Points that will be added to total score: " + scoreForThisRound);
		return scoreForThisRound;
	}//end of computerTurn
	
	private static int playerTurn() {
		
		System.out.println("Player's turn");
		System.out.println("--------------");
		
		boolean keepRolling = true;
		int scoreForThisRound = 0;
		
		while(keepRolling) {
			
			dice = new PairOfDice();
			
			if(dice.getDieValue() == 1 || dice.getDie2Value() == 1) {
				System.out.println("You rolled a one! Computers turn turn!");
				return 0;
				/*
				 * Note: we are returning 0, yes! but the 
				 * scoreForThisRound is STILL accumulated
				 * returned. 
				 */
			}
			else if(dice.totalOfDieValues() == 2) {
				System.out.println("You rolled two one's! All points lost this turn, computer's turn!");
				return scoreForThisRound = 0;
			}
			else {
				scoreForThisRound += dice.totalOfDieValues();
				System.out.println("Current score: " + scoreForThisRound);
			}
			
			System.out.print("Do you want to keep rolling? Yes or No?: ");
			String answer = object.nextLine();
			
			while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
				System.out.print("Please input correct answer: ");
				answer = object.nextLine();
			}//end of while	
			
			if(answer.equalsIgnoreCase("yes")) {
				keepRolling=true;
			}
			else if(answer.equalsIgnoreCase("no")) {
				keepRolling=false;
			}
			
		}
		System.out.println("Points that will be added to total score: " + scoreForThisRound);
		return scoreForThisRound;
	}
	
	
}

