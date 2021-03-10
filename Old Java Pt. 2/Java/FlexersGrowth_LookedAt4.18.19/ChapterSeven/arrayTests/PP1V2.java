package arrayTests;
import java.util.InputMismatchException;
import java.util.Scanner;
public class PP1V2 {
	
	static Scanner scan;
	
	public static void main(String[] args) {
		
		usingForLoop();
		
	}
	
	public static void usingForLoop() {
		
		/**
		 * Limited amount
		 *  - for loop
		 *  - 10 inputs
		 *  - range of 0 to 50
		 */
		
		int tries = 10;
		String value;
		
		int[] list = new int[51];  // index 0 - 50
		
		scan = new Scanner(System.in);

		// initializing all values to 0;
		for(int i=0 ; i < list.length ; i++) {
			list[i] = 0;
		}
		
		
				
		for(int i = 0; i <= tries; i++) {
		
			System.out.println("Enter value: ");
			value = scan.nextLine();
			
			while(value.matches("[a-zA-Z_]+")) {  // use of RegEx 
				System.out.println("Enter correct value: ");
				value = scan.nextLine();
			}
			
			try {
			list[Integer.parseInt(value)]++;
			}
			catch(ArrayIndexOutOfBoundsException a) {
				System.out.println("Value is out of bounds... increasing 0");
				list[0]++;
			}
		}
		
		for(int i=0; i<list.length; i++) {
			if(list[i] > 0) {
				System.out.println(i + " : " + list[i]);
			}
		}
		
	}
	
	public static void usingWhileLoop() {
		
		/**
		 * An arbitrary amount
		 * 	- while loop
		 * 
		 */
		
		scan = new Scanner(System.in);
		
		int[] list = new int[51];  // index 0 - 50
		
		// initializing all values to 0;
		for(int i=0 ; i < list.length ; i++) {
			list[i] = 0;
		}
		
		System.out.println("Enter numbers, to quit enter less than 0 or greater than 50: ");
		int value = scan.nextInt();
		
		while(value >= 0 && value <= 50) {
			list[value]++;	
			
			System.out.println("Enter numbers, to quit enter less than 0 or greater than 50: ");
			value = scan.nextInt();
		}
		
		
		for(int i=0; i<list.length; i++) {
			if(list[i] > 0) {
				System.out.println(i + " : " + list[i]);
			}
		}
	}

}
