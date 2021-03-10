package Stacks;

import java.util.EmptyStackException;

public class ArrayStack<X> {
	
	public static void main(String[] args) {
		
		String exp = "[((<>[{<><><><>}]{}))]";
		
		System.out.println(Balanced(exp));
		
	}
	
	public static boolean arePairs(char opening, char closing) {
		if(opening == '(' && closing == ')') return true;
		if(opening == '[' && closing == ']') return true;
		if(opening == '{' && closing == '}') return true;
		
		return false;
	}
	
	public static boolean Balanced(String expression) {
		ArrayStack<Character> stack = new ArrayStack<>();
		
		for(int i = 0; i < expression.length(); i++) {
			
			if(expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {
				stack.push(expression.charAt(i));
			}
			
			if(expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']') {
				if(stack.isEmpty() || !arePairs(stack.peek(stack.length-1), expression.charAt(i))) {
					return false;
				}
				else {
					stack.pop();
				}
			}
			
		}
		
		return stack.isEmpty();
	}
	
	private X[] data;
	private int length;
	
	public ArrayStack(int size){
		length = 0;
		data = (X[])new Object[size];
	}
	
	private void increaseSize() {
		X[] newArray = (X[]) new Object[data.length + 1];
		for(int i = 0; i < data.length; i++) {
			newArray[i]=data[i];
		}
		data = newArray;
	}
	
	public ArrayStack() {
		this(10000);
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void push(X item) {
		if(length == data.length) {
			increaseSize();
		}
		data[length++] = item;
	}
	
	public X pop() {
		if(length == 0) {
			throw new EmptyStackException();
		}
		return data[--length];
	}
	
	public X peek(int num) {
		return data[num];
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		
		for(int i  = 0; i < length; i++) {
			build.append(data[i] + "\n");
		}
		
		return build.toString();
	}

}
