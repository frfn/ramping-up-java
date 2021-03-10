package CommonElements;

/**
 * 
 * @author Flexer
 *
 *
 * Added a constraint that numbers shall be from 0-999, 
 * 
 * - 1000 is our cutoff, it prints 1000 when the array is not filled up... 
 * - the best I can come up with!
 */

public class CommonElements_Array {
	
	public static void main(String[] args) {
		
		int[] a = {0, 2, 7, 8, 100, 455};
		int[] b = {0, 3, 4, 7, 8, 11, 23, 7, 24, 55, 67, 69, 100, 455};
		
		//System.out.println(binarySearch(a, 0));
		
		int[] commonFor = withBinarySearch(a, b);
		
		for(int val: commonFor) {
			if(val != 1000)
			System.out.print(val +", ");
		}
		
	}
	
	// Big O(n^2)
	public static int[] withForLoop(int[] a, int[] b) {
		int size = 10;
		int index = 0;
		int[] commonElements = new int[size];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if(a[i]==b[j]) {
					commonElements[index++] = a[i];
				}
			}
		}
		return commonElements;
	}
	
	// Big O(log n)
	public static boolean binarySearch(int[] arr, int target) {
		if(arr.length == 0) {
			return false;
		}
		
		int left = 0;
		int right = arr.length-1;
		
		// note the  <=... BINARY = LESS THAN OR EQUAL TO
		while(left <= right) {
			int middle = (left + right) / 2;
			if(arr[middle] == target) {
				return true;
			}
			if(arr[middle] < target) {
				left = middle + 1;
			}
			if(arr[middle] > target) {
				right = middle - 1;
			}
		}
		return false;
	}
	
	// Big O(n) .. amortized cost though :)
	public static int[] increase(int[] arr) {
		int[] temp = new int[arr.length * 2];
		
		for(int i=0; i<temp.length; i++) {
			temp[i] = 1000;
		}
		
		for(int i=0; i<arr.length; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
	
	// Big O(n * log n)
	public static int[] withBinarySearch(int[] a, int[] b) {
		int[] commonElements = new int[1];
		int index = 0;
		
		for(int val: a) {
			if(binarySearch(b, val)) {
				if(commonElements.length == index) {
					int[] newArray = increase(commonElements);
					commonElements = newArray;
				}
				commonElements[index++] = val;
			}
		}
		
		return commonElements;
	}

}
