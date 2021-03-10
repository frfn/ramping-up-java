package Problem1_Is_Unique;

public class ForLoop_Approach {
	
	public static void main(String[] args) {
		System.out.println(isUnique("Flexer"));
	}
	
	public static boolean isUnique(String word) {
		
		String lower = word.toLowerCase();
		
		for(int i = 0; i < lower.length(); i++) {
			for(int j = i + 1; j < lower.length(); j++) {
				if(lower.charAt(i) == lower.charAt(j)) {
					return false;
				}
			}
		}
		
		return true;
		
	}

}
