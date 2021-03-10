package checkbox;

/*
 * We will now construct checkboxes!
 * 
 * 
 * First off is to import NEEDED environments,
 * the swing, awt, and the awt.events
 */

/*
 * How to setup!
 * 
 * 1.) Declare needed components
 * 
 * 2.) Declare ItemListener, private class, NOT IMPLEMENTS JPANEL, you know ;D
 * 
 * 3.) Initialize the labels and check boxes!
 * 
 * 4.) Start listing and giving her the needed looks/listeners
 * 
 * 5.) Initialize whatever that needs to be initialized
 * 
 * 6.) Keep debugging!
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CheckBoxPanel extends JPanel {

	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	
	public CheckBoxPanel() {
		
		label = new JLabel("Keep on swimming and don't overthink anymore!");
		label.setFont(new Font("Helvetica", Font.PLAIN, 24));
		
		bold = new JCheckBox("Click me to become bold!");
		
		italic = new JCheckBox("Click me to become italic!");
		
		Listener listener = new Listener();
		/*
		 * You can create the listener object,
		 * or you can just do a one liner!
		 * 
		 * bold.addItemListener(new Listener());
		 * 
		 * or you can do what were doing here and
		 * creating it.
		 */
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		
		add(label);
		add(bold);
		add(italic);
		
		
		
		
		setBackground(Color.orange);
		setPreferredSize(new Dimension(550, 125));
		
	}
	
	private class Listener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			
			int style = Font.PLAIN;
			System.out.println(style);
			
			
			
			if(bold.isSelected()) {
				style += Font.BOLD;
				
				System.out.println(style);
			}
			
			if(italic.isSelected()) {
				style += Font.ITALIC;
				
				System.out.println(style);
			}
			
			label.setFont(new Font("Helvetica", style, 24));
			
		}
		
	}

}
