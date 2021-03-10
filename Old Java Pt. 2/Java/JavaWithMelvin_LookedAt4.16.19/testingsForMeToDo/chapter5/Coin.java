package chapter5;

public class Coin {

	private int heads = 1;
	private int tails = 0;
	private int faceValue;
	
	public Coin() {
		
		flipCoin();
		
	}
	
	public void flipCoin() {
		
		faceValue = (int)(Math.random() * 2);		
		
	}
	
	public String faceName() {
		
		if(faceValue == heads) {
			return "Heads";
		}else
			return "Tails";
		
	}
	
	public int getResult() {
		
		if(faceValue == heads) {
			return heads;
		}
		else {
			return tails;
		}

		}
	
	public boolean isHeads() {
		return faceValue == heads;
	}
		
	public boolean isTails() {
		return faceValue == tails;
	}
	
	
	
	
	
}
