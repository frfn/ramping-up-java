package chapter4PP4point1and2;

import java.util.*;

/* PIG
 * 
 * User competes against computer, A/I
 * On each turn the player will roll dice and accumulate points
 * 
 * The GOAL is to reach 100 points
 * 
 * Player has control over dice and can keep rolling, until conditions below are met!
 * Player can also voluntarily give turn away to risk losing points, or be a "pig" and keep rolling
 * 
 * Conditions:
 * 
 * If any time a player rolls and gets the value 1, all points are loss for that turn, and turn goes to computer
 * 
 * If any time a player rolls and gets two 1's, player loses all points, and turn goes to computer
 * 
 * Program so that if the computer accumulates 20 or more points, it will be your turn
 */


////////////////////////////////////////////////////////////
//
// Tips and tricks!
//	- using a while loop 
//		and boolean values for "player turn", 
//		such as "the user's turn now", or 
//		"comp" turn now
//
////////////////////////////////////////////////////////////


public class Pig {
	
	private static int endScore = 100;
	
	/*
	 * variable has been declared for later use, 
	 * end score is 100
	 */
	static Scanner object = new Scanner(System.in);
	/*
	 * scanner object is global so it will be usable not just in one method declaration
	 */
	static PairOfDice dice;
	/*
	 * to call dice whenever needed, to instantiate
	 */
	
	
	
	public static void main(String[] whoWillWin) {
		
		
		
		System.out.println("Welcome! We are now playing the game, Pig!");
		System.out.print("Are you ready? Type yes/no to continue!: ");
		
		/*
		 * statements above to make it welcoming to guests/user
		 */
		
		String answer = object.nextLine();
		
		while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
			System.out.print("Please input again, not valid answer: ");
			answer = object.nextLine();
		}
		
		/*
		 * above is the validation,
		 * 
		 * 1. answer = object.nextLine(); will take in the user input
		 * 2. validating starts at while loop, while answer is not yes, and while answer is not no, repeat again!
		 */
		
		if(answer.equalsIgnoreCase("no")) {
			System.out.print("Thanks for playing! Bye!");
			System.exit(0);
		}
		/*
		 * if player says no, then output thanks for playing! and terminate program
		 */
		
		System.out.print("Are there two players or one? Yes or no?: ");
		answer = object.nextLine();
		
		/*
		 * another validation, to see whether there are two players or only one
		 */
		
