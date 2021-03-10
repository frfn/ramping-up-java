package Palindrome;
import java.util.Scanner;
public class Palindrome {
	public static void main(String[] args) {
		
		// Scanner for user input
		Scanner scan = new Scanner(System.in);
		
		// Enter string
		System.out.println("Enter string: ");
		String str = scan.nextLine();
		
		// Array length
		int leftIndex = 0;
		int rightIndex = str.length() - 1;
		
		while(str.charAt(leftIndex) == str.charAt(rightIndex) && leftIndex < rightIndex) {
			leftIndex++;
			rightIndex--;
		}
		
		if(leftIndex < rightIndex) {
			System.out.println("Not palindrome.");
		}
		else {
			System.out.println("Palindrome.");
		}
		
		/**********************************/
		//			Another Way			  //
		/**********************************/
		
		System.out.println("Enter string: ");
		str = scan.nextLine();
		
		String rev = "";
		
		for(int i = 0; i < str.length(); i++) {
			rev = str.charAt(i) + rev;
		}
		
		System.out.println(rev);
		
		if(str.equals(rev)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not palindrome");
		}
	}
}
