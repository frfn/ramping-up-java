package DataStructureList;

/**
 * 
 * @author PluralSight
 * 
 * Doubly Linked List structure, but ultimately a singly linked list, with head node and tail node. first | last
 *
 * @param <X>
 */

public class BasicList<X> implements ListInterface<X> {
	
	
	/**
	 * Head and tail
	 */
	private Node first, last;
	
	/**
	 * This is the length of list
	 */
	private int size;
	
	/*
	 * This is SIMILAR to doubly linked list, difference is NODE CLASS has JUST NEXT variable... interesting...
	 * Ultimately THIS IS IS A SINGLY LINKED LIST
	 */
	public BasicList() {
		first = last = null;
		size = 0;
	}
	
	/*
	 * This also makes them link, last = first... tail = head...
	 * 
	 * Note: Adding
	 * <X> stands for any type.
	 * 
	 * if empty, head = new Node(data);
	 * 
	 * tail=head; 
	 * 
	 * 
	 */
	@Override
	public void add(X data) {  // adds data end of list
		if(first == null) {
			first = new Node(data);
			last = first;  // first and last will be the same
		}
		else {
			Node newLastNode = new Node(data);
			last.setNextNode(newLastNode);  // this is how they're linked. setNextNode points to the 'next' Node variable where it will hold the references
			last = newLastNode;  // reinitialize the last node, to be the newLastNode, because it is the new last node
		}
		size++;  // increment
	}
	
	// Deleting
	@Override
	public X delete() {  // deletes data in front of the list
		if(first == null) {
			throw new IllegalStateException("List is empty");
		}
		else {
			X nodeItem = first.getNodeData();
			first = first.next;  // first will now equal the 'next' references
			size--;
			return nodeItem;
		}
	}

	// Size
	@Override
	public int size() {
		return size;
	}
	
	// Inserting
	@Override
	public void insert(X data, int position) {
		
		int index = 1;
		
		if (first == null) {
			System.out.println("List was empty, current position is: " + size);
			first = new Node(data);
			return;
		}
		
		else if (position < size) {
			throw new IllegalStateException("LinkedList is smaller than position given");
		}
		
		// prepending
		else if(position == 0) {
			Node newNode = new Node(data);
			newNode.next = first;
			first = newNode;
			return;
		}
		
		else {
			Node current = first;
			
			while (current.next != null) {
				if (index == position) {
					Node newNode = new Node(data);
					newNode.next = current.next;  // so new node will LINK to existing nodes AFTER
					current.next = newNode;  // so now, current.next should point to newNode as newNode's 'next' is already chained with others! 
				}
				current = current.next;
				index++;
			}
			size++;  // increases size by one
		}
		
	}

	@Override
	public X removeAt(int position) {
		int index = 1;
		
		if(first == null) {
			throw new IllegalStateException("List is empty");
		}
		
		else if(position < size || position > size) {
			throw new IllegalStateException("Position given does not match size" + size);
		}
		
		else if(position == 1) {
			first = first.next;
			return first.getNodeData();
		}
		
		else {
			Node current = first;
			while(current.next != null) {
				if (position == index) {
					current.next = current.next.next;
					return current.getNodeData();
				}
				current = current.next;
				index++;
			}
			size--;
		}
		
		throw new IllegalStateException("Error");
		
	}
	
	public X find(X data) {  // this is MY implementation, they returned an int value 
		X foundData;
		
		if(first == null) {
			throw new IllegalStateException("No element in list");
		}
		
		else {
			Node current = first;
			while(current.next != null) {
				if(current.getNodeData().equals(data)) {
					foundData = current.getNodeData();
					return foundData;
				}
				
				current = current.next;
			}
		}
		return null;
	}

	@Override
	public X get(int position) {
		int count = 1;
		Node current = first;
		while(current.next != null) {
			if(count == position) {
				return current.getNodeData();
			}
			current = current.next;
			count++;
		}
		
		return null;
	}
	
	public String toString() {
		String str = "";
		Node current = first;
		while (current != null) {
			str += current.toString() + " --> ";
			current = current.next;
		}
		str += current;
		
		return str;
		
	}
	
	/**
	 * 
	 * @author Flexer
	 *
	 * Class Node
	 *
	 */
	public class Node {
		
		private Node next;  // next node variable
		private X data;  // data
		
		public Node(X data) {
			this.data = data;  // constructor
		}
		
		public void setNextNode(Node nextNode) {  // Node variable passed in will be the 'next' node
			next = nextNode;
		}
		
		public Node getNextNode() {  // getting 'next' references
			return next;
		}
		
		public X getNodeData() {  // inside node, will be data
			return data;
		}
		
		public String toString() {
			return data + "";
		}
	}
	
	// Alters first... no good.

	/*
	public X deleteEnd() {
		if(first == null) {
			throw new IllegalStateException("List is empty");
		}
		else {
			while (first.next != null) {
				if(first.next.equals(last)) {
					X lastNode = last.data;
					first.next = first.next.next;
					return lastNode;
				}
				first = first.next;  // the iterator
			}
		}
		return null;  // if gets here, error or could not find!
	}
	*/
	
	/*
	public int size2() {
		int count = 0;
		if(first == null) {
			return 0;
		}
		else {
			while (first.next != null) {
				first = first.next;
				count++;  // might add an incremented value. keep eye out. test size() and size2()
			}
		}
		return count;
	}
	*/
	

	/*
	 * public void test() { System.out.println(".getNextNode: " +
	 * first.getNextNode()); System.out.println(".getCurrentNodeData: " +
	 * first.getNodeData()); }
	 */
	

}
