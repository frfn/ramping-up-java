package guiSplitPane;
import java.awt.*;
import javax.swing.*;
public class Main {
	
	public static void main(String[] args) {
		
		/**
		 * Makes new window
		 *  - JFrame
		 */
		
		JFrame window = new JFrame("Split Pane...");
		
		/**
		 * Creating JLabel
		 *  - Will display picture
		 *  - JLabels are also pictures (They can be icon)
		 */
		JLabel imageLabel = new JLabel();
		
		/**
		 * JPanel
		 *  - Creating new JPanel
		 */
		JPanel imagePanel = new JPanel();
		
		
		/**
		 * Adding JLabel (Picture) to the panel
		 */
		imagePanel.add(imageLabel);
		imagePanel.setBackground(Color.DARK_GRAY);
		
		/**
		 * Creating list
		 *  - Parameter is a JLabel (picture)
		 *  - Relates because the current image will be changed
		 */
		ListPanel list = new ListPanel(imageLabel);
		
		/**
		 * JSplit pane
		 *  - Three parameter
		 *  	- horizontal split
		 *  	- imagePanel (where the pictures will be shown)
		 */
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, imagePanel);
		
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(sp);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}

}
