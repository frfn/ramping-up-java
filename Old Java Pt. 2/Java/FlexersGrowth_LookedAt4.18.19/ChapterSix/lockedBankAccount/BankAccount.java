package lockedBankAccount;
import java.text.DecimalFormat;
import java.util.Random;

public class BankAccount implements Lockable {
	
	static DecimalFormat fmt = new DecimalFormat("######."); //Formatter
	static Random gen = new Random(); //Random Generator
	
	
	private String name;
	private double balance;
	private int pin;
	private int accountNum;
	//private int key;
	private boolean lock;
	
	/**
	 * 5 Fields: 
	 * - @param lock
	 * - @param name
	 * - @param balance
	 * - @param pin
	 * - @param accountNum
	 */
	
	public BankAccount(String name, double balance, int pin, int accountNum) {
		this.name = name;
		this.balance = balance;
		
		pin = Integer.parseInt(fmt.format(pin));
		//formatting the PIN to output correctly, will become String, need to become integer value
		
		this.pin = pin;
		
		accountNum = Integer.parseInt(fmt.format(accountNum));
		//formatting this as well
		
		this.accountNum = accountNum;
	}
	
	//I could have used a this(parameter...) to make it easier
	public BankAccount(String name) {
		/**
		 * Test Case:
		 * 	- If user just puts name parameter
		 *  - Will have 0 balance
		 *  - PIN and accountNum will be given
		 */
		
		this.name = name;
		balance = 0;
		double pinNumber = gen.nextInt(9999)+1;
		pin = (int)pinNumber;
		double accntNum = gen.nextInt(999999)+1;
		accountNum = (int)accntNum;
		
	}
	
	/** 
	 * From interface Lockable: 
	 * --------------------------
	 * All methods in an interface NEEDS to be used. If not, error. 
	 * 	- You can set initialize them and not have them do anything
	 * 
	 * An imaginary key:
	 * 	- It is controlled by a boolean value
	 * 
	 * setKey()
	 * 	- Just sets the PIN/Key, in this case, this is the same thing
	 * 
	 * lock()
	 *  - Boolean value "lock" is set to true
	 *  
	 * unlock()
	 *  - "lock" is set to false
	 *   
	 * locked()
	 *  - returns status if account is unlocked or locked
	 *    
	 *   
	 */
	
	public void setKey(int key) {
		pin = key;
		
	}
	public void lock(int key) {
		if(pin == key) {
			lock = true;
		}
	}
	public void unlock(int key) {
		if(pin == key) {
			lock = false;
		}
	}
	
	public boolean locked() {
		return lock;
	}
	
	/**
	 *Banking methods below
	 */
	public double deposit(double amount) {
		return balance += amount;
	}
	
	public double withdraw(double amount, double fees) {
		return balance -= (amount + fees);
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

	public String toString() {
		return "Name: "+name+"\nAccount Number: "+accountNum+"\nBalance: "+balance+"\nPin: "+pin;
	}
	
}
