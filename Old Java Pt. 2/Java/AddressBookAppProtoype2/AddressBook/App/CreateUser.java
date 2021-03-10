package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CreateUser extends JPanel implements ActionListener {

	JLabel user, password;
	JButton clear, submit;
	JTextField userText, userPass;
	JPanel panel;
	Font font = new Font("Helvetica", Font.PLAIN, 12);  // for ease of use, font has been made
	TitledBorder tb = BorderFactory.createTitledBorder("Update Information");  // for ease of use, Titled Border has been made
	Dimension d = new Dimension(100,30);
	
	public CreateUser() {
		// Labels
		user = new JLabel("Username: ");
		user.setFont(font);
		user.setForeground(Color.white);
		
		password = new JLabel("Password: ");
		password.setFont(font);
		password.setForeground(Color.white);
		
		// Buttons
		clear = new JButton("Clear");
		clear.addActionListener(this);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		
		// Textfields
		userText = new JTextField();
		userText.setColumns(12);
		userText.addActionListener(this);
		
		userPass = new JTextField();
		userPass.setColumns(12);
		userPass.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
