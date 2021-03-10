package App;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener{
	
	JPanel panel;  // JPanel to put all the components in
	
	JLabel uName;  // two JLabels for labeling username and password
	JLabel pWord;
	
	JTextField fnText;			// two textfields, one text and one pass
	JPasswordField pwField;

	JButton submit;  // one buttons for submitting form and logging in
	
	Font font = new Font("Helvetica", Font.PLAIN, 12);  // for ease of use, font has been made
	
	TitledBorder tb = BorderFactory.createTitledBorder("Login Page");  // for ease of use, Titled Border has been made
	
	public Login() {
	// Reset auto increment to 1
		Main.dbms.resetAutoIncrement();
			
		/**
		 * Setting up components to put on panel and setting up panel
		 */
		
	// Panel	
		tb.setTitleColor(Color.white);
		panel = new JPanel();  SpringLayout sl = new SpringLayout();  
		panel.setLayout(sl);  
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(tb);
		
	// Labels	
		uName = new JLabel("Enter Username: ");
		uName.setFont(font);  uName.setForeground(Color.white);
		
		pWord = new JLabel("Enter Password");
		pWord.setFont(font);  pWord.setForeground(Color.white);
	// Field
		fnText = new JTextField();
		fnText.setColumns(12);  fnText.addActionListener(this);
		
		pwField = new JPasswordField();
		pwField.setColumns(12); pwField.addActionListener(this);
	// Submit
		submit = new JButton("Submit");  submit.addActionListener(this);
		
	// Setting components up on Panel
		// UserName
		sl.putConstraint(SpringLayout.NORTH, uName, 30, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, uName, -90, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// PassWord
		sl.putConstraint(SpringLayout.NORTH, pWord, 20, SpringLayout.SOUTH, uName);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, pWord, -90, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// User Field
		sl.putConstraint(SpringLayout.NORTH, fnText, -7, SpringLayout.NORTH, uName);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, fnText, 60, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// Pass Field
		sl.putConstraint(SpringLayout.NORTH, pwField, -7, SpringLayout.NORTH, pWord);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, pwField, 60, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// Submit
		sl.putConstraint(SpringLayout.NORTH, submit, 100, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submit, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Adding components to panel
		panel.add(uName);
		panel.add(pWord);
		panel.add(fnText);
		panel.add(pwField);
		panel.add(submit);
		add(panel);
		
	// Putting these lines of code Matter, if you do NOT put it on the bottom of code, will output differently and not correctly!
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(450, 200));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(Main.dbms.loginValidation(fnText.getText(), pwField.getText())) {
				//JOptionPane.showMessageDialog(null, "Signed in!");
				this.dispose();
				
				InsertUpdateDelete frame = new InsertUpdateDelete();
				frame.setVisible(true);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
