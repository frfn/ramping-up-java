package chapter5;
import java.util.Scanner;
public class PalindromeTester {
	
	/*
	 * This one uses the charAt, so using the word
	 * 
	 */
	
	public static void main(String[] palindrome) {
		
		String userInput;
		int leftIndexOfWord, rightIndexOfWord;
		boolean keepInputting = true, stopInputting = false;
		
		Scanner scan = new Scanner(System.in);
		
		//Notice how the print statement is in the while loop
		//It does not need to be out, it depends
		
		while(keepInputting) {	
			
			System.out.print("Please enter string to determine if palindrome: ");
			userInput = scan.nextLine(); //using nextLine so that it reads the whole entire line
			
			leftIndexOfWord = 0;
			rightIndexOfWord = userInput.length() - 1; 
			
			System.out.println(rightIndexOfWord);
			//why minus one? test this – because it becomes index out of range
			//but why? – because the letter at the end of the word is out of bounds!
			
			
			//these are the index counter of the word
			//hello olleh
			//^ = h is at index 0,
			//
			//hello olleh
			//			^ = h is at index 10,
			
			while(userInput.charAt(leftIndexOfWord) == userInput.charAt(rightIndexOfWord) 
					&& leftIndexOfWord <= rightIndexOfWord) {	

				//THE INEQUALITY IS THERE BECAUSE once the word reaches the middle or passes each other,
				//THE WHOLE STRING HAS BEEN READ!
				
				//IF I do NOT put the &&, the leftIndex++ and rightIndex++ will keep going.
				//THUS becoming outOfBoundsException
				
				leftIndexOfWord++;	//the index will INCREASE to next indexs
				System.out.print("\nL: " + leftIndexOfWord + " – ");
					//**VERY IMPORTANT** – this is the coding that will move the indexes and see if the word is a palindrome
				rightIndexOfWord--; //the index will DECREASE to next index
				System.out.print("R: " + rightIndexOfWord);
				
				System.out.println();
				
			}// end of nested while loop
			
			System.out.println(); //new shortcut, type sysout, then press ctrl + space! it will type it out!
			
			if(leftIndexOfWord < rightIndexOfWord) {
				
				//if the word keeps going, and finds that the string
				//is not a palindrome , considering it read the whole line
				//print
				//the string is not a palindrome
				System.out.println("That string is NOT a palindrome.");
			}else
			{
				System.out.println("That string IS a palindrome.");
			}
			
			System.out.println();
			System.out.print("Do you want to test another word? Type \"no\"!: ");
			userInput = scan.nextLine();
			
			if(userInput.equalsIgnoreCase("no")) {
				keepInputting = stopInputting;
			}
			
		}//end of while loop
		System.out.println();
		System.out.println("Thanks for playing!");
		
	}

}
