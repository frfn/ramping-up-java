package radiobuttons;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
	JFrame window = new JFrame("Select an option please...");
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	window.getContentPane().add(new RadioButton());
	window.setSize(700, 130);
	window.setLocationRelativeTo(null);
	window.setVisible(true);
}
}
