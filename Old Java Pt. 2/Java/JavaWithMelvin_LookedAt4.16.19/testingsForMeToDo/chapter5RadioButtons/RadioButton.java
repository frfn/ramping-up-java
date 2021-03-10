package chapter5RadioButtons;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 PLEASE REVISIT THIS... this needs to be studied.
 
 Check Boxes and Radio Buttons are different from the usual Button with ActionListeners
 */

public class RadioButton extends JPanel {
	
	private JLabel quote;
	private JRadioButton choice1, choice2, choice3;	//the RADIO BUTTONS!
	private String choice1string, choice2string, choice3string;
	
	public RadioButton() {
		/*
		 * Strings are made here, I wonder how theyll be used here.
		 */
		choice1string = "The realization of talking to anyone as just human beings!";
		choice2string = "Your mindset shall not affect who you are around people that are deemed worthy.";
		choice3string = "Be YOURSELF, don't fake anything, be upfront.";
		
		/*
		 * 
		 */
		
		quote = new JLabel("Select to receive an advice...");
		quote.setFont(new Font("Times New Roman", Font.BOLD, 30));
		quote.setForeground(Color.WHITE);
		
		
		choice1 = new JRadioButton("Choice 1");
		//you can have JRadioButton("Choice 1", true); <-- by having "true", it is already selected!
		choice1.setBackground(Color.BLUE);
		choice1.setForeground(Color.white);
		
		choice2 = new JRadioButton("Choice 2");
		choice2.setBackground(Color.BLACK);
		
		choice3 = new JRadioButton("Choice 3");
		choice3.setBackground(Color.WHITE);
		
		/*
		 Creating this object does not "organize" your buttons, this is not a "panel" or 
		 a "container", or something that will display the buttons, this is here because
		 it groups the radio buttons, so when one is chosen, the others will be off
		 */
		
		/*
		 WITHOUT BUTTONGROUP, literally, the choice selection gets messed up, it doesn't behave properly!
		 */
		ButtonGroup group = new ButtonGroup(); //this is an object already created somewhere
		
		group.add(choice1);
		group.add(choice2);	//adding the buttons to the group
		group.add(choice3);
		
		Listener listener = new Listener();
		choice1.addActionListener(listener);
		choice2.addActionListener(listener);
		choice3.addActionListener(listener);
		
		
		add(quote);
		add(choice1);
		add(choice2);
		add(choice3);
		
		setBackground(Color.orange);
		setPreferredSize(new Dimension(450,100));
		
	}
	/*
	 By making this class be one of the first things will make things easy in the future
	 */
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent pushed) {
			
			Object event = pushed.getSource();
			/*
			 So they created this object to make it easier for inputting
			 You can also have (pushed.getSource() == choice1) to have familiarity
			 
			 choice1 is an object, so object == object, they're compatible
			 if done with anything else, it would give us an error
			 */
			
			if(event == choice1) {
				quote.setText(choice1string);
			}
			else if(event == choice2) {
				quote.setText(choice2string);
			}else {
				quote.setText(choice3string);
			}
			
		}
	}

}
