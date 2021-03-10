package DataStructureQueue;

public interface QueueInterface<X> {
	
	/**
	 * One of the easiest data structure to understand.
	 * 
	 * It's essentially a line. FIFO, first in, first out.
	 * 
	 * enter here --> | o o o o - - - - - - > o  | <-- exit here
	 * 
	 * The efficiency of a Stack is similar to Queue
	 * can dequeue from the 'front' and the 'back'
	 */
	
	/**
	 * 
	 * @param item
	 * 5 functions
	 */
	public void enqueue(X item);  // O(1) constant
	public X dequeue();  // O(1) constant
	public boolean contains(X item);  // O(N) linear
	public X access(int position);  // O(N) linear
	public int size();
	
}
