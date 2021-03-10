package AggregationChapter6;

public class Main {
	
	public static void main(String[] args) {
		
		People flexer = new People("Flexer Fadrigalan", "Boston", "MA", "22");
		
		Car flexersCar = new Car(flexer, "Si", "Honda", 
				"NAV", "Anti-Theft", "Alarm", "Tinted Windows");
		
		System.out.println(flexersCar);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		/**
		 * Testing out the default cases.
		 */
		
		People person = new People();
		//Car personsCar = new Car(person, "Type-R", "Honda", "Sports Package", "NAV");
		Car personsCar = new Car();
		
		//System.out.println(person);
		System.out.println(personsCar);
		
		
	}

}
