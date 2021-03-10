package chapter5LeftRight;

import javax.swing.*;

public class LeftRight {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Left or Right");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new LeftRightPanel());
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}
	
}
