package chapter5;


public class HotCold {
	
	private int randomNumber;
	
	public HotCold() {
		giveMeRandomNumber();
	}
	
	public int giveMeRandomNumber() {
		randomNumber = (int)(Math.random() * 100);
		return randomNumber;
	}
	
	public int getNumber() {
		return randomNumber;
	}
	
	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}
	
	public String toString() {
		return "The number is: " + randomNumber;
	}

}
