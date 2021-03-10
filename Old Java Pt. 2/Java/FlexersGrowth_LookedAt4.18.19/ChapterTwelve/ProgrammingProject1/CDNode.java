package ProgrammingProject1;

import java.text.NumberFormat;

public class CDNode {
	
	/**
	 * For node class, two elements are needed, data, and next node!
	 */

	CD data;
	CDNode next;
	
	public CDNode(CD data) {
		this.data=data;
	}
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return "Title: " + data.title + "\tArtist: " + data.artist + "\tTrack: " + data.track + "\tCost: " + fmt.format(data.cost);
	}
	
}
