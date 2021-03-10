package bookTest;

public class BookList {
	
	BookNode head;
	
	public BookList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return(head==null);
	}
	
	public int length() {
		int count = 0;
		if(isEmpty()) {
			return 0;
		}
		BookNode current = head;
		while(current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
	public void prepend(Book data) {
		BookNode newBook = new BookNode(data);
		newBook.next = head;
		head = newBook;
	}
	
	public void delete(Book data) {
		if(isEmpty()) {
			System.out.println("Empty list...");
			return;  // exits out of method
		}
		if(head.data==data) {
			head = head.next;
			return;
		}
		BookNode current = head;
		while(current.next != null) {
			if(current.next.data==data) {
				current.next = current.next.next;  // skips the found value;
				return;  // this exits out of the 'if' condition
			}
			current = current.next;
		}
	
	}
	
	public void add(Book data) {
		if(isEmpty()) {
			head = new BookNode(data);
		}
		BookNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new BookNode(data);
	}
	
	public String toString(){
	    String str = "";
	    BookNode current = head;
	    while(current.next != null){
	      str += current.next + "\n";
	      current = current.next;
	    }
	    return str;
	  }

}
