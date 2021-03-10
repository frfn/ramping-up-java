package InsertionSort;

public class InsertionObjects {
	
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
