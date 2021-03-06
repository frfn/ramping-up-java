package PP2_HospitalEmployee;

public class Doctor extends Employee {
	
	private final static int BASE_SALARY = 150000;
	
	public Doctor() {
		super();
		/**
		 * This will print "Please make Employee..."
		 */ 
	}
	
	public Doctor(Patient p) {
		System.out.println("Hi " + p.name + "!");
	}
	
	/**
	 * 
	 * @param n - name
	 * @param e - ethnicity
	 * @param r - role
	 * @param s - salary
	 */
	
	public String changePatientName(Patient p, String name) {
		
		p.name = name;
		
		return p.name;
	}
	
	public Doctor(String n, String e) {
		super(n, e, "Doctor", BASE_SALARY);
	}
	
	public Doctor(String n, String e, int s) {
		super(n, e, "Doctor", s);
	}
	
	public void whoAmI() {
		System.out.println("I'm a Doctor!");
	}
	
	public void sayHiToPatient() {
		System.out.println("Hi!");
	}
	

}
