package Car;
import java.util.ArrayList;

// Note: extends Abstract Car
// Note: @Overrides came FROM AbstractCar class FROM the Compare class
public class Honda extends AbstractCar {	
	
	// Note: You MUST put the = new ArrayList<>(); LMAOOO!!
	// Note: Do NOT make into static, DO NOT.
	ArrayList<String> features = new ArrayList<String>();
	
	public Honda(double speed, double cost, String...strings) {
		super("Honda", speed, cost);
		
		// This is sick, adds the strings to features
		for(String string: strings) {
			features.add(string);
		}
		
	}
	
	public void printFeatures() {
		System.out.println(features.toString());
	}
	
	public void deleteFeatures(String...strings) {
		for(String string: strings) {
			if(features.contains(string)) {
				features.remove(string);
			}
			// Redundant
//			else {
//				continue;
//			}
		}
	}
	
	public void addFeatures(String...strings) {
		for(String string: strings) {
			features.add(string);
		}
	}

	// Note: overrides are not needed in this case
	@Override
	public boolean isFaster(Compare object) {
		// Note: instanceof, checks if object is instance of AbstractCar
		if(object instanceof AbstractCar) {
			double otherCarSpeed = ((AbstractCar) object).getCarSpeed();
			if(this.getCarSpeed() > otherCarSpeed) {
				return true;
			}
		}
		else {
			AbstractCar otherCar = (AbstractCar)object;
			double otherCarSpeed = otherCar.getCarSpeed();
			if(this.getCarSpeed() > otherCarSpeed) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isMoreExpensive(Compare object) {
		if(object instanceof AbstractCar) {
			double otherCarPrice = ((AbstractCar) object).getCarCost();
			if(this.getCarCost() > otherCarPrice) {
				return true;
			}
		}
		else {
			AbstractCar otherCar = (AbstractCar)object;
			double otherCarCost = otherCar.getCarCost();
			if(this.getCarCost() > otherCarCost) {
				return true;
			}
		}
		return false;
	}
	
//	// Test
//	public static void main(String[] args) {
//		// Instantiation
//		Honda car = new Honda(160, 1100, "GPS", "Heated Seats", "Tinted");
//		Honda car2 = new Honda(180, 1800, "Sport Mode", "Manual", "Heated Seats");
//		
//		car.printFeatures();
//		car2.printFeatures();
//		
//		// Test representation of Car
//		System.out.println(car);
//		
//		// Method testing
//		car.deleteFeatures("Tinted", "Winter Tires", "GPS");
//		car.printFeatures();
//		
//		car2.addFeatures("Winter Tires", "Turbo", "Mud Gaurd");
//		car2.printFeatures();
//		
//		// Testing Compare, interface
//		System.out.println(car2.isFaster(car));
//		System.out.println(car2.isMoreExpensive(car));
//	}

}
