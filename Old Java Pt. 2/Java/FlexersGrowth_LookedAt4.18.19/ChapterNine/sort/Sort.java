package sort;

/**
 * 
 * @author Flexer
 * 
 * To run these, create a driver class and fill with objects.
 * Comparable is a raw type and will do any objects!!
 *
 */

public class Sort {

	public static void selectionSort(Comparable[] list) {
		
		int min; 
		Comparable temp;
		
		/**
		 * Outer for loop
		 * 	- Scans through through the index of the array from 0, 1, 2 ...
		 */
		
		for (int i = 0; i < list.length; i++) { 
			
			min = i;  // setting min variable to current index, so 0
			
			/**
			 * Inner for loop
			 *  - Will compare value from out loop with the rest of the
			 *    values in array
			 *  - 
			 */
			
			for(int j = i; j < list.length; j++) {  // iterating through all the other objects
				
				/**
				 * If value is less than 0, dealing with objects
				 *  - min = j
				 */
				
				
				/**
				 * Lets say list[min] has "F" @ index 0
				 * 
				 * and
				 * 
				 * lets say list[j] has "A" @ index 5
				 */
				
				if(list[j].compareTo(list[min]) < 0) {
					
					min = j;  // update index to index 5
					
				//  min = 5;	
					
				}
				
				// temp is a Comparable object 
				
				/**
				 * Smallest will be held in temp, index updated
				 * - then
				 * At Smallest index, it is overwritten with bigger object
				 * - then
				 * Current index will hold smallest
				 */
				
				temp = list[min];  // temp will hold object at index 5
				
				list[min] = list[i];  // at index 5, copy object at index 0
				
				list[i] = temp;  // the value at index 0 will hold object at index 5
				
				}
			}
		}  // end of method
	
	public static void insertionSort(Comparable[] list) {
		
		for(int i = 1; i < list.length; i++) {  // Iterating through all of the values
			
			Comparable hold = list[i];	// key will have the object value
			int index = i;	// index will have the object's index
			
			/**
			 * While
			 *  - index > 0 , so no out of bounds exception
			 *  - if 'key' (object value) compareTo the object value before is less than
			 *  	- if it is
			 *  		- change current index with value that is less than
			 *  		- index goes down by 1, iterating through ALL the values before current index!!
			 *  		- placing the correct value in order
			 *  - after, the current index of where it is will be replaced by key ( the bigger value object ) 
			 */
			
			while(index > 0 && hold.compareTo(list[ index - 1 ]) < 0) {
				list[index] = list[ index - 1 ];  // 'shifting' values to the right
				index--;							// it is copying the value to the right	
													   // when at the index where value is correct exit out
			}											  // and do ... list[index] = hold
			
			list[index] = hold; // the index here is going to be the smallest value, or value in between
							   // respectively, then replacing the that index with the 'hold' (key) value
		}
		
		
		
		
	}
	
}
