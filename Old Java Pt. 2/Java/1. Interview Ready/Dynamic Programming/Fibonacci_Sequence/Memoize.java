package Fibonacci_Sequence;

public class Memoize {
	
	public static void main(String[] args) {
		
		//System.out.println(fib(50));
		
		// MUST BE initialized first for memoized solution, an array with NULL values (0)
		int[] memo = new int[11];
		
		// USUALLY, you do not need to do this. :)
		for(int i=0; i<memo.length; ++i) {
			memo[i] = 0;   
		}
		
		System.out.println(fibo(10, memo));
		
	}
	
	// THIS IS SIMPLIFIED, at the bottom explains how it works. :)
	public static int fibo(int num, int[] memo) {
		int result;
		if(memo[num] != 0) {
			return memo[num];
		}
		if(num == 1 || num == 2) {
			result = 1;
			return result;
		}
		else {
			result = fibo(num-1, memo) + fibo(num-2, memo);
			memo[num] = result;
			return result;
		}
	}
	
	// This is recursive, this is without MEMOIZATION.
	public static int fib(int num) {
		if(num == 1 || num == 2) {
			return 1;
		}
		else {
			// When this is done, you will then iterate through the call stack, calling calculations that are already been calculate.
			// How to make faster you say?
			return fib(num-1) + fib(num-2);
		}
	}
	
	// MEMOIZED solution!
	
	/**
	 * 
	 * @param num
	 * @param memo
	 * @return
	 * 
	 * Note: It's the memory that it's calculating. The value is stored in the array, so when it comes up again, it can be used.
	 * 
	 * Let us imagine merge sort, or any recursion problem, it goes into the call stack and get's solved after it has been calculated.
	 */
	public static int fib(int num, int[] memo) {
		int result;
		if(memo[num] != 0) {
			/**
			 * if the spot already contains a value... then just return the value!
			 */
			return memo[num];
		}
		/**
		 * Same base case
		 */
		if(num == 1 || num == 2) {
			result = 1;
			return result;
		}
		/**
		 * Storing the value of fib(n-1) + fib(n-2) into result
		 * 
		 * Note: 
		 */
		else {
			
			result = fib(num-1, memo) + fib(num-2, memo);
			
			// once the "left" side finishes, then do the right, if value is encountered, just return!
			  
			/*
			 * 
			 * 						fib(5)
			 * 					  /		  \
			 * 				 fib(4)      fib(3) <-- this has already been seen, just return the value, and don't calculate!
			 * 			   /	  \
			 * 		   fib(3)	 fib(2) <-- this value has already been seen, just return!
			 * 	     /		\
			 *   fib(2)    fib(1)
			 * 					
			 * 
			 * 		Those values will be stored into the array.
			 * 		So that if the right side has to do those values again, no need.
			 * 		It can just return the value!
			 */
			
			memo[num] = result;
			return result;
		}
	}

}
