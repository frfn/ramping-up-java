package chapter5;
import java.util.Scanner;
public class Stars {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter how many starts to start off with man: ");
		int numOfStars = scan.nextInt();
		
		/*
		 * row WILL always be horizontal
		 * 
		 * ------------------------------------
		 * 
		 * column WILL always be horizontal
		 * 
		 * |
		 * |
		 * |
		 * |
		 * |
		 * |
		 * |
		 */
		
		for(int row = 1; row <= numOfStars; row++) {
			
			for(int star = 1; star <= row; star++) {
				
				System.out.print("*");
				
			}
			
			
			System.out.println();
			
			
		}
		
	}

}
