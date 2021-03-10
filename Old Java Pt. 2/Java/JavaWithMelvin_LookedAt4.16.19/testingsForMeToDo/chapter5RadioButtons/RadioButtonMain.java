package chapter5RadioButtons;
import javax.swing.*;
public class RadioButtonMain {

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Radio Buttons");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.getContentPane().add(new RadioButton());
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
				
		
	}
	
}
