package _Stack_Problems;

import java.util.Stack;

public class Expression_OpeningClosingMatching {
	
	public static void main(String[] args) {
		
		String expression = ")()";
		
		System.out.println(isBalanced(expression));
		
	}
	
	public static boolean arePair(char opening, char closing) {
		
		if(opening == '(' && closing == ')') {
			return true;
		}
		else if(opening == '[' && closing == ']') {
			return true;
		}
		else if(opening == '{' && closing == '}') {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean isBalanced(String expression) {
		if(expression.length() == 0 || expression.length() == 1) {
			return false;
		}
		
		else {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < expression.length(); i++) {
			
			if(expression.charAt(i) == '[' || expression.charAt(i) == '{' || expression.charAt(i) == '(' ) {
				stack.push(expression.charAt(i));
			}
			
			else if(expression.charAt(i) == ']' || expression.charAt(i) == '}' || expression.charAt(i) == ')' ) {
				if(stack.empty() || !arePair(stack.firstElement(), expression.charAt(i))) {
					return false;
				}
				else {
					stack.pop();
				}
			}
			
		}
		return (stack.empty()) ? true : false;
		}
		
	}

}
