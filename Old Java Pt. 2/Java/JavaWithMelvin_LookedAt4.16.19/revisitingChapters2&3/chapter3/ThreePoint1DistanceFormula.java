package chapter3;
import java.util.Scanner;

/*
 * Here we are going to compute the distance formula, underneath
 * 
 * square root ( [x2-x1]^2 + [y2-y1]^2 )
 * 
 * By using the Math class, write this in code
 * 
 */

public class ThreePoint1DistanceFormula {
	
	static Scanner scan = new Scanner(System.in); //I will see if this works
	static double x1 = 0, x2 = 0, y1 = 0, y2 = 0, distance = 0; //declared and initialized
	
	public static void main(String[] args) {
		
		System.out.println("Distance Formula calculator...");
		
		System.out.print("Please enter value for x2: ");
		x2 = scan.nextInt();
		
		System.out.print("Please enter value for x1: ");
		x1 = scan.nextInt();
		
		System.out.print("Please enter value for y2: ");
		y2 = scan.nextInt();
		
		System.out.print("Please enter value for y1: ");
		y1 = scan.nextInt();
		
		System.out.println("Computing...");
		
		distance = Math.sqrt( Math.pow( (x2-x1) , 2)  + Math.pow( (y2-y1 ), 2));
		
		System.out.println("The distance is: " + distance);
		
		
	}

}
