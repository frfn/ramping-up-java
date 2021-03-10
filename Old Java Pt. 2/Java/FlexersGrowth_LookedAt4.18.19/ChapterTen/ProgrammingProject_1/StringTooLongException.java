package ProgrammingProject_1;

public class StringTooLongException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	StringTooLongException(String message) { 
		super(message);
	}

}
