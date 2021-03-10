package InheritanceChapter6wNewBoston;

public class DogList {
	
	/**
	 * The Dog List
	 * ---------------
	 * This class holds many dog objects.
	 * Uses an array and stores the object inside the array.
	 */

	private Dog[] dogs = new Dog[5];
	private int i = 0;
	
	/**
	 * Two fields:
	 * 	- dogs array
	 *  - i, counter
	 */
	
	public int length() {
		return dogs.length;
		/**
		 * returning the length of DogList by returning dogs.length which is 5.
		 */
	}
	
	public void addDog(Dog dog) {
		if(i<dogs.length) {
			dogs[i] = dog;
			System.out.println("Animal added at index " + i);
			i++;
		}
		/**
		 * addDog method:
		 * 	- if statement whether the array is filled, if not, add dog
		 *  - Prints out what index the animal is at
		 *  - i++, increases the index
		 */
	}

	
	public String toString() {
		
		String str = "Dog List\n-----------\n";
		
		
		for(int j=0; j<i; j++) {
			str += dogs[j].toString() + "\n\n";
		}
		
		/**
		 * Be detail oriented. 
		 * I messed up and put dog[i].toString INSTEAD of dog[j]
		 *  - It gave NullPointerException because there were null values
		 *  - It gave no output because it starts at the latest index, no value
		 *  - Just be detail oriented.
		 */
		
		return str;
	}
	
	
}
