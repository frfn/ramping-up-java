package chapter4Exercises;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.util.Random;

public class FourPointTwo {
	/*
	 * Create a random color object creator!
	 * This will be the object that will pick the color
	 * for the circle that will be drawn
	 */
	public static void main(String[] coloredObject) {
		
		JFrame window = new JFrame("Different colored circle!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		DrawingShapes circle = new DrawingShapes();
		
		
		
		
		window.getContentPane().add(circle);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	

}

class DrawingShapes extends JPanel {
	
	public DrawingShapes() {
		
		setPreferredSize(new Dimension(200, 200));
		setBackground(Color.BLACK);
		
	}
	
	private static Color randomColor(int red, int green, int blue) {
		
		Random number = new Random();
		
		red = number.nextInt(256);
		green = number.nextInt(256);
		blue = number.nextInt(256);
		
		Color newColorObject = new Color (red, green, blue);
		
		return newColorObject;
		
	}
	
	public void paint (Graphics circle) {
		
		super.paint(circle);
		
		circle.setColor(randomColor(0,0,0));
		circle.fillOval(75, 75, 50, 50);
		
		
	}
	
	
}




	