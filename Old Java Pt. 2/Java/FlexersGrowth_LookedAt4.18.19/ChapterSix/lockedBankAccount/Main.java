package lockedBankAccount;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
		
		int choice = 0;
		/**
		 * @param name
		 * @param balance
		 * @param pin
		 * @param accountNum
		 */
		
		System.out.println("Welcome!");
		System.out.println("Please make bank account...");
		
		System.out.print("Full Name: ");
		String name = scan.nextLine();
		/*
		System.out.print("Balance: ");
		double balance = scan.nextDouble();
		
		System.out.print("Pin: ");
		int pin = scan.nextInt();
		
		
		System.out.print("Account Number: ");
		int actNum = scan.nextInt();
		
		System.out.println();
		
		BankAccount flexer = new BankAccount(name, balance, pin, actNum);
		*/
		
		BankAccount flexer = new BankAccount(name);
		/**
		 * Using the constructor that will only take String as parameter
		 * 	- Name in this case
		 */
		
		//System.out.println(flexer);
		//System.out.println(flexer.locked());
		/*	
		System.out.println("--------------------");
		
		System.out.println("Pin: "+flexer.getPin());
		System.out.println("Account Number: "+flexer.getAccountNum());
		
		System.out.println("--------------------");
		*/
		
		/**
		 * Very text GUI:
		 *  - Uses integer value
		 *  - Has input validation so user will be asked for correct value
		 *  - Heavily relies on "if", "else-if" statements
		 */
		
		while(choice != -1){
			System.out.println();
		System.out.println("Menu");
		System.out.println("1. Lock Account"+"\n2. Unlock Account"+"\n3. Status"+"\n4. Use Account"+"\n5. Show Object"+"\n6. -1 to Quit");
		
		System.out.print("Enter selection: ");
		choice = scan.nextInt();
		
		while(choice > 5 && choice < 1) {
			System.out.print("Enter correct selection: ");
			choice = scan.nextInt();
		}
		
		if(choice == 1) {
			
			if(flexer.locked() == true) {
				System.out.println("Account is already locked...");
			}
			
			if(flexer.locked() == false) {
				System.out.print("Please enter pin to lock account or -1 to Cancel: ");
				int lock = scan.nextInt();
			
				while(lock != -1) {
				
					if(lock != flexer.getPin()) {
						System.out.print("Try again: ");
						lock = scan.nextInt();
					}
				
					if(lock == flexer.getPin()) {
						flexer.lock(lock);
						System.out.println("Account has been locked...");
						lock = -1; //forced stopping
					}
				}
			}
		}
		
		if(choice == 2) {
			
			if(flexer.locked() == false) {
				System.out.println("Account is already unlocked...");
			}
			
			if(flexer.locked() == true) {
				System.out.print("Please enter pin to unlock account or -1 to Cancel: ");
				int lock = scan.nextInt();
			
				while(lock != -1) {
				
					if(lock != flexer.getPin()) {
						System.out.print("Try again: ");
						lock = scan.nextInt();
					}
				
					if(lock == flexer.getPin()) {
						flexer.unlock(lock);
						System.out.println("Account has been unlocked...");
						lock = -1;
					}
				}
			}
		}
		
		if(choice == 3) {
			System.out.println();
			System.out.println("Account Lock Status: "+flexer.locked());
		}
		
		if(choice == 4) {
			
			if(flexer.locked() == true) {
				System.out.println("Account locked, unlock first...");
			}
			
			if(flexer.locked() == false) {
				System.out.println();
				System.out.println("Information Change Menu ");
				System.out.println("1. Withdraw"+"\n2. Deposit"+"\n3. Change PIN"+"\n4. Change Balance(test only)"+"\n5. Show Balance"+"\n6. -1 to Quit");
				System.out.print("Enter choice: ");
				int infoChoice = scan.nextInt();
				
				while(infoChoice > 5 && infoChoice < 1) {
					System.out.print("Enter correct selection: ");
					infoChoice = scan.nextInt();
				}
				
				while(infoChoice != -1){
					
					if(infoChoice == 1) {
						
						if(flexer.getBalance() <= 0) {
							System.out.println("Balance: $0");
						} else {
							System.out.print("Enter to money to withdraw: ");
							double withdraw = scan.nextDouble();
							
							System.out.println("Withdrawing $"+withdraw+ " from "+flexer.getBalance());
							flexer.withdraw(withdraw, 0);
						}		
					}
					
					if(infoChoice == 2) {
						
						System.out.print("Depositing: ");
						int deposit = scan.nextInt();
						
						if(deposit <= 0) {
							System.out.println("You deposited $0");
						}
						else {
							flexer.deposit(deposit);
						}
						
					}

					if(infoChoice == 3) {
						System.out.print("To change PIN, enter again or -1 to Quit: ");
						int changePin = scan.nextInt();
						
						while(changePin != -1) {
							
							if(changePin != flexer.getPin()) {
							System.out.print("Try again or -1 to quit: ");
							changePin = scan.nextInt();
							}
							
							if(changePin == flexer.getPin()) {
							System.out.print("Change PIN: ");
							changePin = scan.nextInt();
							
							flexer.setNewPin(changePin);
							flexer.setKey(changePin);
							flexer.unlock(changePin); 
							}
							
							changePin = -1;
							
						}
					}

					if(infoChoice == 4) {
						System.out.print("Enter balance: ");
						double balance = scan.nextDouble();
						
						flexer.setNewBalance(balance);
					}
					
					if(infoChoice == 5) {
						System.out.println("Balance: " + flexer.getBalance());
					}
					
					System.out.println("Information Change Menu: ");
					System.out.println("1. Withdraw"+"\n2. Deposit"+"\n3. Change PIN"+"\n4. Change Balance(test only)"+"\n5. Show Balance"+"\n6. -1 to Quit");
					System.out.print("Enter choice: ");
					infoChoice = scan.nextInt();
					
				}//end of while
				
			}
			
		}// end of selection 4

		if(choice == 5) {
			System.out.println();
			System.out.print(flexer);
			System.out.println();
		}

			
		}
		
		System.out.println("Logged out...");
		
	}

}
