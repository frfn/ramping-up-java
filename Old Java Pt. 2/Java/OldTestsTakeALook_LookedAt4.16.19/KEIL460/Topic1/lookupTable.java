/*
Flexer Fadrigalan
Coding Exercise for Topic 1
Professor Keil
460 -- ToC
*/
package Topic1;
import java.util.*;

public class lookupTable {

	public static void main(String flex[]) {
		
		Scanner scan = new Scanner(System.in);
		
		boolean validation;
		
		System.out.println("We are going to use the 'and' operater.( Propositional logic P AND Q. )\n");
	//	System.out.print("Please enter first 0 or 1 number: ");
	//	int num1 = scan.nextInt();
		
		//first number
		
	int num1;
		//	if(num1 > 1 || num1 < 0) {
		do {
			System.out.print("Enter first 0 or 1: ");
			num1 = scan.nextInt();
		}while(num1 > 1 || num1 < 0);
	//	}
		
		//second number
		
		System.out.print("Please enter second 0 or 1 number: ");
		int num2 = scan.nextInt();
		
		if(num2 > 1 || num2 < 0) {
			do {
				System.out.print("Enter 0 or 1: ");
				num2 = scan.nextInt();
			}while(num2 > 1 || num2 < 0);
			}
		
		System.out.println("\n" + and(num1, num2) + " value");
		
	}
	
	
	public static boolean and(int a, int b) {
		if(a == 1 && b ==1) {
			return true;
		}else
			
		return false;
		
		
	}
	
	
}
