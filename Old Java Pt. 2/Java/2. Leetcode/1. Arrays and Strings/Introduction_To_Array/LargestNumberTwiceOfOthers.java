package Introduction_To_Array;

public class LargestNumberTwiceOfOthers {
	
	
	public static int largerByTwoTimes(int[] arr) {
		if(arr.length == 0) {
			System.out.println("Empty array...");
		}
		else if(arr.length == 1) {
			return 0; // index is 0
		}
		
		// find the largest number
		// {1, 3, 6, 2, 7}
		
		int maxIndex = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] > maxIndex) {
				maxIndex = i;
			}
		}
		
		for(int i = 0; i<arr.length; i++) {
			// the maxIndex is NOT the current one... for some odd reason
			// and if the current value at ith index is greater than the value at arr[maxIndex], then return -1
			// means false
			if(maxIndex != i && arr[maxIndex] < arr[i] * 2) {
				return -1;
			}
		}
		
		
		return maxIndex;
	}

}
