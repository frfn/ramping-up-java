package chapter5Bullseye;

import javax.swing.*;

public class BullseyeMain {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bullseye Baby!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BullseyePanel panel = new BullseyePanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
