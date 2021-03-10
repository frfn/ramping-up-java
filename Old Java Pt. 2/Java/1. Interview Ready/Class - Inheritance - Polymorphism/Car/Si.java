package Car;

public class Si extends Honda {
	
	// Note: Only variable
	// By putting this, it adds the SI model
	private String model = "Si";
	
	// Note: It uses super();
	// Constructor
	public Si(double speed, double cost, String...strings) {
		super(speed, cost, strings);
	}
	
	
	// Note: overrides the parent toString()
	public String toString() {
		// Use STRINGBUILDER!
		//String str = "";
		//str += "Model: " + this.model;
//		str += "\nBrand: " + this.getCarBrand();
//		str += "\nCost: " + this.getCarCost();
//		str += "\nMax Speed: " + this.getCarSpeed();
		//str += "\n" + super.toString();
		
		StringBuilder str = new StringBuilder();
		str.append("Model: " + this.model);
		str.append("\n" + super.toString());
		return str.toString();
	}
//	
//	// Test
//	public static void main(String[] args) {
//		
//		Honda car = new Honda(150, 2300, "Sport", "Turbo");
//		Si modelOne = new Si(230, 6000, "Turbo", "Nitro", "Sport");
//		
//		System.out.println(car);
//		
//		System.out.println();
//		
//		System.out.println(modelOne);
//		
//	}
}
