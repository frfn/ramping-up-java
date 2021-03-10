package ListTesting;

import java.text.NumberFormat;

public class CD {

	protected String title, artist;
	protected int track;
	protected double cost;
	
	public CD(String t, String a, int track, double c) {
		title=t;
		artist=a;
		this.track=track;
		cost=c;
	}
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return "Title: " + title + "\tArtist: " + artist + "\tTrack: " + track + "\tCost: " + fmt.format(cost);
	}
	
}
