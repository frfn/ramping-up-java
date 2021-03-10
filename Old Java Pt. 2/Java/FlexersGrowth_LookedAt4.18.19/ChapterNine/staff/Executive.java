package staff;

public class Executive extends Employee {
	
	private double bonus;
	
	public Executive(String n, String a, String p, String ssn, double pay) {
		super(n, a, p, ssn, pay);
		
		bonus = 0;
		
	}
	
	public void addBonus(double bonus) {
		this.bonus = bonus;
	}

	public double pay() {
		double payment = super.pay() + bonus;
		
		bonus = 0; //initializing bonus to 0
		
		return payment;
	}
	
}
