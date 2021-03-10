package books;

public class Main {

	public static void main(String[] args) {
		
		Dictionary d = new Dictionary(4, 12);
		
		int pages = d.getPages();
		int defs = d.getDef();
		
		System.out.println("Pages: "+pages+
						 "\nDefs: "+defs );
		
	
	}
	
}
