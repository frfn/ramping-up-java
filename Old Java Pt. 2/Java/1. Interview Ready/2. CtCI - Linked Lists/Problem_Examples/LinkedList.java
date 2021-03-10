package Problem_Examples;

import java.util.HashSet;

public class LinkedList {
	
	Node head;
	int length;
	
	public LinkedList() {
		head = null;
		length = 0;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void add(int data) {
		Node node = new Node(data);
		
		if(isEmpty()) {
			head = node;
			length++;
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = node;
		length++;
		return;
	}
	// helper class for delete middle node
	private void delete(Node node) {
		if(isEmpty()) {
			System.out.println("Empty list...");
		}
		
		if(head==node) {
			head = null;
			length--;
		}
		
		Node current = head;
		while(current.next != null) {
			if(current.next == node) {
				current.next = current.next.next;
				length--;
				return;
			}
			current = current.next;
		}
	
		
	}
	// helper class for deleting middle node AND merge sort!
	private Node getMiddleNode(Node node) {
		if(isEmpty()) {
			System.out.println("List is empty...");
		}
		
		Node slowPtr = node;
		Node fastPtr = node.next;  // this changes the value of middle node, it will land EARLIER since it will hit condition quicker!!
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		return slowPtr;
	}
	private Node merge(Node L, Node R) {
		Node temp = new Node();
		Node finalList = temp;
		while(L != null && R != null) {
			if(L.data < R.data) {
				temp.next = L;
				L = L.next;
			}
			else {
				temp.next = R;
				R = R.next;
			}
			temp = temp.next;
		}
		// if any are left over!
		temp.next = (L == null) ? R : L;
		return finalList.next;
	}
	/**
	 * 
	 * @param node
	 * @return
	 * 
	 * --Important:--
	 * 
	 * Note: when you are merge sorting, always set the returned Node as the new head!!
	 */
	public Node mergesort(Node node) {
		if(node == null || node.next == null) {
			return node;
		}
		
		Node middle = getMiddleNode(node);
		Node secondHalf = middle.next;
		middle.next = null; // because the node we're altering is the "head"
		
		Node L = mergesort(node);
		Node R = mergesort(secondHalf);
		
		return merge(L, R);
		
	}
	// this is made for mergesort to be used in main!
	public void setHead(Node node) {
		head = node;
	}
	public String toString() {
		StringBuilder build = new StringBuilder();
		if(isEmpty()) {
			return "Empty list...";
		}
		
		Node current = head;
		while(current.next != null) {
			build.append(current + " --> ");
			current = current.next;
		}
		build.append(current + " --> null");
		return build.toString();
	}
	
	// Problem 1. Remove duplicates from unsorted linked lists
	public void removeDuplicatesFromUnsortedLinkedList() {
		if(isEmpty()) {
			System.out.println("Empty list...");
		}
		
		HashSet<Integer> set = new HashSet<>();
		Node prev = null;
		Node current = head;
		while(current != null) {
			if(set.contains(current.data)) {
				prev.next = current.next;
				length--; 
			}
			else {
				set.add(current.data);
				prev = current;
			}
			current = current.next;
		}
	}
	
	// Problem 2. Find node nth to the last of the linked lists
	public Node nthToTheLast(int num) {
		if(isEmpty()) {
			return null;
		}
		
		Node current = head;
		Node refPtr = head;
		
		int counter = 0;
		while(counter < num) {
			refPtr = refPtr.next;
			counter++;
		}
		
		while(refPtr != null && refPtr.next != null) {
			current = current.next;
			refPtr = refPtr.next;
		}
		
		return current;
		
	}
	
	// Problem 3. Delete middle node
	public void deleteMiddleNode() {
		Node middle = getMiddleNode(head);
		delete(middle);
	}
	
	// Problem 4. Partition the linked list, separate from less than or greater than
	public void partition(int num) {
		Node current = head;
		
		Node lessThan = new Node();
		Node greaterThan = new Node();
		
		Node lt = lessThan;
		Node gt = greaterThan;
		
		while(current != null){
			if(current.data <= num) {
				lessThan.next = current;
				lessThan = lessThan.next;
				
			}else {
				greaterThan.next = current;
				greaterThan = greaterThan.next;
				
			}
			current = current.next;
			
			/**
			 * I was experiencing a problem
			 * - I had to unlink the chain current hit null!
			 * - current != null works too because it sets it to null!
			 */
			if(current == null) {
				lessThan.next = null;
				greaterThan.next = null;
			}
		}
		
		System.out.println("Less than or equal to " + num);
		while(lt.next != null) {
			System.out.print(lt.next+" --> ");
			lt = lt.next;
		}
		System.out.println(lt.next);
		
		System.out.println();
		
		System.out.println("Greater than " + num);
		while(gt.next != null) {
			System.out.print(gt.next+" --> ");
			gt = gt.next;
		}
		System.out.println(gt.next);
		
	}
	
	// Problem 5. Linked List Sum
	
	// Problem 6. See if linked list is a palindrome
	public boolean isPalindrome() {
		/**
		 * If you're thinking about odd value list, this handles it!
		 */
		
		Node slowPtr = head;
		Node fastPtr = head; // we're getting the node "later", different from mergesort!
		
		while(fastPtr.next != null && fastPtr != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		// the slowPtr becomes reversed!
		// 1 2 3 4 3 2 1
		// becomes: 1 2 3 --> 1 2 3, and yes the list is STILL chained!
		slowPtr = reverse(slowPtr);
		
		// Goes back to head!
		fastPtr = head; 
		
		// we're still chained, so now compare and see if values are equal to each other!
		while(slowPtr != null) {
			if(slowPtr.data != fastPtr.data) {
				return false;
			}
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		return true;
	}
	// used for isPalindrome method()
	private Node reverse(Node node) {
		Node prev, after; prev=after=null;
		Node current = node;
		while(current != null) {
			after = current.next;
			current.next = prev;
			prev = current;
			current = after;
		}
		return prev;
	}
	
	// Problem 7. Intersection
	
	// Problem 8. Detect if there is a loop in linked list
	public boolean isLoop() {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(fastPtr.next != null && fastPtr != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(slowPtr == fastPtr) {
				return true;
			}
		}
		
		return false;
	}
}
