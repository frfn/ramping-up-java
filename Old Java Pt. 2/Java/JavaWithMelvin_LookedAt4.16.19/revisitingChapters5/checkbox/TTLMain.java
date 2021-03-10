package checkbox;
import java.awt.Dimension;

import javax.swing.*;
public class TTLMain {	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Language Selection");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane panel = new JScrollPane(new ThingsToLearn());
		
		window.getContentPane().add(panel);
		window.setSize(500, 300); //NOT PREFERRED SIZE!
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
