package chapter3;
import java.util.Scanner;
import java.text.DecimalFormat;
/*
 * Those above shall be imported so we can use them in this code respectively
 */

/*
 * Assignment – 
 * Program an application that will read the lengths of the triangle,
 * the area of the triangle is computed using Heron's Formula
 * 
 * area = sqrt ( s (s-a) (s-b) (s-c)  )
 * 
 * s = perimeter / 2
 * a, b, c = lengths of the triangle
 * 
 * print to three decimal places
 * 
 */
public class ThreePoint3Heron {
	
	static double area = 0, perimeter = 0, a = 0, b = 0, c = 0, s =  0;
	static Scanner scan = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("0.###");
	
	public static void main(String[] args) {
		
		System.out.println("We are using Heron's Forumla to get area...");
		
		System.out.print("Please input 1st side length: ");
		a = scan.nextDouble();
		
		System.out.print("Please input 2nd side length: ");
		b = scan.nextDouble();
		
		System.out.print("Please input 3rd side length: ");
		c = scan.nextDouble();
		
		System.out.println("Calculating...");
		
		perimeter = a + b + c;
		s = perimeter / 2;
		
		area = Math.sqrt( s * (s - a) * (s - b) * (s - c) );
		
		System.out.println("The area of the triangle is: " + df.format(area));
		
		
		
	}

}
