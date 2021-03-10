package Chapter4PP4point9;


import java.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PushButtonForRandomNumber {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		JFrame window = new JFrame("Random Number Generator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		
		JLabel label = new JLabel("Please press button for label!: ");
		JLabel outputLabel = new JLabel("---");
		JButton button = new JButton("New Number!");
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				int randomNumber = random.nextInt(100) + 1;
				
				String randomNum = Integer.toString(randomNumber);
				
				outputLabel.setText(randomNum);
				
			}
		});
		
		panel.add(label);
		panel.add(outputLabel);
		panel.add(button);
		
		window.getContentPane().add(panel);
		window.setLocationRelativeTo(null);
		window.pack();
		window.setVisible(true);
		
		
	}

}
