package Palindrome;
import java.util.Scanner;
/**
 * 
 * @author Flexer
 * 
 * We are looking into ways of finding if string is a palindrome.
 * Here, we use indices of an array and compare them. 
 * 
 * If left index less than right index, that means the loop did NOT finish.
 * Means not a palindrome
 * 
 */

public class ex1_WhileLoop_Compare_From_StartEnd_Till_Middle {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter string: ");
		String word = scan.nextLine().toLowerCase(); // nextLine scans WHOLE line
		
		System.out.println("Is your word a palindrome?: " + palindromeWhile(word));
		
	}
	
	public static boolean palindromeWhile(String string) {
		int left = 0;
		int right = string.length() - 1;
		
		System.out.println(string.length());
		
		while(string.charAt(left) == string.charAt(right) && left <= right) {
			++left;
			--right;
		}
		
		boolean palindrome = (left < right) ? false : true;
		
		return palindrome;
	}

}
