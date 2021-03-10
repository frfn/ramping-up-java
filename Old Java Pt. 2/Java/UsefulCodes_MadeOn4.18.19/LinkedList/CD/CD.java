package CD;
import java.text.NumberFormat;
public class CD {

	String song, artist;
	int track;
	double cost;
	
	public CD(String s, String a, int t, double c) {
		song = s;
		artist = a;
		track = t;
		cost = c;
	}
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return "Song: " + song + "\tArtist: " + artist + "\tTrack: " + "\tCost:" + cost ;
	}
	
}
