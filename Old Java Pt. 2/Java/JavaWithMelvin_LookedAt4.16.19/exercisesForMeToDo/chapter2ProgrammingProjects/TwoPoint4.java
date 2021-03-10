package chapter2ProgrammingProjects;
import java.util.Scanner;

//Revised the TempConvertor so that it will take user input

public class TwoPoint4 {

	public static void main(String[] converter) {
		
		Scanner scannerObject = new Scanner(System.in);
		
		final int BASE = 32;
		final double CONVERSION_FACTOR = 9.0 / 5.0;
		
		double fahrenheitTemp;
		
		System.out.print("Enter celsius temperature to convert: ");
		int celsiusTemp = scannerObject.nextInt();
		
		fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;
		
		System.out.println("Celsius temperature: " + celsiusTemp);
		System.out.println("Fahrenheit temperature: " + fahrenheitTemp);
		
		scannerObject.close();
	}
	
}
