package chapter4PushButton;

import java.awt.*;
/*
 * abstract windowing toolkit – the basic GUI components
 */
import java.awt.event.*;
/*
 * Famous event handler, this package contains ActionListener and etc.
 */
import javax.swing.*;
/*
 * this package is a more versatile package than its fathering package, the "java.awt.*;"
 */


public class PushButtonPanel extends JPanel {		
	/* 
	 * by putting "extends", 
	 * it makes this class have the 
	 * same attributes and characteristics/behaviors 
	 * of a JPanel
	 */
	
	private int count;
	private JButton pushButton;
	private JLabel labelForButtonCount;
	
	/*
	 * These are global variables, fields,
	 * So I'm assuming that these are declared first,
	 * then we can do what we normally do
	 * if we were to do it on the same file.
	 * 
	 * Check - Revised – edition when completed!
	 */
		//-----------------
			// Constructor !
				//-----------------
	
		public PushButtonPanel() {
			/*
			 * seems like by having this constructor, it's similar
			 * to a method call when instantiated in the "main" class
			 */
			
			count = 0;
			
			pushButton = new JButton("Push to increase by 1!");
			
			pushButton.addActionListener(new ButtonListener());
			/*
			 * Error right now, "ButtonListener()" is an ActionListener that was made
			 * Will be made in new class!
			 */
			
			labelForButtonCount = new JLabel("Pushes: " + count);
			labelForButtonCount.setForeground(Color.white);
			
			add(pushButton);
			add(labelForButtonCount);
			
			//setPreferredSize(new Dimension(500, 300));
			setBackground(Color.gray);
			
		}
		
		//Support method, NOT a service, this is here to support!
		//implements the ActionListener!
		private class ButtonListener implements ActionListener{
			
			public void actionPerformed(ActionEvent push) {
				
				count++;
				labelForButtonCount.setText("Pushes: " + count);
				
				//JOptionPane.showMessageDialog(null, "Hello!, close to increase count!", "Hello!", JOptionPane.INFORMATION_MESSAGE);
				//JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
				/*
				 * Above is how the showMessageDialog is created!
				 * MessageType is ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, or PLAIN_MESSAGE
				 * From the JOptionPane dot operator!
				 */
				
			}
			
		}

}
