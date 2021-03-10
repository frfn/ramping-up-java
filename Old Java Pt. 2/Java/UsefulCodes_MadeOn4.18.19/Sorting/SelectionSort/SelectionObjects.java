package SelectionSort;

public class SelectionObjects {
	
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
			
			for(int j = i+1; j < list.length; j++) {  // iterating through all the other objects
				
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

}
