package StackTesting;
import DataStructureStack.ListStack;
public class ListStackTest {
	
	public static void main(String[] args) {
		
		ListStack<String> stack = new ListStack<String>();
		
		stack.push("Hello");
		stack.push(" ");
		stack.push("World");
		stack.push("!");
		
		System.out.println(stack);
		
		stack.pop();
		
		System.out.println(stack);
		
		//System.out.println(stack.pop());
		
		//System.out.println(stack);
		
		stack.access("Hello");
		
		System.out.println(stack);
		
	}

}
