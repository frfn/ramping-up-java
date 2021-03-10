package App;

/**
 * 
 * @author Flexer
 *
 * 
 * Made a list so I can test on main.
 * 
 * I commented out the things I do not need for database.
 * Codes that are not commented out are useful.
 */

public class InformationList {
	
	private Information[] info;
	private int count;
	
	public InformationList() {
		info = new Information[5];
		count = 0;
	}
	
	/*
	 * public int currentLength() { return count; }
	 */
	
	/*
	 * private void increase() { Information[] temp = new Information[info.length *
	 * 2];
	 * 
	 * for(int i = 0; i < info.length; i++) { temp[i] = info[i]; }
	 * 
	 * info = temp; }
	 */
	
	public void addInformation(String firstName, String lastName, String phoneNumber, String emailAddress) {
		/*
		 * if(count == info.length) { increase(); }
		 */
		
		info[count] = new Information(firstName, lastName, phoneNumber, emailAddress);
		count++;
		
	}
	
	/*
	 * public void printSpecificInformation(int num) {
	 * System.out.println(info[num]); }
	 */
	
	public String toString() {
		String str = "";
		
		for(int i = 0; i < count; i++) {
			str += info[i].toString() + "\n";
		}
		return str;
	}

}
