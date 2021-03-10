//-------------------
// Skipping to project 2.4
//
// Programming Projects for Chapter Two:
// Will have brief explanation on assignment!
// Will have explanation and summarized learnings!
//-------------------

package programmingProjects;
import java.util.Scanner;
import java.text.DecimalFormat;
public class ChapterTwoProgrammingProjects {
	
	public static void main(String[] programmingProjects) {
		//run code by putting method name and the ; at the end!
		twoPointFour();
		
	}
	
	public static void twoPointFour() {
	//-------------
	// TEMPERATURE CONVERTER
	//	from celsius to fahrenheit – (0°C × 9/5) + 32 = 32°F
	//
	//	from fahrenheit to celsius – (32°F − 32) × 5/9 = 0°C
	//
	// This will be a more revised version, will challenge my skills.
	//-------------
		
		Scanner scan = new Scanner(System.in); //scanner object
		DecimalFormat fmt = new DecimalFormat("0.##"); //decimal format, the ## signifies that it will only show two significant numbers
		
		double fahrenheit, celsius; //this is all I can think of for the variables I need
		//variables needed are subject to change
		
		System.out.println("Temperature Converter...");
		System.out.println("1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius\n3. Quit");
		System.out.print("Please input number: ");
		int userChoice = scan.nextInt();
		
		//--------------------------
		// Input validation
		// If the user choice is greater than 3 or less than 1, invalid number!
		//--------------------------
		while(userChoice > 3 || userChoice < 1) {
			System.out.print("Please enter valid number: ");
			userChoice = scan.nextInt();
		}
		
		//-----------
		// I thought about it, and I wanted this to keep going until user wants to quit
		// This is done with a while loop and a sentinel value!
		//----------- 
		
		while(userChoice != 3) {
		//---------------------
		// 1. Celsius to Fahrenheit
		//    (0°C × 9/5) + 32 = 32°F
		//		With this, I fully understand how to solve this method
		//---------------------
			if(userChoice == 1) {
				
				final double conversionFactor = 9/5; //a value that will be handled easer
				System.out.print("Input celsius: ");
				celsius = scan.nextDouble();
				
				double convertedCelsius = (celsius * conversionFactor) + 32; //getting the value from expression
				
				System.out.println("Celsius entered: " + celsius);
				System.out.println("Converted to Fahrenheit: " + fmt.format(convertedCelsius));
				
				//---------------------
				// Considering we are still in the while loop, without asking for AN INPUT AGAIN,
				// we will be in an infinite loop because the input is NOT the value 3, 
				// it is also important in this program because it enables us to ask user again if 
				// they want to do another operation or quit.
				// An input validation.
				//---------------------
				System.out.print("To do more conversions, 1 for C to F, 2 for F to C, 3 to QUIT: ");
				userChoice = scan.nextInt();
				
				while(userChoice > 3 || userChoice < 1) {
					System.out.print("Please enter valid number: ");
					userChoice = scan.nextInt();
				}//end of validation
				
			
			}//end of if statement
		
			else if(userChoice == 2) {
			//---------------------
			// Fahrenheit to Celsius 
			//	(32°F − 32) × 5/9 = 0°C
			//---------------------
				
			final double conversionFactor = 5/9d;
			System.out.print("Input Fahrenheit: ");
			fahrenheit = scan.nextDouble();
			
			double convertedFahrenheit = ((fahrenheit - 32) * conversionFactor);
			
			System.out.println("Fahrenheit entered: " + fahrenheit);
			System.out.println("Converted to Celsius: " + fmt.format(convertedFahrenheit));
			
			System.out.print("To do more conversions, 1 for C to F, 2 for F to C, 3 to QUIT: ");
			userChoice = scan.nextInt();
			
			while(userChoice > 3 || userChoice < 1) {
				System.out.print("Please enter valid number: ");
				userChoice = scan.nextInt();
			}//end of validation
			
			}//end of if-else statement
			else {
				userChoice = 3; //quit by default or if ERROR occurs
			}//end of else statement
		}//end of while loop
		System.out.println("Thanks for using the program!");
	}//end of method
	
