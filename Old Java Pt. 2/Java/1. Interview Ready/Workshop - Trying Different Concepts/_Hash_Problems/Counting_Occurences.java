package _Hash_Problems;

import java.util.HashMap;
import java.util.Map;

public class Counting_Occurences {
	
	public static void main(String[] args) {
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		
		//String[] words = {"a", "a", "b", "b", "d", "d"};
		String words = "aabbdd";
		char[] wordsArray = words.toCharArray();
		
		for(int i = 0; i < wordsArray.length; i++) {
			// Value
			Integer count = dict.get(wordsArray[i]); // the v, value!
			
			int newCount = (count==null) ? 1 : count + 1;  // if the value is null, set to 1, or increase by 1
			
			dict.put(wordsArray[i], newCount); // no duplicates so it just increases the value
		}
		
		for(Map.Entry entry: dict.entrySet()) {
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
		
//		for(char letter: wordsArray) {
//			
//			if(dict.containsKey(letter)) {
//				dict.put(letter, dict.get(letter) + 1);
//			}
//			else {
//				dict.put(letter, 1);
//			}
//			
//			Integer count = dict.get(letter);
//			int newCount = (count==null) ? 1 : count + 1;
//			dict.put(letter, newCount);
//			
//		}
		
		
		
		//System.out.println(dict);
		
		for(Map.Entry entry: dict.entrySet()) {
			if((Integer)entry.getValue() > 1) {
				System.out.print(entry.getValue() +""+ entry.getKey());
			}else {
				System.out.print(entry.getKey());
			}
			
		}
		
	}

}
