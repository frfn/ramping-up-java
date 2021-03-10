package String_Permutation;

import java.util.HashMap;

/**
 * 
 * @author Flexer
 * 
 * The way you're thinking, it works, BUT, programming will probably involve an array, which will take longer.
 * - To count, and increase value at current number.
 * 
 * Instead follow the below for a more constant approach!
 *
 */

public class ex3_isPermutation_HashMap {
	// Nothing here, just main.
	public static void main(String[] args) {
		System.out.println(isPermutation("hello", "elloh"));
	}
	
	// Permutation method!
	public static boolean isPermutation(String s1, String s2) {
		// Quick check! If not the same length, not a permutation!
		if(s1.length() != s2.length()) {
			return false;
		}
		
		// 1. Create HashMap with Character and Integer
		HashMap<Character, Integer> map = new HashMap<>();
		
		// 2. Count the occurrences
		for(int i = 0; i < s1.length(); i++) {
			Integer count = map.get(s1.charAt(i));
			int newCount = (count == null) ? 1 : count + 1;
			map.put(s1.charAt(i), newCount);
		}
		
	
		// 3. Removing process, this is KEY in this algorithm!
		for(int i = 0; i < s2.length(); i++) {
			System.out.println(map);
			
			// 3a. If there is value, decrease by 1
			if(map.containsKey(s2.charAt(i))) {
				
				map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1); // the value CAN be 0, so, if it is, remove!
				
				// 3b. If value is 0, remove value altogether!
				if(map.get(s2.charAt(i)) == 0) {
					map.remove(s2.charAt(i));
				}
				
			}
			
			// 3aa. If there is no value, then it's false!
			else {
				return false;
			}
		}
		
		// If for loop finishes, it's true!
		return true;
	}

}
