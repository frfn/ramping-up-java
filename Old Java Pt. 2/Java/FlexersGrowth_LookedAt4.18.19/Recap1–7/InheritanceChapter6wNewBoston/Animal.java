package InheritanceChapter6wNewBoston;

public class Animal {
	
	
	
	protected String name, noise;
	protected int legs;
	protected String[] features;
	
	/**
	 * Four fields:
	 * 	- name
	 * 	- noise
	 * 	- legs
	 *  - features (an array)
	 */
	
	//default constructor
	public Animal() {
		
		this("No Animal", "No noise", 0, "No features");
		
		//Using made constructor
		
		/**
		 * "this" key word refers to the constructor method
		 */
		
		
	    /***
		 * This is one way of giving them value to print... NOT THE SMARTEST WAY
		 
			features = new String[1];
		
			noise = name = "N/A";
			legs = 0;
			features[0] = "N/A";
		 *
		 **/
	}
	
	//constructor w/ parameters
	public Animal(String name, String noise, int legs, String...strings) {
		this.name = name;
		this.noise = noise;
		this.legs = legs;
		this.features = strings;
	}
	
	
	//Example use of Polymorphism
	public void makeNoise() {
		System.out.println("Animal Default Noise");
	}
	
	//Outputting results
	public String toString() {
		
		String viewFeatures = "";
		
		for(int i = 0; i<features.length; i++) {
			viewFeatures += features[i] + ", ";
		}
		
		return "Name: " + name + "\nNoise: " + noise +
				"\nLegs: " + legs + "\nFeatures: " + viewFeatures;
 	}

}
