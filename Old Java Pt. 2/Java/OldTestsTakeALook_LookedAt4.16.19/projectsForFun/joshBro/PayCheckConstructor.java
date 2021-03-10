package joshBro;

public class PayCheckConstructor {
	
	private String name;
	private float wage;
	private float hours;
	
	public PayCheckConstructor(String name, float wage, float hours) {
		
		this.name = name;
		this.wage = wage;
		this.hours = hours;
		
	}
	
	
	//setters
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setWage(float wage) {
		
		this.wage = wage;
		
	}
	
	public void setHours(float hours) {
		
		this.hours = hours;
		
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public float getWage() {
		return wage;
	}
	
	public float getHours() {
		return hours;
	}

}
