package chapter2;
import java.util.Scanner; //importing a Scanner so we can use a scanner

/*
 * Here, we will be making time go to seconds
 * 
 * 1 hour = 3600 seconds
 * 1 minute = 60 seconds
 * 1 second = 1 second
 * 
 * Ask the user how many hours, minutes and seconds
 * Display seconds!
 * 
 */
public class TwoPoint6TimeToSeconds {
	
	static final int HOUR = 3600; //seconds in an hour
	static final int MINUTE = 60; //seconds in a minute
	static Scanner scan; //scanner variable
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in); //initializing the scanner variable
		
		int hours, minutes, seconds; //declared these variables to hold value
		int hoursConverted, minutesConverted; //declared variables for converted value
		
		System.out.println("Turning time to seconds...");
		
		System.out.print("Please input hour/s: ");
		hours = scan.nextInt();
		
		System.out.print("Please input minute/s: ");
		minutes = scan.nextInt();
		
		System.out.print("Please input second/s: ");
		seconds = scan.nextInt();
		
		
		System.out.println("Your seconds converted!");
		hoursConverted = hours * HOUR;
		minutesConverted = minutes * MINUTE;
		
		System.out.print(hours + ":" + minutes + ":" + seconds + " —to seconds— " 
							+ (hoursConverted+minutesConverted+seconds) + " seconds.");
		
		
		
	}

}
