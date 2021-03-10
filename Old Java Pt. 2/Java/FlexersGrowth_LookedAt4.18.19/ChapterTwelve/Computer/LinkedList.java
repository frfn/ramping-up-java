package Computer;

public 
class LinkedList {
	  
	  ComputerNode head;
	  
	  public boolean isEmpty(){
	    return (head==null);
	  }
	  
	  public void add(Computer data){
	    if (isEmpty()){  // if null, then create new data to be head
	      head = new ComputerNode(data);
	    }
	    // else 
	    ComputerNode current = head;  // created a variable called 'current', it contains the head
	    while (current.next != null){
	      current = current.next;
	    }
	    current.next = new ComputerNode(data);
	  }
	  
	  public void delete(Computer data){
	    if (isEmpty()){
	      return;  // if empt
	    }
	    if (head.data==data){
	      head = head.next;
	      return;
	    }
	    
	    ComputerNode current = head;
	    while (current.next != null){
	      if (current.next.data==data){
	        current.next = current.next.next;
	      }
	    }
	  }
	  
	  public void countComputer(){
	    int count = 0;
	    ComputerNode current = head;
	    if(isEmpty()){
	      System.out.println("Empty list...");
	   	}
	 	while (current.next != null){
	      current = current.next;
	      count++;
	    }
	    System.out.println("Number of elements: " + count);
	  }
	  public String toString(){
	    String str = "";
	    ComputerNode current = head;
	    while(current.next != null){
	      str += current.next + "\n";
	      current = current.next;
	    }
	    return str;
	  }
	  
	}


