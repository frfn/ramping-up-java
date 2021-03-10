package PP8_12_ElectronicEquipment_GO_BACK_AND_COMMENT;

public class Pager extends Tech{
	
	private static final double powerUsage = 60;
	private static final double weight = .35;
	private String OS;

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
