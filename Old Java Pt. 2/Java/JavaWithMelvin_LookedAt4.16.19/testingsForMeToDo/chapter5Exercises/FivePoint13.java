package chapter5Exercises;

public class FivePoint13 {
	
	public static void main(String[] args) {
		
		/*
		 This is an infinite loop because 0 < 50, then 50 + 1n ... this expression is always true!
		 */
		
		int end = 50;
		int start = 0;
		
		while(start < end) {
			
			while(end < 100) {
				System.out.println(end++);
			}
			//start++;
			
		}
		
	}

}
