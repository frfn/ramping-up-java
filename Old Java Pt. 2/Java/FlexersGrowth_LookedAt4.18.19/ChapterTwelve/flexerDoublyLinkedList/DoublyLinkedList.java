package flexerDoublyLinkedList;

/**
 * 
 * @author Flexer
 * 
 * this is based on Denish's tutorial on YouTube for Double Linked List
 *
 */

public class DoublyLinkedList {
	  
	  Node head;  // this starts the LinkedList
	  Node tail;  // the tail
	  public int length;
	  
	  public void display() {
		  if(head==null) {
			  return;
		  }
		  Node current = head;
		  while(current != null) {
			  System.out.print(current.data + " --> ");
			  current = current.next;
		  }
		  System.out.println(current);  // prints null
	  }
	  
	  public DoublyLinkedList(){  // initializing the list
		length = 0;
		tail = null;
	    head = null;  // no need because all objects declared are null, no head
	  }
	  
	  public boolean isEmpty(){
		  return(head==null);
		 /*
		  if (head==null) {
	    	return true;
	    }
	    else if (length==0) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	    */
	  }
	  
	  public int length(Node head){
	    Node current = head;  // countNode(LinkedList.head); to call it properly
	    int count = 1;
	    while (current.next != null){
	      current = current.next;
	      count++;
	    }  // end of while
	    return count;
	  }
	  
	  public void addFirstNode(int data){
		 
		/**
		 * Need to implement doubly linked list code
		 */
		  
	    //Node newHead = new Node(data);  <-- this works too but line below is more efficient
	    //head = newHead;
	    head = new Node(data);
	    length++;
	  }
	  
	  public void append(int data){
		  
		 /**
		  * Need to implement doubly linked list code
		  */
		  
	    if(head==null){  // if empty, create one node
	      addFirstNode(data);
	    }
	    Node current = head;  // create current variable just for the sake of ease
	    while(current.next != null){
	      current = current.next; //current becomes current.next
	    }
	    current.next = new Node(data);  // and that's how they link, the 'next' will have 
	    								// will have the next reference
	    								// current's next will become instantiated with a new reference
	    length++;
	  }
	  
	  public void prepend(int data){
		  
	   /**
		* Need to implement doubly linked list code
		*/
		  
	    Node newHead = new Node(data);  // new head node
	    newHead.next = head;  // setting the next variable of newHead to become head
	    head = newHead;  // the head takes on the newHead variable
	    length++;
	  }
	  
	  public void deleteValue(int data){
		  
		/**
		 * Need to implement doubly linked list code
		 */
		  
		  
	    if(head==null){return;}
	    if(head.data==data){
	      head = head.next;  // since garbage collection is apparent, once the 
	      					 // reference is not used, it will be collected and trashed
	      return;  // exit out of method
	    }
	    Node current = head;
	    while(current.next != null){
	      if(current.next.data == data){  // if the data is found in the next data
	        current.next = current.next.next;
	        length--;
	        return;							   // the next pointer will be equal to the next, next pointer!
	      }
	      	current = current.next;								   // skipping the found value
	    }									   // and being a candidate for garbage collection
	  }
	  	
	  
	  public void insertBehindNextValue(int data, int target) {
		  
		  if(isEmpty()) {
			  head = new Node(data);
		  }
		  
		  Node current = head;
		  while (current.next != null) {  // traverse till not null
			  if(current.next.data == target) {
				  Node newNode = new Node(data);  // created a new node to insert
				  newNode.next = current.next;  // new node's next will become current.next 
				  current.next = newNode;  // current.next will now point to newNode
				  
				  
				  
				/*
				 * Node temp = current.next; current.next = newNode; newNode.next = temp;
				 */
				  
				  return;
				  
			  }
			  current = current.next;  // walking through the list
		  }
	  }
	  
	  public String toString() {
		return head.toString();
	  }
	  
	}

/*
 * public void insertAfter(Node target, int data) {
 * 
 * if(target==null) { System.out.println("Null, error..."); return; }
 * 
 * Node newNode = new Node(data); newNode.next = target; target = newNode;
 * 
 * }
 */
