package chapter3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestCreatingNewFrame {
	
	public static void main(String[] panel) {
		
		JFrame newFrame = new JFrame("Please install new software for device.");
		
		
		SpringLayout layout = new SpringLayout(); //Setting the layout
		
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//when pressing X, it will terminate program
		
		JPanel firstPanel = new JPanel();	//creating JPanel
		firstPanel.setLayout(layout);	//giving the panel a set layout
		firstPanel.setBackground(Color.BLACK);	//background of panel will be black
		firstPanel.setPreferredSize(new Dimension(700, 350)); //new Dimension , this is part of the AWT package
		
		///////
		
		JLabel firstLabel = new JLabel("New update available: 2.4"); //label is created
		
		
		firstLabel.setForeground(Color.white);	//font of color is white
							//1. Position from where padding will start
							//2. component 
							//3. padding
							//4. 
		layout.putConstraint(SpringLayout.NORTH, firstLabel, 120, SpringLayout.NORTH, firstPanel); 
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, firstLabel, 0, SpringLayout.HORIZONTAL_CENTER, firstPanel);
		
		/*
		 * the two codes of line that has .putConstraint is part of SpringLayout 
		 * it is code that sets it on the panel in the users preference, whether its centered, however the
		 * user wants
		 */
		
		
		//JLabel secondLabel = new JLabel("Accept now for installation!");
		//secondLabel.setForeground(Color.white);
		
		
		
		//JLabel thirdLabel = new JLabel("Later to get reminded!");
		//thirdLabel.setForeground(Color.white);
		
		/*
		 * Not needed
		 */
		
		
		
		
		JButton acceptButton = new JButton("Accept");
		
		layout.putConstraint(SpringLayout.NORTH, acceptButton, 25, SpringLayout.NORTH, firstLabel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, acceptButton, 0, SpringLayout.HORIZONTAL_CENTER, firstLabel);
		
		//JButton laterButton = new JButton("Later");
		
		firstPanel.add(firstLabel);
		//firstPanel.add(secondLabel);
		//firstPanel.add(thirdLabel);
		firstPanel.add(acceptButton);
		//firstPanel.add(laterButton);
		
		/*
		 * these lines of code above just adds components to the panel
		 */
		
		/*
		 * BELOW,
		 * this is the "LISTENER",
		 * Upon pressing the button component it will show the confirm dialogue box, "cancel, no, yes"
		 */
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent accept) {
				
				/*
				 * This is explained more in Chapter 4.5
				 */
				
				int valueIfTrue = JOptionPane.showConfirmDialog(null, "FUCK YOUR UPDATE.");
				/*
				 * Upon research, this returns an integer value
				 * if 0 is return, user chosen "Yes"
				 * if 1 is return, user chosen "No"
				 * 
				 */
				
				if(valueIfTrue == 0) {
					JOptionPane.showMessageDialog(null, "SCREW YOUR UPDATE STILL.");
				}
				
				if(valueIfTrue == 1) { // if user says NO which is also NO OPTION
					int afterFirstOption = JOptionPane.showConfirmDialog(null, "Just kidding, let's update!");
					int test = JOptionPane.NO_OPTION;
					if(afterFirstOption == 0) {
						JOptionPane.showMessageDialog(null, "Updating now! Just kidding, screw YOU!");
						JOptionPane.showMessageDialog(null, test);

					}
					if(afterFirstOption == 1) { 
						for(int repeating = 0; repeating < 7; repeating++) {
						JOptionPane.showMessageDialog(null, "SCREW YOU 7x TOO");
					
						}
					}
					
					
				}
				
				
			}
		});
		
		
		
		newFrame.getContentPane().add(firstPanel);
		newFrame.pack();
		newFrame.setLocationRelativeTo(null);
		/*
		 * This code of line right above sets the window right in the middle of the screen
		 */
		newFrame.setVisible(true);
		
	
		
		
	}

}
