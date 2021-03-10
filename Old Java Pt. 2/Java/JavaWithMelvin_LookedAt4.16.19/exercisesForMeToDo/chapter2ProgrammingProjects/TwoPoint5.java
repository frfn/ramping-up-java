package chapter2ProgrammingProjects;
import java.util.Scanner;

//Application to convert miles to kilometers, 1 mile = 1.60935 kilometers

public class TwoPoint5 {
	
	public static void main(String[] mileToKM) {
		
		final double KILOMETER = 1.60935;
		double MILES_INPUT, CONVERTED_VALUE;
		
		Scanner scannerObject = new Scanner(System.in);
		
		System.out.print("Enter mile/s to convert to kilometer: ");
		MILES_INPUT = scannerObject.nextDouble();
		
		CONVERTED_VALUE = MILES_INPUT * KILOMETER;
		
		System.out.println("Miles to be converted : " + MILES_INPUT);
		System.out.println("Converted to Kilometers: " + CONVERTED_VALUE);
		
		scannerObject.close();
	}

}
