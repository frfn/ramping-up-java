package PP1_MonetaryCoin;

public class MonetaryCoin extends Coin {
	
	private int value;

	public MonetaryCoin() {
		value = 10;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
