package chapter2;
import java.util.Scanner;
public class TwoPoint5Convert {

	static final double kilometers = 1.60935;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter miles to convert to kilometer: ");
		int miles = scan.nextInt();
		
		double converted = miles * kilometers;
		
		System.out.println("You inputed " + miles + " miles.");
		System.out.println("Converted to kilometers: " + converted);
		
	}
	
}
