package Problem1_Is_Unique;
import java.util.HashMap;
public class HashMap_Approach {
	
	public static void main(String[] args) {
		
		String word = "abcdefghijklmnopqrsts";
		
		System.out.println(isUnique(word));
		
	}
	
	public static boolean isUnique(String word) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<word.length(); i++) {
			Integer count = map.get(word.charAt(i));
			int newCount = (count == null) ? 1 : count + 1;
			map.put(word.charAt(i), newCount);
		}	
//		for(HashMap.Entry kv: map.entrySet()) {
//			System.out.println(kv.getKey() + " : " + kv.getValue());
//		}
		for(HashMap.Entry value: map.entrySet()) {
			if((int)value.getValue() > 1) {
				return false;
			}
		}
		return true;
		
	}
}


