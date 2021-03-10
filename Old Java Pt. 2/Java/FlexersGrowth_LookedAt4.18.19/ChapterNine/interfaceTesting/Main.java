package interfaceTesting;

public class Main {
	
	public static void main(String[] args) {
		
		Speaker dog = new Dog();
		Speaker human = new Human();
		
		
		System.out.print("Dog goes: "); dog.speak();
	
		System.out.println();
		
		System.out.print("Human goes: "); human.speak();
		
		System.out.println();
		
		dog.announce(human);
		
		human.announce(dog);
		
		String phrase = "hello there!";
		
		if(phrase =="hello there!") {
			System.out.println("It's the same!");
		}
		else {
			System.out.println("It's not.");
		}
		
	}

}
