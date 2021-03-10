package Car;

import java.util.ArrayList;

//Note: extends Abstract Car
//Note: @Overrides came FROM AbstractCar class FROM the Compare class
public class Toyota extends AbstractCar {	
	
	// Note: You MUST put the = new ArrayList<>(); LMAOOO!!
	// Note: Do NOT make into static, DO NOT... interesting. I wonder why. lol.
	// I remember now. 
	// If new object is created, then those new objects will ALL have the same features! 
	ArrayList<String> features = new ArrayList<String>();
	
	public Toyota(double speed, double cost, String...strings) {
		super("Toyota", speed, cost);
		
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
		}
	}
	
	public void addFeatures(String...strings) {
		for(String string: strings) {
			features.add(string);
		}
	}

	// Note: overrides are not needed in this case
	@Override
	
	// this is interesting, even right now, 11/14/2019.
	public boolean isFaster(Compare object) {
		// Note: instanceof, checks if object is instance of AbstractCar
		if(object instanceof AbstractCar) {
			double otherCarSpeed = ((AbstractCar) object).getCarSpeed();
			if(this.getCarSpeed() > otherCarSpeed) {
				return true;
			}
		}
		
		// i should just say... Sysout("Not type car")...
		
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
}