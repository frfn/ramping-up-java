package Ternary_Operators;

/**
 * 
 * @author Flexer
 *
 * Here, we are using the ternary operator to call methods!
 * Pretty cool.
 */

public class ex4_MethodUsage {
	
	public static void main(String[] args) {
		
		int a = 100;
		
		// Note: print is a function that accepts strings!
		// Note: printThis() and printThat() returns strings!
		print( (a > 0) ? printThis() : printThat());
		
	}
	
	
	
	public static void print(String string) {
		System.out.println(string);
	}
	public static String printThis() {
		return "I am printing because I am greater than 0.";
	}
	public static String printThat() {
		return "I am printing because I am less than 0.";
	}

}
