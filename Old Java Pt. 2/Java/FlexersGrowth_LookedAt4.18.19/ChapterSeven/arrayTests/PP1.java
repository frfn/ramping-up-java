package arrayTests;
import java.util.Scanner;

/**
 * 
 * @author Flexer
 *
 * Programming Project 1
 * - Example in book.
 * - Commented throughout
 */

public class PP1 {
	
	public static void main(String[] args) {
		
		/**
		 * Scanner
		 *  - Initialized it for use of user input
		 */
		
		Scanner scan = new Scanner(System.in);
		
		
		/**
		 * Array
		 * - New array initialized to 10 spaces
		 */
		int[] array = new int[10];
		
		/**
		 * Input validation
		 * - Entering value from 0–50
		 * - validating input
		 */
		
		for(int i = 0; i < array.length; i++) {
			
			System.out.print("Enter value from 0-50: ");
			array[i] = scan.nextInt();
			
			while(array[i] < 0 || array[i] > 50) {
				System.out.print("Please input from 0-50: ");
				array[i] = scan.nextInt();
			}
		}//end of for
		
		/**
		 * Printing out array values for test
		 * - I want to see what values are here
		 */
		System.out.println("Array values: ");
		for(int view: array) {
			System.out.print(view + "\t");
		}
		
		/**
		 * Made a new array called counter
		 */
		
		int[] counter = new int[100];
		//int index = 0;
		
		System.out.println();
		
		
		for(int i = 0; i < array.length; i++) {
			//index = array[i];
			counter[array[i]]++;
			/*
			 * ...
			 * 45 - 0
			 * 46 - 0
			 * 47 - 0
			 * 48 - 0
			 * 49 - 1          // at index 49 of counter, increment by 1
			 * 50 - 0
			 * 51 - 0
			 * ...
			 * 
			 */
		}
		
		for(int i = 0; i < counter.length; i++) {
			/*
			 * The if statements inside the for loop is for printing purposes.
			 * Without, it will print out the whole entire array index,
			 * which will not look good for outputting purposes.
			 */
			
			/**
			 * Value at Index whatever, if value is greater than 0 then print
			 */
			if(counter[i] > 0) {
				System.out.println(i + " occured " + counter[i] + " time/s.");
			}
			/*
			else if(counter[i] >= 2) {
				System.out.println(i + " occured " + counter[i] + " time/s.");
			}
			*/
			
			
		}//for loop
	}
}
