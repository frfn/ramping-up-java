/*
 * Flexer Fadrigalan
 * Portfolio 460
 * Code
 * Keil
 * Finite Automata
 */
package Portfolio460;

public class FiniteAutomata {

	public static void main(String[] Flex) {
		

		System.out.println("See if number if 0 in front and end, 1's in the middle.");
		
		System.out.println("Try for 011010: " + FA("011010"));	//will not work
		
		System.out.println("Try for 010100: " + FA("111110"));	//will not work
		
		System.out.println("Try for 011110: " + FA("011110"));	//will work
		
	}
	
	
	public static boolean FA(String num) {
		
		if(num.charAt(0) != '0') {	//if number is not 0, false
			
			return false;
			
		}
		
		if(num.charAt(num.length() -1 ) != '0') {	//if number is not 0 at end, false
			
			return false;
			
		}
		
		for(int i = 1; i < num.length() - 1; i++) {	//if number are not 1's in middle, false
			
			if (num.charAt(i) != '1')
				
			return false;
		}
		
		return true;		//return true if all are satisfiable
		
	}
	
}
