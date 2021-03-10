package editOfInheritanceAndPolymorphism;

/**
 * 
 * @author flexer
 * 
 * This is the first class I have made,
 * this served as the SUPERCLASS, this is just a Car class
 * with horsePower!
 *
 */

public class Car {

	private static final int TIRE_COUNT = 4;
	protected int horsePower;
	protected String chassis;
	
	/**
	 * PROTECTED:
	 * @param horse
	 * 
	 * This has package scope!! So you can use it in other classes in the package!!
	 */
	
	
	//Constructor
	public Car(int horse, String chassis) {
		horsePower = horse;
		this.chassis = chassis;
	}
	
	public Car() {
		this(1000, "No chassis");
	}
	
	
	public int getHorsePower() {
		return horsePower;
	}
	public int getWheelCount() {
		return TIRE_COUNT;
	}
	
	//things that are possible to change
	public void setHorsePower(int horse) {
		horsePower = horse;
	}
	
	//testing polymorphism, see in main, overriding this in other class!!
	public void polyCheck() {
		System.out.println("This is the Car class...");
	}
	
	//EDIT for use of Polymorphism
	
	public void setFeature(String... feature) {
		System.out.println("Polymorphism check!" + feature[0]);
	}
	
	//toString method!!
	public String toString() {
		return "HorsePower: "+horsePower;
	}
	
	
}
