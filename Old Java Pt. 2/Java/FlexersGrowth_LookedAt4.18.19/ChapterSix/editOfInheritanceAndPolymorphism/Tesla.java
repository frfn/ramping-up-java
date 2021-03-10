package editOfInheritanceAndPolymorphism;

import java.util.ArrayList;

/**
 * 
 * @author flexer
 * Class extends Car!
 * 
 */

public class Tesla extends Car {
	
	/**
	 * Another constructor class
	 * By setting up the brand name in the field, "Tesla"
	 * that is the objects brand for EVERY object created,
	 * hence the Tesla Class.
	 */
	
	private String brand = "Tesla";
	private String model = "N/A";
	private String feature = "";

	//construction of object,
	//super(horsePower) is the way for inheritance to be used!!
	
	/*
	 * Multiple tests have been conducted:
	 * 
	 * Constructors can be made, but it just needs to use the
	 * Car class constructor somehow!
	 * 
	 * EDIT:
	 * There needs to be a default constructor SO that you can
	 * make multiple constructors without a problem
	 * 
	 * LOOK AT line 43
	 */
	
	public Tesla() {
		super();
	}
	
	public Tesla(String lol, String lollol, String lollollol) {
		/**
		 * Here you can see that in the super class Car
		 * there is NO Tesla(String, String, String) 
		 * constructor but this happily takes it and no error!
		 */
	}
	
	/*
	public Tesla(String model, int horsePower, String feature, String chassis) {
		super(horsePower, chassis);
		
		this.model = model;
		this.feature = feature;
		
	}
	*/
	//Overriding the toString from car class to show all info of Tesla object!!
	public String toString() {
		return "Brand: " + brand + " | Model: " + model + " | Horse Power: " + horsePower +
				"\nFeature: " + feature;
	}
	
	//add feature! USING VARARGS!!!! WTF!!!
	//it utilizes an array like data structure!
	
	//set to void if were NOT RETURNING anything, like getModel() or whatever!
	public void setFeature(String... strings) {
		for(int i=0; i<strings.length; i++) {
			this.feature += strings[i] + ", ";
		}	
	}
	
	public void setFeature(ArrayList<String> newnew) {
		for(int i = 0; i<newnew.size(); i++) {
			this.feature += newnew.get(i) + ", "; 
		}
	}
	
	//Overriding!
	public void polyCheck() {
		System.out.println("This is the Telsa class...");
	}
	

}

