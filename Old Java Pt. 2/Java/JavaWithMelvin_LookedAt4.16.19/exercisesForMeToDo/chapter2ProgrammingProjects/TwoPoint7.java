package chapter2ProgrammingProjects;
import java.util.Scanner;

/*
 * Reversed version of TwoPoint6,
 * where if you put in seconds
 * such as 9999 seconds, it will be 
 * 2 hours, 46 minutes and 39 seconds
 * 
 * one hour is 3600 seconds
 * one minute is 60 seconds
 * one second is  1 second
 * 
 * 
 * 
 * use, MODULOUS
 * 
 * 
 * PLEASE LOOK AGAIN AND TRY TO UNDERSTAND
 */

public class TwoPoint7 {

	public static void main(String[] reversed) {
		
		Scanner object = new Scanner(System.in);
		

		
		System.out.print("Seconds to be converted: ");
		int SECONDS = object.nextInt();
		
		int TEMP;
		int HOURS;
		int MINUTES;
		
		//TO GET HOURS
		HOURS = SECONDS / 60; //		hours = 166.65, remaining 166
		
		//so that you can get minutes
		
		
		//TO GET MINUTES
		MINUTES = HOURS % 60; //		166 % 60 = 46
		
		//after you get minutes, get hours in minutes
		
		
		//TO GET HOURS
		HOURS = HOURS / 60; 	 //		166 / 60 = 2.76 , 
							 //		but since int, will only show 2
		
		//to get seconds
		
		//TO GET SECONDS
		TEMP = SECONDS % 60; //modular/remainder operator so if 9999, the remaining is 36
		
	
		
		
		System.out.print(HOURS + " : " + MINUTES + " : " + TEMP);
		
		int i = 367263;
		
		/*
		 * first divide number
		 * ex. 687,456 / 576 = 1193.5
		 * 		answer is 1193.5 , no decimal 1193 to find value
		 * 	   1193 * 576 = 678,168
		 * 		678,456 - 678,168 = 288
		 */
		
		int j = 4;
		
		int a = i % j;
		
		System.out.print("\n" + a);
		
		
		object.close();
	}
	
}
