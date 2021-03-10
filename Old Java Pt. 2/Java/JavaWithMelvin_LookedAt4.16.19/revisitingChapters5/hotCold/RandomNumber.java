package hotCold;
import java.util.Random;

public class RandomNumber {
	
	Random generator = new Random();
	private int randomNumber = 0;
	
	public RandomNumber() {
		random();
	}
	
	public void random() {
		randomNumber = generator.nextInt(100) + 1;
								//0-99, adding +1 will
								//increase it from 1-100;
	}
	
	public int getNumber() {
		return randomNumber;
	}
	
	public String toString() {
		return "Your number is: " + randomNumber;
	}

}
