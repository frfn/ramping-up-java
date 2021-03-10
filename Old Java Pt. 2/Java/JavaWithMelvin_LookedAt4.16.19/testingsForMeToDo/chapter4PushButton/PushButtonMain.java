package chapter4PushButton;

import javax.swing.*;

public class PushButtonMain {
	
	public static void main(String[] pushingButtons) {
		
		JFrame frame = new JFrame("Pushing Buttons!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		PushButtonPanel creatingPanel = new PushButtonPanel();   <--  RIGHT HERE
		
		frame.getContentPane().add(creatingPanel);			<-- CAN BE SHORTENED TO ONE LINE
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		This is a test, this was done in the SmileyFace class,
		it seems that there is a quicker way to do the same thing
		
		*/
		
		/*
		 * The only thing quicker was instead of creating the panel,
		 * it was created in the .add (actual parameter) as seen below!
		 */
		
		frame.getContentPane().add(new PushButtonPanel());  //<-- AS SHOWN HERE
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}

}
