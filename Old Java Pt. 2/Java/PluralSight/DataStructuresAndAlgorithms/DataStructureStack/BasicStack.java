package DataStructureStack;
// Check their Open Declaration
// import java.util.Stack;
// import java.util.Deque;
/**
 * Also check Stack.class implementation!
 * I like this, but am curious to see what the other one holds
 *
 * import java.util.Stack; Stack newStack = new Stack();
 * 
 * After inspection, Stack class implemented here RETURNS an element
 *
 * java.util.Stack is 1.0 - the normal stack class
 * java.util.Deque is 1.6 - the stack class UPDATED.
 * 
 * @author Flexer
 *
 *    --  <X>  --  <X>  -- <X> 
 *  -- <X>   @param  <X>  --
 *  <X>  --  <X>  --  <X>  --
 *  
 *  ^ that was created when I was mad at Nicole :(
 * 
 * Creating a stack from SCRATCH!!!!!
 * Read from the beginning to end!!!
 *
 * Understand why he's RETURNING some methods.
 *  - The sole purpose of having an object to return IS so that we can keep track said return things... (objects, ints, type w.e)
 * 
 * Underlying issue, this should be abstract.
 *  - Why? So that is remains consistent.
 *  - Lists will use this stack! Check it out, same package :)
 *  
 * Use this as something that other Stack classes will inherit from
 * 	- Can be a listStack where it utilizes the ArrayList and still be able to do Stack operations
 *  - Instead of using initialized space, now it's dynamic. 
 *  
 *  Dynamic Programming??? ....
 **/


public class BasicStack<X> implements StackInterface<X>  {  // We're saying that this will become Generic and can hold type of Data Type
	
	private X[] data;  // we'll be using an array to hold the information in
	private int stackPointer; // this just means index of stack pointer
	
	/**
	 * Keep it private.
	 * No setters, no getters.
	 * Will only be handled internally.
	 */
	

	
	public BasicStack() {
		/**
		 * casting the Objects to become X... which is, whatever objects
		 */
		data = (X[]) new Object[2];  // data will hold 1000 elements, 1000 open memory slots
		/**
		 * (X[]) - cast as Object will become generic
		 * new Object[1000] - type Object with 1000 open memory slots
		 */
		stackPointer = 0;  // an internal pointer, essentially a place holder, an index, a spot in memory, i
		
	}
	
	// Amortized
	private void increase() {
		// Create new array
		X[] temp = (X[]) new Object[data.length * 2];
		
		// Copy all the stuff from old array, to new array.
		// O(n) -- will become slow, if millions of data entry...
		for(int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		
		data = temp;
	}
	
	public void push(X newItem) {
		// THIS BELOW... is dynamic programming. Ex. When array reaches max size, double size!
		if(size() == data.length) {
			System.out.println("Inreasing size to " + data.length * 2);
			increase();
		}
		
		data[stackPointer++] = newItem;  
		System.out.println("- New Item: " + newItem);
		// the counter will go up every time a new item has been added after the fact
		// post increment
	}
	
	public X pop() {
		if(stackPointer == 0) {
			throw new IllegalStateException("No more items to pop on stack");
		}
		return data[--stackPointer];  // Notice: we're not deleting anything but OVERWRITING it. 
		 							// Now that I understand what a garbage collector is and how linked list works, that data will just be collected
		
		// Notice: prefix decrement! It will decrement WITH the assigning, NOT AFTER.
		// Stack pointer will be EXACT.
		// Putting the prefix and postfix IS IMPORTANT when using it with assigning variables.
		
		/**
		 * What is it going to return? The exact data! 
		 * return data[--stackPointer] will return the data BEFORE the value of StackPointer
		 */
	}
	
	public boolean contains(X item) {  // contains just goes through the array and see if there are any .equal elements
		boolean found = false;
		
		for(int i = 0; i < stackPointer; i++) {  // iterating through ALL the elements inside array, we're keeping it simple. We're only putting integer values so this will work. 
			if(data[i].equals(item)) {
				found = true;
				return found;  // not going to break, will just return found
			}
		}
		
		return found;
	}
	
	public X access(X item) {  // this is a destructive operation as it deletes till it finds the item you're looking for
		while(stackPointer > 0) {
			X tempItem = pop();
			/**
			 * Confusing to look at.
			 * X tempItem = pop(); ?
			 * Not anymore.
			 * 
			 * X just means the data type. (String, int, double, whatever!)
			 * tempItem is the reference variable.
			 * pop(); remember this returns data!
			 * 
			 * Deletes going from last element, to the first!
			 */
			
			if(item.equals(tempItem)) {  // if item equals the item that is about to be popped, return the tempItem
				return tempItem;
			}
		}
		
		// if we didn't find the item, throw exception, a guard or check code
		throw new IllegalArgumentException("Could not find item on stack: " + item);  // this is a way to 'return' something?! Crazy.
	}
	
	public int size() {  // returns the size, which is the stackPointer, or i.
		return stackPointer;
	}
	
	public String toString() {
		String str = "";
		
		if(stackPointer == 0) {
			return str += "Stack is empty.";
		}
			else {
				str = "";
				for (int i = 0; i < stackPointer; i++) {
				str += data[i];
			}
		}
		return str;
	}
 
}
