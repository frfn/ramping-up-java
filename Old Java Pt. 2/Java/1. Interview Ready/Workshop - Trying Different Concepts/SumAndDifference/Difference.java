package SumAndDifference;

/**
 * 
 * @author Flexer
 * 
 * 
 *
 */

public class Difference {
	
	public static void main(String[] args) {
		
		int[] list = {1, 7, 5, 9, 2, 12, 3};
		
		String[] dif = differenceArray(list, 2);
		
		for(String val: dif) {
			if(val == null) {
				continue;
			}
			System.out.println(val);
		}
	}
	
	/**
	 * Naive Way, O(n^2) - can't think of nothing else
	 * 
	 * - A different way to return all of the answers
	 * - Great way to start, it gives us the answer
	 * - The reason why it's not list.length-1, because we are not comparing the number with list[i+1], with this, it would cause error.
	 */
	public static String[] differenceArray(int[] list, int target) {
		// Array size set
		String[] arr = new String[list.length];
		
		// Index for arr
		int index = 0;
		
		for(int i = 0; i < list.length; i++) {
			// variable does not need to be initialized
			int iValue = list[i];
			
			for(int j = 0; j < list.length; j++) {
				// variable does not need to be initialized
				int jValue = list[j];
				
				// Just adding into the arr
				if((jValue - iValue) == target) {
					arr[index] = "(" + Integer.toString(iValue) + ", " + Integer.toString(jValue) + ")";
					index++;
				}
			}
		}
		return arr;
	}
}
