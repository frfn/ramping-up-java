/*
 * Flexer Fadrigalan
 * Professor Keil
 * 3.3d
 * Recursion
 */

package Portfolio;

public class descendingArray {

	public static void main(String flex[]) {
		
		int[] Array = {10, 6, 4, 11, 5, 7, 2, 9};
		int temp;
		
		System.out.print("Elements before descending order: ");
		for (int i = 0; i < Array.length; i++) {
			System.out.print(Array[i] + ", ");
		}
		
		for( int i = 0; i < Array.length; i++) {
			for (int j = i + 1; j < Array.length; j++) {
				
				if(Array[i] < Array[j]) {
					
					temp = Array[i];
					Array[i] = Array[j];
					Array[j] = temp;
					
				}
				
			}
		}
		System.out.println();
		System.out.print("Now in descending order: ");
		for(int i = 0; i < Array.length; i++) {
			System.out.print(Array[i] + ", ");
		}
		
		
	}
	
}
