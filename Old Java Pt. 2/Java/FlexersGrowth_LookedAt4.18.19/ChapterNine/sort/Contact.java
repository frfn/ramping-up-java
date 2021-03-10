package sort;

public class Contact implements Comparable {

	private String firstName, lastName, phone;
	
	public Contact(String f, String l, String p) {
		firstName = f;
		lastName = l;
		phone = p;
	}
	
	public String toString() {
		return lastName + ", " + firstName + ", " + phone;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override //equals method in Object class
	public boolean equals(Object other) {
		return (lastName.equals( ( (Contact) other).getLastName() ) &&  // ( (Contact) other ) type casted other
				firstName.equals( ( (Contact) other).getFirstName() ) );
	}

	/**
	 * Override
	 * 	- This comes from the implementation of Comparable
	 *  - Only 1 method, compareTo
	 *  	- returns
	 *  		–1 if less than
	 *  		 0 if equal to
	 *  		 1 if greater than
	 */
	
	@Override //compareTo method in Comparable class
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int result;
		
		/**
		 * By putting the parenthesis ( (Contact) o ) .getFirstName
		 * 	- It gives access to the Contact class
		 * 
		 * If parenthesis is (Contact) o .getFirstName
		 * 	- Will NOT work because we are accessing "o"'s class
		 * 		- Hence not being able to call the methods in Contact class
		 */
		String otherFirst = ((Contact)o).getFirstName();
		String otherLast = ((Contact)o).getLastName();
		
		if(lastName.equals(otherLast)) {
			result = firstName.compareTo(otherFirst);
		}
		else {
			result = lastName.compareTo(otherLast);
		}
		
		return result;
	}
	
	
	
}
