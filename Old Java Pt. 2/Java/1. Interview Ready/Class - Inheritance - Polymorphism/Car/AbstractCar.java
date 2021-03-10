package Car;
/*
 * Things to take away -
 * 
 * Abstract Classes can not be instantiated, just extended to another 
 * abstract class or to a concrete class.
 * 
 * Three access modifiers:
 * 	- Private   : Only in class can be used
 * 	- Public    : All classes can use (if no access modifier, this is default)
 * 	- Protected : Only in package can be used
 * 
 * 
 */

// Note: abstract
// Note: implements Compare
// Note: implementing MUST include all methods in Class.
// In abstract classes, you do not need to, but when making concrete classes through extends, you MUST!
public abstract class AbstractCar implements Compare {
	
	// Just variables that will be used for this class
	// Note: private
	private String carBrand;
	private double speed, cost;
	
	// Constructor
	public AbstractCar(String carBrand, double speed, double cost) {
		this.carBrand = carBrand;
		this.speed = speed;
		this.cost = cost;
	}
	
	// Note: this(args);
	public AbstractCar() {
		this("No brand", 0, 0);
	}
	
	// Getters
	public String getCarBrand() {
		return carBrand;
	}
	public double getCarSpeed() {
		return speed;
	}
	public double getCarCost() {
		return cost;
	}
	
	// Setters
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public void setCarSpeed(double speed) {
		this.speed = speed;
	}
	public void setCarCost(double cost) {
		this.cost = cost;
	}
	
	// toString 
	// Note: when printed, it will print the string representation of object
	public String toString() {
		// use string builder!
//		String str = "";
//		str += "Brand: " + carBrand;
//		str += "\nCost: " + cost;
//		str += "\nMax Speed: " + speed;
//		return str;
		
		StringBuilder str = new StringBuilder();
		str.append("Brand: " + carBrand);
		str.append("\nCost: " + cost);
		str.append("\nMax Speed: " + speed);
		return str.toString();
	}
	
}
