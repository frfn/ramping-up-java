package InheritanceChapter6wNewBoston;

public class AnimalList {
	
	/**
	 * Important Documentation is in DogList.
	 * --------
	 * Scroll down for increase() method, so you will never run out of array space!
	 */
	
	private Animal[] animals = new Animal[5];
	private int i = 0;
	
	public void addAnimal(Animal animal) {
		if(i<animals.length) {
			animals[i] = animal;
			System.out.println("Animal added at index " + i);
			i++;
		}
		
		if(i == animals.length) {
			/**
			 * If index is max, increase size.
			 * This is done by copying the current array to a new array with double the index size
			 */
			increase();
		}
		
	}
	
	public String toString() {
		
		String str = "Animal List\n-----------\n";
		
		for(int j=0; j<i; j++) {
			str += animals[j].toString() + "\n\n";
		}
		
		return str;
		
	}
	
	private void increase() {
		/**
		 * Increases size of array:
		 * 	- A temp array that is twice the amount of animal length
		 *  - Initializing the temp array with animal values and respective index
		 *  - animals array is now equals to temp array.
		 */
		Animal[] temp = new Animal[animals.length*2];
		
		for(int i=0; i<animals.length; i++) {
			temp[i] = animals[i];
		}
		
		animals = temp;
	}
	
	

}
