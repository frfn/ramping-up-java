package oneClassTake;
import java.util.Scanner;
import java.util.Random;
/*
 * 
 * Program that will print out numbers in between a range!
 * 
 * Utilizes a method call to range();
 */
public class FourPointOneRange {
	
	public static void main(String[] args) {
		
		
		int counter=0;
		
		boolean go = true;
		boolean stop = false;
		
		while(go) {
			int range = range(10,15);
			
			if(range == 10) {
				System.out.println("You got 10!");
				go = stop;
			}
			counter++;
		}
		System.out.println("It took " + counter + " try/ies!");
	}
	
	public static int range(int origin, int bound) {
		
		if(origin > bound || bound == 0) {
			System.out.println("chill, its bound equals 0 or origin is greater than bound");
			return 0;
		}
		
		Random gen = new Random();
		
		int range = bound - origin;
		
		//int numberInRange = ((int)((Math.random() ) * range + 1) + origin) ;
		int numberInRange = gen.nextInt((range) + 1) + origin;
		// 10 , 11 , 12 , 13 , 14 , 15
		// 				5 = 15 - 10 -->  
		
		//							Math.random()*5 = 0, 1, 2, 3, 4
										//								+10 --> 10, 11, 12, 13, 14
		//+ 10 -->
		//								
		
		
		
		return numberInRange;
		
		
	}

}
