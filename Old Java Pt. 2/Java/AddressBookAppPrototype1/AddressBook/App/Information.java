package App;

/**
 * 
 * @author Flexer
 * 
 * Made a class called Information
 *  - A constructor class
 *  - Has getters and setters
 */

public class Information {
	
	protected String firstName, lastName, phoneNumber, emailAddress;
	
	// Constructor
	public Information(String f, String l, String p, String e) {
		firstName = f;
		lastName = l;
		phoneNumber = p;
		emailAddress = e;
	}
	
	// Getter
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	// Setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String toString() {
		String str = "";
		str += "\nFirst Name: " + firstName + "\nLast Name: " + lastName;
		str += "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress;
		return str;
	}

}
