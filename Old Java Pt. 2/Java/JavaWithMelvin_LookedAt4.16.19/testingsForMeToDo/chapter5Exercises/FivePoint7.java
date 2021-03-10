package chapter5Exercises;

/*
 * So it prints out 5 elements, including 0,
 * 
 * 0, 4, 8, 12, 16 – NOT 20 because num is LESS than max ( 20)
 */

public class FivePoint7 {
	
	static int num = 0, max = 20;

	
	public static void main(String[] args) {
		
		while(num < max) {
			System.out.println(num);
			num += 4;
		}
		
	}

}
