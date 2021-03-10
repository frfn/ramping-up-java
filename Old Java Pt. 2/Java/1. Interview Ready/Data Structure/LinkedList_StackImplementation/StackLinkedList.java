package LinkedList_StackImplementation;

import java.util.Stack;

public class StackLinkedList {
	
	/**
	 * REVERSE METHOD, revisit:
	 * https://www.youtube.com/watch?v=sFVxsglODoo&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=15
	 * 
	 * That is stack implementation! :)
	 */

	Node head;
	int length = 0;
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public String toString() {
		if(isEmpty()) {
			return "List is empty...";
		}
		
		String str = "";
		Node current = head;
		while(current.next != null) {
			str += current + " --> ";
			current = current.next;
		}
		str += current + " --> " + current.next;
		return str;
	}
	
	public boolean isLoop() {
		if(isEmpty()) {
			return false;
		}
		
		Node slowPtr = head;
		Node fastPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(fastPtr == slowPtr) {
				return true;
			}
		}
		
		return false;
	}
	public Node top() {
		return head;
	}
	
	public void push(Node node) {
		if(isEmpty()) {
			head = node;
		}
		else {
			node.next = head;
			head = node;
		}
		length++;
	}
	
	public Node pop() {
		Node popped;
		if(isEmpty()) {
			return null;
		}
		else {
			length--;
			popped = head;
			head = head.next;
			return popped;
		}
	}
	
	public void reverse() {
		Stack<Node> stack = new Stack<Node>();
		
		Node current = head;
		while(current != null) {
			stack.push(current);
			current = current.next;
		}
		
		current = stack.lastElement();
		head = current;
		
		stack.pop();
		
		while(!stack.empty()) {
			current.next = stack.lastElement();
			stack.pop();
			current = current.next;
		}
		current.next = null;
		
	}
	
}
