package chapter2;
import java.util.Scanner;
public class TwoPoint4TempConverter {
	
	static final int base = 32;
	static final double convert = 9/5;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("We are converting Fahrenheit to Celsius: ");
		double fahrenheit = scan.nextDouble();
		
		double celsius = (fahrenheit * convert) + base;
		
		System.out.println("Your temperature in celsius is: " + celsius);
		
		scan.close();
	}

}
