package PP2_HospitalEmployee;

/**
 * 
 * @author Flexer
 *
 * Edit: I understand the meaning of abstract classes now
 *  - It is a class that you don't want to instantiate
 *  - Other objects can REFER to it, but itself can not be made!
 *
 */

abstract public class Employee {
	
	private String name, ethnicity, role;
	private int salaryPay, hourlyPay, hoursWorked, hoursPaid;
	
	//default constructor
	public Employee() {
		this("N/A", "N/A");
		System.out.println("Please make Employee...");
	}
	
	/**
	 * Constructor 1
	 * @param name
	 * @param ethnicity
	 * 
	 *  - Just employee with no role yet
	 */
	public Employee(String name, String ethnicity) {
		this.name = name;
		this.ethnicity = ethnicity;
	}
	
	/**
	 * Constructor 2
	 * @param name
	 * @param ethnicity
	 * @param salaryPay
	 * 
	 *  - Employee with salary pay
	 */
	public Employee(String name, String ethnicity, String role, int salaryPay) {
		this.name = name;
		this.ethnicity = ethnicity;
		this.role = role;
		this.salaryPay = salaryPay;
	}
	
	/**
	 * Constructor 3
	 * @param name
	 * @param ethnicity
	 * @param hourlyPay
	 * @param hoursWorked
	 * 
	 *  - Employee with hourly pay and keeps track of hours worked
	 */
	public Employee(String name, String ethnicity, String role, int hourlyPay, int hoursWorked) {
		this.name = name;
		this.ethnicity = ethnicity;
		this.role = role;
		this.hourlyPay = hourlyPay;
		this.hoursWorked = hoursWorked;
	}
	
	public void viewNewEmployee() {
		System.out.println("Name: " + name + 
						   "\nEthnicity: " + ethnicity + "\n");
	}
	
	public void viewEmployeeSalaryInformation() {
		System.out.println("Name: " + name +
						   "\nEthnicity: " + ethnicity + 
						   "\nRole: " + role + 
						   "\nSalary: " + salaryPay + "\n");
	}
	
	public void viewEmployeeHourlyInformation() {
		hoursPaid = hourlyPay*hoursWorked;
		
		System.out.println("Name: " + name +
				   "\nEthnicity: " + ethnicity + 
				   "\nRole: " + role + 
				   "\nHourly Pay: " + hourlyPay + 
				   "\nHours Worked: " + hoursWorked + 
				   "\nPay For Today: " + hoursPaid + "\n");
	}
	
	public void whoAmI() {
		System.out.println("I'm a possible new hire!");
	}
	
	public String toString() {
		return "Error... Use viewEmployeeSalary or viewEmployeeInformation...";
	}

}
