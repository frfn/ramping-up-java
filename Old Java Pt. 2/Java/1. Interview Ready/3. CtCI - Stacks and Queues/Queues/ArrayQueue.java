package Queues;

/**
 * Main Point: the FRONT moves, the front deletes FIRST.
 * 
 * @author Flexer
 *
 * @param <X>
 * 
 * Interface:
 * - add(X data)
 * - remove()
 * - peek(int num)
 * - isEmpty()
 * 
 * Key Syntax:
 * 	front = -1
 * 	end = -1
 * 
 * add: 
 * 	if empty
 * 		++front;
 * 		data[++end] = item
 * 
 * 	else
 * 		data[++end] = item
 * 
 * remove: 
 * 	if empty
 * 		exception
 * 
 * 	if front == end
 * 		item = data[front]
 * 		data[front] = null
 * 		front=end= -1
 * 
 * 	else
 * 		item = data[front]
 * 		data[front] = null;
 * 		++front;
 */

public class ArrayQueue<X> {
	
	public static void main(String[] args) {
		
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		
		queue.add(1); // 0 index
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		System.out.println(queue);
		
		System.out.println("Removing: " + queue.remove()); 
		System.out.println("Removing: " + queue.remove()); 
		
		System.out.println();
		System.out.println(queue);
		
	}
	
	// an array of X objects
	private X[] data;
	private int front, end;
	
	public ArrayQueue(int size) {
		if(size == 0) {
			data = (X[]) new Object[10];
		}else {
			data = (X[]) new Object[size];
		}
		// Resolves to -1 if empty!
		front = -1;
		end = -1;
	}
	public ArrayQueue() {
		this(1);
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// Note: toString() is different 
	public String toString() {
		StringBuilder build = new StringBuilder();
		
		// Note: There is a Hot Spot -- i <= end
		for(int i = front; i <= end; i++) {
			build.append(data[i] + ", ");
		}
		
		return build.toString();
	}
	
	// Note: size() is different
	public int size() {
		// Means empty
		if(front == -1 && end == -1) {
			return 0;
		}
		else {
			// the way to find
			return end-front+1;
		}
	}
	private void increaseSize() {
		X[] temp = (X[]) new Object[data.length + 1];
		for(int i=0; i<data.length;i++) {
			temp[i]=data[i];
		}
		data = temp;
	}
	
	// unique to Queue
	public void add(X item) {
		// if END, specifically END has no remainder, means size is full!
		if((end+1) % data.length == front) {
			increaseSize();
		}
		
		// Check it, pre increment means it ASSIGNS AT index+1, not after!.
		if(size() == 0) {
			// Unique to queues!
			++front; // straight 0
			data[++end] = item; // item is at index 0!
			
		}
		else {
			data[++end] = item; // item is at index + 1!
		}
	}
	
	/**
	 * @return
	 * The most important part is HERE.
	 * Front is the one that MOVES!
	 */
	public X remove() {
		if(size() == 0) {
			throw new IllegalStateException("Queue is empty...");
		}
		X item = null;
		if(front == end) {
			item = data[front];
			data[front] = null;
			front = end = -1;
		}
		else {
			item = data[front];
			data[front] = null; // line 153, ++front, makes it so that this is Garbage Collected, but we're here to help
			++front;
		}
		return item;
	}

}
