package Ternary_Operators;

/**
 * 
 * @author Flexer
 * 
 * It's more commonly known as the conditional operator.
 * 
 * It can be used as an alternative to the if / else syntax!
 * 
 * In this example, we are exploring what the ternary operator is.
 *
 */

public class ex2_Practice {
	
public static void main(String[] args) {
		
	int a, b;
	
	a=100;
	b=200;
	
	// if a is less than b, assign a to minVal, else assign b to minVal
	// Note: no parenthesis, with it, they ARE easier to read.
	int minVal=a<b?a:b;
	
	// Note: parenthesis is used here. Easier to read :)
	int maxVal=(a>b)?a:b;
	
	System.out.println(minVal);
	System.out.println(maxVal);
		
	}

}
