package pp4point1And4point2;
import java.util.*;
public class Pig {
	
	private static int endScore = 100;
	private static PairOfDice die;
	private static Scanner scan;
	public static int playerScore = 0, player2Score = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Pig");
		System.out.println("-----");
		
		while(playerScore < endScore && player2Score < endScore) {
			
			//playerScore += playerTurn();
		
		if(playerTurn() == 2) {
			playerScore = 0;
		}
		
			
		
		
		System.out.println("Current score for player one: " + playerScore);
		
		
		//player2Score += computerTurn();
		
		
		if(computerTurn() == 2) {
			player2Score = 0;
		}
			
		
		
		System.out.println("Current score for computer: " + player2Score);
			
		}	
		
		if(playerScore > 100) {
			System.out.println("Player One won!");
		}
		
		if(player2Score > 100) {
			System.out.println("Computer won!");
		}
		
	}
	
	//Respected that there are two players
	public static int playerTurn() {
		
		boolean keepRolling = true;
		
		die = new PairOfDice();
		scan = new Scanner(System.in);
		
		int score = 0;
		
		System.out.println("Player Turn...");
		
		while(keepRolling) {
		
			die.rollBoth();
			
			if(die.getDieValueOfBoth() == 2) {
			System.out.println("DIES ARE BOTH ONEE!!!! Resetting score to 0.");
			playerScore = 0; //resetting user score
			System.out.println("Current score: " + playerScore);
			return 2;
			}
				
			else if(die.getDieValue() == 1 || die.getDieTwoValue() == 1) {
			System.out.println("One of the two die's rolled a one! Returning 0.");
			return 0;
			//returning 0 will force you out of method!
			}
		
			else {
			score += die.getDieValueOfBoth();
			System.out.println("Current score to be added: " + score);
			}
			
			System.out.print("Roll again? Yes or No: ");
			String answer = scan.nextLine();
			
			while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
				System.out.print("Enter correct answer: ");
				answer = scan.nextLine();
			}
			
			if(answer.equalsIgnoreCase("yes")) {
				keepRolling = true;
			}
			if(answer.equalsIgnoreCase("no")) {
				keepRolling = false;
			}
			
			
		}//end of while
		
		System.out.println("Points to be added this round: " + score);
		
		return score;
		
	}
	
	//Player Two
	public static int playerTwoTurn() {
		
		boolean keepRolling = true;
		
		die = new PairOfDice();
		scan = new Scanner(System.in);
		
		int score = 0;
		
		System.out.println("Player Two Turn...");
		
		while(keepRolling) {
		
			die.rollBoth();
			
			if(die.getDieValueOfBoth() == 2) {
			System.out.println("DIES ARE BOTH ONEE!!!! Resetting score to 0.");
			//player2Score = 0; //resetting user score
			System.out.println("Current score: " + player2Score);
			return 2;
			}
				
			else if(die.getDieValue() == 1 || die.getDieTwoValue() == 1) {
			System.out.println("One of the two die's rolled a one! Returning 0.");
			return 0;
			//returning 0 will force you out of method!
			}
		
			else {
			score += die.getDieValueOfBoth();
			System.out.println("Current score to be added: " + score);
			}
			
			System.out.print("Roll again? Yes or No: ");
			String answer = scan.nextLine();
			
			while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
				System.out.print("Enter correct answer: ");
				answer = scan.nextLine();
			}
			
			if(answer.equalsIgnoreCase("yes")) {
				keepRolling = true;
			}
			if(answer.equalsIgnoreCase("no")) {
				keepRolling = false;
			}
			
			
		}//end of while
		
		System.out.println("Points to be added this round: " + score);
		
		return score;
		
	}
	
	//I can use if its player VS comp
	public static int computerTurn() {
		boolean keepRolling = true;
		
		die = new PairOfDice();
		scan = new Scanner(System.in);
		
		int score = 0;
		
		System.out.println("Computer Turn...");
		
		while(keepRolling) {
		
			die.rollBoth();
			
			
		
			if(die.getDieValueOfBoth() == 2) {
			System.out.println("DIES ARE BOTH ONEE!!!! Resetting score to 0.");
			//player2Score = 0; //resetting user score
			return 2;
			}
			
			else if(die.getDieValue() == 1 || die.getDieTwoValue() == 1) {
			System.out.println("One of the two die's rolled a one! Returning 0.");
			return 0;
			//returning 0 will force you out of method!
			}
		
			else {
			score += die.getDieValueOfBoth();
			System.out.println("Current score to be added: " + score);
			}
			
			//this is how the "AI" will stop
			if(score >= 20) {
				System.out.println("Computer rolled over 20!");
				keepRolling = false;
			}
			
			
		}//end of while
		
		System.out.println("Points to be added this round: " + score);
		
		return score;
		
		
	}

}
