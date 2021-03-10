package chapter5Exercises;
import java.util.Scanner;

public class FivePoint14 {
	
	static Scanner scan = new Scanner(System.in);
	static int userValue;
	
	public static void main(String[] args) {
		
		System.out.print("Please enter positive value: ");
		userValue = scan.nextInt();
		
		while(userValue < 0) {
			System.out.print("Please enter positive value: ");
			userValue = scan.nextInt();
		}
		
		System.out.println("Your value is: " + userValue);
		
	}

}
