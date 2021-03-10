package PP5_DemographicInformationCOULDHAVEHADBETTERAPPROACHBUTCOMPLETED;

public class Income extends Data {
	
	private double income;
	
	public Income(double income) {
		this.income = income;
	}
	
	public Income(String name, int income) {
		super(name);
		
		this.income = income;
	}
	
	public double getIncome() {
		return income;
	}

	public String toString() {
		
		String str = "";
		
		str += "\nName: " + name + " | Income: " + income;
		
		return str;
		
	}
}
