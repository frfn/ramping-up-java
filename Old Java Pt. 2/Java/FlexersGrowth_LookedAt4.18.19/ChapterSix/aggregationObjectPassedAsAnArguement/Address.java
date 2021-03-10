package aggregationObjectPassedAsAnArguement;

/**
 * 
 * @author flexer
 *
 *
 * Example inside book, learning more about it.
 */

public class Address {
	
	/**
	 * Initialized FOUR fields
	 * 
	 * address, city, state and zip
	 */
	
	private String address, city, state;
	private long zip;
	
	
	/**
	 * 
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * 
	 * These four are in the constructor,
	 * this will make the object!
	 */
	public Address(String address, String city, String state, long zip) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * A getter of ZIP code – this was a test BECAUSE the zip code
	 * was not outputting correctly
	 */
	public long getZip() {
		return zip;
	}
	
	//toString method
	public String toString() {
		
		String str = "";
		
		str += "\n"+address + ", ";
		str += city + ", " + state + ", ";
		str += zip;
		
		return str;
	}
	
	

}
