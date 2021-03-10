package chapter2ProgrammingProjects;
import java.util.Scanner;
public class TwoPoint7WhileLoop {
	
	static int HOUR = 3600;
	static int MINUTE = 60;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter seconds to convert into --:--:-- format: ");
		int seconds = scan.nextInt();
		
		//getting hours
		int hourCount = 0;
		while(seconds > (HOUR * hourCount)) { //while seconds inputed is greater than HOUR * i amount, increase i            
	  		//keep going if seconds is greater than  (HOUR * hourCount) , else stop!
			hourCount++;
			
		}
		hourCount--;
		
		seconds = seconds - (hourCount * HOUR);
		
		//getting minutes
		
		int minuteCount = 0;
		while(seconds > (MINUTE * minuteCount)) {
			minuteCount++;
		}
		minuteCount--;
		
		seconds = seconds - (minuteCount * MINUTE);
		
		System.out.print(hourCount + ":" + minuteCount + ":" + seconds);
		
	}
	
	
	

}
