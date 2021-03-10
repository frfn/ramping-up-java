package Computer;

public class Main {
	  public static void main(String[] args) {
		    
		    System.out.println("Computer Linked List");
		    System.out.println("----------------------");
		    
		    LinkedList list = new LinkedList();
		    
		    list.add(new Computer("Apple", "MacBook Pro 15"));
		    list.add(new Computer("Apple", "MacBook Pro 13"));
		    list.add(new Computer("Microsoft", "Surface Book 2"));
		    list.add(new Computer("Microsoft", "Surface Laptop 2"));
		    list.add(new Computer("Microsoft", "Surface Pro 6"));
		    
		    System.out.print(list.toString());
		    System.out.print("Number of elements: ");
		    list.countComputer();
		    
		    
		    
		  }
		}

