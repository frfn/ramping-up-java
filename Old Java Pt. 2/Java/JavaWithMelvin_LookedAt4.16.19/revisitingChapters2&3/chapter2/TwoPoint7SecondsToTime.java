package chapter2;
import java.util.Scanner;


/*
 * In this assignment, seconds will be translated to a time format
 * 
 * If you input 7200 seconds it should output 2:0:0 = two hours.
 * 
 *   Key: 1 hour = 3600
 *   	  1 minute = 60
 * 
 */
public class TwoPoint7SecondsToTime {
	//these are Global variables also known as instance variables
	static final int HOUR = 3600;
	static final int MINUTE = 60;
	static Scanner scan;
	
	public static void main(String[] args) {
		
		int seconds;
		/*
		 * these came to mind after thinking about the process
		 */
		int hourCounter = 0, minuteCounter = 0;
		int adjustedValue;
		
		scan = new Scanner(System.in); //scan is our scanner variable
		
		System.out.println("Seconds to time...");
		
		System.out.print("Please enter seconds: ");
		seconds = scan.nextInt();
		
		/*
		 * using a while loop to see how many hours will fit into seconds
		 */
		while(seconds >= hourCounter * HOUR) {
			/*
			 * While true keep running when it is FALSE it stops
			 */
			
			//7200    >  0	* 3600 
			//0 ++ = 1
			//7200    >  1 * 3600
			//7200    >  2 * 3600
			//it starts from 1,
			//1 loop = 0 , 2 loops = 3600, 3 loops = 7200
			hourCounter++;
		}
		hourCounter -= 1; //exiting out of loop, we shall subtract one for correct value
		
		adjustedValue = hourCounter * HOUR; // 7200 = 2 * 3600
		
		seconds = seconds - adjustedValue; // 0 = 7200 - 7200
		
		while(seconds >= minuteCounter * MINUTE) {
			minuteCounter++;
		}
		minuteCounter--; //another way to subtract 1
		
		adjustedValue = minuteCounter * MINUTE;
		
		seconds -= adjustedValue;
		
		System.out.println(hourCounter + ":" + minuteCounter + ":" + seconds);
		
		
	}

}
