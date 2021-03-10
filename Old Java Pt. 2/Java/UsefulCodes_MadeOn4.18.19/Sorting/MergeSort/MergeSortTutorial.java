package MergeSort;

public class MergeSortTutorial {
	
	public static void main(String[] args) {
		int[] set = {5, 4, 3, 2, 1};
		int[] printMe = mergeSort(set);
		
		for(int value : printMe) {
			System.out.println(value);
		}
		
	}
	
	public static int[] mergeSort(int[] arr) {
		
		/**
		 * Recap:
		 * if the size of the array is less than or equal to one, return array, or sub array, look below!
		 */
		
		if(arr.length <= 1) {
			return arr;  // means we have one element in the array
		}
		
		
		/**
		 * Recap:
		 * We're cutting the array in half for size
		 * 
		 * We then initialize two new arrays called, 'left' and 'right' with their sizes
		 * 
		 * left[].length = midpoint
		 * 
		 * right[].length = will depend on the size if (arr.length % 2 == 0)
		 */
		int midpoint = arr.length / 2;
		
		int[] left = new int[midpoint];  // just setting the length of left array;
		int[] right; // = new int[arr.length - midpoint] edit: 10/2
		
		/**
		 * If array length is 5.
		 * ex. 5, 4, 3, 2, 1
		 * 
		 * When divided by two WITH INT, it will produce 2.
		 * 
		 * Left will have the length of two
		 * Right will have the length of 'two + 1', 3.
		 */
		
		if(arr.length % 2 == 0) {
			right = new int[midpoint];  
		}
		else {
			right = new int[midpoint + 1];  // properly accounting size
		}
		
		/**
		 * Populating the left and right array
		 */
		
		for(int i = 0; i < midpoint; i++) {  // do NOT set to '<=' because then size will be 3, IndexOutOfBoundsException
			left[i] = arr[i];  // since mid point is 2 -- index 0 = value 5, index 1 = value 4
		}
		
		for(int j = 0; j < right.length; j++) {
			right[j] = arr[midpoint + j];  // so it's in respect of adding
			// index 2 = value 3 ... and so on
		}
		
		/**
		 * This is the interesting part
		 */
		
		int[] sortedArray = new int[arr.length];  //Recap: just created new array that will have the sorted elements inside
		
		/**
		 * Recap:
		 *  -- left = mergeSort(left); --
		 *  -- right = mergeSort(right); --
		 * 
		 * Looking at it, it is confusing. 
		 * Look at it slowly though. :) it is easy.
		 * 
		 * left = mergeSort(left)
		 * 
		 * Currently left has two elements inside it.
		 * 
		 * when calling mergeSort to ... recursively ... split it
		 * it will create sub arrays in visualizing (look below) till each array is split
		 */
		
		/**
		 * I can create statement if mergeSort is one element stop reading, no need.
		 */
		
		left = mergeSort(left);  // once left.length is 1, move to next line
		/**
		 * Explanation:
		 * 	- example Array of: 5, 4, 3, 2, 1
		 * 
		 *  - left[] array initially has elements [5, 4]
		 *  
		 *  Calling mergeSort, this will separate the elements in the left[] array
		 *  - left[] = [5]
		 *  - right[] = [4]
		 *  
		 *  so under the left[] array, there is sort of a sub array
		 *  
		 *  				left[]
		 *  				/    \
		 *  			left[5]   right[4]
		 */
		right = mergeSort(right);
		
		
		
		
		
		sortedArray = merge(left, right);
		
		
		
		return sortedArray;
		
	}
	
	private static int[] merge(int[] left, int[] right) {
		
		int[] result = new int[left.length + right.length];  // merging the two array lengths
		
		// declaring int variablesm -- i, j, k 
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		while(leftPointer < left.length || rightPointer < right.length) {  // if EITHER array is less than length, keep looping
			
			if(leftPointer < left.length && rightPointer < right.length) {  // if BOTH array has element, do this 'if' block
				
				if(left[leftPointer] < right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];  // sorting from least to highest, there are iterators there so that it can move the array spot forward
				}
				else {
					result[resultPointer++] = right[rightPointer++];
				}
				
				/**
				 * If there are only elements left in the LEFT ARRAY, then run block of code
				 */
			}
			else if(leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			}
			
				/**
				 * If there are only elements left in the RIGHT ARRAY, then run block of code
				 */
			
			else if(rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}
		return result;
	}

}
