package Car;

public class Si extends Honda {

	protected String model;
	
	public Si() {
		super(0, 0);
		
		model = "Si";
	}
	
	public Si(double s, double c) {
		super (s, c);
		
		model = "Si";
	}
	
	public String toString() {
		String str = super.toString();;
		str += " Model: " + model;
		return str;
	}
	
}
