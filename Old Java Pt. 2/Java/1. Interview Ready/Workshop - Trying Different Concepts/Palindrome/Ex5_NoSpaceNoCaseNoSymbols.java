package Palindrome;

public class Ex5_NoSpaceNoCaseNoSymbols {
	
	public static void main(String[] args) {
		
		boolean booVal = isPalindrome("Ra Ce.. cAr !)>");
		System.out.println(booVal);
	}
	
	public static boolean isPalindrome(String s) {
		
		boolean itisPalindrome = true;
		
		// replaceAll returns a String object and uses RegEx to determine what characters will be filtered out, O(n)
		// toLowerCase returns a String object that will turn all capitalized letters to lower case, O(n)
		String filtered = s.replaceAll("[^a-zA-Z]+" , "").toLowerCase();
		
		// Printing what the filtered variable will be
		/* System.out.println(filtered); */ 
		
		// O(n)
		for(int i = 0; i < filtered.length() / 2; i++) {
			// Prints out values step by step
			/* System.out.println(i + ": " + filtered.charAt(i) + " -- " + (filtered.length() - i - 1) + ": " + filtered.charAt(filtered.length() - i - 1)); */
			
			// if not the same, then return false
			if(filtered.charAt(i) != filtered.charAt(filtered.length() - i - 1)) {
				itisPalindrome = false;
				return itisPalindrome;
			}
		}
		
		return itisPalindrome;
		
	}

}
