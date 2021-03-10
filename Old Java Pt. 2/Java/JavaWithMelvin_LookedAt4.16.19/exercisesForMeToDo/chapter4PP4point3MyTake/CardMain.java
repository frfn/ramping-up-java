package chapter4PP4point3MyTake;
import java.util.Random;
/*
 * Create a program that deals 5 RANDOM cards from the class "Card"
 */

public class CardMain {
	
	private static int cardLimit = 52;
	private static int cardValueLimit = 12;
	private static String[] cardSuit = { "diamonds", "clubs", "spades", "hearts"};
	
	public static void main(String[] cards) {
		
		Random random = new Random();
		
		int randomCardValueLimit = (int)((Math.random() * cardValueLimit) + 1);
			
		int randomCardSuitNumber = (int)(Math.random() * 4);
		String randomCardSuit = cardSuit[randomCardSuitNumber];
		
		Card card = new Card(randomCardSuit, randomCardValueLimit);
		
		randomCardValueLimit = (int)((Math.random() * cardValueLimit) + 1);
		
		randomCardSuitNumber = (int)(Math.random() * 4);
		randomCardSuit = cardSuit[randomCardSuitNumber];
		
		Card card2 = new Card(randomCardSuit, randomCardValueLimit);
		
		randomCardValueLimit = (int)((Math.random() * cardValueLimit) + 1);
		
		randomCardSuitNumber = (int)(Math.random() * 4);
		randomCardSuit = cardSuit[randomCardSuitNumber];
		
		Card card3 = new Card(randomCardSuit, randomCardValueLimit);
		
		randomCardValueLimit = (int)((Math.random() * cardValueLimit) + 1);
		
		randomCardSuitNumber = (int)(Math.random() * 4);
		randomCardSuit = cardSuit[randomCardSuitNumber];
		
		Card card4 = new Card(randomCardSuit, randomCardValueLimit);
		
		randomCardValueLimit = (int)((Math.random() * cardValueLimit) + 1);
		
		randomCardSuitNumber = (int)(Math.random() * 4);
		randomCardSuit = cardSuit[randomCardSuitNumber];
		
		Card card5 = new Card(randomCardSuit, randomCardValueLimit);
		 
		
		System.out.println(card);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(card4);
		System.out.println(card5);
		
		
	}

}
