package fauxWork;
import java.util.Scanner;

/**
 * 
 * @author Flexer
 *
 * First two letters are your initials.
 * Numbers after hours worked
 * 
 * if more than three digits, display error, try catch
 */

public class hoursWorked {
	
	static Scanner scan;
	public static String initials;
	public static int hours;
	public static String worked;
	
	
	public static void main(String[] args) {
		
		String hours = header(); //scans user
		
		try {
			tester(hours);
		} catch (StringTooLongException e) {
			// TODO Auto-generated catch block
			/* e.printStackTrace(); */
			System.out.println("String too long...");
		}
		
	}
	
	public static String header() {
		
		scan = new Scanner(System.in);
		
		System.out.println("--Welcome, please input hours below: -- #FORMAT -- ex. FF8"); //initials FF , 8 hours
		System.out.print("Hours worked: ");
		worked = scan.nextLine();
		
		return worked;
		
	}
	
	public static void tester(String hourly) throws StringTooLongException {
		
		
		StringTooLongException e1 = new StringTooLongException("String too long...");
		
		if(hourly.length() > 3) {
			throw e1;
		}

		try {
			hours = Integer.parseInt(hourly.substring(2, 3));
			initials = hourly.substring(0, 2);			
		}
		catch(NumberFormatException n) {
			System.out.println("Incorrect value...");
		}
		catch(StringIndexOutOfBoundsException s) {
			System.out.println("Input length too short...");
		}
		
		System.out.println("You have worked for: " + hours + " hours");
		System.out.println("Initials: " +  initials);
		
	}
	
}
