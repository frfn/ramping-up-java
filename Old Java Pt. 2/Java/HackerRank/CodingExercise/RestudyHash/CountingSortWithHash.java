package RestudyHash;

import java.util.HashMap;
import java.util.Set;

public class CountingSortWithHash {
	
	public static void main(String[] args) {
		
		int[] set = {5,2,7,12,7,2,10,4,2,6,5,5,5,3,2,6,24,67,21};
		// { 1, 2, 4, 7, 8, 2, 1, 3, 6, 9 };
		// 
		
		HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
		
		// usually working with arrays, it will be better to use a 'for-each' loop. Look below
		
		for(int key : set) {  // for each value in the array 'set', it will go in the variable 'key' for an iteration
			
			Integer count = list.get(key);  // this will 'get' the key, since first round, it will contain nothing, hence null!
			
			int incrementingCount = (count == null) ? 1 : count + 1;
			
			list.put(key, incrementingCount);  // list does NOT contain duplicates!!
			
			
			
		}
		
		System.out.println(list);
		
		
		Set<Integer> keys = list.keySet();  // the list now has values, set is the corresponding correct data type
										   
		Object[] key = keys.toArray();   // making them an array!
		
		for(Object newKey : key) {
			
			Integer counts = list.get(newKey);
			
			System.out.print("[" + newKey + " has " + counts + " iterations ], ");  // so now I can use the keys!
			
		}
		
		System.out.println();
		
		int[] listingOut = new int[set.length]; // set length = 10
		int index = 0;
		
		// key length = 8
		
		for(int i = 0; i < key.length; i++) {
			int iterationsNeededToBeMade = list.get(key[i]);  // 1 = 2 iterations
			
			for(int j = 0; j < iterationsNeededToBeMade; j++) {
				listingOut[index] = (int)key[i];
				index++;
			}
			
		}
		
		for(int viewing : listingOut) {
			System.out.print(viewing + " ");
		}
		
		
		
		
	}

}
