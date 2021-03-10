package chapter4BankAccountConstructor;

public class BankAccountMain {
	
	public static void main (String bankAccount[]) {
		
		BankAccountConstructor Flexer = new BankAccountConstructor("Fadrigalan, Flexer", 323898, 4200.79);
		BankAccountConstructor Melvin = new BankAccountConstructor("Merlos, Melvin", 617480, 6000.69);
		
		double flexersMoney = Flexer.getBalance();
		double melvinsMoney = Melvin.getBalance();
		
		double avg = (flexersMoney + melvinsMoney) / 2;
		
		System.out.println(avg);
		
		/*
		 * Creating object "Flexer", these parameters are there because of constructor! Take a look!
		 */
		
		Flexer.deposit(5000);
		
		/*
		 * testing the deposit service, balance = balance + deposit;
		 */
		
		Flexer.addInterest();
		
		/*
		 * interest is 0.035, so multiply balance, and add on to it to get interest added on!
		 */
		
		System.out.println(Flexer.getBalance());
		
		/*
		 * Printing out the balance pre format!
		 */
		
		System.out.println();
		
		System.out.println(Flexer);
		
		/*
		 * .toString, this will be the automatic String output! Take a look in constructor!
		 */
	}

}
