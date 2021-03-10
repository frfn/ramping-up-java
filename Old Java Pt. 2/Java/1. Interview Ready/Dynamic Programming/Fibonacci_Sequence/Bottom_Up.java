package Fibonacci_Sequence;

public class Bottom_Up {
	
	public static void main(String[] args) {
		
		System.out.println(fibBottomUp(40));
		
	}
	
	public static int fibBottomUp(int num) {
		if(num < 2) {
			return 1;
		}
		int[] bottomUp = new int[num+1];
		bottomUp[1] = 1;
		bottomUp[2] = 1;
		
		for(int i = 3; i<num+1; ++i) {
			bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
		}
		
		return bottomUp[num];
	}

}
