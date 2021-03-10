package pushButtonDifferentPanel;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Push the button!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//creating the panel inside the add() !!
		window.getContentPane().add(new Button());
		window.setSize(300, 65);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
