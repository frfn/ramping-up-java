package Borders;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Borders {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Borders..."); //JFrame - the window
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 5, 10));
		//0 rows, 2 elements per row, horizontal gap, height gap
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		//											   (top, left, bottom, right)
		
		////////////////////////////
		/*		Line Border		  */
		////////////////////////////
		
		JPanel p1 = new JPanel();
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
												//(color, thickness, rounded)
												//Color of line, thickiness of line, if edges should be rounded
												//Color.red, 3, true
		p1.add(new JLabel("Line border"));
		
		////////////////////////////
		/*	   Etched Border	  */
		////////////////////////////
		
		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createEtchedBorder());
		p2.add(new JLabel("Etched Border"));
		
		////////////////////////////
		/*	 Raised Bevel Border  */
		////////////////////////////

		JPanel p3 = new JPanel();
		p3.setBorder(BorderFactory.createRaisedBevelBorder());
								//.createSoftRaisedBevelBorder – the design is a more softer feel, that is it
		p3.add(new JLabel("Raised Bevel Border"));
		
		////////////////////////////
		/*   Lowered Bevel Border */
		////////////////////////////
		
		JPanel p4 = new JPanel();
		p4.setBorder(BorderFactory.createLoweredBevelBorder());
		p4.add(new JLabel("Lowered Bevel Border"));
		
		////////////////////////////
		/*      Titled Border     */
		////////////////////////////
		
		JPanel p5 = new JPanel();
		BoxLayout topping = new BoxLayout(p5, BoxLayout.Y_AXIS);
		p5.setLayout(topping);
		
		p5.setBorder(BorderFactory.createTitledBorder("Toppings")); //by default, it is to the left
		p5.add(new JCheckBox("Pepperoni"));
		p5.add(new JCheckBox("Sausage"));
		
		////////////////////////////
		/*    Titled Border V2    */
		////////////////////////////
		
		JPanel p6 = new JPanel();
		/*
		 *  Parameters:
			border – the Border object to add the title to
			
			title – a String containing the text of the title
			
			titleJustification – an integer specifying the justification of the title -- one of the following:
			TitledBorder.LEFT
			TitledBorder.CENTER
			TitledBorder.RIGHT
			TitledBorder.LEADING
			TitledBorder.TRAILING
			TitledBorder.DEFAULT_JUSTIFICATION (leading)
			
			titlePosition –  an integer specifying the vertical position of the text in relation to the border -- one of the following:
			TitledBorder.ABOVE_TOP
			TitledBorder.TOP (sitting on the top line)
			TitledBorder.BELOW_TOP
			TitledBorder.ABOVE_BOTTOM
			TitledBorder.BOTTOM (sitting on the bottom line)
			TitledBorder.BELOW_BOTTOM
			TitledBorder.DEFAULT_POSITION (the title position is determined by the current look and feel)
		 */
		TitledBorder tb = BorderFactory.createTitledBorder("Sauces");
		tb.setTitleJustification(TitledBorder.RIGHT);
		p6.setBorder(tb);
		p6.add(new JCheckBox("Tomato Sauce"));
		p6.add(new JCheckBox("White Sauce"));
		
		////////////////////////////
		/*     Compound Border    */
		////////////////////////////
		
		JPanel p7 = new JPanel();
		TitledBorder titled = BorderFactory.createTitledBorder("Compound Border");
		titled.setTitlePosition(TitledBorder.ABOVE_TOP);
		Border line = BorderFactory.createLineBorder(Color.RED, 7);
		p7.setBorder(BorderFactory.createCompoundBorder(titled, line));
		p7.add(new JLabel("Compound Border"));
		
		////////////////////////////
		/*       Matte Border     */ 
		////////////////////////////
		
		JPanel p8 = new JPanel();
		ImageIcon bank = new ImageIcon("bank.jpg");
		Border mb = BorderFactory.createMatteBorder(7, 7, 10, 7, bank);
		p8.add(new JLabel("Matt Border"));
		p8.setBorder(mb);
		
		
				//Parameters:
				//	top an integer specifying the width of the top, in pixels
				//	left an integer specifying the width of the left side, in pixels
				//	bottom an integer specifying the width of the right side, in pixels
				//	right an integer specifying the width of the bottom, in pixels
				//	tileIcon the Icon object used for the border tiles

		
		
		
		//Adding components to panel
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);
		panel.add(p6);
		panel.add(p7);
		panel.add(p8);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
}
