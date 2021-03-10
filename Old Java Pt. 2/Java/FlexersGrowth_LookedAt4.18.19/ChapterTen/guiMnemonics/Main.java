package guiMnemonics;
import java.awt.*;
import javax.swing.*;
public class Main {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Mnemonic Testing...");
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new Panel());
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}

}
