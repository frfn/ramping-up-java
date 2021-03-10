package Car;

public class Toyota extends AbstractCar {

	public Toyota() {
		super("Toyota", 0, 0);
	}
	
	public Toyota(double s, double c) {
		super ("Toyota", s, c);
	}
	
	public String toString() {
		String str = "";
		str += "-Toyota Cars-\n" + super.toString();
		return str;
	}
	
}
