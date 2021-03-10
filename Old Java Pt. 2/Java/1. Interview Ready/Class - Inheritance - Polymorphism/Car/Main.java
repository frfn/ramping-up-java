package Car;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<AbstractCar> list = new ArrayList<AbstractCar>();
		
		
		Honda genericCar = new Honda(120, 4000, "GPS", "Leather Seats", "Heated Seats");
		
		// Polymorphism!
		// Note: This is probably basic shit, this is possible because Si extends Honda... meaning it is type of Honda... means their same type.
		Honda modelSi = new Si(150, 5000, "Turbo", "GPS", "Sports");
		
		
		Toyota genCar = new Toyota(110, 4500, "Premium Package");
		
		Toyota camry = new Camry(130, 3500, "Camry Basic Package");
		
		list.add(genericCar);
		list.add(genCar);
		list.add(modelSi);
		list.add(camry);
		
		for(AbstractCar car: list) {
			System.out.println(car);
			if(car instanceof Toyota) {
				((Toyota) car).printFeatures();
			}
			if(car instanceof Honda) {
				((Honda) car).printFeatures();
			}
			
			System.out.println();
		}
		
		//System.out.println("Cars: \n" + list.toString());
		
//		Object[] carArray = list.toArray();
//		for(Object car: carArray) {
//			System.out.println(car);
//		}
		
		
//		// Test
//		System.out.println(genericCar);
//		System.out.println();
//		System.out.println(modelSi);
	
	}

}
