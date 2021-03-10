package chapter2;
import java.util.*;
public class TwoPoint3Floaters {
	
	static Scanner scan;
	static float num, num2, total, product, quotient, difference;
	
	public static void main(String[] args) {
		
		
		scan = new Scanner(System.in);
	
			System.out.print("Enter float 1: ");
			num = scan.nextFloat();
			
			System.out.print("Enter float 2: ");
			num2 = scan.nextFloat();
			
			total = num + num2;
			product = num * num2;
			quotient = num / num2;
			difference = num - num2;
			
			
		
		
		System.out.println("Your total is: " + total);
		System.out.println("Your product is: " + product);
		System.out.println("Your difference is: " + difference);
		System.out.println("Your quotient is: " + quotient);
		
	}

}
