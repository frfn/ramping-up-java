package chapter3;

public class TestToSeeIfOutdated {
	
	public static void main(String[] outdated) {
		
		/*
		 * In this case, this is NOT outdated
		 * Simply put, this was how it was written before
		 * with a constructor!, along with the reserved word 'new'
		 * Now, a String object can be created by using 
		 * double quotes and it will create the object 
		 * even without the use of the constructor
		 */
		
		String properlyWritten;
		
		String shortCutWritten;
		
		
		properlyWritten = new String("Flexer"); //with constructor, and reserved word new
		
		shortCutWritten = "Flexer"; //without, still very valid and creates string         
				
		
		 System.out.print((properlyWritten.length() + shortCutWritten.length()));
		
	}

}
