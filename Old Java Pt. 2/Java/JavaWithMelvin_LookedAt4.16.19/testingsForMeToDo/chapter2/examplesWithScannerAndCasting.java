package chapter2;
import java.util.*;

public class examplesWithScannerAndCasting {

	public static void main(String[] castingAndScanner) {
		
		int dollars;
		double cash, cents;
		
		double realAmount;
		
		Scanner scanObject = new Scanner(System.in);
		
		System.out.print("Enter money to put deposit into your bank account: ");
		cash = scanObject.nextDouble();
		
		System.out.print("Did you forget any change in your pocket? Type 0 if no: ");
		cents = scanObject.nextDouble();
		
		dollars = (int)cash + (int)cents;
		
		realAmount =  cash + cents;
		
		System.out.println("Your account with casting: " + dollars);
		
		System.out.print("Your account without casting: " + realAmount);
		
		scanObject.close();
		
	}
	
}
