package chapter5ProgrammingProjects;
import java.util.Scanner;

public class FivePoint12LowercaseVowelCounter {
	
	static Scanner scan = new Scanner(System.in);
	static String userInput;
	static int a = 0, e = 0, ii = 0, o = 0, u = 0;
	
	public static void main(String[] args) {
		
		System.out.print("Input string, I will count vowels: ");
		userInput = scan.nextLine();
		
		
		for(int i = 0; i < userInput.length(); i++) {
			
			if(userInput.charAt(i) == 'a') {
				a++;
			}
			if(userInput.charAt(i) == 'e') {
				e++;
			}
			if(userInput.charAt(i) == 'i') {
				ii++;
			}
			if(userInput.charAt(i) == 'o') {
				o++;
			}
			if(userInput.charAt(i) == 'u') {
				u++;
			}
			
			
		}
		
		System.out.println("a count: " + a);
		System.out.println("e count: " + e);
		System.out.println("i count: " + ii);
		System.out.println("o count: " + o);
		System.out.println("u count: " + u);
	
		
	}
	

}
