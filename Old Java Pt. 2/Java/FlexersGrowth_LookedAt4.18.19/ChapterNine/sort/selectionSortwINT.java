package sort;

public class selectionSortwINT {
	
	public static void selectionSort(int[] arr) {
		
		int temp, minValue, minIndex;
		
		for(int i = 0; i < arr.length; i++) {  // iterating through the array
			
			minValue = arr[i];  // the min value is first 
			
			minIndex = i;  // the min value is at THIS index
			
			for(int j = i; j < arr.length; j++) {
				
				if(arr[j] < minValue) {
					
					/**
					 * Updating minValue if there is smallest value
					 * 
					 * Updating minIndex at index where smallest value is
					 */
				
					minValue = arr[j];  // the min value will be
									    // THAT value
					
					minIndex = j;  //the minIndex is at THIS index
					
				}
				
			}
			/**
			 * minValue here is updated
			 *  - if smaller than value at arr[i]
			 */
			
			 /**
			  * Bigger will be held in temp
			  * - then
			  * Current index will become smaller value
			  * - then
			  * At minIndex, copy bigger value
			  */
			
			if(minValue < arr[i]) {
				 
				temp = arr[i];  // 3 will go into temp variable
				arr[i] = arr[minIndex];  // the value of minIndex ( 1 ) overwrites
										 // the value 3
				arr[minIndex] = temp;  //copy number to where minIndex was
				
			}
			
		}
		
	}

}
