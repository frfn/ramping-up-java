package VIP;
import java.util.Arrays;
/*
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

public class PairsVersion2 {
	
		static int[] data = {1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9}; 

			public static void main(String[] args) {
				
				printAllPairs(data, 10);
				
				printUniquePairs(data, 10);
				
				printDistinctPairs(data, 10);
				
	}
	
	public static void printAllPairs(int[] array, int n) {
		
		String str, reverse;
		str = reverse = "";
		
		for(int i = 0; i < array.length; i++) {
			int value = array[i];
			
			for(int j = i + 1; j < array.length; j++) {
				int secondValue = array[j];
				
				if( (value + secondValue) == n ) {
					str += "[" + value + "," + secondValue + "], ";
					reverse = "[" + secondValue + "," + value + "], " + reverse;
				}
				
			}
			
		}
		
		System.out.println(str+=reverse);
		
	}
	
	// 1, 1, 2, 4, 4, 5, 5, 5, 6, 7, 9
	
	public static void printUniquePairs(int[] array, int n) {
		
		
		String str, reverse, print;
		print = str = reverse = "";
		
		for(int i = 0; i < array.length; i++) {
			int value = array[i];
			
			for(int j = i + 1; j < array.length; j++) {
				int secondValue = array[j];
				
				if (value == secondValue) {
					i++; j++;
					//str += "[" + value + "," + secondValue + "], ";
				} 

				if ( (value + secondValue) == n ) {
					str += "[" + value + "," + secondValue + "], ";
					//reverse = "[" + secondValue + "," + value + "], " + reverse;
				}
				
				
				
				
			}
			
		}
		
		System.out.println(str+=reverse);
		
	}
	
	public static void printDistinctPairs(int[] array, int n) {
		
		
		
	}
	
}
