package books;

public class Dictionary extends Book {
	
	private int definitions;
	
	/**
	 * Revisit please.
	 */
	
	/**
	 * 
	 * @param numPages
	 * @param numDefinitions
	 * 
	 * Using super to call the constructor of Book
	 *  - Contains constructor --> public Book(pages) { this.pages = pages; }
	 *  - numPages will be passed into the Book constructor and will directly assign pages a value
	 */
	
	public Dictionary(int numDefinitions, int numPages) {
		super(numPages);
		//numPages is initializing "pages" variable in Book class
		// --- Giving it value ---
		
		definitions = numDefinitions;
	}
	
	public double ratio() {
		return definitions/pages;
	}
	
	public int getDef() {
		return definitions;
	}
	
}
