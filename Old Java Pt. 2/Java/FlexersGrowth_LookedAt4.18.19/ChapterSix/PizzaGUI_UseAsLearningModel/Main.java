package PizzaGUI_UseAsLearningModel;
import javax.swing.*;
public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Flexerino - Home of the Great Pizza");
		
		JTabbedPane tp = new JTabbedPane();
		tp.add("Pizza", new PizzaPanel());
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(tp);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}
	
}
