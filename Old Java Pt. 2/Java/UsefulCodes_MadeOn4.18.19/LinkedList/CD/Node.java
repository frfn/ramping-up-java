package CD;

import java.text.NumberFormat;

public class Node {
	
	CD data;
	Node next;
	
	public Node(CD data) {
		this.data = data;
	}
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return "Song: " + data.song + "\tArtist: " + data.artist + "\tTrack: " + data.track + "\tCost:" + data.cost ;
	}

	
	
}
