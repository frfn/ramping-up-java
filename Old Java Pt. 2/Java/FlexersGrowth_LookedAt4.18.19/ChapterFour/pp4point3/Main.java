package pp4point3;

public class Main {

	public static void main(String[] args) {
		
		Card card = new Card();
		
		for(int i=0; i<=5; i++) {
		
		card.getNewCard();
		
		System.out.println(card.toString());
		}
		
	}
	
}
