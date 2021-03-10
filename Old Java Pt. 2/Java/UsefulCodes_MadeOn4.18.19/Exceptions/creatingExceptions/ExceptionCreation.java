package creatingExceptions;
import java.util.Scanner;
public class ExceptionCreation {
	
	public static void main(String[] args) throws OutOfRangeException {
		
		Scanner scan = new Scanner(System.in);
		
		// predefining exception, as e.
		OutOfRangeException e = new OutOfRangeException("Out Of Range Exception...");  
		
		System.out.println("Enter number less than 10: ");  int number = scan.nextInt();
		
		if(number > 10) {
			// throwing exception
			throw e; 
		}
		
		System.out.println(number);
		
		////////////////////////
		//		Different	  //
		////////////////////////
		
		System.out.println("Enter number less than 100: ");  number = scan.nextInt();
		if(number > 100) {
			// creating object here, no predefining needed.
			throw new OutOfRangeException("Hold up, too much...");
		}
		
		System.out.println(number);
		
	}

}
