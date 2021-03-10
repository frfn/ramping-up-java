package Problem2_String_Permutation;

import java.util.HashMap;

public class HashMap_Approach {
	
	public static void main(String[] args) {
		
		HashMap_Approach p = new HashMap_Approach();
		
		boolean permutation = p.isPermutation("ABC", "ABA");
		
		System.out.println(permutation);
		
	}
	
	public boolean isPermutation(String str, String str2) {
		
		if(str.length() != str2.length()) {
			return false;
		}
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < str.length(); i++) {
			Integer count = map.get(str.charAt(i));
			int newCount = (count==null) ? 1 : count+1;
			map.put(str.charAt(i), newCount);
		}
		
		for(int i = 0; i < str2.length(); i++) {
			if(map.containsKey(str2.charAt(i))) {
				map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
				if(map.get(str2.charAt(i)) == 0) {
					map.remove(str2.charAt(i));
				}
			}
			else {
				return false;
			}
		}
		
		return true;
	}

}
