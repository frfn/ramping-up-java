package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Insert extends JFrame implements ActionListener {

	/**
	 * DESIGN what you need for this Window.
	 * Need a submit button for sure and 4 textboxes,
	 * for validation ask if user wants to add new element to database!
	 *  - fill in all fields
	 * 
	 * set false button when enabled for UpdateInsertDeletePanel, 
	 * look at Update for more consistent programming 
	 *  - what i've closed and what i've set!.. all the nuances
	 *  - setting the fields empty after hitting submit
	 *  - etc!
	 *  
	 *  Will make a record object that will be passed on to the insertInto method
	 *  in the DBManager
	 */
	
	AddressRecord information = null;
	JLabel heading, fn, ln, pn, email;
	JTextField fnField, lnField, pnField, emailField;
	JButton submit, clear;
	JPanel panel;
	Font font = new Font("Helvetica", Font.PLAIN, 12);  // for ease of use, font has been made
	TitledBorder tb = BorderFactory.createTitledBorder("Update Information");  // for ease of use, Titled Border has been made
	Dimension d = new Dimension(100,30);
	
	
	public Insert() {
	// Reset auto increment to 1
		Main.dbms.resetAutoIncrement();
		
	// Turn off button once clicked
		InsertUpdateDelete.insert.setEnabled(false);
	
	// JPanel
		tb.setTitleColor(Color.white);
		panel = new JPanel(); SpringLayout sl = new SpringLayout();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(sl);
		panel.setBorder(tb);
		
		
	// Initializing components
		heading = new JLabel("Please insert new record below");
		heading.setFont(new Font("Helvetica", Font.PLAIN, 18));
		heading.setForeground(Color.white);
	// Placement
		sl.putConstraint(SpringLayout.NORTH, heading, 70, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, heading, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// First Name
		fn = new JLabel("First Name:");
		fn.setFont(font);
		fn.setForeground(Color.white);
	
		fnField = new JTextField();
		fnField.setColumns(12);
		fnField.addActionListener(this);
	// Placement	
		sl.putConstraint(SpringLayout.NORTH, fn, 130, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, fn, -100, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, fnField, 123, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, fnField, 70, SpringLayout.HORIZONTAL_CENTER, panel);
	
	// Last Name 
		ln  = new JLabel("Last Name:");
		ln.setFont(font); 
		ln.setForeground(Color.white);
		
		lnField = new JTextField();
		lnField.setColumns(12);
		lnField.addActionListener(this);
	// Placement	
		sl.putConstraint(SpringLayout.NORTH, ln, 170, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, ln, -100, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, lnField, 163, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, lnField, 70, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Phone Number	
		pn  = new JLabel("Phone Number:");
		pn.setFont(font); 
		pn.setForeground(Color.white);
		
		pnField = new JTextField();
		pnField.setColumns(12);
		pnField.addActionListener(this);
	// Placement	
		sl.putConstraint(SpringLayout.NORTH, pn, 210, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, pn, -88, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, pnField, 203, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, pnField, 70, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Email	
		email = new JLabel("Email:");
		email.setFont(font); 
		email.setForeground(Color.white);
		
		emailField = new JTextField();
		emailField.setColumns(12);
		emailField.addActionListener(this);
	// Placement	
		sl.putConstraint(SpringLayout.NORTH, email, 250, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, email, -113, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, emailField, 243, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, emailField, 70, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Button
		submit = new JButton("Submit");
		submit.setPreferredSize(d);
		submit.addActionListener(this);
		
		clear = new JButton("Clear");
		clear.setPreferredSize(d);
		clear.addActionListener(this);
	// Placement
		sl.putConstraint(SpringLayout.NORTH, submit, 317, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submit, -70, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, clear, 317, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, clear, 70, SpringLayout.HORIZONTAL_CENTER, panel);
		
		
	// Adding components to panel then frame
		panel.add(heading);
		panel.add(fn);
		panel.add(ln);
		panel.add(pn);
		panel.add(email);
		panel.add(fnField);
		panel.add(lnField);
		panel.add(pnField);
		panel.add(emailField);
		panel.add(submit);
		panel.add(clear);
		
		this.add(panel);
		
	// Settings for window
		this.setSize(new Dimension(400, 470));
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter() {  // turn on Update button once window is closed!
			public void windowClosing(WindowEvent we) {
				InsertUpdateDelete.insert.setEnabled(true);  // setting the update button to be clickable again!
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		String fn = fnField.getText();
		String ln = lnField.getText();
		String[] arrayFn, arrayLn;
		arrayFn = fn.split(" ");
		arrayLn = ln.split(" ");
		
		if(arrayFn.length > 1 || arrayLn.length > 1){
			JOptionPane.showMessageDialog(null, "Please input one name");
		}
		
		else if(fnField.getText().isEmpty() || lnField.getText().isEmpty() ||
				pnField.getText().isEmpty() || emailField.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Please fill in all fields");
		}
		
		else if (source == submit || source == fnField || source == lnField
				|| source == pnField || source == emailField) {
			information = new AddressRecord(fnField.getText(), lnField.getText(), pnField.getText(), emailField.getText());
			
			Main.dbms.insertInto(information);
			
		}
		
		if(source == clear) {
			fnField.setText("");
			lnField.setText("");
			pnField.setText("");
			emailField.setText("");
		}
		
	}

}
