package radiobuttons;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * Sooooo, check it out!
 * 
 * The strings were made first so that is going to be first!
 * 
 */
public class RadioButton extends JPanel implements ActionListener {

	private JLabel quote;
	private JRadioButton choice, choice2, choice3;
	private String str, str2, str3;
	
	public RadioButton() {
		
		//5. YEA YEA. DO these fiRsT, I forgot okay!
		setBackground(new Color(0, 136, 209)); //AND NEW LEARN: new Color(); !!
		setPreferredSize(new Dimension(500, 300));
		//1.) Initialize these muffuckin strings
		
		str = "                                  I miss you.                               ";
		str2 = "                            Miss talking to you.                        ";
		str3 = "Miss spending my nights with you.";
		
		/*
		 * 1.1) These don't have to be made.
		 */
		
		//2. I initialized the JLabel , this is how I can change the text!
		quote = new JLabel("                            Hey you...                             ");
		quote.setFont(new Font("Georgia", Font.PLAIN, 40));
		quote.setForeground(new Color(255, 165, 117));
		
		//3. Initialize the fucking buttons!
		choice = new JRadioButton("Press Me!");
		choice.setForeground(new Color(255, 165, 117));
		choice2 = new JRadioButton("Press Me Next!");
		choice2.setForeground(new Color(255, 165, 117));
		choice3 = new JRadioButton("Press Me After!");
		choice3.setForeground(new Color(255, 165, 117));
		
		//4. ADD THOSE DAMN LISTENERS! ehehehe.
		choice.addActionListener(this);
		choice2.addActionListener(this);
		choice3.addActionListener(this);
		
		//6. This is adding the ButtonGroup object
		/*
		 * this makes the buttons FUNCTIONABLE, without this
		 * buttons DOES NOT work properly, like it DOES NOT auto
		 * select off, or it DOES NOT output correct 
		 */
		
		/*
		 * They are abstract buttons?
		 * Abstract: 
		 * Existing in thought or as an idea but
		 * not having a physical or concrete existence.
		 * 
		 * Java Terms:
		 * An abstract class is a class that is declared abstract
		 * —it may or may not include abstract methods. 
		 * 
		 * Abstract classes cannot be instantiated, 
		 * but they can be subclassed.
		 */
		ButtonGroup group = new ButtonGroup();
		group.add(choice);
		group.add(choice2);
		group.add(choice3);
		
		//7. Adding the components to the panel!
		add(quote);
		add(choice);
		add(choice2);
		add(choice3);
		
		
	} //end of RadioButton
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		//Creating an object CALLED clickedOn,
		/*
		 * so ActionEvent e, we utilized it and made an object of the event
		 * Event being the button is clicked on!
		 * If clicked on equals choice, then do that!
		 */
		Object clickedOn = e.getSource(); //From ActionEvent!
		
		if(clickedOn == choice3) {
			quote.setText(str);
			quote.setForeground(new Color(255, 165, 117));
			quote.setFont(new Font("Georgia", Font.PLAIN, 40));
		}
		
		if(clickedOn == choice2) {
			quote.setText(str2);
			quote.setForeground(new Color(255, 165, 117));
			quote.setFont(new Font("Georgia", Font.PLAIN, 40));
		}
		
		if(clickedOn == choice) {
			quote.setText(str3);
			quote.setForeground(new Color(255, 165, 117));
			quote.setFont(new Font("Georgia", Font.PLAIN, 40));
		}
		
	} //end of actionPerformed

} //end of class
