package exceptionHandling;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		
		int divideByZero = 0;
		
		try {
		divideByZero = 10/0;
		}
		catch (ArithmeticException ae) {
			System.out.println("Fool, you cannot divide by 0. \nInfinity");
		}
		
		System.out.println("Returning: " + divideByZero);
		
		
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		String code;
		char letter;
		int district, valid = 0, banned = 0;
		
		System.out.print("Enter product code or xxx to quit: ");
		code = scan.nextLine();
		
		while(!code.equalsIgnoreCase("xxx")) {
			try {
				letter = code.charAt(5);
				district = Integer.parseInt(code.substring(0, 5));
				//System.out.println(district);
				valid++;
			
				if(letter == 'F' || district > 61696) {
				banned++;
				}  // end of if
				
			}
			catch(StringIndexOutOfBoundsException e) {
				System.out.println("Input correct length...");
			}
			catch(NumberFormatException e) {
				System.out.println("Input correct values...");
			}
			
			System.out.print("Enter product code or xxx to quit: ");
			code = scan.nextLine();
			
		}  // end of while
		
		System.out.println("Valid codes entered: " + valid);
		System.out.println("Banned codes: " + banned);
		System.out.println("Exiting...");
	}

}
