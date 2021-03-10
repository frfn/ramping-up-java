package chapter4TempConverterGUI;

import javax.swing.*;

public class TempMain {
	
	public static void main(String[] tempConvert) {
		
		JFrame window = new JFrame("Convert now!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.getContentPane().add(new TempPanel());
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}

}
