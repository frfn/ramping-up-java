package chapter2;
import java.util.*;
public class TwoPoint2Average {
	
	static Scanner scan;
	static double num, total, avg;
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		for(int i = 1; i <= 3; i++) {
			
			System.out.print("Enter integer " + i + ": ");
			
			num = scan.nextDouble();
			
			total += num;
		}
		
		avg = total / 3;
		
		System.out.println("Your average is: " + avg);
		
	}
	
	

}
