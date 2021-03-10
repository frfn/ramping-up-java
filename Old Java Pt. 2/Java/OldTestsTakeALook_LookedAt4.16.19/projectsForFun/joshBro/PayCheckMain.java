package joshBro;
//import java.util.Scanner;
public class PayCheckMain {
	
	public static void main(String args[]) {
		
	//	Scanner scan = new Scanner(System.in);
		
		PayCheckConstructor Josh = new PayCheckConstructor("Josh", 18, 9);
		
		float cashFlow = Josh.getHours() * Josh.getWage();
		
		System.out.println("Josh worked for: " + Josh.getHours() + " hrs.");
		System.out.println("Josh's wage is: " + Josh.getWage() + " dollars.");
		System.out.print("He makes " + cashFlow + " pretax, but makes " + deductedTax(cashFlow) + " after taxes.");
		
		
	//	scan.close();
	}
	
	public static float deductedTax(float totalAmount) {
		
		float taxRate = 0.0625f;
		float federalRate = 0.0515f;
		
		float taxes = totalAmount * taxRate;
		float fedTaxes = totalAmount * federalRate;
		
		float combinedTaxes = taxes + fedTaxes;
		
		
		float taxed = totalAmount - combinedTaxes;
		
		return taxed;
		
	}

}
