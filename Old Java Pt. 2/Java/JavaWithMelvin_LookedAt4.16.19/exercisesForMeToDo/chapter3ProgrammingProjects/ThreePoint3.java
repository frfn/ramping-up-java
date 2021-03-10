package chapter3ProgrammingProjects;
/*
 * Reading the problem I had no idea what it meant
 * Went on Google to find out that Heron's Formula,
 * you would need to find the perimeter and divide by 2.
 * "half of the perimeter of the triangle"
 */

import java.util.Scanner;
import java.text.DecimalFormat;


public class ThreePoint3 {
	
	public static void main(String[] heronsFormula) {
		
		double a, b, c, area, s;		//s represents the half perimeter
		
		DecimalFormat format = new DecimalFormat("0.###");
		
		Scanner object = new Scanner(System.in);
		
		System.out.println("This is the Heron's Formula calculator!");
		System.out.println("Please input all three side lenghts of triangle below...");
		
		System.out.print("Side A: ");
		a = object.nextDouble();
		
		System.out.print("Side B: ");
		b = object.nextDouble();
		
		System.out.print("Side C: ");
		c = object.nextDouble();
		
		//To calculate halfPerimeter , add all side lengths and then divide by 2
		s = (a + b + c) / 2;
		
		//To calculate the area, all one one line of code, lengthy formula!
		/*
		 * sqrt((S)(S-A)(S-B)(S-C))
		 */
		
		area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
		
		System.out.println();
		System.out.println(a + " + " + b + " + " + c + " = " + (a + b + c));
		System.out.println("Half of the perimeter: " + s);
		System.out.println("Applying Heron's Formula: " + format.format(area));
		
		object.close();
		
		
	}

}
