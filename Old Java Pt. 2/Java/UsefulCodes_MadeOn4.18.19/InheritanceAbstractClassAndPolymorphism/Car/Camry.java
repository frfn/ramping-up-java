package Car;

public class Camry extends Toyota {

protected String model;
	
	public Camry() {
		super(0, 0);
		
		model = "Camry";
	}
	
	public Camry(double s, double c) {
		super (s, c);
		
		model = "Camry";
	}
	
	public String toString() {
		String str = super.toString();;
		str += " Model: " + model;
		return str;
	}
	
}
