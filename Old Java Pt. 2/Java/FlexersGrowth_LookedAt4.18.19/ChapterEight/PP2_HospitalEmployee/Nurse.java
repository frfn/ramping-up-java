package PP2_HospitalEmployee;

public class Nurse extends Employee {
	
	/**
	 * Nurses are hourly paid
	 */
	
	private final static int HOURLY_PAY = 13;
	
	public Nurse() {
		super();
		/**
		 * This will print "Please make Employee..."
		 */
	}
	
	/**
	 * 
	 * @param n - name
	 * @param e - ethnicity
	 * @param r - role
	 * @param s - salary
	 */
	
	public Nurse(String n, String e) {
		super(n, e, "Nurse", 0, 0);
	}
	
	public Nurse(String n, String e, int hw) {
		super(n, e, "Nurse", HOURLY_PAY, hw);
	}
	
	public void whoAmI() {
		System.out.println("I'm a Nurse!");
	}
	
}
