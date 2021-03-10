package PP2_HospitalEmployee;

public class Surgeon extends Employee {
	
	private final static int BASE_SALARY = 200000;
	
	public Surgeon() {
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
	
	public Surgeon(String n, String e) {
		super(n, e, "Surgeon", BASE_SALARY);
	}
	
	public Surgeon(String n, String e, int s) {
		super(n, e, "Surgeon", s);
	}
	
	public void whoAmI() {
		System.out.println("I'm a Surgeon!");
	}


}
