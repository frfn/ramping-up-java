package aggregationObjectPassedAsAnArguement;

/**
 * 
 * @author flexer
 *
 * Student class that will build the student object
 *
 */

public class Student {
	
	//THREE fields, TWO being an ADDRESS type
	//fullName, school and home
	private String fullName;
	private Address school, home;
	
	/**
	 * 
	 * @param fullName
	 * @param school
	 * @param home
	 * 
	 * This is an aggregation since objects are being 
	 * passed inside a parameter
	 * 
	 * ***Think of it as this
	 * 		you're passing one object
	 * 		that just contains all the other stuff
	 * 		don't be overwhelmed brother! Literally look at it
	 * 		like there is ONLY THREE objects! B/C THERE ONLY IS
	 * 		three objects!!
	 */
	Student(String fullName, Address school, Address home){
		this.fullName = fullName;
		this.school = school;
		this.home = home;
	}
	
	public void setNewName(String newName) {
		this.fullName = newName;
	}
	
	public String toString() {
		return "Full Name: " + fullName + 
				"\n -- School Address --" + school + 
				"\n-- Home Address --" + home;
	}
	/*
	 * The toString of type Address will handle this method as well,
	 * when called, the toString of type Address will compile
	 * the toString in it's class, however it is formatted!!
	 * 
	 */
	
	

}
