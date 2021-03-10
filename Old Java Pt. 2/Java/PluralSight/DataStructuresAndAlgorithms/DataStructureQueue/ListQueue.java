package DataStructureQueue;
import java.util.ArrayList;
public class ListQueue<X> implements QueueInterface<X> {

	private ArrayList<X> list;
	private int front, end;
	
	public ListQueue() {
		this.front = -1;
		this.end = -1;
		list = new ArrayList<X>();
	}
	
	@Override
	public void enqueue(X item) {
		if(size() == 0) {
			front++; end++;
			list.add(item);
		}
		else {
			end++;
			list.add(item);		}
		}

	@Override
	public X dequeue() {
		X item = null;
		if(size() == 0) {
			throw new IllegalStateException("Queue is empty");
		}
		else if(front == end) {
			item = list.get(front);
			front = end = -1;
		}
		else {
			item = list.get(front);
			front++;
		}
		
		return item;
	}

	@Override
	public boolean contains(X item) {
		boolean found = false;
		
		if(size() == 0) {
			throw new IllegalStateException("Stack is empty");
		}
		else if(list.contains(item)) {
			found = true;
			return found;
		}
		
		return found;
	}

	@Override
	// this is not a DESTRUCTIVE method -- deleting data
	// It is just accessing that data
	public X access(int position) {
		if(size() == 0 || position > size()) {
			throw new IllegalArgumentException("No items in the queue");
		}
		
		int trueIndex = 0;
		for(int i = front; i <= end; i++) {
			if(trueIndex == position) {
				return list.get(i);
			}
			trueIndex++;
			//System.out.println(trueIndex);
		}
		
		throw new IllegalArgumentException("Could not get queue item at position" + position);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if(front == -1 && end == -1) {
		return 0;
		}
		else {
			return end - front + 1;
		}
	}
	
	public String toString() {
		String str = "";
		for (int i = front; i <= end; i++) {
			str += list.get(i).toString();
		}
		return str;
	}

}
