package PizzaGUIChapter6forFunSCRAPPED;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main {
	
public static void main(String[] args) {
		
		JFrame frame = new JFrame("Pizza");
		
		JTabbedPane tp = new JTabbedPane();
		tp.add("Pizza", new PizzaPanel());
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(tp);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
