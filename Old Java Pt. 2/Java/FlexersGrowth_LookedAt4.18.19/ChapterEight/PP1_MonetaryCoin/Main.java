package PP1_MonetaryCoin;

public class Main {

	public static void main(String[] args) {
		
		Coin coin = new Coin();
		
		MonetaryCoin newCoin = new MonetaryCoin();
		/**
		 * MonetaryCoin inherits all the superclass, Coin
		 *  - The service that coin has
		 *  - it's methods
		 *  - MonetaryCoin is a little more specific
		 *  	- Has a value of 10
		 */
		
		newCoin.flip(); //method void, either one or zero
		/**
		 * Basically it's just printing a fucking string.
		 * flip() method, at the end of it really, it's a string
		 * toString() prints head or tails.
		 */
		int v = newCoin.getValue();
		
		System.out.println(newCoin); //<-- PRINTS OBJECT, if 0-heads, if 1-tails
		System.out.println(v);
		
		
		
		
		/*
		coin.flip();
		
		System.out.println(coin);
		
		if(coin.isHeads()) {
			System.out.println("You win");
		}
		else {
			System.out.println("You lost");
		}
		*/
	}
	
}
