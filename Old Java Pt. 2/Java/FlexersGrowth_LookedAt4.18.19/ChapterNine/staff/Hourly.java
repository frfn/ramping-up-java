package staff;

public class Hourly extends Employee {
	
	private int hoursWorked;
	
	public Hourly(String n, String a, String p, String ssn, double pay) {
		super(n, a, p, ssn, pay);
		
		hoursWorked = 0;
	}
	
	public void addHours(int hours) {
		hoursWorked += hours;
	}
	
	public double pay() {
		double payment = hoursWorked * payRate;
		hoursWorked = 0;
		return payment;
	}
	
	public String toString() {
		String str = super.toString();
		
		str += "\nHours Worked: " + hoursWorked;
		
		return str;
	}

}
