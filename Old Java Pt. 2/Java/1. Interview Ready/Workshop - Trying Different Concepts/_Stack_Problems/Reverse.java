package _Stack_Problems;

import java.util.Stack;

public class Reverse {
	
public static void main(String[] args) {
		
		String word = "flexer";
		
		String reversed = reverse(word);
		
		System.out.println(reversed);
		
		
	}
	
	public static String reverse(String str) {
		Stack<Character> stack = new Stack<Character>();
		char[] charArray = str.toCharArray();
		
		for(char letter: charArray) {
			stack.push(letter);
		}
		
		for(int i = 0; i < charArray.length; i++) {
			charArray[i] = stack.lastElement();
			stack.pop();
		}
		
		String reversed = new String(charArray);
		return reversed;

	}

}
