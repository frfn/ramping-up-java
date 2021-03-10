package palindrome;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

/*
 * Read this for notes okay?
 * 
 * Take note that CLASS EXTENDS JPANEL.
 * Why? SO that it takes JPanel characteristics and can be used in Main
 * 
 * Listen, first off I created the constructor panel and then
 * the private class with nothing in them, and yes, with the public void
 * 
 * Pre setup done!
 * 
 * 1.) components are declared globally
 * 
 * 2.) Started to assign declared components inside constructor
 * 
 * 3.) Coded the listener so that when I press submit it will compute and 
 * 		see if word is a palindrome! Very interesting code.
 * 
 * 4.) added the components on the panel with add 
 * 		and gave it a background color
 * 		 ... I thought about giving it a PreferredSize but since you can
 * 		  manipulate this in the main, I thought about not doing it.
 * 
 * 5.) The code gave me trouble when it is a palindrome because of the while loop!
 * 		- Check while loop
 */

public class Panel extends JPanel {

	/*
	 * Global variabes are declared.
	 * I first thought three were needed, you can fully 
	 * think of this if you have GUI in mind.
	 */
	
	private JLabel prompt, label; 
	private JTextField textbox;
	private JButton submit;
	
	public Panel() {
		
		/*
		 * just giving these newly declared components values, function, and string
		 */
		
		prompt = new JLabel("Welcome, this program checks if a word is a palindrome.");
		prompt.setFont(new Font("Helvetica", Font.PLAIN, 18));
		prompt.setForeground(Color.white);
		
		label = new JLabel("Please enter a word to see if it is a palindrome: ");
		label.setFont(new Font("Helvetica", Font.PLAIN, 14));
		label.setForeground(Color.white);
		
		textbox = new JTextField();
		textbox.setColumns(9);
		
		JComboBox dropDown = new JComboBox();
		dropDown.setSize(new Dimension(100, 200));
		
		submit = new JButton("Submit");
		//LOOK AT THIS. Add addActionListener , its creating an object **I created the object
									//new submitListener
		submit.addActionListener((ActionListener) new submitListener());
		
		add(prompt);
		add(label);
		add(textbox);
		add(submit);
		add(dropDown);
		
		setPreferredSize(new Dimension(500, 120));
		setBackground(Color.DARK_GRAY);
	}
	
	//created submitListener
	/*
	 * Since this is how most
	 * action listeners are implemented
	 * these
	 */
	private class submitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String string = textbox.getText();
			//I like this approach way better.
			
			/*
			 * This is more streamlined rather than the 
			 * exercisesforMeToDo --> chapter5ProgrammingProjects -->  FivePoint31PalindromeGUI.java
			 */
			
			int beginningIndex, endOfIndex;
			
			beginningIndex = 0;
			endOfIndex = string.length() - 1;
			
			while(string.charAt(beginningIndex) == string.charAt(endOfIndex)
					//comparing characters
					&& beginningIndex <= endOfIndex) {
					//comparing the index number
				
				beginningIndex++;
				endOfIndex--;
				
			}//end of while
			
			if(beginningIndex < endOfIndex) {
				label.setText("This word is NOT a palindrome!");
				//if it exceeds, it is not a palindrome
			}
			else 
				label.setText("This word is a palindrome!");
				//if beginningIndex is NOT less endOfIndex
					//then it is a palindrome because it falls under the condition
			
			
		}//end of public void
		
	}
	
}
