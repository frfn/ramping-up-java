package chapter3ProgrammingProjects;
/*
 * Write an application that reads the radius of a sphere 
 * and print its
 * VOLUME and SURFACE AREA
 * Decimal Value to fourth decimal
 * 
 * r represents radius
 * 
 * Volume = (4/3)((pi * r)^3)
 * 
 * Surface Area = (4)((pi * r)^2)
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class ThreePoint2 {
	
	public static void main(String[] sphere) {
		
		System.out.println("Volume and Surface Area calculator!");
		System.out.print("What is the value of r? (Radius): ");
		
		Scanner object = new Scanner(System.in);
		
		double r, surfaceArea, volume, valueHolder;
		
		valueHolder = 4/3;	//Will be easier to keep track when using with formula
		
		DecimalFormat format = new DecimalFormat("0.####"); 	//created a decimal format so that the print will be four values to the right
		
		r = object.nextDouble();
		
		//next two line of codes, I went ahead and got it formulated so that it will get the value
		
		surfaceArea = valueHolder * (Math.pow((Math.PI * r), 3));
		
		volume = 4 * (Math.pow((Math.PI * r), 2));
		
		System.out.println("r = " + r);
		System.out.println("Surface area of sphere from radius will be: " + format.format(surfaceArea));
		System.out.println("Volume of sphere from radius will be: " + format.format(volume));
		
		object.close();
	}

}
