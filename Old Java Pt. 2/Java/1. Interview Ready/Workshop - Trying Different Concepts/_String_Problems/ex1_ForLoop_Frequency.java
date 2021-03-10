package _String_Problems;

public class ex1_ForLoop_Frequency {
	public static void main(String[] args) {
		 
		// String variables
		String letters = "fflexerr";
		String newStr = "";
		
		// Learned that String class has a .toCharArray() method
		char[] letter = letters.toCharArray();
		
		System.out.println(letter.length);
		
		// Each letter it sees will be 1
		int count = 1;
		
		// One for loop
		for(int i=0; i<letter.length-1; i++) {
			
			// if encounters, add one
			if(letter[i] == letter[i+1]) {
				count++;
			}
			
			// if not the same
			else if(letter[i] != letter[i+1]) {
				
				// print the letter and the count
				newStr += (count > 1) ? letter[i] + Integer.toString(count) : letter[i];
				
//				if(count > 1) {
//					newStr += letter[i] + Integer.toString(count);
//				}
//				else {
//					newStr += letter[i];
//				}
				
				count = 1;
			}
	
		}
		
		// outside for loop, the count variable is STILL containing a reference, a value
		newStr += (count > 1) ? letter[letter.length-1] + Integer.toString(count) : letter[letter.length-1];
//		if(count > 1) {
//			newStr += letter[letter.length-1] + Integer.toString(count);
//		}
//		else {
//			newStr += letter[letter.length-1];
//		}
		
		System.out.println(newStr);
		
	}
	
}
