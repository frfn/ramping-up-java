package reDo;
import java.util.Scanner;
public class exceptions {
	
	static Scanner scan;
	
	public static void main(String[] args) {
		
		enterProductCode();
		
	}
	
	public static void divisionByZero() {
		
		scan = new Scanner(System.in);
		int number, result = 0;
		System.out.print("Enter numbers but 0: ");
		number = scan.nextInt();
		
		try {
			result = 1/number;
		}catch(ArithmeticException a) {
			System.out.println("Division by 0... error.");
		}
		
		System.out.println("Result: " + result);
		
	}
	
	public static void enterProductCode() {
		
		scan = new Scanner(System.in);
		String productCode;
		int districtCode, confirmed = 0;
		char letter;
		
		System.out.println("Enter product code or xxx to quit: ");
		productCode = scan.nextLine();
		
		while(!productCode.equals("xxx")) {
			try {
				letter = productCode.charAt(5);
				districtCode = Integer.parseInt(productCode.substring(2, 5));
				
				System.out.println(districtCode);
				System.out.println(letter);
				
				if(letter == 'A' || letter == 'F' && districtCode > 250) {
					confirmed++;
				}
				
			}catch(StringIndexOutOfBoundsException s) {
				System.out.println("Enter correct length...");
			}catch(NumberFormatException n) {
				System.out.println("Enter correct values...");
			}
			
			
			
			System.out.println("Enter product code or xxx to quit: ");
			productCode = scan.nextLine();
			
		}
		
		System.out.println("Confirmed products: " + confirmed);
		
	}
	
	
	
	
	
	

}
