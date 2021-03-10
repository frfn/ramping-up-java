package staff;

/**
 * 
 * @author Flexer
 *
 *
 * This class is the driver class
 *  - Includes StaffMember array called staffList
 *  - Populates array with different types of objects
 */

public class Staff {
	
	private StaffMember[] staffList;
	
	public Staff() {
		
		staffList = new StaffMember[5];
		
		staffList[0] = new Executive("Flexer Fadrigalan", "Boston, MA", "323898", "01386", 55000);
		staffList[1] = new Executive("Nicole Stanton", "Boston, MA", "781664", "01239", 60000);
		staffList[2] = new Hourly("Cyro Fadrigalan", "Boston, MA", "857249", "01386" , 70000);
		staffList[3] = new Volunteer("Maru Chandra", "Newton, MA", "781932");
		staffList[4] = new Employee("Jonah Grauman", "Portland, ME", "617898", "43486", 27);
		
		((Executive)staffList[0]).addBonus(350);
		((Employee)staffList[4]).paid(8); // I created the paid method
		((Hourly)staffList[2]).addHours(8);
		
	}
	
	public void payDay() {
		
		double amount;
		
		for(int i = 0; i < 5; i++) {
			
			System.out.println(staffList[i]); //Prints out their information
			
			amount = staffList[i].pay();
			/**
			 * Since this is NOT instantiated, it's only for one use, then becomes '0' again
			 *  - Values will not add up
			 */
			
			/**
			 * If amount = 0, print thanks, else print their paid amount, followed by ---...
			 */
			
			if(amount == 0) {
				System.out.println("Thanks!");
			}
			else {
				System.out.println("Paid: " + amount);
			}
			
			System.out.println("------------------------");
			
		}
		
		
	}

}
