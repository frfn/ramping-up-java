package oneClassTake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * create an application that will have a plus and minus button
 * it will change the value(50) accordingly to the button. 
 * 
 * increment and decrement respectively when clicked on
 * 
 * two panel!
 */

public class PlusMinusGUI {

	private static int value = 50;
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Plus and Minus");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panelOne = new JPanel();
		panelOne.setBackground(Color.WHITE);
		panelOne.setSize(new Dimension(150, 250));
		
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(Color.BLACK);
		panelTwo.setSize(new Dimension(100, 50));
		
		JLabel label = new JLabel("Current value: " + value);
		
		JButton plus = new JButton("+");
		plus.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				value++;
				
				label.setText("Current value: " + value);
			}
		});
		
		JButton minus = new JButton("–");
		minus.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				value--;
				
				label.setText("Current value: " + value);
			}
		});
		
		
		panelTwo.add(minus);
		panelTwo.add(plus);
		panelOne.add(label);
		panelOne.add(panelTwo);
		
		window.getContentPane().add(panelOne);
		window.setSize(180, 100); //instead of pack
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
		
		
	}
	
}
