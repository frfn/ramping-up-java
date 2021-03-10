package Stacks;

import java.util.EmptyStackException;

/**
 * 
 * @author Flexer
 *
 * @param <X>
 * 
 *  Stack has 4 main functions!
 *  - isEmpty() returns if stack is empty
 *  - pop() returns the element on top of stack and destroys it
 *  - push(X data) pushed new element on top of stack
 *  - peek() returns the element on top of stack!
 */

public class LinkedListStack<X> {
	
	public static void main(String[] args) {
		LinkedListStack<Integer> list = new LinkedListStack<Integer>();
		
		// adding
		list.push(4);
		list.push(5);
		list.push(6);
		list.push(7);
		list.push(8);
		
		// System.out.println("Peeking: " + list.peek());  // peeking
		
		// deleting
		list.pop(); // 8 is gone
		list.pop(); // 7 is gone
		
		System.out.println(list);
		
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
	
	Node<X> head;
	int length;
	
	public LinkedListStack() {
		head = null; length = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(X data) {
		Node<X> newNode = new Node<X>(data);
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	public X pop() {
		if(head == null) {
			throw new EmptyStackException();
		}
		X item = head.data;
		head = head.next;
		length--;
		return item;
	}
	
	public X peek() {
		if(head == null) {
			throw new EmptyStackException();
		}
		return head.data;
	}
	
	public String toString() {
		StringBuilder build = new StringBuilder();
		Node<X> current = head;
		
		
		while(current.next != null) {
			build.append(current + "\n");
			current = current.next;
		}
		build.append(current + "\nBottom of Stack");
		return build.toString();
	}
	

}
