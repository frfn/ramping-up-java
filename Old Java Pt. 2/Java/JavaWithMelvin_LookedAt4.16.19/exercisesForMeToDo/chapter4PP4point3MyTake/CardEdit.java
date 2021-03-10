package chapter4PP4point3MyTake;

public class CardEdit {
	
	/*
	 * Global variables should always be private to enforce encapsulation
	 */
	
	/*
	 * VERY IMPORTANT
	 * IF YOU ARE USING MATH.RANDOM, 
	 * YOU NEED PARENTHESIS AROUND IT AND THE CAST
	 */
	
	private String cardSuit;
	private String cardValue;
	
	private String suit[] = {"Diamonds", "Spades", "Clubs", "Hearts"};
	private String value[] = {"Ace", "Two", "Three", "Four", "Five", 
								"Six", "Seven", "Eight", "Nine",
								"Ten", "Jack", "Queen","King"};
	

	
	
	public CardEdit() {
		
		cardSuit = "Please call the new card method to get card suit!";
		cardValue = "Please call the new card method to get card value!";
		
	}
	
	public void newCard() {
		
		/*
		 * Every time this method is invoked, new VALUES WILL BE GIVEN
		 */
		
		/*
		 * VERY IMPORTANT
		 * IF YOU ARE USING MATH.RANDOM, 
		 * YOU NEED PARENTHESIS AROUND IT AND THE CAST
		 */
		
		int randomNumberForSuit = (int)(Math.random() * 4); 
		// there are four suits in total, index starts at 0 - 3
		// SO... 0, 1, 2, 3
		
		int randomNumberForValue = (int)(Math.random() * 13);
		//there are thirteen values in total, index starts at 0 - 12
		
		cardSuit = suit[randomNumberForSuit];
		// random number will be give to the suit index, giving us a value for cardSuit
		
		cardValue = value[randomNumberForValue];
		// random value will be given to cardValue
		
		
	}
	
	
	public String getSpecificCard() {
		cardSuit = suit[0];
		return cardSuit;
	} //this method is a test to see the out of bounds of an array
		//to conclude, random numbers should go up to max value
	
	// Getting the value
	public String getCardSuit() {
		return cardSuit;
	}
	public String getCardValue() {
		return cardValue;
	}
	public String toString() {
		return "Card suit: " + cardSuit + "\n"
				+ "Card value:" + cardValue;
	}
	
	
	
	

}
