package Day8Maps;

import java.util.HashMap;

public class HashMapping {

	public static void main(String[] args) {
		
		int[] list = { 3, 3, 4, 5, 1, 2, 9, 3, 2, 1};
		
		HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
		
		for(int key : list) {
			Integer count = data.get(key);
			
			int value = (count == null) ? 1 : count + 1;
			
			data.put(key, value);
		}
		
		System.out.println(data);
		
	}
	
}
