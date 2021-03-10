package LinkedList_Ex3_NewMethods;

import java.util.HashSet;

public class LinkedList {
	Node head;
	int length = 0;
	public boolean isEmpty() {
		return (head==null);
	}
	// Use StringBuilder...
	public String toString() {
		Node current = head;
		String string = "Head: ";
		
		while(current.next != null) {
			string += current.toString() + " --> ";
			
			// IMPORTANT
			// Note: do NOT forget to iterate linked list with: current = current.next;
			current = current.next;
		}
		string += current.toString() + " --> " + current.next;
		return string;
	}
	// Note: constructor
	public LinkedList() {
		//head = new Node(node.data);
		head = null;
		length = 0;
	}
	public void prepend(Node node) {
		node.next = head;
		head = node;
		++length;
	}
	public void add(Node node) {
		if(isEmpty()) {
			System.out.println("Empty list, adding node...");
			//head = new Node(node.data); ++length;
			head = node; length++;
			return;
		}
		else {
	
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = node;
		//current.next = new Node(node.data);
		//node.next = null; ITS ALREADY NULL.
		++length;
		return;
		}
	}
	public void delete(int num) {
		if(isEmpty()) {
			System.out.println("Empty list, can't delete...");
			return;
		}
		if(num == head.data) {
			head = head.next;
			--length;
			return;
		}
		Node current = head;
		while(current.next != null) {
			if(num == current.next.data) {
				current.next = current.next.next;
				--length;
				return;
			}
			current = current.next;
			
		}
		
	}
	public void delete(Node node) {
		if(isEmpty()){
			System.out.println("Empty list, can't delete...");
			return;
		}
		if(node == head) {
			head = head.next;
			--length;
			return;
		}
		Node current = head;
		while(current.next != null) {
			if(node == current.next) {
				current.next = current.next.next;
				--length;
				return;
			}
			current = current.next;
		}
		
	}
	
	////////////// New Methods //////////////
	
	// Note: sees if there's a loop.
	// - Very nice to see that if you add the same "node", it points to itself, it is an infinite loop.
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
	
	public void rotation(Node node) {
		
		// Added two new nodes, they're containers that will contain stuff
		// Note: MUST initialize to null for some reason.. :\
		// ... well stupid, it's because it's an object!
		Node newHead = null;
		Node addToHead = null;
		
		// Note: anything that deals with being selected, while(current != null) is the correct way compared to current.next
		// Note: similar to delete method!
		Node current = head;
		while(current != null) {
			if(current.next == node) {
				
				// Note: Once we find the node we're switching, the work starts!
				
				// current.next, the next object will be our new head
				newHead = current.next;
				
				// we want to set the current.next, null! newHead already contains it now!
				current.next = null;
				
				// addHead = head, it means it contains, 1 --> 2 --> 3 --> null | Note: null because current.next is set to null on line 112
				// Note: head is now altered, it's considered now as "old head" :)
				
				// it does affect the linked list as a whole, so head only IS 1 --> 2 --> 3 --> null
				addToHead = head;
				
				// head will become, 4 --> 5 --> null
				head = newHead;
				
				
				// Now we just have to add to the "new" head!
				current = head;
				while(current.next != null) {
					current = current.next;
				}
				
				// addToHead will be the 1 --> 2 --> 3 --> null !
				current.next = addToHead;  
				return;
			}
			current = current.next;
		}
		
	}
	
	// I don't like this method.
	public void add(Node node, int index) {
		if(index == 1) {
			node.next = head;
			head = node;
			++length;
		}
		
		int currentIndex = 1;
		Node current = head;
		while(current != null) {
			++currentIndex;
			if(currentIndex == index) {
				
				// Note: Think about it, don't delete nothing yet!
				// Note: assign FIRST, so node.next = current.next!!
				
				// THEN: current.next = node!!
				node.next = current.next;
				current.next = node;
				
				++length;
				return;
				
			}
			current = current.next;
		}
	}
	
	public void reverse() {
		Node prev, after;
		prev=after=null;
		
		Node current = head;
		while(current != null) {
			after = current.next;
			current.next = prev;
			prev = current;
			current = after;
			
		}
		head = prev;
	}
	
