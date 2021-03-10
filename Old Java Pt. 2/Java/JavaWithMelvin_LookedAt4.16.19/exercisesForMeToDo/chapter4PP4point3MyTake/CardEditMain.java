package chapter4PP4point3MyTake;

public class CardEditMain {
	
	public static void main(String[] args) {
		
		CardEdit card = new CardEdit();
		
		//System.out.println(card.getSpecificCard() + "\n");
		
		for(int i = 0; i < 5; i++) {
			card.newCard();
			System.out.println(card.getCardValue() + " of "+ card.getCardSuit());
		}
		
	}

}
