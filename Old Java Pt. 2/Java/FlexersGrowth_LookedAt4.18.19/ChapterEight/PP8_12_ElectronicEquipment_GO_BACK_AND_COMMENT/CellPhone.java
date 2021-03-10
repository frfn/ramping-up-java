package PP8_12_ElectronicEquipment_GO_BACK_AND_COMMENT;

public class CellPhone extends Tech{
	
	private static final double powerUsage = 60;
	private static final double weight = .35;
	private String OS;
	
	public CellPhone(String os, double cost, String brand) {
		super(weight, cost, powerUsage, brand);
		
		OS = os;
	}
	
	public void setOS(String args) {
		OS = args;
	}
	
	public String getOS() {
		return OS;
	}

	@Override
	public double withTax() {
		double withTax;
		withTax = cost * MASS_TAX;
		return withTax;
	}
	
	public String toString() {
		
		String str = super.toString();
		
		str += "\nOperating System: " + OS;
		
		return str;
		
	}

}
