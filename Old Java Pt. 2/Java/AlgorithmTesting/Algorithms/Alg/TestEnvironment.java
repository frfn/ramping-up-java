package Alg;
import java.util.*;
public class TestEnvironment {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numOfElements = scan.nextInt();
		
		int[] intArray = new int[numOfElements];
		
		for(int i = 0; i < intArray.length; i++) {
			intArray[i] = scan.nextInt();
		}
		
		for(int i = intArray.length-1; i >= 0; i--) {
			System.out.print(intArray[i] + " ");
		}
		
		
	}

}
