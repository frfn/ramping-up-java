package chapter4SmileyFace;
import javax.swing.*;
import java.awt.*;

public class SmileyFaceMain {
	
	public static void main(String smile[]) {
		
		JFrame window = new JFrame("Smiley Face"); //title of frame
		 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //operation when X is clicked on
		
		SmileyFacePanel panel = new SmileyFacePanel();
		
		/*
		 * The panel that we are creating,
		 * "SmileyFace" is a class type of JPanel as it is extended.
		 * Though it's nice to do a different class, having to remember the services 
		 * is difficult.
		 * Such as .setPreferredSize(new Dimension (100, 100));
		 *         .setBackground(Color.black);
		 */
		
		
		window.getContentPane().add(panel);
		
	
		window.pack();
		
		window.setLocationRelativeTo(null);
		/*
		 * This will set the window frame that is opened to be centered,
		 * if done before "window.pack();" the left hand top corner will be in the middle,
		 * since middle of screen is 0, 0!
		 */
		
		window.setVisible(true);
		
	}

}
