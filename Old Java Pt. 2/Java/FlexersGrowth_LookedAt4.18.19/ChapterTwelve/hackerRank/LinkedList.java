package hackerRank;

public class LinkedList {
	
	Node head;  // the head of the LinkedList
	
	/**
	 * Background:
	 *  - The only way to access/get in a linked list is to start with the 'head'
	 *  
	 *  - That is why, Node current = head, current is the value you're putting in.
	 *  
	 *  	- Followed by a while loop, while (current.next != null), read below.
	 *  
	 *  		- Simply saying, from 'head', walk to the last node, to null.
	 */
	
	// Methods
	
	public static int countNodes(Node head) {
		
		/**
		 * int count = 1;
		
		while (head.next != null) {
			head = head.next;
			count++;
		}
		
		return count;
		 */
		
		int count = 1;  // counter
		Node current = head;
		
		while (current.next != null) {  // while the reference inside 'next' is NOT NULL
			current = current.next;		// current will equal next Node's reference. --> Node next = new Node(next Object); and if not NULL continue.
			count++;					// increase count
		}								// loop again
		
		return count;
		
	}
	
	public void append(int data) {
		/**
		 * Now do you understand? 
		 */
		if(head == null) {  
			head = new Node(data);
			return;
		}
		
		Node current = head;  // current is now the 'head' 
		
		while (current.next != null) {  // walking through the list till null
			
			current = current.next;  // current will keep moving forward
			
		}
		
		current.next = new Node(data);  // the pointer, pointing to null, which is 'current.next' will equal new Node(data)
																		//  - creating a new node and a 'next' reference
	}  // end of append
	
	public void prepend(int data) {
		Node newHead = new Node(data);  // created new node
		
		newHead.next = head;	// pointing newHead's 'next' to the old head reference
		
		head = newHead;		// newHead is now head
	}
	
	public void delete(int data) {
		
		//ALWAYS HAVE a validation
		if (head == null) return;  //return exits us out of the loop
		
		if (head.data == data) {
			head = head.next; // head will now equal the reference it was holding inside 'next'
			return;
		}
		
		Node current = head;
		
		while (current.next.data == data) {
			current.next = current.next.next;  // I want the current's next pointer to equal current next next. SKIPPING the other pointer
		}
		
		
	}

}  // end of LinkedList
