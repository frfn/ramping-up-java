package CommonElements;

import java.util.HashSet;

public class CommonElements_Set {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 4, 6, 8, 9, 11, 23};
		int[] arr2 = {0, 2, 4, 11, 3, 5, 7, 9, 13, 23, 34};
		
		HashSet<Integer> common = commonElements(arr, arr2);
		
		for(int val: common) {
			System.out.print(val + ", ");
		}
		
		
	}
	
	public static HashSet<Integer> commonElements(int[] arr, int[] arr2) {
		
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> commonElements = new HashSet<>();
		
		for(int val: arr) {
			set.add(val);
		}
		
		for(int val: arr2) {
			if(set.contains(val)) {
				commonElements.add(val);
			}
		}
		
		return commonElements;
		
	}

}
