package ArrayList_Ex1_Fundamentals;

/**
 * 
 * @author Flexer
 *
 * @param <X>
 * 
 * This is a strict Array data structure where the array can be added
 * in relation to the -- length value --
 * 
 * This is so that it has a structure rather than being an original array. :)
 * 
 * Sweet.
 * 
 * There will be special cases like adding or deleting at the beginning (index 0) --
 * 
 * It is similar to prepending, or deleting something in front when compared to a linked list!
 * 
 */

public class ArrayList<X> {
	
	X[] arr; // size of array
	int length; // number of elements inside of the array
	
	public ArrayList() {
		arr = (X[])new Object[10];
		length = 0;
	}
	
	public ArrayList(int size) {
		arr = (X[])new Object[size];
		length = 0;
	}
	
	public void increaseSize() {
		X[] temp = (X[])new Object[arr.length * 2];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}
	
	public void add(X data) {
		if(arr.length == length) {
			increaseSize();
		}
		arr[length++] = data;
	}
	
	public void addAtIndex(X data, int index) {
		
		/**
		 * If spot is empty, then the length will be that index (for printing purposes)
		 * - if index does not exist yet because the arr.length is not big enough, error. :)
		 * 
		 * Ex. index = 13, when arr.length is originally length of 10, outOfBoundsException
		 */
		if(index > arr.length || index < 0) {
			System.out.println("Invalid index...");
		}
		
		if(arr[index] == null) {
			length = index;
			arr[index] = data;
			length++;
		}
		else {
			for(int i = length+1; i >= index; i--) {
				arr[i] = arr[i+1];
			}
			arr[index] = data;
			++length;
		}
	}
	
	public X deleteAtIndex(int index) {
		
		// return the value at this index!
		X data = arr[index];
		
		for(int i = index; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		length--;
		return data;
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		for(int i = 0; i < length; i++) {
			build.append("Index: " + i + " - " + arr[i] + "\n");
		}
		return build.toString();
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> stringArray = new ArrayList<>();
		
		stringArray.add("Hello");
		stringArray.add(" ");
		stringArray.add("World");
		stringArray.add("1");
		stringArray.add("2");
		stringArray.add("3");
		stringArray.add("4");
		
		System.out.println(stringArray.toString());
		
		stringArray.addAtIndex("5", 4);
		
		
	}

}
