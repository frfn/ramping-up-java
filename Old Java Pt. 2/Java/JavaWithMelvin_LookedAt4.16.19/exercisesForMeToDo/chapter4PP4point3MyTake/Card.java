package chapter4PP4point3MyTake;
import java.util.Scanner;

public class Card {
	
	private String cardSuit;
	private int cardValue;
	
	
	
	public Card(String suit, int value) {
		
		cardSuit = suit;
		cardValue = value;
	
	}
	
	public void setCardValue(int value) {
		cardValue = value;
	}
	
	public void setCardSuit(String suit) {
		cardSuit = suit;
	}
	
	public int getCardValue() {
		return cardValue;
	}
	
	public String getCardSuit() {
		return cardSuit;
	}
	
	public String toString() {
		return cardSuit + ": " + cardValue;
	}

}
