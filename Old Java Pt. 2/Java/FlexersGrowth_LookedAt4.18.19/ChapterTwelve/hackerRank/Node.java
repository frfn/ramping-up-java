package hackerRank;

public class Node {
	
	/**
	 *  To make it a double linked list
	 *  - Node prev;
	 *  - watch about it!
	 */
	
	Node next;  // <-- hmm?, how does it know what it is supposed to do? ANSWERED.
	
				// next DOES STORE VALUES. next IS THE REFERENCE. ANSWER BELOW.
	
				// also not 'private', keep in mind, so you can call this outside this constructor class
	
	/**
	 * The edit you were looking for... 
	 * 
	 *  - 'next' is creating a new node object called next
	 *  
	 *  - when you create an object with Node class, it will create 'next' and instantiate it to 'null'
	 *  
	 * 
	 *  ex. |-------------------|
	 *  	|    data	|  next | ---> null     <-- that's the representation anyways...
	 *  	|-------------------|
	 *  
	 *  - when 'current.next' is called, it is pointing to the REFERENCE to the 'next' object of where ever it is
	 *  
	 *  - when 'current.next = new Node(data);' is called
	 *  							- it is creating a new Node object
	 *  							- to the old Node object's 'next'
	 *  							- Creating a relationship with the old object
	 *  
	 */

	int data;

	/**
	 * A constructor
	 */
	public Node(int data) {
		this.data = data;
	}

}  // end of Node
