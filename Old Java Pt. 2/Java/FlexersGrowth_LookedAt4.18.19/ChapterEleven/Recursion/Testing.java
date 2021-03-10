package Recursion;
import java.util.Scanner;
public class Testing {
	
	public static void main(String[] args) {
		
		double value = recursive(4);
		
		System.out.println("Value: " + value);
		
		/*
		 * Scanner scan = new Scanner(System.in); System.out.print("Enter base: "); int
		 * base = scan.nextInt();
		 * 
		 * System.out.print("Enter power: "); int power = scan.nextInt();
		 * 
		 * int result = 1;
		 * 
		 * for(int i = 1; i <= power; i++) { result = result * base; }
		 * 
		 * System.out.println(result);
		 */
		
		int print = pow(2, 3);
		System.out.println(print);
		
	}
	
	public static double recursive(double num) {
		
		if(num == 1) {
			/**
			 * return 1?
			 * 	- Because this method NEEDS to return a value
			 *  - Why 1? Because num * 1 will be the base the case, it needs to multiply with 1!
			 *  - Image recursive(4)
			 *  	- 4 * 3
			 *  		= 12
			 *  	- 12 * 2
			 *  		= 24
			 *  	- 24 * 1 	<-- that one came from here
			 *  		= 24
			 */
			return 1;  // <-- right here!
		}
		else {
			return num * recursive(num-1);
			
		}
		
	}
	
	public static int pow(int x, int y) {
		
		int result;
		
		if(y == 0) {
			result = 1;
		}
		else {
			result = x * (pow(x, y - 1));
		}
		
		return result;
		
	}

}
