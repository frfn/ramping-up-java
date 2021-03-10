package chapter3ProgrammingProjects;

/*
 * Adding a fourth image with the text labeled on top, centered
 * 
 * Image will be of Himawari
 */

import javax.swing.*;
import java.awt.*;

public class ThreePoint5RevisedAddScrollPaneAndColors {

	public static void main(String[] pictureFrame) {
		
		JFrame window = new JFrame("3.5 – Chapter Three Exercises"); //title
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //operation
		
		
		
		ImageIcon Himawari = new ImageIcon("/Users/flexer/Downloads/HimawariHD.png"); //image from file
		
		JLabel label1, label2, label3, label4;	//JLabel creation
		
		/*
		 * Labels are also pictures as well!
		 */
		
		label1 = new JLabel("Himawari to the left!", Himawari, SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		
		label2 = new JLabel("Himawari to the right!", Himawari, SwingConstants.CENTER);
		label2.setHorizontalTextPosition(SwingConstants.LEFT);
		label2.setForeground(Color.WHITE);
		
		label3 = new JLabel("Himawari at the top!", Himawari, SwingConstants.CENTER);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setForeground(Color.WHITE);
		
		label4 = new JLabel("Himawari at the bottom!", Himawari, SwingConstants.CENTER);
		label4.setHorizontalTextPosition(SwingConstants.CENTER);
		label4.setVerticalTextPosition(SwingConstants.TOP);
		label4.setForeground(Color.WHITE);
		
		JPanel panelForLabels = new JPanel(); //creating a panel for the labels to on!
		
		panelForLabels.setBackground(Color.PINK);
		panelForLabels.setPreferredSize(new Dimension (800, 1330));
		/*
		 * THIS MATTERS FOR SCROLL BAR
		 */
		panelForLabels.add(label1);
		panelForLabels.add(label2);
		panelForLabels.add(label3);
		panelForLabels.add(label4);
		
		/*
		 * Above, these lines of codes just adds the components to the panels
		 */
		
		JScrollPane panelUpgraded = new JScrollPane(panelForLabels);
		panelUpgraded.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		/*
		 * Code above, just two lines of code, gives us the scrollbar function
		 * Second line of code prohibits the horizontal scrollbar to appear
		 */
		
		
		
		window.getContentPane().add(panelUpgraded);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
}
