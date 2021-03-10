/*
 * Flexer Fadrigalan
 * Portfolio 460
 * Stack Machine
 * Keil
 */
package Portfolio460;
import java.util.*;

public class stackMachine {
	public static void main(String Flex[]) {
		
		Stack<Integer> stack = new Stack<Integer>();	//integer stack implemented
		
		stack.push(1);
		stack.push(3);		//pushing numbers
		stack.push(5);
		stack.push(7);
		printingStack(stack);	//printing stack
		
		System.out.println();
		
		//for(int i = 0; i < 2; i++ )
		stack.pop();
		stack.pop();									//popping two numbers
		printingStack(stack); 	//printing stack
		
		System.out.println();
		
		Stack<String> strStack = new Stack<String>();		//string stack implemented
		
		strStack.push("Hi");
		strStack.push(" ");
		strStack.push("this");
		strStack.push(" is a");
		strStack.push(" ");
		strStack.push("stack machine");
		strStack.push("test push");
		
		printingstrStack(strStack);
		
		System.out.println();
		
		strStack.pop();
		printingstrStack(strStack);
		
		
		//printing stack method calls underneath
	}

	private static void printingStack(Stack<Integer> printing) {
		
		if(printing.isEmpty()) {
			System.out.println("You have nothing on stack");
		}
		else {
			System.out.print(printing);
		}
		
	}
	
	private static void printingstrStack(Stack<String> printing) {
		
		if(printing.isEmpty()) {
			System.out.println("You have nothing on stack");
		}
		else {
			System.out.print(printing);
		}
	}
}
