package programmingTests;

/**
 * 
 * @author flexer
 * 
 * this is the Trick class
 * it demonstrates how you can
 * call METHODS without the construction of an object!
 * 
 * Static methods can be called by "className.methodName()"
 *
 */

public class Trick {

	public static void tricking() {
		System.out.println("This is the tricking class.");
	}
	
	public static String specificTrick(String args) {
		
		if(args.equals("TDR")) {
			return "TDR";
		}else {
			return "Not TDR";
		}
		
	}
	
	public static String palindrome(String args) {
		int leftIndex = 0, rightIndex = args.length() - 1;
		while(args.charAt(leftIndex) == args.charAt(rightIndex) && leftIndex <= rightIndex) {
			leftIndex++;
			rightIndex--;	
		}
		if(leftIndex<rightIndex) { //if left index is smaller, we know it IS NOT a palindrome, left index is 4 and right is 9, means than charAt are not the same
			return "Not a palindrome";
		}else {
			return "Palindrome!";
		}
	}
	public static String palindromeReversed(String args) {
		String reverse = "";
		
		try {
			
		for(int i = args.length(); i >= 0; i--) {
		//for(int i = args.length() - 1; i >= 0; i--) {
			/**
			 * It starts at the last index, charAt, so it will go bo from last to first
			 */
			reverse += args.charAt(i);
		}
		
		}catch(StringIndexOutOfBoundsException s) {
			
			System.out.println("Uh oh... error. ");
			
		}
		
		if(args.equals(reverse)) {
			return "Palindrome!";
		}else {
			return "Not a palindrome!";
		}
		
	}
	
}
