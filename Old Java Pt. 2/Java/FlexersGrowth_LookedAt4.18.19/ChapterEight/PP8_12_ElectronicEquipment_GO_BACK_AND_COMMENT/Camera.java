package PP8_12_ElectronicEquipment_GO_BACK_AND_COMMENT;

public class Camera extends Tech{
	
	private static final double powerUsage = 70;
	private static final double weight = .55;
	private String qualityOfPicture;
	
	public Camera(String qop, double cost, String b) {
		super(weight, cost, powerUsage, b);
		
		qualityOfPicture = qop;
	}
	
	public String getQuality() {
		return qualityOfPicture;
	}
	
	public void upgradeQuality(int args) {
		
		switch(args) {
		case 0: System.out.println("Quality not changed...");
		break;
		
		case 1: qualityOfPicture = "480p";
		break;
		
		case 2: qualityOfPicture = "720p";
		break;
		
		case 3: qualityOfPicture = "1080p";
		break;
		
		case 4: qualityOfPicture = "4K";
		break;
			
		default: System.out.println("Quality not changed...");
		}
		
	}

	@Override
	public double withTax() {
		double withTax;
		withTax = cost * MASS_TAX;
		return withTax;
	}
	
	public String toString() {
		
		String str = super.toString();
		
		str += "\nPicture Quality: " + qualityOfPicture;
		
		return str;
		
	}


}
