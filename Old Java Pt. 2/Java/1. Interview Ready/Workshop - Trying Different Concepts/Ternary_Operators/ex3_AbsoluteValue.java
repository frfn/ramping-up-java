package Ternary_Operators;

/**
 * 
 * @author Flexer
 * 
 * Here, we are using a method called abs that uses the ternary operator.
 * 
 * We started with a having -100. The absolute value of -100, is 100!
 * So abs return the positive value!
 * 
 */

public class ex3_AbsoluteValue {
	
	public static void main(String[] args) {
		int a = -100;
		System.out.println(abs(a));
	}
	public static int abs(int num) {
		int absoluteValue = (num < 0) ? -num : num;
		return absoluteValue;
	}

}
