package chapter4BankAccountConstructor;
import java.text.NumberFormat;
import java.text.DecimalFormat;

//Testings and in book exercises for me to do 

/*
 * Will be explaining, if more than a single line of comment, underneath the line of code
 */

public class BankAccountConstructor {
	
	private final double taxRate = 0.035;
	
	/*
	 * 1. private – so that the value of taxRate is encapsulated and protected, not public
	 * 2. final – so that the value of taxRate cannot be changed
	 * 3. double – value is 0.035
	 */
	
	private long accountNumber;
	private double balance;
	private String name;
	
	
	
	/*
	 * 1. "long" is used, but "int" as well as "short" may be used, can be set by user
	 * 2. Keeping these variables private so that the "main" class cannot get their hands on this
	 */
	
	public BankAccountConstructor(String name, long account, double money) {
		
		accountNumber = account;
		balance = money;
		this.name = name;
		
		/*
		 * Left hand side gets the value!
		 * The reserved word "this" can be used here as well
		 * By having these lines of code, it gives us an element when executed
		 */
		
	}
	
	public double deposit(double deposit) {
		/*
		 * it would give us an error at the beginning, TRY, it is just telling us that it needs a return value
		 * You can use the argument "deposit" as a formal parameter as it is instantiated when called in "main"
		 */
		
		balance = balance + deposit;
		
		return balance;
		
	}
	
	public double withdraw(double withdraw, double fees) {
		
		
		return balance = ((balance - withdraw) - fees);
		
		/*
		 * You can do it all in one line as well, though maybe separating them may be a little cleaner to look at
		 */
		
	}
	
	public double addInterest() {
		
		balance = balance + (balance * taxRate);
		
		return balance;
		
	}
	
	public double getBalance() {
		
		return balance;
		
	}
	
	public String toString() {
		
		DecimalFormat fmt = new DecimalFormat(".##");
		
		return (accountNumber + "\t" + name + "\t" + "$" + fmt.format(balance));
		
	}
			

}
