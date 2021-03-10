package InheritanceChapter6wNewBoston;

public class Main {
	
	/**
	 * Great examples here:
	 *  - New view of exceptions, NullPointerException
	 *  - Utilizing inheritance and polymorphism
	 */
	
	public static void main(String[] args) {
		
		/**
		 * Testing out the objects:
		 * 	- Giving them parameters and values
		 *  - Printing them out, seeing if toString() works
		 */
		
		Animal animal = new Animal();
		System.out.println(animal);
		animal.makeNoise();
		
		System.out.println(); //SPACER
		
		Dog oscar = new Dog("Oscar", "BARK", 4, "White", "Pug");
		System.out.println(oscar);

		System.out.println(); //SPACER

		Cat lucy = new Cat("Lucy", "MEOW", 4, "White", "Furry");
		System.out.println(lucy);
		
		System.out.println(); //SPACER
		
		/////////////////////////////////////////////////////////////
		
		/**
		 * Testing out the DogList and AnimalList
		 *  - Adding elements into the list
		 *  - DogList will have their own toString() to view the contents inside the list
		 */
		
		//test dogs
		Dog maru = new Dog("Maru", "What are you doing!?", 2, "Tan");
		Dog cam  = new Dog("Cam" , "Yo! Ball!?", 2, "White");
		
		//Dog List
		DogList dogList = new DogList(); //initialized a dog list
		
		//adding dogs to the list
		dogList.addDog(oscar);
		dogList.addDog(maru);
		dogList.addDog(cam);
		
		System.out.println(); //SPACER
		
		System.out.println(dogList); //Printing Dog List
		System.out.println("End of Dog List");
		System.out.println();
		
		//Animal List
		AnimalList animalList = new AnimalList();
		
		animalList.addAnimal(lucy);
		animalList.addAnimal(oscar);
		
		System.out.println(); //SPACER
		
		System.out.println(animalList);
		System.out.println("End of Animal List");
		
		/////////////////////////////////////////////////////////////
		
		/**
		 * Testing out Polymorphism
		 * 	- Objects all fall under Animal class – inheritance
		 *  - A simple test that uses polymorphism, prints out makeNoise()
		 *  - Why is Polymorphism?
		 *  	- the object is type Animal, though one is Dog and one is Cat
		 *  	- It embodies different types of Objects, is done through inheritance
		 */
		
		Animal[] list = new Animal[5];
		
		list[0] = lucy; //cat
		list[1] = maru; //dog
		
		list[2] = new Cat("Nicole", "Flex!", 2, "Beautiful");
		list[3] = new Dog("Flexer", "Cole!", 2, "Handsome");
		
		/**
		 * IMPORTANT DOCUMENTATION BELOW:
		 * 	- Teaches the lesson of NullPointerException
		 */
		
		//if you run this you will get a NullPointerException, A RUNTIME ERROR
		//because the array size is 5, you only used 2 spaces, 
		//there are 3 null values, hence a NullPointerException
		
		for(int i = 0; i < 2; i++) {
			list[i].makeNoise();
		}
		
		//for(Animal noise: list) {
		//	noise.makeNoise();
		//}
		
		System.out.println("\n\n");
		
		/**
		 * An experimentation:
		 * 	- The creation of the object, Dog/Cat, will determine what method will be used.
		 *  - In this case, makeNoise() method, it calls from their OWN class,
		 *    it will print THEIR OWN makeNoise() method. Which is different.
		 *  - Overriding is the concept being used.
		 *  	- Animal class has it's own makeNoise() method, 
		 *  	  but is being overridden with Dog/Cat's own makeNoise() method.
		 *  	- You can see below, that when barkBark() method is called for testingD,
		 *  	  it will not work. 
		 *  
		 *        It is undefined for type Animal, but defined in type Dog
		 */
	
		Dog testingB = new Dog();
		Animal testingD = new Dog();
		Animal testingC = new Cat();
		
		System.out.println("Testing out: ");
		
		testingB.barkBark();
		//testingD.barkBark();
		testingD.makeNoise();
		
		testingC.makeNoise();
		
	}

}
