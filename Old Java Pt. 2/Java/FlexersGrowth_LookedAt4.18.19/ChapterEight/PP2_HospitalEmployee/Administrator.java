package PP2_HospitalEmployee;

public class Administrator extends Employee {
	
	private final static int BASE_SALARY = 80000;
	
	public Administrator() {
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
	
	public Administrator(String n, String e) {
		super(n, e, "Administrator", BASE_SALARY);
	}
	
	public Administrator(String n, String e, int s) {
		super(n, e, "Administrator", s);
	}
	
	public void whoAmI() {
		System.out.println("I'm a Administrator!");
	}

}
