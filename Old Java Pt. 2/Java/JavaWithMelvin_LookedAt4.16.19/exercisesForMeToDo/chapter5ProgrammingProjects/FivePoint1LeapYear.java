package chapter5ProgrammingProjects;

/*
 The program is going to determine whether the year is a Leap Year or not
 A leap year is divisible by 4 UNLESS it is divisible by 100 but not 400.
 
 2003 is not a leap year, but 2004 is.
 1900 is not a leap year 
 
 produce a warning if input value is less than 1582
 */

public class FivePoint1LeapYear {
	
	static int year = 1600;  //declared a variable called year
	
	public static void main(String[] args) {
		
		System.out.println("The year we are testing is: " + year);
		
		// a % 100 != 0 – not a leap year
		// a % 400 == 0 – leap year
		// a % 4   == 0 – leap year
		
		
		if(year < 1582) {
			System.out.println("Invalid year");
		}
		//validation for year! if 1582, output invalid year!
		
		
		else if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			
			System.out.println("It is a leap year");
		}
		//else if  ( the year is divisible by 4
		//			 AND year is not divisible by 100 OR year is divisible by 400 )
		//			 then it IS a leap year!
					
		
		else { 
			System.out.println("Not a leap year");
		}
		
		
	}

}
