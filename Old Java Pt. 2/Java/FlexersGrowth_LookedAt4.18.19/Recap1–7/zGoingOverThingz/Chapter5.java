package zGoingOverThingz;

import java.util.Scanner; //imported scanner

/**
 * 
 * @author Flexer
 * going over Chapter 5 experiments and coding projects
 */

public class Chapter5 {
	
	static Scanner scan; //not initialized yet
	private int num;
	
	public static void main(String[] args) {
		
		//minAndMax(43, 2, 10, 44, 5, 14);
		
	}
	
	public Chapter5() {
		
		num = 0;
		
	}
	
	public String toString() {
		return "num: " + num;
	}
	
	public static void palindrome() {
		/**
		 * Reversing the string and seeing if it is 
		 * a palindrome
		 */
		
		scan = new Scanner(System.in);
		System.out.print("Enter string: ");
		
		String string = scan.nextLine(); //getting user input
		
		String reverse = "";
		
		/**
		 * Let's say the string is "HELLO"
		 * String length minus 1 = 4. 
		 * 0 , 1 , 2 , 3 , 4
		 * At index 4, it is the letter "O".
		 * 
		 * while i is greater than or equal to 0, subtract.
		 * 
		 * Visualizing, it will be in this order:
		 *  - 4 , 3 , 2 , 1 , 0
		 *  - Hence why we get the string backwards.
		 */
		
		/**
		 * --  Insane this works too.
		 * --	for(int i = 0; i < string.length(); i++) { 
		 * --		reverse = string.charAt(i) + reverse; 
		 * --   }
		 * 
		 *  h  e  l  l  o
		 *  0  1  2  3  4
		 *  
		 *  h + "" = h
		 *  e + h = eh
		 *  l + eh = leh
		 *  l + leh = lleh
		 *  o + lleh = olleh
		 */
		
		/**
		 * Below works 
		 *  - index = 4
		 *  - reverse = ""
		 *  
		 *  h  e  l  l  o
		 *  0  1  2  3  4
		 *  
		 *  "" + o = o
		 *  o + l = ol
		 *  ol  + l = oll
		 *  oll + e = olle
		 *  olle + h = olleh
		 */
		for(int i = string.length() - 1; i >= 0; i--) {
			reverse += string.charAt(i);
		}
		
		System.out.println(string);
		System.out.println(reverse);
		
		if(string.equalsIgnoreCase(reverse)) {
			System.out.println("It's a palindrome");
		}
		else {
			System.out.println("It's not a palindrome");
		}
		
	} //end of palindrome
	
	public static void palindrome2() {
		
		/**
		 * Now using the index of the string
		 */
		
		scan = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		String string = scan.nextLine();
		
		int leftIndex = 0;
		int rightIndex = string.length() - 1;
		
		while(string.charAt(leftIndex) == string.charAt(rightIndex)
				&& leftIndex <= rightIndex) {
			leftIndex++;
			rightIndex--;
		}
		
		if(leftIndex < rightIndex) {
			System.out.println("It is not a palindrome");
		}
		else {
			
			/**
			 * if leftIndex = 1 and rightIndex = 1, then it is a palindrome
			 * 1 = 1, this pertains to the while condition, "leftIndex <= rightIndex")
			 */
			System.out.println("It is a palindrome");
		}
		
	}
	
	/*
	 * does not work, will look into later.
	 * 
	public static Chapter5 min(Chapter5... elements) {
		
		Chapter5 min = elements[0];
		
		for(int i = 0; i < elements.length; i++) {
			
			
		
		}
		return min;
	}
	*/
	
	public static int max(int...num) {
		
		int max = num[0];
		
		for(int i = 0; i < num.length; i++) {
			
			if(num[i] > max) {
				max = num[i];
			}
		
		}
		return max;
	}
	
	public static int largerNum(int num1, int num2) {
		
		int largeNum = (num1 > num2) ? num1 : num2;
		
		return largeNum;
		
	}
	
	/*
	public static int minAndMax(int... num) {
		
		int max = num[0];
		int min = num[0];
		
		for(int i = 0; i < num.length; i++) {
			
			if(num[i] > max) {
				max = num[i];
			}
			
			if(num[i] < min) {
				min = num[i];
			}
		
		}
		
		//System.out.println("Min: " + min +
				   //"\nMax: " + max );
		
	}//minAndMax
	*/
	

}
