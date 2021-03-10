package AggregationChapter6;

public class Car {
	
	/**
	 * Car Constructor
	 * ----------------
	 * The car of people, what kind of car they own.
	 * Will have default constructor and secondary
	 * 	- default: no car
	 * 	- secondary: specified info of car
	 * 	- 
	 */
	
	private People owner;
	private String carModel, carBrand;
	private String[] features; //practicing using varying parameters
	
	//default constructor
	public Car() {
		
		String[] defaultFeature = {"No feature"};
		
		owner = new People();
		this.carModel = "No car...";
		this.carBrand = "N/A";
		this.features = defaultFeature;
	}
	
	public Car(People owner, String carModel, String carBrand, String... features) {
		this.owner = owner;
		this.carModel = carModel;
		this.carBrand = carBrand;
		this.features = features;
	}
	
	public String toString() {
		
		String viewFeatures = "";
		
		for(int i = 0; i < features.length; i++) {
			viewFeatures += features[i] + ", ";
		}
		
		return "-- Owner --\n" + owner + "\nCar Model: " + carModel 
				+ "\nCar Brand: " + carBrand + "\nCar Features: " + viewFeatures; 
		
	}
	
	
	
	

}
