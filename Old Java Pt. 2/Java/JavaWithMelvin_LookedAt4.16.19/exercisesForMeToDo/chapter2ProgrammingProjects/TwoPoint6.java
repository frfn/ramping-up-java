package chapter2ProgrammingProjects;
import java.util.Scanner;

//create an application that will print out hours, minutes and
//seconds to just seconds

public class TwoPoint6 {
	
	public static void main(String [] time) {
		
		Scanner scannerObject = new Scanner(System.in);
		
		final int baseNumber = 60;
		
		double HOURS, MINUTES, SECONDS;
		double CONVERTHOURS, CONVERTMINUTES;
		
		System.out.print("Enter hours: ");
		HOURS = scannerObject.nextDouble();
		
		System.out.print("Enter minutes: ");
		MINUTES = scannerObject.nextDouble();
		
		System.out.print("Enter seconds: ");
		SECONDS = scannerObject.nextDouble();
		
		CONVERTHOURS = HOURS * baseNumber * baseNumber;
		CONVERTMINUTES = MINUTES * baseNumber;
		
		System.out.print("Your total for " + HOURS + " hours, " + MINUTES 
				+ " minutes, " + SECONDS + " seconds, in seconds is: " +
				(CONVERTHOURS + CONVERTMINUTES + SECONDS));
		
		/*
		 * 
		 * Another solution at the bottom, creative thinking!
		 * I had the thought of using actual numbers such as
		 * 3600 because that is how many seconds it is in an hour,
		 * 60 because that is how many seconds in a minutes!
		 * 
		 * By using those numbers, I had another way to solve the issue!
		 * 
		 * 8/2 August 2018
		 * 
		 */
		final int hour = 3600;
		final int minutes = 60;
		//final int seconds = 1;
		
		double num1, num2, num3;
		
		
		System.out.print("\n\nEnter hours: ");
		num1 = scannerObject.nextDouble();
		
		System.out.print("Enter minutes: ");
		num2 = scannerObject.nextDouble();
		
		System.out.print("Enter seconds: ");
		num3 = scannerObject.nextDouble();
		
		double convertHours = num1 * hour;
		double convertMinutes = num2 * minutes;
		
		System.out.print("The value of time in seconds will be: " + (convertHours + convertMinutes + num3));
		scannerObject.close();
	}

}
