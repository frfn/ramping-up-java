package QueueTesting;
import DataStructureQueue.BasicQueue;
public class QueueTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		BasicQueue<Integer> queue = new BasicQueue<Integer>();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		
		System.out.println(queue);
		
		queue.dequeue();
		
		System.out.println(queue);
		
		queue.dequeue();
		
		System.out.println(queue);
		
	}
	
}
