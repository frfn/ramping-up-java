package ExploreExceptions;
import java.util.Scanner;
public class MultipleCatch {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int code;
		
		System.out.print("Enter number or -1 to quit: ");
		String number = scan.nextLine();
		
		while(!number.equals("-1")) {
			
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
		
	}
	
	public void inBookExample() {
		
		Scanner scan = new Scanner(System.in);
		String code;
		char letter;
		int district, valid = 0, banned = 0;
		
		System.out.print("Enter product code or xxx to quit: ");
		code = scan.nextLine();
		
		while(!code.equalsIgnoreCase("xxx")) {
			try {
				letter = code.charAt(5);  // needs to be letter at index 5
				district = Integer.parseInt(code.substring(0, 5));  // code needs to an int from index 0-5
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
