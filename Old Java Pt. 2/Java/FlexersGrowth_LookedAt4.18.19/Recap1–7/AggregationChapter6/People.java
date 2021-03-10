package AggregationChapter6;

public class People {
	
	/**
	 * People Constructor
	 * -------------------
	 */
	
	private String name, city, state, age;
	
	/**
	 * Four fields
	 * ------------
	 * 	- name
	 * 	- city
	 * 	- state
	 * 	- age
	 */
	
	//default constructor
	public People() {
		/*
		 * this.name = "No name applicable..."; this.city = "City not specified...";
		 * this.state = "State not specified..."; this.age = "No age...";
		 */
		this("No Name", "No City", "No State", "No Age");
	}
	
	//secondary constructor w/ parameters
	public People(String name, String city, String state, String age) {
		this.name = name;
		this.city = city;
		this.state = state;
		this.age = age;
	}
	
	/**
	 * You can overload the constructor
	 * ---------------------------------
	 * Does not need to be just these two!
	 */
	
	//No getters or setters needed, just testing out and printing!
	
	public String toString() {
		
		String str = "";
		
		str += "Name: " + name + "\nCity: " + city;
		str += "\nState: " + state + "\nAge: " + age;
		
		return str;
		
	}

}
