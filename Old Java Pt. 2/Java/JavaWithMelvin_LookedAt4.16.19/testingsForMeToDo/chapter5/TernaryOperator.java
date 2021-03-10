package chapter5;

public class TernaryOperator {
	
	private static int max = 10;
	private static int count = 6;
	
	public static void main(String[] args) {
		
		int newValue = (max < count)     ?     count + 5     :      count * 2;
					// if condition      is    true		     or	    false
		
		/*
		 * SIMILAR TO THIS
		 * 
		 * if ( max < count ) {
		 * 
		 * 		count + 5;
		 * 
		 * else{
		 * 
		 * 		count * 2;
		 * 
		 * }
		 * 
		 * }
		 */
		
	//it works like this
		
		// 1. (condition)  – look above!
		// 2. ? – almost similar to like , so is it?
		// 3. condition to be done if true
		// 4. : – separates the other condition
		// 5. condition to be done if false
		
		int newValue2 = (max > count ? max - 4 : count + 4);
		
		
		System.out.print(newValue2);
		
	}

}
