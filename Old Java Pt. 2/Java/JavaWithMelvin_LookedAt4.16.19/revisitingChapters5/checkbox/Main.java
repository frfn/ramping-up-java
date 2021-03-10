package checkbox;
import javax.swing.*;
public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Check Boxes");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.getContentPane().add(new CheckBoxPanel());
		window.pack();
		window.setVisible(true);
		
	}
	
}
