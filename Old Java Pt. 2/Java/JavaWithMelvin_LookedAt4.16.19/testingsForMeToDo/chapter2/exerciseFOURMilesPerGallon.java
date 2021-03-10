package chapter2;
import java.util.Scanner;

public class exerciseFOURMilesPerGallon {

	public static void main(String[] mpg) {
		
		Scanner scannerObject = new Scanner(System.in);	//created a scannerObject
		
		int miles;	//declared miles as an int
		double gallons, milesPerGallon;	//declated gallons and milesPerGallon
		
		System.out.print("Enter number of miles: ");		//outputting Enter number of miles
		miles = scannerObject.nextInt();					//reading user input
		
		System.out.print("Enter number of gallons used: ");  	//outputting Enter number of gallons used
		gallons = scannerObject.nextDouble();				//reading user input
		
		milesPerGallon	 = 	miles	 /	 gallons;		//milesPerGallon will calculate user input of miles and gallon
		
		System.out.print("The miles per gallon of the car is: " + milesPerGallon); 	//Will output string literal 
																					//and milesPerGallon value
		
	}
	
}
