
package App;

public class AddressRecord {
	
	protected String firstName, lastName, phoneNumber, emailAddress;
	
	// Constructor
	public AddressRecord(String f, String l, String p, String e) {
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
	
	public String toString() {
		String str = "";
		str += "\nFirst Name: " + firstName + "\nLast Name: " + lastName;
		str += "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress;
		return str;
	}

}

