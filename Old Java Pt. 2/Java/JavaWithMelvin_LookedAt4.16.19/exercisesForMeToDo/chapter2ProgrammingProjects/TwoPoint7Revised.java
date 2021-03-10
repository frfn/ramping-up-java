package chapter2ProgrammingProjects;
import java.util.Scanner;

public class TwoPoint7Revised {
	
	public static void main(String[] time ) {
		
		/*
		Scanner object = new Scanner(System.in);
		
		final int hours = 3600;
		final int minutes = 60;
		//final int seconds = 1;
		
		int convertHour, convertMinute, convertSecond;
		
		System.out.print("Enter seconds to convert: ");
		int secondsInput = object.nextInt();
		
		convertHour = secondsInput / hours;
		
		System.out.println(convertHour);
		
		convertMinute = (secondsInput / minutes) % minutes;
		//convertMinute = convertMinute % minutes;
		
		System.out.println(convertMinute);
		
		convertSecond = secondsInput % minutes;
		
		System.out.println(convertSecond);
		*/
		
		//
		//
		/*
		 * Without the use of MODULAR
		 * or the remainder operator " % "
		 * Using for loops, also while loops
		 * to figure out how many hours, minutes can fit into seconds inputed
		 */
		//
		//
		Scanner object = new Scanner(System.in);
		
		System.out.print("Enter seconds to convert into hours, less than 86399: ");
		
		String  secondsInput2 = object.nextLine();
		int  secondsInput = Integer.parseInt(secondsInput2);
		
		
	
		
		//THIS CODE OF BLOCK IS A VALIDATOR, if number is in range, then accept, if not, keep on asking!
		/*
		 * Go back to this!
		 * Create a validator that will read strings!
		 * Parse number if number is detected, if character or string is detected, prompt to enter a number!
		 */
		
		
		while(secondsInput >= 86400 || secondsInput < 0) {
			System.out.print("Please enter number in range, thank you: ");
				secondsInput = object.nextInt();

			
		}
		
		
		
		int hourCounter, minuteCounter, secondsCounter;
		int hourAdjuster, minuteAdjuster;
		//int remainingNumberH, remainingNumberM;
		
		final int HOUR = 3600;
		final int MINUTE = 60;
		
		
		for(hourCounter = 0; secondsInput >= (HOUR * hourCounter); hourCounter++) {
			
			//ex.   hourCounter starts at 0,
			//		9999 >= (3600 * hourCounter)
			//		hourCounter increases by 1,
			//		once it fulfills that it is greater than 9999
			//		it will stop
			
				//nothing goes inside "for" loop , the top portion evaluates the hourCounter for us
		}
		
		hourCounter = hourCounter - 1; 	//subtracting one as exiting the loop will increment by 1, giving us an additional 1,
										//lets say the hour is 2, but it will give us 3, so "- 1" for accurate answer and debugging
		
		
		if(hourCounter < 0) {						//TEST
													//
			System.out.print("Negative number. ");	//testing to see if number will become negative
													//
		}											//edit: this is redundant now,
													//		but was used for first phase of project
													//		to see if we are still getting 10800, because it was giving
													//		output of 3, instead of 2 ! So 9999 - 10800 = "- 801"
		
		hourAdjuster = secondsInput - (HOUR * hourCounter);	//will subtract hours from seconds!
															//ex. 9999 seconds, 
															//there are 2 hours that can fit,
															//(3600 * 2 = 7200) 
															//–––> 9999 - 7200 = 2799
															// hourAdjuster = 2799
		
	
		
		for(minuteCounter = 0; hourAdjuster >= (MINUTE * minuteCounter); minuteCounter++ ) {
			//evaluating how many "minutes"(60) will fit into hourAdjuster(ex. 2799)
		}
		minuteCounter = minuteCounter - 1;	//subtracting one as the "for" loop will give us an additional one, 
											//2799... it can fit 60, 46 times because 60 * 47 = 2760
											//if we do not " - 1" the loop will produce 61 , because by process and how it will finish	
											//the condition
		
		minuteAdjuster = hourAdjuster - (MINUTE * minuteCounter);		//since we have 2799
																	//how many 60 can fit in 2799
																	//in this case 46
																	//60 * 46 = 2760
																	//2799 - 2760 = 39
		
		secondsCounter = minuteAdjuster;								//secondsCounter = 39
																	//this will be the remaining time left, or seconds left
		
		System.out.print(hourCounter + " : " + minuteCounter + " : " + secondsCounter);
		
		object.close();
	}

}
