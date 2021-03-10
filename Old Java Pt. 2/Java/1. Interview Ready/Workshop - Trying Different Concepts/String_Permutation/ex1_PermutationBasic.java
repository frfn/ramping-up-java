package String_Permutation;

public class ex1_PermutationBasic {
	
	// We created an object so that the other methods do not have to be "static"
	public static void main(String[] args) {
		String abc = "ABC";
		ex1_PermutationBasic permutate = new ex1_PermutationBasic();
		
		permutate.permute("CBA", 0, abc.length()-1);
	}
	
	/**
	 * 
	 * @param string
	 * @param leftIndex
	 * @param rightIndex
	 * 
	 * First thing to NOTE:
	 * - This algorithm, needs string argument and left/right index!
	 * - It is recursive!
	 * - i = leftIndex; i <= rightIndex , Note: <= (less than or equal to!)
	 * 
	 */
	public void permute(String string, int leftIndex, int rightIndex) {
		
		// This is recursive, this is a base case
		if(leftIndex == rightIndex) {
			System.out.println(string);
		}
		
		else {
			// Hot spot, the "less than or equal to sign matters" -- i <= rightIndex
			for(int i = leftIndex; i <= rightIndex; i++) {
				
				// Swaps the character so it goes through the whole string
				string = swap(string, leftIndex, i);
				
				// the + 1 moves it along, this is the "driver", it is recursion!
				permute(string, leftIndex + 1, rightIndex);
				
				// backtrack!
				string = swap(string, leftIndex, i);
			}
		}
	}
	
	// Basic swap.
	// Note: we made a character array because we had to swap!
	public String swap(String string, int i, int j) {
		
		char[] characterArray = string.toCharArray();
		
		char temp = characterArray[i];
		characterArray[i] = characterArray[j];
		characterArray[j] = temp;
		
		// returns the string representation of character array!
		return String.valueOf(characterArray);
		
	}

}
