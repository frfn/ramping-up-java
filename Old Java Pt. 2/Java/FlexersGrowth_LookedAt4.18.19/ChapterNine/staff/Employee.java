package staff;

/**
 * 
 * @author Flexer
 *
 *
 * Employee is the class that most classes will inherit from
 *  - Inherits StaffMember
 */

public class Employee extends StaffMember{
	
	/**
	 * Fields
	 *  - ssn and payRate
	 */
	
	protected String ssn;
	protected double payRate;
	
	public Employee(String n, String a, String p, String ssn, double pay) {
		super(n, a, p);
		
		this.ssn = ssn;
		payRate = pay;
		
	}
	
	/**
	 * 
	 * @param hours
	 *  - I wrote this on
	 *   - Gets paid for Employee if no role
	 */
	public void paid(int hours) {
		
		double paid;
		
		paid = payRate * hours;
				
		payRate = paid;
		
	}
	
	public String toString() {
		/**
		 * Using the 'super' key work, followed by . operator
		 *  - super has certain functions as well AND NOT just constructors
		 *  - Concatenating strings to super.toString() 
		 *  	- Staff member toString
		 */
		
		String str = super.toString();
		
		str += "\nPay Rate: " + payRate + "\nSocial Security Number: " + ssn;
		
		return str;
		
	}

	@Override
	/**
	 * An abstract method that needs to be instantiated
	 */
	public double pay() {
		// TODO Auto-generated method stub
		return payRate;
	}

}
