package MathFunctions;

/**
 * 
 * @author Flexer
 * Utilizing the varying args!!
 */

public class MaxAndMin {
	
	public static int min(int...num) {
		
		// Setting the minimum value so we have SOMETHING to compare to
		int min = num[0];
		
//		for(int i = 0; i < num.length; i++) {
//			if(num[i] < min) {
//				min = num[i];
//			}
//		}
		
		for(int number: num) {
			if(number < min) {
				min = number;
			}
		}
		
		return min;
	}

	public static int max(int...num) {
		
		int max = num[0];
		
		for(int i = 0; i < num.length; i++) {
			
			if(num[i] > max) {
				max = num[i];
			}
		
		}
		return max;
	}
	
	public static int largerNum(int num1, int num2) {
		
		// Practicing ternary operator
		/**
		 * condition --> ? --> return num1 ELSE return num2
		 * 
		 * I want to see this in real life world case. 
		 * Search up ternary operators!
		 */
		int largeNum = (num1 > num2) ? num1 : num2;
		
		return largeNum;
		
	}
	
	public static void main(String[] args) {
		System.out.println(min(10, 2, 4, 10, 1, 3, 4, 0, -2, 3, 1));
		System.out.println(max(10, 2, 4, 10, 234, 1, 3, 4, 0, -2, 3, 1));
		System.out.println(largerNum(23, 43));
		
	}

}
