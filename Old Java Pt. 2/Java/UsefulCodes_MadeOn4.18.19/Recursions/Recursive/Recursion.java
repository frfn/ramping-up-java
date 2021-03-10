package Recursive;

public class Recursion {
	
	public static void main(String[] args) {
		
		double a = recursive(4);
		System.out.println(a);
		
		System.out.println(pow(2,3));
		
	}
	
	public static double recursive(int num) {
		
		if(num == 1) {
			return 1; 
		}
		else {
			return num * recursive(num-1);
		}
		
	}
	
	public static int pow(int x, int y) {
		
		if(y==0) {
			return 1;
		}else {
			return x * pow(x, y-1);  // we're using x for the variable, if 2, then it will keep passing 2 for the recursion
									 // y is the value that is changing
		}
		
		
		//  ( 2, 3 )
		//  
		//   2^3
		//
		//
		//  2 * pow (2, 2) = 4
		//  2 * pow (2, 1) = 8
		//  2 * pow (2, 0) = return 1; = 8 * 1 = 8
		
	}

}
