package chapter4PushButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * this is my take on the push button,
 * doing it all in file!
 * 
 * Also, this is an example of approaching it without creating a 
 * different class that "extends" the JPanel!
 */

public class PushButtonMainRevised {
	
	static short count = 0;
	static JLabel labelNextToButton;
	
	/*
	 * I found out that if you were to have something such as "count"
	 * be used in the ActionListener/Event,
	 * You would NEED to declare it for the whole class, a global variable
	 */
	
	public static void main(String[] pushingButtons) {
		
		
		
		JFrame window = new JFrame("To Push Or Not");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelForButton = new JPanel();
		panelForButton.setPreferredSize(new Dimension(300, 60));
		panelForButton.setBackground(Color.WHITE);
		
		JButton pushButton = new JButton("Push me!");
		
		//((ActionListener new ActionListener() {
		
		//The Anonymous Class – learn more about this in the Oracle Tutorial!
		//Creating and instantiating an object at the same time!
		
		
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent push) {
				
				count++;
				labelNextToButton.setText("To Push Or Not: " + count);
				
				if(count > 10 && count < 15) {
					JOptionPane.showMessageDialog(null, "You're in the range of 10 - 15!", "10-15", 0);
				}
				
			}
		});
		
		
		labelNextToButton = new JLabel("Press \"Push me!\" and see what happens!");
		
		panelForButton.add(labelNextToButton);
		panelForButton.add(pushButton);
		
		window.getContentPane().add(panelForButton);  //<-- AS SHOWN HERE
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}

}
