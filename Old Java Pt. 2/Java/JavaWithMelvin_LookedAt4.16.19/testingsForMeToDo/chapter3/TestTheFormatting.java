package chapter3;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;


public class TestTheFormatting {
	
	/*
	 * First one demonstrates the Number Format, in this case
	 * the Percentage and Dollar values – how it is implemented
	 * and how it is used.
	 * 
	 * Note: you do not have to put "new" ( a constructor ) to
	 * make get formatting to be different.
	 * 
	 * Second one will demonstrate the Decimal Format and how
	 * it is instantiated and created.
	 * 
	 * Note: you NEED to have "new" to get the formatting 
	 * to be what you wanted
	 */
	
	public static void main(String[] format) {
		
		final double TAX_RATE = 0.0625;		//MASSACHUSETTS TAX
		final double iPhoneX64 = 999;		//Price of the item
		
		Scanner object = new Scanner(System.in);	//scanner object created
		
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();		//Currency, so this will be the dollar value format
		NumberFormat fmt2 = NumberFormat.getPercentInstance();		//Percent, so this will be the percent value format
		
		int buyInBulk;		//Declared buyInBulk variable, will be the quantity 
		
		double subTotal, taxes;	//subTotal for total prices 
								//taxes for the taxes on the product (buyInBulk * iPhoneX64) * TAX_RATE;
		
		System.out.println("-- The Number Foramt -- ");
		System.out.println();
		System.out.println();
		
		System.out.println("Welcome To My iPhone Shop!");								//creating a shop like environment
		System.out.println("-----------------------------");							//separator for the title
		System.out.print("Enter number of iPhone X's (64 GB) you would want: ");		//printing out the string
		
		buyInBulk = object.nextInt();		//user will input how many products he/she will buy
		
		System.out.println();
		System.out.println("Thank you, calculating now with taxes!");
		System.out.println();
		
		taxes = (iPhoneX64 * buyInBulk) * TAX_RATE;		//to get taxes of the product
		subTotal = (iPhoneX64 * buyInBulk) + taxes;		//to get total of the product
		
		System.out.println("Quantity of product: " + buyInBulk);								//print the quantity that the user wants
		System.out.println("Product is: " + fmt1.format(iPhoneX64));							//how much the product will be
		System.out.println("Tax percent on product will be: " + fmt2.format(TAX_RATE));		//taxes for Massachusetts	
		System.out.println("Taxes on product will be: " + fmt1.format(taxes));				//how much taxes will be
		System.out.println("Full price of product/s will be: " + fmt1.format(subTotal));		//how much in total for everything
		
		System.out.println();
		System.out.println();
		System.out.println("-- The Decimal Format --");
		System.out.println();									//this whole block of code is for getting ready
		System.out.println();									//the next method call
		
		theDecimalFormat();						//method call, it will call the "theDecimalFormat"
		
		object.close();
		
	}
	
	public static void theDecimalFormat() {			//method "theDecimalFormat"
		
		int radius;						//variable declared as radius 
		double area, circumference;		//variables declared as area and circumference
		
		Scanner object = new Scanner(System.in);		//Scanner object created
		
		DecimalFormat fmt = new DecimalFormat(".##");		//Explain!, this will round to the third decimal number
		
		System.out.println("Getting the circle's Area and Circumference from radius!");
		System.out.println("--------------------------------------------------------");
		
		System.out.print("Enter radius: ");
		radius = object.nextInt();		//user input
		
		area = Math.PI * Math.pow(radius, 2);		//using Math class fot PI and the exponent (Math.pow(radius, 2))
		
		circumference = ( Math.PI * radius ) * 2;
		
		//printing out the results as well as formatting them in a certain way, the decimal way :) ( having three digits! )
		
		System.out.println("The circle's radius: " + radius);
		System.out.println("The circle's area: " + fmt.format(area));
		System.out.println("The circle's circumference: " + fmt.format(circumference));
		
		object.close();
		
	}

}
