package chapter3;
import java.util.Scanner; //importing the Scanner because we will need user input
import java.text.DecimalFormat; //special, folder is text
//import java.text.NumberFormat;

/*
 * Decimal Format: java.text.DecimalFormat;
 * 
 * DecimalFormat nameOfObject = new DecimalFormat("0.###"); # = denotes how many to print
 * 
 * ––––––––––––––––––––––––––––––––––
 * 
 * Number Format: java.text.NumberFormat;
 * 
 * NumberFormat nameOfObject = NumberFormat. (getCurrencyInstance OR getPercentageInstance OR format)
 */

/*
 * Key:
 * 
 * volume = (4/3)(pi * r ^ 3)
 * surfaceArea = 4 (pi) r ^ 2
 * 
 * Print out the output to four decimal places, 
 * 
 * r denotes the radius
 */

public class ThreePoint2SphereMeasurements {
	//these are all global variables
	static double r = 0, surfaceArea = 0, volume = 0;	//variable r will denote radius
	static double value = 4/3;
	static Scanner scan = new Scanner(System.in); //scanner for user input
	static DecimalFormat dfmt = new DecimalFormat("0.####");
	//static NumberFormat nfmt = NumberFormat.getCurrencyInstance(); //playing with NumberFormat, better in financial code
	
	public static void main(String[] args) {
		
		System.out.println("We are caluclating the volume and surface area...");
		
		System.out.print("Please input value for r(radius): ");
		r = scan.nextDouble();
		
		System.out.println("Calculating...");
		volume = (value * Math.PI) * (Math.pow(r, 3)); //value = 4/3
		surfaceArea = (4 * Math.PI) * Math.pow(r, 2);
		
		System.out.println("Volume: " + dfmt.format(volume) + "\nSurface Area: " + dfmt.format(surfaceArea));
		
		
		
		
	}
	
}
