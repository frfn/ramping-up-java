package PP5_DemographicInformationCOULDHAVEHADBETTERAPPROACHBUTCOMPLETED;

public class Occupation extends Data {
	
	private String job;
	
	public Occupation(String job) {
		this.job = job;
	}
	
	public Occupation(String name, String job) {
		super(name);
		
		this.job = job;
	}
	
	public String getOccupation() {
		return job;
	}
	
	public String toString() {
		
		String str = "";
		
		str += "\nName: " + name + " | Occupation: " + job;
		
		return str;
		
	}

}
