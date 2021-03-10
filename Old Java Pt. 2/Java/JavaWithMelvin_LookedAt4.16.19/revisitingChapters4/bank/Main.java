package bank;

public class Main {
	
	public static void main(String[] args) {
		
		BankAccount Flexer = new BankAccount(616, "Flexer", 104513.436);
		
		String printOut = Flexer.toString();
		System.out.println(printOut);
		
		//can be one lined to Sysout(Flexer);
		/*
		 * I re-learned that if you just 
		 * used the objects name as the argument
		 * it will print out the toString
		 * information
		 */
		
		System.out.println();
		System.out.println("After spending $50,000 on stocks...");
		
		Flexer.withdraw(50000, 150);
		//withdraw: 50,000 ... Fees: 150
		
		System.out.println(Flexer.toString());
		
		System.out.println("\nAfter depositing stocks...");
		
		Flexer.deposit(100000);
		Flexer.addInterest(); //adding interest to the balance AFTER stock deposit
		System.out.println(Flexer);
		
	}

}
