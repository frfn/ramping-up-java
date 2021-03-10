package App;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class InformationPanel extends JPanel implements ActionListener {
	
								/*	  THESE WERE USED FOR LIST TESTS    */
								/*          I don't need these	        */
								/*     private InformationList list;    */
								/*     list = new InformationList();    */
								/* list.addInformation(fn, ln, pn, ea); */
	/* System.out.println("View List"); System.out.println("-----------"); System.out.println(list); */
	
	DatabaseManager dbms = new DatabaseManager();  // DatabaseManager object
	
	// 4 fields
	JLabel firstName;
	JLabel lastName;
	JLabel phoneNumber;
	JLabel emailAddress;
	
	// 4 text fields
	JTextField fnText;
	JTextField lnText;
	JTextField pnText;
	JTextField eaText;
	
	// 1 submit button
	JButton submit;
	JButton view;
	JButton clear;
	JButton update;
	JButton read;
	
	public InformationPanel() {
		
		try {
		dbms.connectToDB();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		SpringLayout sl = new SpringLayout();  // layout for panel
		
		this.setLayout(sl);
		this.setBackground(Color.DARK_GRAY);
		
		firstName = new JLabel("Enter First Name: ");
		firstName.setFont(new Font("Helvetica", Font.PLAIN, 12));
		firstName.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, firstName, 90, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, firstName, -80, SpringLayout.HORIZONTAL_CENTER, this);
		
		lastName = new JLabel("Enter Last Name: ");
		lastName.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lastName.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, lastName, 20, SpringLayout.SOUTH, firstName);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, lastName, -80, SpringLayout.HORIZONTAL_CENTER, this);
		
		phoneNumber = new JLabel("Enter Phone Number: ");
		phoneNumber.setFont(new Font("Helvetica", Font.PLAIN, 12));
		phoneNumber.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, phoneNumber, 20, SpringLayout.SOUTH, lastName);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, phoneNumber, -80, SpringLayout.HORIZONTAL_CENTER, this);
		
		emailAddress = new JLabel("Enter Email Address: ");
		emailAddress.setFont(new Font("Helvetica", Font.PLAIN, 12));
		emailAddress.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, emailAddress, 20, SpringLayout.SOUTH, phoneNumber);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, emailAddress, -80, SpringLayout.HORIZONTAL_CENTER, this);
		
		fnText = new JTextField();
		fnText.setColumns(10);
		fnText.setHorizontalAlignment(JTextField.RIGHT);
		
		sl.putConstraint(SpringLayout.BASELINE, fnText, 10, SpringLayout.NORTH, firstName);
		sl.putConstraint(SpringLayout.WEST, fnText, 50, SpringLayout.EAST, firstName);
		
		lnText = new JTextField();
		lnText.setColumns(10);
		lnText.setHorizontalAlignment(JTextField.RIGHT);
		
		sl.putConstraint(SpringLayout.BASELINE, lnText, 10, SpringLayout.NORTH, lastName);
		sl.putConstraint(SpringLayout.WEST, lnText, 50, SpringLayout.EAST, lastName);
		
		pnText = new JTextField();
		pnText.setColumns(10);
		pnText.setHorizontalAlignment(JTextField.RIGHT);
		
		sl.putConstraint(SpringLayout.BASELINE, pnText, 10, SpringLayout.NORTH, phoneNumber);
		sl.putConstraint(SpringLayout.WEST, pnText, 38, SpringLayout.EAST, phoneNumber);
		
		eaText = new JTextField();
		eaText.setColumns(10);
		eaText.setHorizontalAlignment(JTextField.RIGHT);
		
		sl.putConstraint(SpringLayout.BASELINE, eaText, 10, SpringLayout.NORTH, emailAddress);
		sl.putConstraint(SpringLayout.WEST, eaText, 40, SpringLayout.EAST, emailAddress);
		
		submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension(100, 23));	
		submit.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, submit, 30, SpringLayout.SOUTH, eaText);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submit, -100, SpringLayout.HORIZONTAL_CENTER, this);
		
		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(100, 23));
		clear.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, clear, 0, SpringLayout.NORTH, submit);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, clear, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		view = new JButton("View");
		view.setPreferredSize(new Dimension(100, 23));
		view.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, view, 0, SpringLayout.NORTH, clear);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, view, 100, SpringLayout.HORIZONTAL_CENTER, this);
		
		update = new JButton("Update Name");
		update.setPreferredSize(new Dimension(167, 23));
		update.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, update, 10, SpringLayout.SOUTH, view);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, update, 80, SpringLayout.HORIZONTAL_CENTER, this);
		
		read = new JButton("Read Specific Elemet");
		read.setPreferredSize(new Dimension(167, 23));
		read.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, read, 10, SpringLayout.SOUTH, view);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, read, -80, SpringLayout.HORIZONTAL_CENTER, this);
		
		
		add(firstName);
		add(lastName);
		add(phoneNumber);
		add(emailAddress);
		add(fnText);
		add(lnText);
		add(pnText);
		add(eaText);
		add(submit);
		add(clear);
		add(view);
		add(update);
		add(read);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(read == source) {
			
			JFrame window3 = new JFrame("Read");
			window3.getContentPane().add(new ReadAbsoluteRow());
			window3.setSize(new Dimension(450, 300));
			window3.setLocationRelativeTo(null);
			window3.setVisible(true);
			
		}
		
		if(update == source) {
			/*
			 * JFrame window2 = new JFrame("Update");
			 * 
			 * window2.getContentPane().add(new UpdateInformationPanel());
			 * window2.setSize(new Dimension(450, 300));
			 * window2.setLocationRelativeTo(null); window2.setVisible(true);
			 */
			UpdateInformationPanel frame = new UpdateInformationPanel();
			
			
			
			
			
		}
		
		if(submit == source) {  // if user selects submit
			
			String fn = fnText.getText();
			String ln = lnText.getText();
			String pn = pnText.getText();
			String ea = eaText.getText();
			
			if(fn.equals("") || ln.equals("") || pn.equals("") || ea.equals("")) {  // if any of the fields are empty, no go
				JOptionPane.showMessageDialog(null, "Enter for all fields...", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
				dbms.addStudent(fn, ln, pn, ea);  // adding student to database
				}catch(Exception ex) {
					ex.getMessage();
				}
				
			}
		}
		
		if(clear == source) {
			
			 fnText.setText(""); lnText.setText(""); pnText.setText(""); eaText.setText("");  // if user hits clear, set text to blank
			
			try {
				dbms.deleteAll();  // delete all is called
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(view == source) {
			
			try {
				dbms.readStudents();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println();
			
			
		}
		
	}
}
