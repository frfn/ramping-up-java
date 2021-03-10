package chapter5Bullseye;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class BullseyePanel extends JPanel { //extends JPanel character
	
	/*
	 * Things do NOT have to be a global variable, but it is nice to have them so the whole class can use it
	 */

	private final int maxWidthOfCircle = 300; //300 because this is the size of the GUI
	private final int numberOfRings = 14; //number of rings that will show
	
	
	private final int ringWidth = 10; //I will soon see why this matters
	
	
	
	public BullseyePanel() {
		
		setBackground(Color.orange); //setting the panel color to be white
		
		setPreferredSize(new Dimension(300, 300)); //setting the dimenson of the panel
		
		/*
		 * THIS IS WHERE THE BACKGROUND COLOR AND SIZE OF THE PANEL IS GOING TO BE.
		 */
		
		
	}
	
	public void paintComponent(Graphics page) {
		
		super.paintComponent(page); //super refers to the parent class! //what that means is that it calls the paintComponent from the
									//actual class of "paintComponent"
		
		
		int x = 0;
		int y = 0;
		int diameter = maxWidthOfCircle;	
		
		page.setColor(Color.WHITE);
		
		for(int count = 0; count < numberOfRings; count++) {
			
			
			//this block of code alternate the colors
			if(page.getColor() == Color.black) {
				page.setColor(Color.WHITE);
			}else {
				page.setColor(Color.BLACK);
			}
			
			page.fillOval(x, y, diameter, diameter);
			//x and y is the coordinate!
			//diameter is the size of the width, and height! , mess with this later
			
			diameter = diameter - (2 * ringWidth); 
			/*
			 * diameter = diameter - ( 2 * 50 )
			 * diameter = 300 - 100;
			 * diameter = 200;
			 */
			
			
			//THIS IS THE LOCATION OF WHERE THE NEW CIRCLE WiLL start!
			//I finally figured it out, wow, hahaha!
			
			x = x + ringWidth;
			/*
			 * x = x + 50;
			 * x = 0 + 50;
			 * x = 50;
			 */
			
			y = y + ringWidth;
			/*
			 * y = y + 50;
			 * y = 0 + 50;
			 * y = 50;
			 */
		}
		
		//outside the loop, 
		page.setColor(Color.red);
		page.fillOval(x, y, diameter, diameter);
		
	}
	
	
	

}
