package chapter5;
import java.util.Scanner;
public class MultiplesOfStuff {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("Enter a digit and I will show you the multiples: ");
	int number = scan.nextInt();
	
	System.out.print("Print up to?: ");
	int limit = scan.nextInt();
	
	System.out.println("I will now print out the multiples of " + number + ", " + limit + " of times.");
	int count = 0;
	int printingNumbers = 5;
	for (int i = number; i <= limit; i += number) {
		
		System.out.print(i + "\t");
		
		count++;
		
		
		
		if(count % printingNumbers == 0) {
			System.out.println();
		}
		
	}
	
	
}
}
