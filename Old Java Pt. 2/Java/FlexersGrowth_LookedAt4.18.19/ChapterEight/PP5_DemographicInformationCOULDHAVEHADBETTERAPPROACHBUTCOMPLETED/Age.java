package PP5_DemographicInformationCOULDHAVEHADBETTERAPPROACHBUTCOMPLETED;

public class Age extends Data {
	
	private int age;
	
	public Age(int age) {
		this.age = age;
	}
	
	public Age(String name, int age) {
		super(name);
		
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public String toString() {
		
		String str = "";
		
		str += "\nName: " + name + " | Age " + age;
		
		return str;
		
	}
}
