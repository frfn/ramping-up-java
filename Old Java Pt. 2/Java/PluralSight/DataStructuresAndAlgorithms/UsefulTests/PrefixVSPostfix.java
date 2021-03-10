package UsefulTests;

public class PrefixVSPostfix {
	
	/**
	 * 
	 * @param args
	 * 
	 * Very interesting, when you use i++ in loops 
	 * it will increment AFTER the fact of being called.
	 * 
	 * ++x, this will be helpful in the Time class, where you are counting hours, mins, and secs.
	 * 
	 * When it exits out of loop, no need for the 'HOUR--' as it is already incremented.
	 */
	
	public static void main(String[] args) {
		
		int x = 1;
		
		System.out.println(x++); // will output 1
		/**
		 * 
		 */
		//System.out.println(x);  // prints 2 now! LOL.
		
		x = 1;
		
		System.out.println(++x);  //will output 2
		/**
		 * 
		 */
	}

}
