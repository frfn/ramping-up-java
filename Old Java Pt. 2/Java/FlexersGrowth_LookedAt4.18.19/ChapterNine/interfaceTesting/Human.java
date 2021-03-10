package interfaceTesting;

public class Human implements Speaker{

	@Override
	public void speak() {
		System.out.println("I am human");
	}

	@Override
	public void announce(Speaker s) {
		System.out.println(s);
	}
	
	public String toString() {
		return "I am not a dog, thank you.";
	}

}
