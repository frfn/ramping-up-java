package VIP;
import java.util.Arrays;
import java.util.HashSet;
/**
 * 
 * @author Flexer
 *
   Efficiency -- Big O Notation
  
   Write a program that allows for an integer array to be passed in and will then output all of the pairs that sum up to 10.  
   
   Please provide a solution that allows for: 
   
   1) output all pairs (includes duplicates and the reversed ordered pairs)
   2) output unique pairs only once (removes the duplicates but includes the reversed ordered pairs)
   3) output the same combo pair only once (removes the reversed ordered pairs). 
  
   For example passing in [1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9] the following results should occur:
 
   1) output all pairs would output: [1,9], [1,9], [4,6], [4,6], [5,5], [5,5], [5,5], [5,5], [5,5], [5,5], [6,4], [6,4] [9,1] , [9,1] 
   2) output unique pairs only once would output: [1,9], [4,6], [5,5], [6,4], [9,1] 
   3) output the same combo pair only once would output: [1,9], [4,6], [5,5]   "
 *
 */


public class Pairs {
	
	/**
	 * Initialized an integer array called numbers and filled them with possible values
	 */
	
	static int[] numbers = { 1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9  };

	public static void main(String[] args) {
		
		/**
		 * Main's sole purpose is to print
		 */
		
		System.out.print("All pairs: "); printAllPairs(numbers, 10);
		System.out.println();
		
		System.out.print("Unique Pairs: "); printUniquePairs(numbers, 10);
		System.out.println();
		
		System.out.print("Distinct Pairs: "); printDistinctPairs(numbers, 10);
		
	}
	
	public static void printAllPairs(int[] array, int target) {  // O(n^2) -- worst case 
		/**
		 * Created String variables to store the values in
		 * Reverse had the values switched and added on to main 'str' variable.
		 * 
		 * Reversing the array, I messed with the .split() and reversing it like a palindrome, but does NOT work.
		 * 	- format is messed up
		 *  - Instead, I created 'reverse' variable and concatenated with 'str' variable.
		 */
		String str = "";  
		String reverse = "";
		int firstValue, secondValue;
		firstValue = secondValue = 0;
		
		for (int i = 0; i < array.length; i++) {
			firstValue = array[i];
			
			for (int j = i + 1; j < array.length; j++) {
				secondValue = array[j];
				
				if((firstValue + secondValue) == target) {  // if the values equals the target number
					str += "[" + firstValue + "," + secondValue + "], ";   
					reverse = "[" + secondValue + "," + firstValue + "], " + reverse;
				}
			}
		}
		
		str += reverse;  // concatenating the strings together
		System.out.print(str);  // output
	
	}
	
	public static void printUniquePairs(int[] array, int target) {  // O(N) -- linear
		
		HashSet<Integer> set = new HashSet<Integer>(array.length); // created a HashSet so it will have no duplicates and run constant time
		HashSet<Integer> filter = new HashSet<Integer>();
		/**
		 * Using a HashSet. 
		 *  - I am novice with Hashes and will research more about it.
		 *  - HashMaps, HashSets, HashCode, etc. 
		 * 
		 *
		 * Notes:
		 * For each value in the array,
		 * 	9 = 10 - 1;
		 *  
		 *  if the set does not contain the difference
		 *  	- print out
		 *  
		 *  +-----------------------------+
		 *  | Duplicating (5, 5) -- error.|
		 *  +-----------------------------+
		 */
		for(int val: array) {
			filter.add(val);
		}
	
		
		for (int value: filter) {
			
			int difference = target - value;  // difference = 10 - value in array
			
			if(difference == value) {
				System.out.println(difference + " : " + value);
			}
			
				if(!set.contains(difference)) {
					
					set.add(value);
					set.add(difference);
				} 
				else {
					/**
					 * This is the way I chose to output,
					 * if it is not in the set, print out [ value, difference ]
					 */
					System.out.print("[" + value + "," + difference + "], ");
				}	
		}
	}	
	
	public static void printDistinctPairs(int[] array,  int target) { // O(log N) -- efficient
		
		/**
		 * Utilizing the ends of the array, it traverses from the beginning to end,
		 * comparing the two elements and moving respectively.
		 */
		
		Arrays.sort(array);  // research Arrays.sort() declaration, dual pivot quicksort
		
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		
		/**
		 * Research Branch Prediction.
		 */
		
		while (leftIndex < rightIndex) {  // the indexes will meet and will stop loop
			
			int total = array[leftIndex] + array[rightIndex];  // creating a variable for ease of use
			
			if (total == target) {  // if total = 10
				
				System.out.print("[" + array[leftIndex] + "," + array[rightIndex] + "], ");
				
				leftIndex++;  // moving forward in the array index
				rightIndex--;  // moving backwards in the array index
				
			}  // end of if
			
			else if (total < target) { // if the sum is less than target, increase left index
				leftIndex++;
			}
			
			else if (total > target){  // if the sum is greater than target, decrease right index
				rightIndex--;
			}
		}  // end of while
		
	}

}
