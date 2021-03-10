package Introduction_To_Array;

public class PivotIndex {
	
	public static void main(String[] args) {
		
		int[] arr = {5, 1, 2, 3};
		
		System.out.println(getPivotIndex(arr));
		
	}
	
	public static int getPivotIndex(int[] arr) {
		
		int firstSum = 0;
		int secondSum = 0;
		
		for(int value: arr) {
			firstSum += value;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(secondSum == firstSum - secondSum - arr[i]) {
				return i;
			}
			secondSum += arr[i];
		}
		
		return -1;
		
	}

}
