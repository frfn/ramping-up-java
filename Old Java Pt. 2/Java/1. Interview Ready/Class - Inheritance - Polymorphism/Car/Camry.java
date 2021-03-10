package Car;

public class Camry extends Toyota {
	
	private String model = "Camry";
	
	public Camry(double speed, double cost, String...strings) {
		super(speed, cost, strings);
	}
	
	// Note: overrides the parent toString()
	public String toString() {
		// use StringBuilder or just use the super.toString()
		String str = "";
		str += "Model: " + this.model;
		str += "\n" + super.toString();
		return str;
	}

}
