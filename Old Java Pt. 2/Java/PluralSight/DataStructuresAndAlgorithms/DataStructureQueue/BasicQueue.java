package DataStructureQueue;

public class BasicQueue<X> implements QueueInterface<X> {  // Notice the <X>, it signifies generic typing
	
	private X[] data;  // array with generic values
	private int front, end;  // two variables front and end, notice they are int.

	public BasicQueue() {
		this(1000);  // he's using the constructor made after, and passing 1000 in
		// will now have 1000 spaces
		
		/**
		 * Setting front and end to -1
		 * and data = (X[]) new Object[1000];
		 */
	}
	
	public BasicQueue(int size) {  // once initialized, set their numbers to -1
		front = -1;  // if negative one, the queue is empty
		end = -1;
		data = (X[]) new Object[size];  // initialized with a specific size
	}

	@Override
	public void enqueue(X item) {
		/**
		 * Since the queue can be any size,
		 * this code makes sense.
		 * 
		 * Ex. size = 1000;
		 * 
		 * if end + 1, (it accounts for the index count) -- if 1000
		 * % data.length 								 -- % 1000
		 * == front										 -- front = 0
		 * 
		 * then it is full. 1000 % 1000 = 0.
		 * 
		 * if size 5.
		 * 
		 * 0, 1, 2, 3, 4 = 5 elements | index = (4 + 1) = 5 % 5  == 0. Front = 0; hence queue is full
		 * 
		 * if ( (end+1) == data.length ) {
		 * 		queue is full
		 * }
		 * 
		 */
		if((end+1) % data.length == front) {  // just a fancy way of saying if its equal to 0.
			throw new IllegalStateException("Queue is full");
		} 
		
		else if(size() == 0) {
			
			// front value will NEVER CHANGE, it will just be 0 the whole time
			front++; 
			
			
			end++;  // will initialize both of them to 0, making them have an element
			data[end] = item;
			// data[0] = item
			// does NOT matter if front, or end. In the end their just the index.
			
		}
		else {
			end++;
			data[end] = item;
		}
		
	}

	@Override
	public X dequeue() {  // this is the IMPORTANT part of the Data Structure, it is dequeuing: first in, first out!
		X item = null;  // we want to return something... that's why we made this because we don't need it...
		if(size() == 0) {
			throw new IllegalStateException("Queue is empty");
			// I can return 0;
		}
		else if(front == end) {
			item = data[front];  // or 'item = data[end]', does NOT matter. 
			// both will be at index 0.
			data[front] = null;  // the queue is NOW empty.
			
			// data that is being returned is variable, 'item'
			
			//initialize back to negative value to signify empty queue
			front = end = -1;
		}
		else {
			item = data[front];  // for good practice, front so it makes sense
			data[front] = null;  // helping the garbage collector, does NOT need to be coded
			front++;  // increase front -- we're 'dequeuing', so remove from front
		}
		return item;
	}

	@Override
	public boolean contains(X item) {  // O(N) - linear
		boolean found = false;
		
		if(size() == 0) {
			throw new IllegalStateException("Stack is empty");
		}
		
		else {
		
			for (int i = front; i < end; i++) {
				if(data[i].equals(item)) {
					found = true;
					return found;
				}
			}
			
			return found;
		}
	}

	@Override
	public X access(int position) {  //big o(N) - linear
		if(size() == 0 || position > size()) {  // if any 'size issues'
			throw new IllegalArgumentException("No items in the queue");
		}
		
		int trueIndex = 0;   // true index because front will not be 0 at all times.
		for(int i = front; i <= end; i++) {
			if(trueIndex == position) {
				return data[i];  // return at position [i]
			}
			trueIndex++;  // increase index 
		}
		
		throw new IllegalArgumentException("Could not get queue item at: " + position);
	}

	@Override
	public int size() {
		if(front == -1 && end == -1) {
			return 0;  // if empty, return 0;
		}
		else {
			return end - front + 1;  // the +1 is added because it is initialized as -1
			// so its basically saying 'end - 0 = end', end being the current size
		}
	}
	
	public String toString() {
		String str = "";
		for(int i = front; i <= end; i++ ) {
			str += data[i].toString();
		}
		return str;
	}
	
}
