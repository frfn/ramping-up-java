package zGoingOverThingz;

/**
 * 
 * @author flexer
 *
 * Going over chapter two experiments
 * 
 */

import java.util.Scanner; //scanner package
import java.text.DecimalFormat; // decimal formatter

public class Chapter2 {
	
	static Scanner scan;
	//making this a global/instance variable 
	
	static DecimalFormat fmt;
	
	public static void main(String[] args) {
		
		secondsIntoTime();
		
	}
	
	public static void multipleInputs() {
		
		scan = new Scanner(System.in);
		
		int[] five = new int[5];
		
		//using array to hold mulitple inputs
		//by default the regular expression/pattern is ("\\s+") or a blank space
		
		//System.out.print("Enter 5 values: ");
		
		//Value 0 because index starts at 0!
		
		for(int i = 0; i < five.length; i++) {
			System.out.print("Enter value " + i + ": " );
			five[i] = scan.nextInt();
		}
		
		for(int view : five) {
			System.out.print(view + "\t");
		}
		
		
		/**
		 * -------
		 * 
		 * -------
		 */
		
	}

	public static void secondsIntoTime() {
		
		/**
		 * An application that will turn seconds into time
		 * 
		 */
		
		fmt = new DecimalFormat("00");
		scan = new Scanner(System.in);
		
		int[] timeHolder = new int[3]; // index 0, 1, 2
									   // 3 elements
		
		final int HOUR = 3600;
		final int MINUTE = 60;
		final int DAY = 24;
		
		int hrCtr, minCtr, dayCtr;
		dayCtr = hrCtr = minCtr = 0;
		
		System.out.print("Enter seconds: ");
		int seconds = scan.nextInt();
		
		while(seconds >= (HOUR*hrCtr)) {
			hrCtr++;
		}
		hrCtr--; //subtract one.
		//By experimenting before, leaving a loop will increment
		//value by one.
		
		seconds -= hrCtr*HOUR; //seconds = seconds - (total hours in seconds)
		
		while(seconds >= (MINUTE*minCtr)) {
			minCtr++;
		}
		minCtr--;
		
		seconds -= minCtr*MINUTE;
		
		while(hrCtr >=(DAY*dayCtr)) {
			dayCtr++;
		}
		dayCtr--;
		
		hrCtr -= (DAY*dayCtr);
		
		System.out.println("Days: " + 
							fmt.format(dayCtr) + 
							"\nTime: " + 
							fmt.format(hrCtr) + ":" + fmt.format(minCtr) + ":" + fmt.format(seconds));
		
		
		
		
		
	}
	
}
