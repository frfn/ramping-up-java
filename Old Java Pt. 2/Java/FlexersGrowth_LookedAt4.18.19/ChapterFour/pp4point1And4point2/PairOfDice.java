package pp4point1And4point2;
import java.util.Random;
public class PairOfDice {
	
	//Creating the Fields
	private int die;
	private int die2;
	private final int maxNum = 6;
	private static Random gen = new Random();

	//Creating constructor, has rollBoth method so it will roll both die's!
	public PairOfDice() {
		rollBoth();
	}
	
	
	//Methods and services that PairOfDice will have!
	public void cheat() {
		die = 1;
		die2 = 1;
	}
	public void rollBoth() {
		die = gen.nextInt(maxNum) + 1;
		die2 = gen.nextInt(maxNum) + 1;
	}
	public void rollDieOne() {
		die = gen.nextInt(maxNum) + 1;
	}
	public void rollDieTwo() {
		die2 = gen.nextInt(maxNum) + 1;
	}
	public int getDieValue() {
		return die;
	}
	public int getDieTwoValue() {
		return die2;
	}
	public int getDieValueOfBoth() {
		return die + die2;
	}
	
	
}
