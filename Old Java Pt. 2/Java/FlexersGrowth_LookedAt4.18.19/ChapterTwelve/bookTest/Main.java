package bookTest;

public class Main {
	public static void main(String[] args) {
		Book b1 = new Book("The Hunger Games", "Stephen Collins");
		Book b2 = new Book("Catching Fire", "StephenCollins");
		Book b3 = new Book("The Mockingjay", "Stephen Collins");
		Book b4 = new Book("The Mockinghay Part II", "Stephen Collins");
		Book b5 = new Book("Post Games", "Stephen Collins");
		
		BookList library = new BookList();
		
		library.add(b1);
		library.add(b2);
		library.add(b3);
		library.add(b4);
		library.add(b5);
		
		System.out.println(library);
		System.out.println("Deleting Post Games...");
		
		library.delete(b5);
		
		System.out.println(library);
		
		System.out.println("Hello");
		
	}

}
