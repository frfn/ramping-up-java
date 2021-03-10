package bank;
import java.text.NumberFormat;
public class BankAccount {
	
	/*
	 * Past code, looks like 4 variables declared,
	 * taxRate initialized to 0.035;
	 * taxRate was commented because
	 * I guess it is a complex line.
	 */
	
	////////////////////////
	//	Global variables  //
	////////////////////////
	
	private final double taxRate = 0.035;
	private long accountNumber;
	
	/*
	 * Eight primitive data types (starting from smallest value)
	-	Byte
	-	Short 
	-	Int
	-	Long
	-	Float
	-	Double
		o	All these are able to casted when to code, examine exercise, AS WELL AS 
		o	double   example   =   1.0202D
	-	Character
		o	Character literals can be invoked by char = ‘a’; or any valid character
				String literals are in double quotes remember?
		o	Control characters are sometimes called nonprinting or invisible characters because they do not have a symbol to represent them
			Unicode character set, 16 bits per character supporting 65,546 unique characters
	-	Boolean
		o	Only has two values: true or false
		o	Used for representing any situation that two states, true or false
		o	Invoked by boolean   flag    =    true;
	 *
	 */
	private double balance;
	private String name;
	
	public BankAccount(long accountNumber, String name, double balance) {
		/*
		 * Constructor: important!
		 * Necessary to input information respectively,
		 * your account number, your name, then your balance
		 */
		this.accountNumber = accountNumber;
		
		//the order does not NEED to in order.
		this.balance = balance; 
		this.name = name;
		
	}
	
	public double deposit(double deposit) {
		//formal parameter VS actual parameter
		//formal parameter INSTANTIED from actual parameter
		
		//balance = balance + deposit;
		/*
		 * Commented out because I saw that it 
		 * can be shortened
		 */
		balance += deposit;
		return balance;
	}
	
	public double withdraw(double withdraw, double fees) {
		
		balance -= withdraw; //balance = balance - withdraw
		balance -= fees; //balance = balance - fees
		
		
		return balance;
		
	}
	
	public double addInterest() {
		balance += (balance*taxRate);
		//balance = balance + (balance*taxRate);
		
		return balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		/*
		 * Looks like here, I had a DecimalFormat before
		 * I think the getCurrency from NumberFormat 
		 * will be better
		 */
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return    "Account Number: " + accountNumber
				+ "\nAccount Holder: " + name
				+ "\nBalance: "        + fmt.format(balance);
		
	}
	
}	
