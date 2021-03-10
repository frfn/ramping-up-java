package constructorTesting;

public class BankAccount {
	
	private String name;
	private double balance;
	private int pin;
	private int accountNum;
	private final double massTax = 0.0625;
	
	/**
	 * Constructor 1: Building a constructor
	 * @param name
	 * @param balance
	 * @param pin
	 * @param accountNum
	 */
	
	//---------------
	//	 * Scenario:
	//   * Probably here, they are a full account
	//---------------
	public BankAccount(String name, double balance, int pin, int accountNum) {
		this.name = name;
		this.balance = balance;
		this.pin = pin;
		this.accountNum = accountNum;
	}
	
	/**
	 * Constructor 2: Overloading example
	 * @param name
	 * @param pin
	 * @param accountNum
	 */
	
	
	//---------------
	//   * Probably here, they are just starting an account
	//---------------
	public BankAccount(String name, int pin, int accountNum) {
		this.name = name;
		this.pin = pin;
		this.accountNum = accountNum;
	}
	
	/**
	 * Constructor 3
	 * @param amount
	 * @return
	 * 
	 * public BankAccount() {
		this(name, pin, accountNum);
	   } 
	 */
	
	

	public double deposit(double amount) {
		return balance += amount;
	}
	
	public double withdraw(double amount, double fees) {
		return balance -= (amount + fees);
	}
	
	public double addInterest() {
		return balance += (balance*massTax);
	}

	public double getBalance() {
		return balance;
	}
	
	public double getPin() {
		return pin;
	}
	
	public double getAccountNum() {
		return accountNum;
	}
	
	public void setNewBalance(double newBalance) {
		balance = newBalance;
	}
	
	public void setNewPin(int newPin) {
		pin = newPin;
	}
	
	

}
