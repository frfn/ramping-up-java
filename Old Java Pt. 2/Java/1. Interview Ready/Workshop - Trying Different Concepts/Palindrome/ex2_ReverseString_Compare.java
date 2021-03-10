package Palindrome;

import java.util.Scanner;

public class ex2_ReverseString_Compare {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter string: ");
		String word = scan.nextLine();
		
		System.out.println("Is your word a palindrome: " + palindrome(word));
		
		
	}
	
	public static boolean palindrome(String string) {
		
		String reverse = "";
		for(int i=0; i<string.length(); i++) {
			reverse = string.charAt(i) + reverse;
		}
		
		boolean palindrome = (reverse.equals(string)) ? true : false;
		return palindrome;
	}
	
}
