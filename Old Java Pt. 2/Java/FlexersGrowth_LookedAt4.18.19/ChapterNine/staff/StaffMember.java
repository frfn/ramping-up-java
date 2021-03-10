package staff;

/**
 * 
 * @author Flexer
 *
 *
 * Abstract class
 * 	- You cannot instantiate this class
 *  - Purely for blueprinting purposes
 */

public abstract class StaffMember {
	
	/**
	 * Note that these are 'protected' fields
	 *  - Good practice for encapsulation within package scope
	 */

	protected String name, address, phone;
	
	public StaffMember(String n, String a, String p) {
		name = n;
		address = a;
		phone = p;
	}
	
	public String toString() {
		return "Name: " + name + "\nAddress: " + address + 
				"\nPhone: " + phone;
	}
	
	public abstract double pay();
	
}
