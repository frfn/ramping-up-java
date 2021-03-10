package constructorTesting;
import java.text.NumberFormat;
/**
 * Constructor 1: Building a constructor
 * @param name
 * @param balance
 * @param pin
 * @param accountNum
 * 
 * Constructor 2: Overloading example
 * @param name
 * @param pin
 * @param accountNum
 */

public class Main {
	
	public static void main(String[] banking) {
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		BankAccount flexer = new BankAccount("Flexer Fadrigalan", 450.73, 0000, 61696);
		BankAccount nicole = new BankAccount("Nicole Stanton", 231.43, 0001, 12395);
		BankAccount melvin = new BankAccount("Melvin Merlos", 1034.32, 0010, 35441);
		
		//Combining Flexer's and Nicole's account
		double combined = flexer.getBalance() + nicole.getBalance();
		
		System.out.println("Combined balance: " + fmt.format(combined));
		
		//Flexer gets new job, adjusted balance
		
		flexer.setNewBalance(10000);
		
		System.out.println("Flexer's new balance: " + fmt.format(flexer.getBalance()));
		
	}

}
