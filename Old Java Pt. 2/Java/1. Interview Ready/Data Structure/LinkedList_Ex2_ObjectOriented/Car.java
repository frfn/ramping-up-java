package LinkedList_Ex2_ObjectOriented;

public class Car {
	
	private String carBrand;
	private double carPrice;
	
	public Car(String carBrand, double carPrice) {
		this.carBrand = carBrand;
		this.carPrice = carPrice;
	}
	
	public String toString() {
		String str = "";
		str += "Car Brand: " + carBrand +
			   "\nCar Price: " + carPrice;
		return str;
	}

}
