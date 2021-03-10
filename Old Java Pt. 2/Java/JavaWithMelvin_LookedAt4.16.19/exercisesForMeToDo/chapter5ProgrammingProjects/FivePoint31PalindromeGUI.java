package chapter5ProgrammingProjects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FivePoint31PalindromeGUI {
	
	static int beginningIndexOfString, endIndexOfString;
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Is it a palindrome!?");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setPreferredSize(new Dimension(300, 100));
		
		
		/*
		 * components
		 */
		JButton sumbit = new JButton("Submit");		
		
		JTextField textbox = new JTextField();
		textbox.setColumns(20);
		
		
		JLabel instruction = new JLabel("Please input a string in the text box...");
		instruction.setForeground(Color.white);
		instruction.setFont(new Font("Helvetica", Font.PLAIN, 15));
		
		sumbit.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent press) {
				
				int lengthOfString = textbox.getText().length();
				String word = textbox.getText();
				
				beginningIndexOfString = 0;
				endIndexOfString = lengthOfString - 1;
				
				while(word.charAt(beginningIndexOfString) ==
						word.charAt(endIndexOfString) &&
							beginningIndexOfString <= endIndexOfString) {
					/*
					 * The inequality is there because once the string is read
					 * it will give a boolean value
					 * 
					 * I ran it with out the && ... <= ... and it gave me an out of bound.
					 * 
					 * So we have to tell the program to stop 
					 */
					
					beginningIndexOfString++;
					endIndexOfString--;
					
				}
				
				if(beginningIndexOfString < endIndexOfString) {
					JOptionPane.showMessageDialog(null, "It is not a palindrome!", "Sorry to say but...", JOptionPane.PLAIN_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Yes! It is a palindrome!", "Congratulations!", JOptionPane.PLAIN_MESSAGE);
					
				
				
			}
		});
		
		panel.add(instruction);
		panel.add(textbox);
		panel.add(sumbit);
		
		window.getContentPane().add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}

}
