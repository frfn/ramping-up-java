package bookTest;

public class Book {
	
	public String name, author;
	
	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}
	
	public String toString() {
		return "Book Name: " + name + "\nAuthor: " + author;
	}

}
