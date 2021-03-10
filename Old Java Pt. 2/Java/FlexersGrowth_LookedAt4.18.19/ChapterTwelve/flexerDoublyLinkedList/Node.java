package flexerDoublyLinkedList;

public class Node {
  
  public int data;  // type
  Node next;  // next node variable
  Node prev;  // prev node variable
  
  
  public Node(int data){
    this.data = data;
  }
  
  public void display(){
    System.out.println("Your value is: " + data);
  }
  
  public String toString() {
	  return data + "";
  }
}


