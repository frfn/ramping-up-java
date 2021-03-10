/*
 * Flexer Fadrigalan
 * Professor Keil
 * 2.1c
 * Recursion
 */
package Topic2;
import java.util.*;

public class recursiveMethod {
	
	public static void main(String Flex[]) {
		
		Scanner in = new Scanner (System.in);
		
		int x = 2;
		
		System.out.print("Y: ");
		int y = in.nextInt();
		
		System.out.print(recursion(x, y));
	}
	public static int recursion(int x, int y) {
		
		if(y == 0) {
			return 1;
		}else
			
			return x * recursion(x, y-1);
		
	}
	
	public static void turnIntoRecursion() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Number: ");
		int x = scan.nextInt();
		
		int i = 0; int y = 1;
		
		while ( i < x) {
			
			y = y * 2;
			i = i + 1;
			
		}
		
		System.out.print(y);
		
	}
}
