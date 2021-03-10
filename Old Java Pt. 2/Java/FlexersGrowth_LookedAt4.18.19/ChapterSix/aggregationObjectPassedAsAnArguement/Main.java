package aggregationObjectPassedAsAnArguement;

//PROBLEM,
//Passing the zip code as an int changes value when outputted, changed as a String for now!!


/**
 * 
 * @author flexer
 * This is the aggregation of objects example
 * Using objects inside of objects!
 */
public class Main {

	public static void main(String[] args) {
		
		String zip = "02132";
		System.out.println(Integer.parseInt(zip));
		
		/**
		 * Created two objects of type Address
		 */
		
		Address home = new Address("Freeman Avenue", "Boston", "MA", 02132);
		System.out.println(home.getZip());
		
		Address school = new Address("Worcester Street", "Framingham", "MA", 01701);
		System.out.println(school.getZip());
		
		/**
		 * Student will need TWO type Address objects as the argument!
		 */
		
		Student flexer = new Student("Flexer", school, home);
		
		System.out.println(flexer);
		
	}
	
}
