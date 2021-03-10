package animation;
import java.awt.*;
import javax.swing.*;

public class Rebound {
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Animation");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new ReboundPanel());
		window.setSize(980, 800);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
