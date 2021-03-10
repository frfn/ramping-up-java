package programmingTests;

public class TrueOrFalse {
	
	public static void main(String[] args) {
		
		String word = "East";
		
		boolean tryMe = vowel(word);
		
		System.out.println(tryMe);
		
		
	}
	
	public static boolean vowel(String word) {
		
		/**
		 * TAKE NOTE:
		 *  - This method returns a true or false value.
		 *  - If -1 is returned, then it is false
		 *  - If anything else, then return true.
		 *  - You can write as
		 *    if(...)
		 *    	return true;
		 *    else
		 *    	return false;
		 *    
		 *    but it seems here, it takes the condition as a true or false value
		 *    and RETURNS THAT.
		 */
		
		String vowels = "aeiouAEIOU";
		
		char letter = word.charAt(0);
		
		System.out.println(vowels.indexOf(letter));
	 
		return (vowels.indexOf(letter) != -1); 
		//it returns a true or false value
		//method will return true or false 
		
		/*
		 *  Returns the index within this string of the first occurrence of the specified character. 
		 *  If a character with value ch occurs in the character sequence represented by this String 
		 *  object, then the index (in Unicode code units) of the first such occurrence is returned. 
		 *  For values of ch in the range from 0 to 0xFFFF (inclusive), this is the smallest value k 
		 *  such that:
		 *  
 			this.charAt(k) == ch
 
			is true. For other values of ch, it is the smallest value k such that:
			
 			this.codePointAt(k) == ch
 
			is true. In either case, if no such character occurs in this string, then -1 is returned.
			
			Parameters:
			ch a character (Unicode code point).
			
			Returns:
			the index of the first occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur.
		 */
	}

}
