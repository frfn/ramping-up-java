package _String_Problems;

public class ex1_ForLoop_FrequencyCleanUp {

	public static void main(String[] args) {
		String letters = "fflexerr";
		
		frequency(letters);
		
	}
	
	public static void frequency(String str) {
		
		StringBuilder compress = new StringBuilder();
		
		int count = 1;
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				count++;
			}
			else if(str.charAt(i) != str.charAt(i+1)) {
				if(count > 1) {
					compress.append(str.charAt(i) + Integer.toString(count));
				}
				else {
					compress.append(str.charAt(i));
				}
				count = 1;
			}
		}
		
		// it does COMPARE it, now see if count is greater than one!
		
		if(count > 1) {
			compress.append(str.charAt(str.length()-1) + Integer.toString(count)); 
		}
		else {
			compress.append(str.charAt(str.length()-1));
		}
		System.out.println(compress);
		
	}
	
}
