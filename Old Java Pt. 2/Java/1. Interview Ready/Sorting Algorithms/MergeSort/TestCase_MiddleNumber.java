package MergeSort;

public class TestCase_MiddleNumber {
	public static void main(String[] args) {
		int[] array = {9, 8, 3, 7, 9};
		
		int middle = array.length / 2;
		
		// populate left array
		int[] left = new int[middle];
		for(int i=0; i<middle; ++i) {
			left[i]=array[i];
		}
		
		// populate right array
		int[] right = new int[array.length - middle];
		for(int i=0; i<array.length-middle; ++i) {
			right[i]=array[middle+i];
		}
		
		for(int i=0; i<left.length; i++) {
			System.out.print(left[i] + ", ");
		}
		
		System.out.println();
		
		for(int i=0; i<right.length; i++) {
			System.out.print(right[i] + ", ");
		}
		
		
	}
}
