package Car;

public class Honda extends AbstractCar {

	public Honda() {
		super("Honda", 0, 0);
	}
	
	public Honda(double s, double c) {
		super ("Honda", s, c);
	}
	
	public String toString() {
		String str = "";
		str += "-Honda Cars-\n" + super.toString();
		return str;
	}
	
}
