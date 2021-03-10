package chapter5Exercises;
/*
 * Exercise that will show the numbers
 * from 200, BEGINNING at 200 and down,
 * that is DIVISIBLE by 4.
 * 
 * You can change the == to != and see the numbers that ARE NOT divisible by 4.
 */
public class FivePoint10 {
	
	public static void main(String[] args) {
		
		for(int val = 200; val >= 0; val--) {
			
			if(val % 4 == 0) {
				System.out.println(val);
			}
			
		}
		
	}

}
