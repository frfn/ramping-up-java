package oneClassMain;
import java.util.Scanner;
public class ZeroOddEven {
	private static Scanner scan = new Scanner(System.in);
	private static int zeros=0;
	private static int evens=0;
	private static int odds=0;
	public static void main(String[] args) {
		
		System.out.println("Sorting, 0\'s, even\'s, and odd\'s");
		System.out.print("Please enter any number, -1 to quit: ");
		String number = scan.nextLine();
		
		while(!number.equals("-1")) {
			
			for(int i=0; i<number.length(); i++) {
				
				int parseInt = Integer.parseInt(String.valueOf(number.charAt(i)));
								//Integer.pasrseInt needs a STRING OBJECT, not a CHAR
								//putting the the String.valueOf() this will
								//deconstruct it so that we can use CHAR object
				if(parseInt == 0) {
					zeros++;
				}else if(parseInt % 2 == 0) {
					evens++;
				}else {
					odds++;
				}
				
			}
			
			System.out.println("Zeros in " + number + ": " + zeros);
			System.out.println("Evens in " + number + ": " + evens);
			System.out.println("Odds in " + number + ": " + odds);
			
			zeros=evens=odds=0; //NEW WAY TO IMPLEMENT TO 0 
			
			System.out.print("Please enter any number, -1 to quit: ");
			number = scan.nextLine();
		}
		
		System.out.println("Thanks! for playing");
		
		
	}
}
