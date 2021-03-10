package testingObjects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Pizza");
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new PizzaPanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
