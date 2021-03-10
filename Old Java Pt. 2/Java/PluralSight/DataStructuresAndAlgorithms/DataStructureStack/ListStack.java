package DataStructureStack;

import java.util.ArrayList;

/**
 * 
 * @author Flexer
 *
 * @param <X>
 * 
 * Notice the <X>, it is of generic type.
 */

public class ListStack<X> implements StackInterface<X> {

	/**
	 * Implementing an ArrayList instead of an array
	 */
	
	private ArrayList<X> list;
	private int stackPointer;
	
	public ListStack() {
		list = new ArrayList<X>();
		stackPointer = 0;  // initializing to 0
	}
	
	@Override
	public void push(X item) {
		list.add(item);
		stackPointer++;  // increase stack pointer once element is added
	}

	@Override
	public X pop() {
		return list.remove(--stackPointer);  
		// remove from list
		//--stackPointer;  
		// subtract the current iteration  
		// gets the updated element
	}

	@Override
	public boolean contains(X item) {
		if(list.contains(item)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public X access(X item) {
		while (list.size() > 0) {
			X tempItem = pop();
			if(item.equals(tempItem)) {
				return tempItem;
			}
		}
		throw new IllegalArgumentException("Could not find item on stack: " + item);
	}

	@Override
	public int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}

}
