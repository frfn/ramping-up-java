package chapter5Exercises;
import java.util.Scanner;
public class FivePoint19 {
	
	public static void main(String[] args) {
		
		Scanner scan  =  new Scanner (System.in);
		
		
		int counter = 1;
	
		
		System.out.print("Please enter integer: ");
		int userValue = scan.nextInt();
		int biggestValue = userValue;
		int smallestValue = userValue;
		
		
		
		while(counter < 10) {
			
			if(userValue < smallestValue) {
				smallestValue = userValue;
			}
			
			if(userValue > biggestValue) {
				biggestValue = userValue;
			}
			
			System.out.print("Please enter integer: ");
			userValue = scan.nextInt();
			counter++;
		}
		
		System.out.println("Biggest value is: " + biggestValue);
		System.out.println("Smallest value is: " + smallestValue);
		
	}

}
