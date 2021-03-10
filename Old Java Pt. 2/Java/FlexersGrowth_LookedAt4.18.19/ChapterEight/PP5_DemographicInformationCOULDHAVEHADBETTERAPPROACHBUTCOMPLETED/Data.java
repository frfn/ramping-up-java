package PP5_DemographicInformationCOULDHAVEHADBETTERAPPROACHBUTCOMPLETED;

public class Data {
	
	protected String name;
	
	public Data(String name) {
		this.name = name;
	}
	
	
	public Data() {
		this("N/A");
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String str = "";
		
		str += "Name: " + name;
		
		return str;
	}
	
}
