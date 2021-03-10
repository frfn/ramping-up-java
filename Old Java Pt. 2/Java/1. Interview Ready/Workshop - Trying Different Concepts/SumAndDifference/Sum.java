package SumAndDifference;
import java.util.HashMap;

public class Sum {
	
	public static void main(String[] args) {
	
		int[] list = {1, 1, 7, 4, 7, 5, 9, 2, 12, 3, 1};
		
		int[] pairs = twoSum(list, 19);
		
		for(int val: pairs) {
			System.out.println("Index: " + val);
		}
		
	}
	
	public static int[] twoSum(int[] list, int target) {
		
		/**
		 * All this does is it calculates the difference of "target" value and the current value we are in.
		 * 
		 * The difference will be stored in the variable difference.
		 * 
		 * If that value is in the Hash Map, then they're a pair that equals the sum!+
		 * 
		 */
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//int[] pair = new int[2];
		
		for(int i = 0; i < list.length; i++) {
			
			int difference = target - list[i];
			
			if(map.containsKey(difference)) {
				//pair = new int[] {map.get(difference), i};
				return new int[] {map.get(difference), i};
			}
			
			map.put(list[i], i);  // updates the index
			
		}
		
//		for(HashMap.Entry entry: map.entrySet()) {
//			System.out.println(entry.getKey() + " : " + entry.getValue());
//		}
		
		//return pair;
		
		throw new IllegalArgumentException("No pairs are found...");
		
	}

}
