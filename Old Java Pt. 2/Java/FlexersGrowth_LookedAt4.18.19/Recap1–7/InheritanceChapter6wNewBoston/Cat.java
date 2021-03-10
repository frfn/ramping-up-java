package InheritanceChapter6wNewBoston;

public class Cat extends Animal{
	
	/**
	 * Important documentation in Dog class.
	 * This class is test class that uses cat as another class for object creation.
	 */

	public Cat() {
		super();
	}
	
	public Cat(String name, String noise, int legs, String...strings) {
		super(name, noise, legs, strings);
	}
	
	public void makeNoise() {
		System.out.println("Meow! Meow!");
	}

	
	//overriding example
	/*
	public String toString() {
		return "Cat: " + name ;
	}
	*/
}
