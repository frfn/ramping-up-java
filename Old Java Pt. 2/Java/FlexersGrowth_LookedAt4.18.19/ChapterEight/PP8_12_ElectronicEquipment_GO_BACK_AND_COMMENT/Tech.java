package PP8_12_ElectronicEquipment_GO_BACK_AND_COMMENT;

/**
 * 
 * @author Flexer
 *
 */

/**
 * Abstract class
 *  - I do NOT want this class to be instantiated, but classes should inherit from here!
 */
abstract public class Tech implements ComparePrice {
	
	/**
	 * Fields 
	 * 	- Weight
	 *  - Cost
	 *  - Power Usage
	 *  - Names of Manufacturer
	 */
	
	protected double weight, cost, powerUsage;
	protected String brand;
	protected final double MASS_TAX = 1.0625;
	
	/**
	 * Default Constructor 
	 *  - Tech() { }
	 *  
	 * Constructor
	 *  - Tech(...parameters...) { } 
	 */
	
	public Tech() {
		this(0, 0, 0, "N/A");
	}
	
	public Tech(double weight, double cost, double powerUsage, String brand) {
		this.weight = weight;
		this.cost = cost;
		this.powerUsage = powerUsage;
		this.brand = brand;
	}
	
	public String toString() {
		return "Weight: " + weight + "\nCost: $" + cost + 
				"\nPower Usage: " + powerUsage + "\nBrand: " + brand;
	}

	public double getCost() {
		return cost;
	}
	
	public boolean isMoreExpensive(ComparePrice args) {
		
		Tech otherTech = (Tech)args;
		
		if(this.getCost() > otherTech.getCost()) {
			return true;
		}
		else if(this.getCost() == otherTech.getCost()) {
			return false;
		}
		else {
			return false;
		}
	}
	
	public double difference(ComparePrice args) {
		
		double difference;
		
		Tech otherTech = (Tech)args;
		
		difference = this.getCost() - otherTech.getCost();
		
		return difference;
	}
	
	abstract public double withTax();

	/*
	 *  Code is logically sound, just wrong use of it! 
	 *  
	public double totalPrice(ComparePrice... args) {
		
		double totalPrice = 0;
		Tech[] techArray = new Tech[args.length];
		
		techArray = (Tech[]) args;

		for(int i = 0; i < techArray.length; i++) {
			totalPrice += techArray[i].getCost();
		}
		
		return totalPrice;
	}
	*/
}
