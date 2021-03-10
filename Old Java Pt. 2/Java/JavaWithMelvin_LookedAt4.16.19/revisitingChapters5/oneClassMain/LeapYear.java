package oneClassMain;
import java.util.Scanner;
public class LeapYear {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int stopValue = -1;
		
		int year;
		
		System.out.print("Please enter year from 1582 to 2200, or -1 to quit: ");
		year = scan.nextInt();
		
		while(year != stopValue) {
			
			System.out.println("Year entered: " + year);
			
			while(year < 1582 || year > 2200) {
				System.out.println("Please enter in range: ");
				year = scan.nextInt();
			}
			
			if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0 )) {
				System.out.println(year + " is a Leap Year!");	
			}else {
				System.out.println("Sorry, " + year + " is not a leap year!");
			}
			
			System.out.print("Please enter year from 1582 to 2200, or -1 to quit: ");
			year = scan.nextInt();
		}
		System.out.println("Thank You for playing!");
	}
	
}
