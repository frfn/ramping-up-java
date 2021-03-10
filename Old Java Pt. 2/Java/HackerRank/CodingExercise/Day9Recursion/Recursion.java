package Day9Recursion;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		int print = factorial(num);
		
		System.out.println(print);
		
		scan.close();
		
		
	}
	
	public static int factorial(int num) {  // it needs to be an int so that it can call the last number calculated, a recursion!
		if  (num <= 1) {
			return 1;
		}
		else {
			return (num * factorial(num-1));
		}
		
		
		/**
		 * return (n > 1) ? num * factorial(num-1) : 1;
		 */
	}
	
}
