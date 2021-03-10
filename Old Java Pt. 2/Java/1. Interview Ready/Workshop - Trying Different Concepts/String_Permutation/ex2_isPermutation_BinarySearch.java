package String_Permutation;
import java.util.Arrays;
/**
 * BUGGY CODE. x
 * 
 * DEBUG LATER. x
 * 
 * Binary Search does not work fully, linear does. x
 * 
 * -- Binary Search works, it just needs to be SORTED first. -- 
 * - Fully works :)
 * 
 * @author Flexer
 *
 * My take on permutation, 
 * see if string is a permutation
 */

public class ex2_isPermutation_BinarySearch {
	
	public static void main(String[] args) {
		/**
		 * By creating an instance no need for all the methods to be static
		 * 
		 * This makes it easier to reference things!!
		 * - Bonus!
		 */
		ex2_isPermutation_BinarySearch permutate = new ex2_isPermutation_BinarySearch();
		boolean value = permutate.isPermutation("hello", "hlloe");
		
		System.out.println(value);
	}
	
	/**
	 * BinarySearch for Strings!!
	 * 
	 * The only thing we used is the compareTo() method from String class
	 * - It gives us a value to work with 
	 * - to see if we need to search in the left, right fields!
	 * - if compareTo() value is 0, then it is found!
	 * 
	 * @param strings
	 * @param target
	 * @return
	 */
	private boolean binarySearch(String[] strings, String target) {
		// Validation, if string length is 0, false right away!
		if(strings.length == 0) {
			return false;
		}
		
		Arrays.sort(strings);
		
		// Usual protocols, left and right!
		int left = 0;
		int right = strings.length-1;
		
		// note the  <=... BINARY = LESS THAN OR EQUAL TO
		while(left <= right) {
			// the overflow, left + (right - left) may fix the issue... hmm.
			int middle = (left + right) / 2;
			
			/**
			 *  this is probably the cause as to why
			 *  - search is not reading the last element
			 *  - to fix, we created an if statement under code to check last element
			 */
			
			// this is where the comparison happens! this is how the value is chosen!
			int lexicoValue = target.compareTo(strings[middle]);
			
			// if the value is 0, it is the same!
			if(lexicoValue == 0) {
				return true;
			}
			else if(lexicoValue > 0) {
				left = middle + 1;
			}
			else if(lexicoValue < 0) {
				right = middle - 1;
			}
		}
		
		// Hot spot
		// for some reason the value for the last element is not checked, we check here!
		if(strings[strings.length-1].equals(target)) {
			return true;
		}
		
		return false;
	}
	
	public boolean isPermutation(String string, String guess) {
		// Big O(n) - linear time to get size
		int size = 1;
		for(int i=1; i<=string.length(); i++) {
			size = size * i;
		}
		
		String[] mutations = permutate(string, 0, string.length()-1, size);
		
		return (binarySearch(mutations, guess)); // ? true : false; lol redundant!
	}
	
	/**
	 * GLOBAL VARIABLES
	 * - why? So it won't be affected in the permutate() method
	 */
	int index = 0;
	String[] mutations = new String[0];
	
	// added int size because after finding out I need an array to returned, you have to initialize the size of array first!
	public String[] permutate(String string, int leftIndex, int rightIndex, int size) {
		
		// changes the size!
		if(mutations.length == 0) {
			mutations = new String[size];
		}
		
		// This is recursive, this is a base case
		if(leftIndex == rightIndex) {
			mutations[index++] = string;
		}
		else {
			
			// Hot spot, the "less than or equal to sign matters" -- i <= rightIndex
			for(int i = leftIndex; i <= rightIndex; i++) {
				string = swap(string, leftIndex, i);
				permutate(string, leftIndex + 1, rightIndex, size);
				string = swap(string, leftIndex, i);
			}
		}
		
		return mutations;
	}
	
	private String swap(String string, int i, int j) {
		
		char[] characterArray = string.toCharArray();
		
		char temp = characterArray[i];
		characterArray[i] = characterArray[j];
		characterArray[j] = temp;
		
		// no need for String str = new String(characterArray); just do valueOf(char[] var);
		return String.valueOf(characterArray);
		
	}
}
