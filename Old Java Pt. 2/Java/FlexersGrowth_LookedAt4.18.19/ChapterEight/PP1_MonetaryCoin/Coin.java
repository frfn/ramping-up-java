package PP1_MonetaryCoin;

/**
 * 
 * @author Flexer
 * 
 * Coin  constructor
 *  - Has method to "flip"
 *  	- Random number 0 or 1
 *  	- If 0, print head, if 1 print tails
 *  
 *  - isHeads()
 *  	- Returns boolean value true if HEADS
 *  
 *  - toString()
 *  	- Returns string value of "HEADS" or "TAILS"
 *
 */

public class Coin {
	
	private final int HEADS = 0;
	private final int TAILS = 1;
	private int face;
	
	public Coin() {
		flip();
	}
	
	public void flip() {
		face = (int)(Math.random() * 2);
	}
	
	public boolean isHeads() {
		return (face == HEADS);
	}
	
	public String toString() {
		String faceName;
		
		if(face == HEADS) {
			faceName = "Heads";
		}
		else {
			faceName = "Tails";
		}
		
		return faceName;
	}
	
}
