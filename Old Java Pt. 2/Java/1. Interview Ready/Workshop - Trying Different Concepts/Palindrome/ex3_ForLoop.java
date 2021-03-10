package Palindrome;

import java.util.Scanner;

public class ex3_ForLoop {
	
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter string: ");
		String word = scan.nextLine().toLowerCase(); // nextLine scans WHOLE line
		
		System.out.println("Is your word a palindrome?: " + palindromeFor(word));
		
	}

	public static boolean palindromeFor(String string) {
		
		for(int i = 0; i < string.length() / 2; i++) {
			if(string.charAt(i) != string.charAt(string.length() - i - 1)) {
				return false;
			}
		}
		
		return true;
		
	}

}
