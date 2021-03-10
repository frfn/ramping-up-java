package editOfInheritanceAndPolymorphism;

import java.util.ArrayList;

public class CarMain {
	
	public static void main(String[] args) {
		
		
		
		Car car1 = new Car(200, "Steel");
		System.out.println(car1);
		car1.polyCheck();
		System.out.println(car1.getHorsePower());
		
		System.out.println();
		
		//Since you extend, this is the practice of POLYMORPHISM.
		
		
		//Tesla car2 = new Tesla("3", 450, "Electric Car", "Aluminum");
		Tesla car2 = new Tesla();
		ArrayList<String> newnew = new ArrayList<String>();
		
		newnew.add("Hello");
		newnew.add("Hi");
		newnew.add("Hey");
		
		String[] features = {"lol", "lol more"};
		
		//car2.setFeature(newnew);
		car2.setFeature("Navigation Package", "Heated Seats", "Sports Edition",
					"Heated Steering Wheel", "Coupe");
		
		
		
		//This is RUNNING the Tesla setFeature, IT OVERRIDES IT!!!! WTFFF!FFFFFF!! I Get it!
		
		//("Navigation Package", "Heated Seats", "Sports Edition",
		//		"Heated Steering Wheel", "Coupe")
		System.out.println(car2);
		car2.polyCheck();
		
		car2.setHorsePower(600);
		
		System.out.println();
		
		System.out.println("Increasing horse power...");
		
		//System.out.println(car2.getHorsePower());
		
		System.out.println(car2);
		
		System.out.println(newnew.get(2));
		
	}
}
