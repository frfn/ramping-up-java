package PP5_DemographicInformationCOULDHAVEHADBETTERAPPROACHBUTCOMPLETED;

public class Nationality extends Data {
	
	private String race;
	
	public Nationality(String race) {
		this.race = race;
	}
	
	public Nationality(String name, String race) {
		super(name);
		
		this.race = race;
		
	}
	
	public String getNationality() {
		return race;
	}
	
	public String toString() {
		
		String str = "";
		
		str += "\nName: " + name + " | Nationality: " + race;
		
		return str;
		
	}

}
