package chapter2ProgrammingProjects;
import java.util.Scanner;

//An application that asks the users what kind of coins are in the jar
/*
 * Shall be able to print the total in dollars and cents 
 */

public class TwoPoint8 {

	public static void main(String[] coin) {
		
		Scanner object = new Scanner(System.in);
		
		final double QUARTER = .25;
		final double DIME = .10;
		final double NICKEL = .05;
		final double PENNY = .01;
		
		int quarterCount, dimeCount, nickelCount, pennyCount;
		
		double totalQuarter, totalDime, totalNickel, totalPenny;
		
		System.out.print("Enter amount of quarter/s in jar: ");
		quarterCount = object.nextInt();
		totalQuarter = quarterCount * QUARTER;
		
		System.out.print("Enter amount of dime/s in jar: ");
		dimeCount = object.nextInt();
		totalDime = dimeCount * DIME;
		
		System.out.print("Enter amount of nickel/s in jar: ");
		nickelCount = object.nextInt();
		totalNickel = nickelCount * NICKEL;
		
		System.out.print("Enter amount of penny/ies in jar: ");
		pennyCount = object.nextInt();
		totalPenny = pennyCount * PENNY;
		
		System.out.print("The amount of altogether: $" + (totalQuarter + totalDime + totalNickel + totalPenny));
		
		/*
		 * SEE IF YOU CAN CREATE A REVISED VERSION, if you have 999 pennies, how many is that in dollars
		 */
		
		object.close();
		
	}
}