		if(answer.equals("yes")){
		String player1name = promptPlayerName();
		String player2name = promptPlayerName();
		
		//calling prompPlayerName which just returns the String value
		
		System.out.println();
		
		int player1score = 0;
		int player2score = 0;
		
		//initializing 0 points to both players for start
		
		while(player1score < endScore && player2score < endScore) {
		
			/*
			 * while both players are under end score, 100, keep playing!
			 */
		
		
		int player1turnScore = playerTurn(player1name);
		
		/*
		 * value will go into score, and playerTurn is a function that has the calculation
		 */
		player1score += player1turnScore;
		/*
		 * increase value of overall score
		 */
		
		printCurrentScore(player1name, player1score, player2name, player2score);
		/*
		 * printing current score by calling the function
		 */
		
		int player2turnScore = playerTurn(player2name);
		player2score += player2turnScore;
		
		printCurrentScore(player1name, player1score, player2name, player2score);
		
		}
		
		printResults(player1name, player1score, player2name, player2score);
		/*
		 * print result method called
		 */
		}else {
			
			//player vs comp
			
			
			String player1name = promptPlayerName();
			String player2name = "Computer";
			
			System.out.println();
			
			int player1score = 0;
			int player2score = 0;
			
			while(player1score < endScore && player2score < endScore) {
			
			
			
			int player1turnScore = playerTurn(player1name);
			player1score += player1turnScore;
			
			printCurrentScore(player1name, player1score, player2name, player2score);
			
			int player2turnScore = computerTurn(player2name);
			player2score += player2turnScore;
			
			printCurrentScore(player1name, player1score, player2name, player2score);
			
			}
			
			printResults(player1name, player1score, player2name, player2score);
			
			
			
			
			
		}
	}
	
	private static void printResults(String player1name, int player1score,
									 String player2name, int player2score) {
		
		System.out.println("------Game Over!------");
		
		if (player1score > player2score){
			System.out.print(player1name + " won with " + player1score + " points!");
			
		}else {
			System.out.print(player2name + " won with " + player2score + " points!");
			
		}
		
		/*
		 * Method just prints out the results!
		 */
		
		
	}
	
	private static String promptPlayerName() {
		
		System.out.print("Enter player name: ");
		return object.nextLine();
		
		/*
		 * method just prompts the players name
		 */
		
	}
	
	private static void printCurrentScore(String player1name, int player1score, String player2name, int player2score) {
		
		System.out.println("\n" + player1name + ": " + player1score + 
				  "\n" + player2name + ": " + player2score + "\n");
		
		/*
		 * calls the methods and it prints out the information above, the current score
		 */
		
	}
	
	private static int computerTurn(String computerName) {
		
		/*
		 * this is made with the exact same logic as the players
		 */
		
		System.out.println("It is the computer's turn!");
		
		boolean keepRolling = true;
		
		/*
		 * this is very handy, 
		 * by having a boolean, keepRolling
		 * I can put it in the while loop, while it is true, keep running, else false, and it will end
		 */
		
		int turnScore = 0;
		/*
		 * turn score is 0,
		 */
		
		while(keepRolling) {
			
			dice = new PairOfDice();
			
			if(dice.getDie1Value() == 1) {
				System.out.println("First die rolled a 1! Computer loses all points for this turn, it is your turn!");
				return 0;
			}
			if(dice.getDie2Value() == 1) {
				System.out.println("Second die rolled a 1! Computer loses all points for this turn, it is your turn!");
				return 0;
			}
			if(dice.getDie1Value() == 1 && dice.getDie2Value() == 1) {
				System.out.println("You rolled a 1 for both dice! Computer loses all score, it is your turn!");
				return turnScore = 0;
			}

			
			turnScore += (dice.getDie1Value() + dice.getDie2Value());
			
			if(turnScore >= 20) {
				System.out.println("Computer accumulated more than 20 points! Your turn!");
				keepRolling = false;
			}
		}
		
		return turnScore;
		
	}
	
	private static int playerTurn(String playerName) {
		
		System.out.println(playerName + "'s turn!");
		
		boolean keepRolling = true;
		/*
		 * set to true!
		 * because if false, while loop will stop!
		 * 
		 * think about how "while loop" 's work!
		 */
		int turnScore = 0;
		while(keepRolling) {
			
			dice = new PairOfDice();
			/*
			 * by instantiating dice,
			 * we created an object which will
			 * roll the dice!
			 */

			if(dice.getDie1Value() == 1) {
				System.out.println("First die rolled a 1! You lose all points for this turn, and your turn is over!");
				return 0;
			}
			if(dice.getDie2Value() == 1) {
				System.out.println("Second die rolled a 1! You lose all points for this turn, and your turn is over!");
				return 0;
			}
			if(dice.getDie1Value() == 1 && dice.getDie2Value() == 1) {
				System.out.println("You rolled a 1 for both dice! You lose all score and your turn is over!");
				return turnScore = 0;
			}

			
			turnScore += (dice.getDie1Value() + dice.getDie2Value());
			System.out.println("Current score for " + playerName + "!: " + turnScore);
			
			System.out.print("Want to roll again? Type yes or no!: ");
			String answer = object.nextLine();
			
			while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
				System.out.println("Enter correct input! \"Yes\" or \"No\"!: ");
				answer = object.nextLine();
			}
			
			if(answer.equalsIgnoreCase("no")) {
				keepRolling = false;
			} 
			
			if(answer.equalsIgnoreCase("yes")) {
				keepRolling = true;
			}
			
		}
		System.out.println(playerName + " has: " + turnScore + " points!"+ "\n");
		
		return turnScore;
		
	}
	
	

}

	
