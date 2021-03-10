package palindrome;
import javax.swing.*;
public class Main {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Palindrome.dmg");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		window.getContentPane().add(new Panel());
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
