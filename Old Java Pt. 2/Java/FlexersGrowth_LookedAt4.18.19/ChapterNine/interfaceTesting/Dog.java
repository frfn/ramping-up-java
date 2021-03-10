package interfaceTesting;

public class Dog implements Speaker {

	@Override
	public void speak() {
		System.out.println("Bark! Bark!");
		
	}

	@Override
	public void announce(Speaker s) {
		System.out.println(s);
	}
	
	public String toString() {
		return "Bark!!!";
	}
	
}
