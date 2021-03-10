package chapter5CheckBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBox extends JPanel {
	
	/*
	 * Usually declaring the variables here will be the variables that 
	 * will be mainly used in the program
	 */
	
	//three fields
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	
	
	//constructor will create panel
	public CheckBox() {
		
		/*
		 Setting the label!
		 */
		label = new JLabel("Coffee?!");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		label.setForeground(Color.white);
		/*
		 Setting the Check Boxes
		 */
		
		//Bold check box
		bold = new JCheckBox("Do you want Bold?");
		bold.setBackground(Color.CYAN);
		
		//Italic check box
		italic = new JCheckBox("Do you want Italic?");
		italic.setBackground(Color.MAGENTA);
		
		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		
		add (label);
		add (bold);
		add (italic);
		
		setBackground (Color.DARK_GRAY);
		setPreferredSize (new Dimension (540, 100));
		
	}
	
	/*
	 Having a private class will make sure this is not touched when compiled
	 and run.
	 
	 This will be the listener, if the check box is selected, this will happen
	 */
	
	private class StyleListener implements ItemListener {
		public void itemStateChanged (ItemEvent event) {
			
			int style = Font.PLAIN;
			
			//value is 0 for plain
		
			
			if(bold.isSelected()) {
				style = Font.BOLD; 
				
				//value is 1 for bold
				//System.out.println(style);
			}
			
			
			
			if(italic.isSelected()) {
				style += Font.ITALIC;
				
				//value is 2 for italic 
				//System.out.println(style);
			}
			
			label.setFont(new Font("Times New Roman", style, 36));	
			//this line right above is here because after the if
			//statement has been chosen, it's style changed
			//meaning that it has to be "set" again for the
			//fonts to show change!
		}
	}

}
