package InheritanceChapter6wNewBoston;

public class Dog extends Animal {
	
	/**
	 * Slowly understanding the concept of inheritance.
	 */
	
	public Dog() {
		super(); //
		/**
		 * By calling super, this super imposes the super class ANIMAL's default constructor!
		 * this("No Animal", "No noise", 0, "No features");
		 */
	}
	
	public Dog(String name, String noise, int legs, String...strings) {
		super(name, noise, legs, strings);
		/**
		 * By calling super w/ variables inside, this imposes the constructor that contains these arguments!
		 */
	}
	
	/**
	 * Only Dog dog = new Dog();
	 * 		can call barkBark
	 * 
	 * if done with Animal dog = new Dog();
	 * 		will NOT work, Animal does not have barkBark, Dog class does
	 */
	public void barkBark() {
		System.out.println("I'm a dog!");
	}
	
	public void makeNoise() {
		System.out.println("Bark! Bark!");
		/**
		 * Polymorphism example!
		 */
	}
	
}
