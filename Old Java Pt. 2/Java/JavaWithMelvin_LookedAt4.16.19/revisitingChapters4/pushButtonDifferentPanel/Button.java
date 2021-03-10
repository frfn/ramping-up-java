package pushButtonDifferentPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 * This will be a panel that holds the
 * JButton and JLabel
 * 
 * value will increment by one when button is clicked
 * 
 */
//Panel class – will create panel when instantiated
/*
 * extends JPanel gives this class
 * the properties of a JPanel
 */


/*
 * Steps to use such class:
 * 
 * 0.) class will extend JPanel so that it is inheriting the JPanel attributes
 * 1.) Set and declare the needed components
 * 2.) Constructor needs to be created.
 * 
 * 	2pt2.) If need be see what private class/methods need to be thought of –
 * 		   In this case, the ActionListener private class!
 * 		   Just lay it out, don't complete yet!
 * 
 * 3.) Create the ActionListener object
 * 
 * 4.) Create the content in the constructor!
 * 		– This will include size of panel AND color of panel!
 * 		– Components of panel!
 * 		– Everything on the panel!
 */


	//0.) extending JPanel to class
public class Button extends JPanel {
	
	//1.) Components being declared, they are global variables
	//    initialize it in constructor
	private int increment; 
	private JButton button;
	//2pt2.) Since button won't have an ActionListener,
	//		 We're already thinking about it!
	JLabel label;
	
	public Button() {
		
		increment = 0;
		button = new JButton("Click Me!");
		label = new JLabel("Press that button!");
		label.setFont(new Font("Helvetica", Font.PLAIN, 14));
		
		
		button.addActionListener(new ButtonListener());
		//you have to add "new" because the listener is AN OBJECT
		
		add(label);
		add(button);
		
		setPreferredSize(new Dimension(300, 250));
		setBackground(Color.ORANGE);
		
	}
	
	//the action performed is  from ActionListener 
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			increment++;
			if(increment < 10) {
			label.setFont(new Font("Helvetica", Font.PLAIN, 14));
			label.setText("Keep on clicking! Till 10!: " + increment);
			}
			
			if(increment >= 10) {
				if(increment == 10) {
				JOptionPane.showMessageDialog(null, "Holy shit, you actually did it scrub! LMAO.", "Your insane.", JOptionPane.PLAIN_MESSAGE);
				}
				label.setFont(new Font("Helvetica", Font.PLAIN, 14));
				label.setText("Just keep clicking now!: " + increment);
			}
			
			
			
		} //end of ActionPerformed
	}//end of class ButtonListener
	
	

}
