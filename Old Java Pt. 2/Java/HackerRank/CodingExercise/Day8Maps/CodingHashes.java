package Day8Maps;

import java.util.HashMap;

public class CodingHashes {
	
	public static void main(String[] args) {
		
		int[] list = {1, 1, 1, 1, 6, 4, 32, 6, 2};
		
		HashMap<Integer, Integer> data = new HashMap<>();
		
		for (int key : list) {
			
			Integer count = data.get(key);
			
			int value = ( count == null ) ? 1 : count + 1;
			
			data.put(key, value);
			
		}
		
		System.out.println(data);
		
		/*
		 * int[] list = {1, 1, 1, 1, 6, 4, 32, 6, 2};
		 * 
		 * HashMap<Integer, Integer> data = new HashMap<>();
		 * 
		 * 
		 * for (int i = 0; i < list.length; i++) {
		 * 
		 * Integer key = data.get(list[i]);
		 * 
		 * //System.out.println(key);
		 * 
		 * int value = (key == null) ? 1 : key + 1;
		 * 
		 * data.put(list[i], value);
		 * 
		 * }
		 * 
		 * System.out.println(data);
		 */
		
		
	}

}
