package chapter3;

public class TestEnumeration {
	
	/*
	 * Enumerations are like having your own, controlled data type, 
	 * it is type-safe because you cannot assign any other value
	 * other than the ones that are declared inside the enumeration declaration
	 * as seen below "enum brands {...};"
	 * 
	 */
	
	enum brands {Apple, Microsoft, Oracle, Bose, StartUps, Lenovo, Honda, Infinit, Acura, Nissan};
	
	public static void main(String[] enumerations) {
		
		
		brands name; //creating a variable under brands
		
		brands testName = brands.Microsoft;
		
		name = brands.Oracle;	//giving name a value, value can only be given 
		
		System.out.println(name);
		System.out.println(name.ordinal());	//ordinal is the index of the value is, name = Orcale, which is 2
		
		System.out.println(testName);
		System.out.println(testName.ordinal());
	}

}
