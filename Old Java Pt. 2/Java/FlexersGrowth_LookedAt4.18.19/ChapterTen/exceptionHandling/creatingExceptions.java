package exceptionHandling;
import java.util.Scanner;
public class creatingExceptions {
	
	static Scanner scan;
	
	public static void main(String[] args) throws OutOfRangeException {
		scan = new Scanner(System.in);
		
		OutOfRangeException exception1 = 
				new OutOfRangeException("Value is out of range...");
		
		System.out.println("Enter number less than 100: ");
		int number = scan.nextInt();
		
		
		if(number > 100) {
			throw exception1;
		}
		
		System.out.println("Number: " + number);
		
		tryCatch();
		
	}
	
	public static void tryCatch() {
		
		scan = new Scanner(System.in);
		
		System.out.println("Enter number greater than 100: ");
		int number = 0;
		
		try {
			number = scan.nextInt();
			
			if(number < 100) {
				throw new OutOfRangeException("Number is less than 100...");
			}
			
		}catch(OutOfRangeException o) {
			System.out.println("Value is less than 100");
			//o.printStackTrace();
		}
		System.out.println("Your number: " + number);
	}

}
