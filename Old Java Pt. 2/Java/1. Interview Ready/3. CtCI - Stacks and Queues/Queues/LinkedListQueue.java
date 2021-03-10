package Queues;

import java.util.EmptyStackException;

public class LinkedListQueue<X> {
	
	public static void main(String[] args) {
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		
		queue.enqueue(10);
		queue.enqueue(9);
		queue.enqueue(8);
		queue.enqueue(7);
		queue.enqueue(6);
		
		System.out.println("First Element: "+queue.peek());
		
		System.out.println(queue);
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		System.out.println(queue);
	}
	
	private static class Node<X> {
		private X data;
		private Node<X> next;
		
		public Node(X data) {
			this.data = data;
		}
		public String toString() {
			return data.toString();
		}
	}
	
	Node<X> first, last;
	int length;
	
	public boolean isEmpty() {
		return first == null && last == null;
	}
	
	public LinkedListQueue() {
		first = last = null;
		length = 0;
	}
	
	public void enqueue(X item) {
		Node<X> newNode = new Node<X>(item);
		if(isEmpty()) {
			last = newNode;
			first = last;  // connects the linked list
			length++;
		}
		
		else {
			// will be placed after current node
			last.next = newNode;
			
			// sets newNode as the "last" value
			last = newNode;
			length++;
		}
	}
	
	public X dequeue() {
		
		if(isEmpty()) {
			System.out.println("Empty queue...");
		}
		else {
			X item = first.data;
				
			first = first.next;
			length--;
			
			if(first == null) {
				last = null;
			}
			return item;
		}
		
		return null;
	}
	
	public X peek() {
		if(isEmpty()) {
			System.out.println("Empty queue...");
		}
		return first.data;
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		
		Node<X> current = first;
		while(current != null) {
			build.append(current + ", ");
			current = current.next;
		}
		build.append(current + ", ");  // to show if nothing!
		return build.toString();
	}
}
