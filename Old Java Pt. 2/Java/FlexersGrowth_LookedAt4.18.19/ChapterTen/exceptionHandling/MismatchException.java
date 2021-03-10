/**
 * DOES NOT work. 
 *  - You will need a validator rather than an
 *    exception handler
 */

package exceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MismatchException {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		int num;
		
		try {
		System.out.println("Enter number: ");
		num = scan.nextInt();
		}
		catch(InputMismatchException m) {
			System.out.println("Try again: ");
			num = scan.nextInt();
		}
		finally {
			System.out.println("All set...");
		}
		
		System.out.println(num);
		
		System.out.print("Enter num: ");
		num = scan.nextInt();
		while(num != -1) {
			System.out.print("Your number is: ");
			
			System.out.print("Enter num: ");
			num = scan.nextInt();
		}
		*/
		
		
		int code;
		
		System.out.print("Enter number or -1 to quit: ");
		String number = scan.nextLine();
		
		while(!number.equals("-1")) {
			
			
			/*
			try {
				number = scan.nextInt();
			}catch(InputMismatchException i) {
				System.out.println("Input correct code...");
			}
			*/
			while(number.matches("[a-z]+")) {
				System.out.print("Enter correct value: ");
				number = scan.nextLine();
			}
			
			try {
				code = Integer.parseInt(number.substring(3, 6));
			}catch(NumberFormatException n) {
				System.out.println("Code invalid...");
			}catch(StringIndexOutOfBoundsException s) {
				System.out.println("Enter correct length...");
			}

			System.out.print("Enter number or -1 to quit: ");
			number = scan.nextLine();
		}
		
		char productLetter;
		int productNumber, banned = 0;
		
		
		System.out.print("Enter product code, -1 to quit: ");
		String productCode = scan.nextLine();
		
		while(!productCode.equals("-1")) {
		
				try {
				productLetter = productCode.charAt(4);
				productNumber = Integer.parseInt(productCode.substring(5, 9));
				
				if(productLetter == 'N') {
					banned++;
				}
				
				}catch(StringIndexOutOfBoundsException e) {
					
					System.out.println("Enter correct code...");
					
				}
				catch(NumberFormatException e) {
					System.out.println("Enter correct code...");
				}
			
				System.out.print("Enter product code, -1 to quit: ");
				productCode = scan.nextLine();
				
		}
		
		
		
	}
}