	public static void twoPointFive() {
		//---------
		// Program converts miles to kilometers
		// 1 mile = 1.60935 kilometer
		//--------- 
		Scanner scan = new Scanner(System.in); //a scanner
		DecimalFormat fmt = new DecimalFormat("0.##"); //created a decimal formatter for simplicity
		
		final double miles = 1.60935d; //having a "d" at the end may sometimes be needed for good practice
		double kilometers;
		
		System.out.println("Converting miles to kilometers... ");
		System.out.print("Input value: ");
		int userInput = scan.nextInt();
		
		kilometers = miles * userInput;
		String value = fmt.format(kilometers); //fmt.format(parameter) IS A STRING. 
		
		System.out.println("Miles: " + userInput + "\nConverted to Kilometers: " + value);
				
		
	}
	
	public static void twoPointSix() {
		//----------------------
		// Application that reads values in hours, minutes and seconds and convert all of it to hours
		// 1 hour, 1 minute and 20 seconds = 3680 seconds
		//----------------------
		final int hour = 3600;
		final int minute = 60;
		
		//--------------
		// I thought about using an array for this, just to get familiar with them
		//--------------
		int[] timeHolder = new int[3];
 		Scanner scan = new Scanner(System.in);
 		
 		//---------------
 		// Had a little ERROR, did not program correctly, BUT FIXED :)
 		//---------------
		System.out.println("Calculating time into seconds...");
		System.out.print("Input hours: ");
		timeHolder[0] = scan.nextInt(); // A little test, and it works, as it should. timeHolder[0] and the line below!
		timeHolder[0] = timeHolder[0] * hour;
		
		System.out.print("Input minutes: ");
		int MINUTE = scan.nextInt();
		timeHolder[1] = MINUTE * minute;
		
		System.out.print("Input seconds: ");
		timeHolder[2] = scan.nextInt();
		
		int seconds = 0;
		for(int i = 0; i < timeHolder.length; i++) {
			seconds += timeHolder[i];
		}
		
		System.out.println("Total seconds: " + seconds);
		
		
	}
	
	public static void twoPointSeven() {
		
		//-----------------------
		// Reverse engineer twoPointSix
		// from seconds to hours, minutes and seconds
		// User will input certain amount of seconds and will
		// translate into HH:MM:SS
		//-----------------------
		
		Scanner scan = new Scanner(System.in);
		DecimalFormat fmt = new DecimalFormat("00"); //having this will make the output have a "03" if output is just "3"
		
		final int hour = 3600;
		final int minute = 60;
		
		System.out.println("Converting seconds to HH:MM:SS format...");
		System.out.print("Input seconds: ");
		int seconds = scan.nextInt();
		
		int hrCtr, minCtr; //initialized
		
		hrCtr = minCtr = 0; //easy way to initialize two variables to zero
		
		while(seconds >= (hrCtr*hour)) { //while seconds is greater or equal to HR COUNTER times HOUR , keep running
			hrCtr++;
		}
		hrCtr--;
		
		seconds = seconds - (hrCtr*hour);
		
		while(seconds >= (minCtr*minute)) { //while seconds is greater or eaual to MIN COUNTER times MINUTE , keep running
			minCtr++;
		}
		minCtr--;
		
		seconds = seconds - (minCtr*minute);
		
		//---------------------
		// NEW UPDATE:
		// If hours over exceed 24 hours, it will turn into days
		// in this new update, it will turn it into days rather than seeing a number over 24.
		// it will also accommodate hour change.
		//---------------------
		
		int dayConverter = 24;
		
		if(hrCtr >= dayConverter) { //if the hour counter is greater or equal to 24 then run code
			
			int days = 0;
			while(hrCtr >= (dayConverter*days)) { //while HR COUNTER is greater than or equal to 24 times DAYS
				days++;
			}
			days--;
			
		hrCtr = hrCtr - (days*dayConverter); //hrCtr will now equal hrCtr - days*dayConverter(24)
		
			System.out.println("Days: " + days);
			System.out.println("Formatted: " + fmt.format(hrCtr) + ":" + fmt.format(minCtr) + ":" + fmt.format(seconds));
			
		}else {
		System.out.println("Formatted: " + fmt.format(hrCtr) + ":" + fmt.format(minCtr) + ":" + fmt.format(seconds));
		}
	}

}
