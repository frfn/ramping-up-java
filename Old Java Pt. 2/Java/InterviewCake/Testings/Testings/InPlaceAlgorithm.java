package Testings;

public class InPlaceAlgorithm {
	
	public static void main(String[] args) {
		
		/**
		 * In Place Algorithm -- Destructive
		 * 
		 * - Working in place is a GOOD way to save space. Will generally have O(1) space cost
		 * - Beware: original input is 'destroyed', which can affect code even outside of block
		 */
		
		int[] data = {1, 3, 2};
		
		int[] result = squareArrayInPlace(data);
		
		for(int print:result) {
			System.out.print(print + ", ");
		}
		
		System.out.println();
		
		for(int test : data) {
			System.out.print(test + ", ");
		}
		
		System.out.println();
		System.out.println();
		
		
		/**
		 * Out of Place Algorithm -- Safer
		 * 
		 * - Generally safer because they avoid side effects
		 * - Only use in place algorithms if you're very space constrained
		 */
		
		int[] data2 = {1, 3, 2};
		
	int[] result2 = squareArrayOutOfPlace(data2);
		
		for(int print:result2) {
			System.out.print(print + ", ");
		}

		System.out.println();
		
		for(int test : data2) {
			System.out.print(test + ", ");
		}
		
	}

	  public static int[] squareArrayInPlace(int[] intArray) {

		    for (int i = 0; i < intArray.length; i++) {
		        intArray[i] *= intArray[i];
		    }

		    // NOTE: we could make this method void, since we modify
		    // intArray in place.
		    return intArray;
		}

		public static int[] squareArrayOutOfPlace(int[] intArray) {

		    // we allocate a new array with the length of the input array
		    int[] squaredArray = new int[intArray.length];

		    for (int i = 0; i < intArray.length; i++) {
		        squaredArray[i] = (int) Math.pow(intArray[i], 2);
		    }

		    return squaredArray;
		}
	
}
