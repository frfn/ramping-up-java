package _Array_Problems;

/**
 * 
 * @author Flexer
 *
 * Reversing an array in place!
 * This is also O (N), just because it's half does not affect the time complexity
 *
 */

public class ReverseArray {
	
	public static void main(String[] args) {
		
		int[] list = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		for(int val: list) {
			System.out.print(val + ", ");
		}
		
		System.out.println();
		
		/**
		 * Main Focus:
		 * - "other" variable KEEPS TRACK of the last element in the array
		 */
		for(int i = 0; i < list.length / 2; i++) {
			int other = list.length-i-1;
			
			// basic swapping algorithm
			int temp = list[i];
			list[i] = list[other];
			list[other] = temp;
		}
		
		for(int val: list) {
			System.out.print(val + ", ");
		}
		
	}

}
