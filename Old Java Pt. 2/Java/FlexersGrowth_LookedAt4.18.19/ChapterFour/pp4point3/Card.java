package pp4point3;
import java.util.Random;
public class Card {
	
	private String suit;
	private String value;
	private String[] cardSuit = {"Diamonds", "Spades", "Clubs", "Hearts"};
	private String[] cardValue = {"Ace", "Two", "Three", "Four", "Five", 
									"Six", "Seven", "Eight", "Nine",
									"Ten", "Jack", "Queen","King"};
	
	
	public Card() {
		
		System.out.println("Call the newCard() method for a new card!");
		
	}
	
	public void getNewCard() {
		
		Random random = new Random();
		
		suit = cardSuit[random.nextInt(4)];
		
		value = cardValue[random.nextInt(13)];
		
	}
	
	public void getSpecificCard(String suit, String value) {
		suit = cardSuit[Integer.parseInt(suit)];
		value = cardSuit[Integer.parseInt(value)];
		
		System.out.println("Specified Card: " + value + " of " + suit);
		
	}
	
	public String getSuit() {
		return suit;
	}
	public String getValue() {
		return value;
	}
	public String toString() {
		return value + " of " + suit;
	}
	
	

}
