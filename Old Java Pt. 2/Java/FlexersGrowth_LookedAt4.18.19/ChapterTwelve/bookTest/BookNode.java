package bookTest;

public class BookNode {
	
	// Two references
	
	Book data;  // the object type
	BookNode next;  // the next node
	
	public BookNode(Book data) {
		this.data = data;
	}
	
	public String toString() {
		return "Book Name: " + data.name + "\nAuthor: " + data.author;
	}
}