	// This middle node is used for merge sorting a linked list!
	public Node getMiddleNode(Node node) {
		if(node == null || node.next == null) {
			return null;
		}
		
		Node slowPtr = node;
		Node fastPtr = node.next;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;  // this can be a null, hence why fastPtr != null is in the while condition
		}
		return slowPtr;
	}
	
	public Node getMiddleNode() {
		
		/**
		 * This makes so much sense..
		 * 
		 * Note: the slowPtr is returned because as slowPtr runs forward next, fastPtr runs forward twice!
		 * 		 slowPtr returns the middle node!
		 */
		
		if(isEmpty()) {
			System.out.println("Empty list...");
			return null;
		}
		Node slowPtr = head;
		Node fastPtr = head;
		
		if(length == 1) {
			return slowPtr;
		}
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;  // this can be a null, hence why fastPtr != null is in the while condition
		}
		return slowPtr;
	}
	
	public Node getNthNodeFromEnd_Length(int n) {
		if(isEmpty()) {
			return null;
		}
		Node current = head;
		int count = this.length - n; int i = 0;
		while(i < count) {
			current = current.next;
			i++;
		}
		return current;
	}
	
	public Node getNthNodeFromEnd_Logical(int n) {
		if(isEmpty()) {
			return null;
		}
		
		Node current = head;
		Node refPtr = head;
		int i = 0;
		while(i < n) {
			refPtr = refPtr.next;
			i++;
		}
		
		while(refPtr != null) {
			current = current.next;
			refPtr = refPtr.next;
		}
		
		return current;
	}
	
	public void removeDuplicateFromUnsortedList() {
		HashSet<Integer> hs = new HashSet<Integer>();
		
		Node current = head;
		
		// Note: Since prev = current, it will be as ONE, with current, they will work on the same list!
		Node prev = null;
		
		while(current != null) {
			
			int current_data = current.data;
			
			if(hs.contains(current_data)) {
				prev.next = current.next;
			}
			else {
				hs.add(current_data);
				prev = current;
			}
			
			current = current.next;
			
		}
	}
	
	public void insertNodeSortedLinkedList(Node node) {
		if(isEmpty()) {
			return;
		}
		
		if(node.data < head.data) {
			node.next = head;
			head = node;
			++length;
			return;
		}
		
		Node current = head;
		Node temp = null;
		while(current != null && current.data < node.data) {
			temp = current;
			current = current.next; // will lead to null
		}
		node.next = current;
		temp.next = node;
		++length;
		return;
	}
	
	private Node merge(Node L, Node R) {
		Node temp = new Node();  // this IS important, this makes a whole new "list" every time 
		Node finalList = temp;
		
		while(L != null && R != null) {
			if(L.data < R.data) {
				temp.next = L;
				L = L.next;
			}else {
				temp.next = R;
				R = R.next;
			}
			temp = temp.next;
		}
		temp.next = (L == null) ? R : L;
		
		return finalList.next;
	}
	
	public Node mergesort(Node node) {
		if(node == null || node.next == null) {
			return node;
		}
		
		// middle is just a step to assist, the real half is secondHalf!
		Node middle = getMiddleNode(node);  
		
		// Note: secondHalf is, AFTER the middle the node!
		Node secondHalf = middle.next;
		/**
		 * Note: though middle is a "new" variable, linked lists are still CHAINED together.
		 * When set to null, it also sets the whole linked list, for the last node to null.
		 */
		middle.next = null;  // this alters the whole linked list! 
		
		Node left = mergesort(node);
		Node right = mergesort(secondHalf);
	
		return merge(left, right);
	}

	// O(N LOG N) -- use merge sort to accomplish n log n
	public void removeDuplicateFromSortedList() {
		if(isEmpty()) {
			return;
		}
	
		Node current = head;
		while(current != null) {
			/**
			 * Initializing temp node for comparison!
			 *  - if the data is the same, temp = temp.next
			 *  - this moves the POINTER, since temp = current, the list is STILL connected
			 */
			Node temp = current;
			
			while(temp != null && current.data == temp.data) {
				/**
				 * Move next node if the same
				 */
				temp = temp.next;
			}
			
			/**
			 * Changes here are important
			 *  - current.next = number that is not duplicate
			 *  - current will become the number that is not the duplicate
			 *  - linked list are still chained
			 */
			current.next = temp;
			current = current.next;
			
		}
	}
	
	public void setHead(Node node) {
		head = node;
	}
	
	// Recursion is NO good, iterative is better BUT, it's good to understand :)
	// Recursive Approach - Main Focus: Base Case and Argument is needed
	public void reverseWithRecursion(Node node) {
		if(node.next == null) {
			head = node;
			System.out.println("ha");
			return;
		}
		reverseWithRecursion(node.next);
		
		// In stack, this is how it works... node.next = 5, node = 4...
		// current.next = node is saying, 5 --> 4, node.next = null, 5 --> 4 --> null
		
		System.out.println("node.next: " + node.next);
		System.out.println("node: " + node);
		
		Node current = node.next;
		
		current.next = node;
		node.next = null;
	}
  	
	public void displayForwardWithRecursion(Node node) {
		if(node == null) {
			System.out.println("null");
			return;
		}
		System.out.print(node + " --> ");
		displayForwardWithRecursion(node.next);
		
	}
	
	public void displayReverseWithRecursion(Node node) {
		if(node == null) {
			return;
		}
		displayReverseWithRecursion(node.next);
		System.out.print(node + " --> ");
		
	}

}