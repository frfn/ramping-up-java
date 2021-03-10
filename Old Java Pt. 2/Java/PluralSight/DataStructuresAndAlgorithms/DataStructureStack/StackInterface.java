package DataStructureStack;

/**
 * 
 * @author Flexer
 *
 * @param <X> - stands for GENERIC type!!!!!!!!!
 */

public interface StackInterface<X> {
	
	/* This class will hold the needed methods for the stack
	 *
	 * Stack are of O(1) so it's very efficient - adding
	 * Other methods are of linear efficiency, O(N) - doing operations
	 * Java's right out of box, class Stack and Deque - in house implementation
	 */
	
	public void push(X item);
	public X pop();
	public boolean contains(X item);
	public X access(X item);
	public int size();

}
