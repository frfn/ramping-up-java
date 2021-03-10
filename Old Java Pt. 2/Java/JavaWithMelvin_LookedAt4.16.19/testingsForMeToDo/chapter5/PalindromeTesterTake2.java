package chapter5;
import java.util.Scanner;
public class PalindromeTesterTake2 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String userInput, reverse = "";
		
		System.out.print("Enter string: ");
		userInput = scan.nextLine();
		
		int startOfWord = 0;
		int lengthOfWord = userInput.length() - 1;
		
		for(int i = lengthOfWord; i >= startOfWord; i--) {
			reverse = reverse + userInput.charAt(i);
		}
		
		System.out.println("Reverse: " + reverse);
		System.out.println("User Input: " + userInput);
		
		if(userInput.equals(reverse)) {
			System.out.println("It is a palindrome");
		}else {
			System.out.println("You\'re shit out of luck.");
		}
		
		
	}

}
