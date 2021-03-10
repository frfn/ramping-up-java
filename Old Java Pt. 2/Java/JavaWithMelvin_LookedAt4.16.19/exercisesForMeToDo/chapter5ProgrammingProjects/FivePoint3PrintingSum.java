package chapter5ProgrammingProjects;
import java.util.Scanner;

/*
 Printing the sum of all even numbers with a set range
 */

public class FivePoint3PrintingSum {
	static Scanner scan;
	static int number;
	/*
	 I first set these two variables because it is what I thought to be needed
	 */
	
	static int evenSum; //I now declared this because this will hold the even sum value
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		
		System.out.print("Enter number range and I will produce the sum of all even numbers: ");
		number = scan.nextInt();
		
		while(number < 2) {
			System.out.print("Error! Enter value greater than 2: ");
			number = scan.nextInt();
		}
		
		for(int i = 0; i <= number; i ++) {
			
			if(i % 2 == 0) {
				evenSum = evenSum + i;
			}
		
			
		}
		
		System.out.print("The even sum from 2 to " + number + " will be: " + evenSum);
		
		
	}

}
