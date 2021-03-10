package PP8_12_ElectronicEquipment_GO_BACK_AND_COMMENT;

public class Computer extends Tech{
	
	private static final double powerUsage = 120;
	private static final double weight = 3.7;
	private int ram;

	public Computer(int ram, double cost, String brand) {
		super(weight, cost, powerUsage, brand);
		
		this.ram = ram;
	}
	
	public void setRAM(int args) {
		if(args % 8 == 0) {
			ram = args;
		}
		else {
			System.out.println("RAM not changed...");
		}
	}
	
	public int getRAM() {
		return ram;
	}
	
	@Override
	public double withTax() {
		double withTax;
		withTax = cost * MASS_TAX;
		return withTax;
	}
	
	public String toString() {
		
		String str = super.toString();
		
		str += "\nRAM: " + ram;
		
		return str;
		
	}

}
