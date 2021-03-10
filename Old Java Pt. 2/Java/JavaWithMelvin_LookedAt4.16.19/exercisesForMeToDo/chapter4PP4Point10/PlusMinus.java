package chapter4PP4Point10;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlusMinus {

	private static int initialSet = 50;
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Plus-Minus!");
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Press buttons to alter number!: ");
		JLabel label2 = new JLabel("50");
		
		
		JButton plusButton = new JButton("+");
		JButton minusButton = new JButton("–");
		
		
		
		
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				initialSet++;
				
				String newLabel = Integer.toString(initialSet);
				
				label2.setText(newLabel);
				
				if(initialSet >= 60 && initialSet <= 65) {
				 
					JOptionPane.showMessageDialog(null, "It is too hot bro! ~");
					
				}
				
				
			}
		});
		
		
		
		minusButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				initialSet--;
				
				String newLabel = Integer.toString(initialSet);
				
				label2.setText(newLabel);
				
			}
		});
		
		
		
		
		panel.add(label);
		panel.add(label2);
		panel.add(plusButton);
		panel.add(minusButton);
		
		window.getContentPane().add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	
	
	
}
