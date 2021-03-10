package Computer;

public class ComputerNode {
	  
	  Computer data;  // data that we are putting in
	  ComputerNode next;  // the next node (reference)
	  
	  public ComputerNode(Computer data){
	    this.data = data;
	  }
	  
	   public String toString(){
	    return "Brand: " + data.brand + "\nModel: " + data.name;
	  }
	  
	}

