package CommonElements;

import java.util.HashMap;

public class CommonElements_HashMap {
	
	public static void main(String[] args) {
		
		int[] a = {1, 2, 5, 7, 7, 9};
		int[] b = {1, 3, 4, 7, 7, 8};
		
		int[] commonFor = withHashMap(a, b);
		
		for(int val: commonFor) {
			if(val != 0) {
				System.out.print(val +", ");
			}
			
		}
		
	}

	// Big O(A + B)
	public static int[] withHashMap(int[] a, int[] b) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int size = 10;
		int index = 0;
		int[] commonElements = new int[size];
		
		// O(N)
		for(int i=0; i<b.length;i++) {
			map.put(b[i], i);
		}
		
		// O(N)
		for(int i=0; i<a.length; i++) {
			if(map.containsKey(a[i])) {
				commonElements[index++] = a[i];
			}
		}
		
		return commonElements;
		
	}
	
}
