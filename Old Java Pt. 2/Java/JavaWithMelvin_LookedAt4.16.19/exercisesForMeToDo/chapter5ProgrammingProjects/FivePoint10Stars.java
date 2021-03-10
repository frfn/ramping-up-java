package chapter5ProgrammingProjects;

public class FivePoint10Stars {
	
	static int horizontal = 10;
	static int vertical = 10;
	
	public static void main(String[] args) {
		
		/*
		 * This code below prints out
		 * 
		 * **********
		 * *********
		 * ********
		 * *******
		 * ******
		 * *****
		 * ****
		 * ***
		 * **
		 * *
		 * 
		 */
		
		for(int i = 0; i <= vertical; i++) { //first for loop
			
			for(int j = i; j <= horizontal; j++ ) { //second loop
				
				System.out.print("*");
				
				
			}
			
			System.out.println();
			
		}
		
		/*
		 * End of first print
		 */
		
		/*
		 * Prints this code
		 * 
		 *           *
		 *          **
		 *         ***
		 *        ****
		 *       *****
		 *      ******
		 *     *******
		 *    ********
		 *   *********
		 *  **********
		 * 
		 */
		
		System.out.println();
		
		horizontal = 10;
		
		;
		
		for(int i = 0; i < vertical; i++) {
			for(int j = 0; j < horizontal; j++) {
				System.out.print(" ");
			}
			horizontal--;
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		/*
		 * ************
		 *  ***********
		 *   **********
		 *    *********
		 *     ********
		 *      *******
		 *       ****** 
		 *        *****
		 *         **** 
		 *          ***
		 *           **
		 *            *
		 */
		
		System.out.println();
		
		horizontal = 10; 
		
		for(int i = 0; i <= vertical; i++) {
			
			for(int spaces = 0; spaces <= i; spaces++) {
				
				System.out.print(" ");
				
			}
			
			horizontal--;
			
			for(int stars = 0; stars <= horizontal; stars++) {
				
				System.out.print("*");
				
			}
			
			System.out.println();
			
		}
		
	}

}
