package chapter5CheckBoxes;
import java.awt.Frame;

import javax.swing.*;
public class CheckBoxMain {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Check Boxes!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CheckBox panel = new CheckBox();
		
		
		
		window.getContentPane().add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}

}
