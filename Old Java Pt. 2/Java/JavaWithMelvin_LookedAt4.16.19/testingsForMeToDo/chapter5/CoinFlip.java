package chapter5;
import java.util.Scanner;
public class CoinFlip {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Coin firstCoin = new Coin();
		
		System.out.println(firstCoin.faceName());
		System.out.println(firstCoin.getResult());
		System.out.println(firstCoin.isHeads());
		System.out.println(firstCoin.isTails());
		
		firstCoin.flipCoin();
		
		System.out.println(firstCoin.faceName());
		
		System.out.print("Do you want to play a game of heads and tails? Input yes/no: ");
		String answer = scan.nextLine();
		
		while(!answer.equalsIgnoreCase("yes") && !answer.equals("no")) {
			System.out.print("Please input correct input... yes/no: ");
			answer = scan.nextLine();
		}
		
		if(answer.equalsIgnoreCase("no")) {
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
		
		System.out.print("How many players? 1 or 2?: ");
		int playerAnswer = scan.nextInt();
		
		while(playerAnswer != 1 && playerAnswer != 2) {
			System.out.print("Please input correct input... 1 or 2: ");
			playerAnswer = scan.nextInt();
		}
		
		if(playerAnswer == 2) {
			
			Scanner object = new Scanner(System.in);
			
			Coin forPlayerOne = new Coin();
			Coin forPlayerTwo = new Coin();
			
			int winningVariable = 3;
			
			int playerOneWins = 0;
			int playerTwoWins = 0;
			
			System.out.println("Best game out of three! Get heads! Good luck!");
			
			System.out.print("Who is player one?: ");
			String p1 = object.nextLine();
			
			System.out.print("Who is player two?: ");
			String p2 = object.nextLine();
			
			while(playerOneWins < winningVariable && playerTwoWins < winningVariable) {
				
				forPlayerOne.flipCoin();
				forPlayerTwo.flipCoin();
				
				System.out.println(p1 + " got!: " + forPlayerOne.faceName());
				System.out.println(p2 + " got!: " + forPlayerTwo.faceName());
				
				if(forPlayerOne.getResult() == 1 && forPlayerTwo.getResult() == 1) {
					System.out.println("Both got heads, flip again!");
				}
				
				else if(forPlayerTwo.getResult() == 1) {
					playerTwoWins++;
				}
				
				else if(forPlayerOne.getResult() == 1) {
					playerOneWins++;
				}
				
				
				System.out.println();
				System.out.println("Total wins for " + p1 + ":" + playerOneWins);
				System.out.println("Total wins for " + p2 + ":" + playerTwoWins);
				System.out.println();
				
			}
			
			
			
			
			
		}else {
			
			
			
			System.out.println("Go play with two player lonely-ass-bitch.");
			/*
			 * creating a method for the game would have been better so you can just call it.
			 */
			System.exit(0);
			
			
			
		}
		
	}

}
