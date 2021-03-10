package binarySearch;

import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;

public class binarySearchWithHash {
	
	
	
	public static void main(String[] args) {
		int[] list = {1,5,2,7,12,7,2,10,4,2,6,5,5,5,3,2,6,};
		
		int[] counting = countingSort(list);
		
		System.out.println(Arrays.toString(counting));
		
		int isThere = binarySearch(counting, 50);
		
		System.out.println(isThere);  // works
	}
	
	/**
	 * Finish Here!
	 * @param array
	 * @param target
	 * @return
	 */
	
	public static int binarySearch(int[] array, int target) {
		
		// bounding
		int floorIndex = -1;  // start our wall to the left
		int ceilingIndex = array.length;
		
		while(floorIndex + 1 < ceilingIndex) {  // 0 < length
			
			//Need to find distance
			int distance = ceilingIndex - floorIndex; // ex. 5 - (-1) = 6
			int halfDistance = distance / 2;  // cutting in half
			int guessIndex = floorIndex + halfDistance;  // -1 + 3 = 2
			
			//guessing
			int guessValue = array[guessIndex];
			
			if(guessValue == target) {
				return 1;
			}
			
			if(guessValue > target) {
				ceilingIndex = guessIndex;  // shortening the length, moving ceiling down
			}
			
			if(guessValue < target) {
				floorIndex = guessIndex;  // moving up the floor
			}
			
		}
		
		return -1;
		
	}
	
	// With bigger numbers, this sort with map has a problem!
	
	public static int[] countingSort(int[] array) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int num : array) {
			
			Integer count = map.get(num);
			
			int totalOccurence = (count == null) ? 1 : count+1;
			
			map.put(num, totalOccurence);
			
		}
		
		int[] sorted = new int[array.length];
		int index = 0;
		
		Set set = map.keySet();
		Object[] key = set.toArray();
		
		for(Object keyValue : key) {
			int totalOccurences = map.get(keyValue);
			
			for(int j = 0; j < totalOccurences; j++) {
				sorted[index] = (int)keyValue;
				index++;
			}
		}
		
		return sorted;
		
	}

}
