package Car;

abstract public class AbstractCar implements Compare {

	protected String carBrand;
	protected double speed, cost;
	
	public AbstractCar() {
		this("N/A", 0 , 0);
	}
	
	public AbstractCar(String cb, double s, double c) {
		carBrand = cb;
		speed = s;
		cost = c;
	}
	
	//Getters
	public String getBrand() {
		return carBrand;
	}
	public double getSpeed() {
		return speed;
	}
	public double getCost() {
		return cost;
	}
	
	public void startUp() {
		System.out.println("Vroom!");
	}
	
	public String toString() {
		String str = "";
		str += "Brand: " + carBrand +
			   " Speed: " + speed +
			   " Cost: " + cost;
		return str;
	}
	
	//implemented from Compare class
	public boolean isFaster(Compare o) {
		AbstractCar other = (AbstractCar)o;
		if(this.getSpeed() > other.getSpeed()) return true;
		else return false;
	}
	
	@Override
	public boolean isMoreExpensive(Compare o) {
		AbstractCar other = (AbstractCar)o;
		if(this.getCost() > other.getCost()) return true;
		else return false;
		
	}

	@Override
	public double difference(Compare o) {
		double result;
		AbstractCar other = (AbstractCar)o;
		result = this.getCost() - other.getCost();
		return result;
	}

}
