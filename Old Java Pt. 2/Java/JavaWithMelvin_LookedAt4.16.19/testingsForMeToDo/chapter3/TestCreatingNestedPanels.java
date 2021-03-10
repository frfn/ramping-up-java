package chapter3;

/*
 * This will showcase a frame with two different Panels
 * 
 * WILL try to implement an icon or a GIF into this created panels!
 */

import java.awt.*;		//abstract windowing toolkit, foundation, NEEDED
import javax.swing.*;	//provides more components that are more versatile than AWT

public class TestCreatingNestedPanels {
	
	public static void main(String[] twoPanels) {
		
		ImageIcon Boruto = new ImageIcon("/Users/flexer/Downloads/BorutoHD.jpg");	//creating new image objects
		
		ImageIcon Himawari = new ImageIcon("/Users/flexer/Downloads/HimawariHD.png");	//created another image object
		
		JFrame window = new JFrame("Naruto And Hinata's Children");	//Creating new frame, with title "Naruto and Hinata's Children
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//terminates program if user hits "X" on window / red button on Mac
		
		//JPANEL and JLABEL for One
		
		JPanel panelOne = new JPanel();		//creating new Panel
		panelOne.setPreferredSize(new Dimension(300,150));	//size of the panel
		panelOne.setBackground(Color.RED);	//red background
		
		
		JLabel labelForPanelOne = new JLabel("This is panel one.");	//created a label
		labelForPanelOne.setForeground(Color.WHITE); 	//font is white
		panelOne.add(labelForPanelOne);	//adding the label on to the panel
		
		//JPANEL and JLABEL for Two
		
		JPanel panelTwo = new JPanel();		//creating another new Panel
		//panelTwo.setBackground(Color.MAGENTA); commented out, but will produce pinkish background
		
		
		JLabel borutoForPanel = new JLabel("Testing", Boruto, SwingConstants.CENTER);
		/*
		 * Can be three parameters for JLabel
		 * First is string, will be the label, can be null, or blank to show no text at all
		 * Second is the image object that will be shown
		 * Third is the horizontal alignment, can only be horizontal - center to be specific, other positioning results in error
		 */
		borutoForPanel.setVerticalTextPosition(SwingConstants.TOP);			//having this will
		borutoForPanel.setHorizontalTextPosition(SwingConstants.CENTER);		//set the label(the string) 
																			//anywhere the user wants
		panelTwo.add(borutoForPanel);	//adding borutoForPanel to panelTwo
		
		//JPANEL and JLABEL for Three
		
		JPanel panelThree = new JPanel();		//created third JPanel
		
		JLabel himawariForPanel = new JLabel("SEE", Himawari, SwingConstants.CENTER);		//Picture of KAWAII Himawari
		
		//himawariForPanel.setHorizontalTextPosition(SwingConstants.CENTER);
		//himawariForPanel.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		panelThree.add(himawariForPanel);
		
		
		JPanel panelForThree = new JPanel();			//FOURTH PANEL TO GET ALL OTHER PANELS TO BE SHOWN
		panelForThree.add(panelOne);
		panelForThree.add(panelThree);
		panelForThree.add(panelTwo);
		
		
		/*
		 * Series of code
		 * to get contents to the FRAME from panels (line 78)
		 * as well as ORGANIZATION of panels (line 79)
		 * and to show FRAME window (line 80)
		 */
		
		window.getContentPane().add(panelForThree);
		window.pack();
		window.setVisible(true);
	}

}
