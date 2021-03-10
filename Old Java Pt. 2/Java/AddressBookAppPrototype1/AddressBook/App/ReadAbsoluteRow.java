package App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.swing.*;

public class ReadAbsoluteRow extends JPanel implements ActionListener {
	
								/*	  THESE WERE USED FOR LIST TESTS    */
								/*          I don't need these	        */
								/*     private InformationList list;    */
								/*     list = new InformationList();    */
								/* list.addInformation(fn, ln, pn, ea); */
	/* System.out.println("View List"); System.out.println("-----------"); System.out.println(list); */
	
	DatabaseManager dbms = new DatabaseManager();  // DatabaseManager object
	
	// 4 fields
	JLabel firstName;
	JLabel countOfPeople;
	
	
	// 4 text fields
	JTextField fnText;


	
	// 1 submit button
	JButton submit;
	JButton clear;
	
	public ReadAbsoluteRow() {
		
		int count = 0;
		
		try {
		dbms.connectToDB();
	
		count = dbms.size();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		SpringLayout sl = new SpringLayout();  // layout for panel
		
		this.setLayout(sl);
		this.setBackground(Color.DARK_GRAY);
		
		firstName = new JLabel("View Information On Row?: ");
		firstName.setFont(new Font("Helvetica", Font.PLAIN, 12));
		firstName.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, firstName, 90, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, firstName, -80, SpringLayout.HORIZONTAL_CENTER, this);
	
		countOfPeople = new JLabel("Information On List -- "+ count + ": ");
		countOfPeople.setFont(new Font("Helvetica", Font.PLAIN, 12));
		countOfPeople.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, countOfPeople, 50, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, countOfPeople, -20, SpringLayout.HORIZONTAL_CENTER, this);

		
		fnText = new JTextField();
		fnText.setColumns(10);
		fnText.setHorizontalAlignment(JTextField.RIGHT);
		
		sl.putConstraint(SpringLayout.BASELINE, fnText, 10, SpringLayout.NORTH, firstName);
		sl.putConstraint(SpringLayout.WEST, fnText, 50, SpringLayout.EAST, firstName);
		

		

		
		submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension(100, 23));	
		submit.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, submit, 30, SpringLayout.SOUTH, firstName);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submit, -50, SpringLayout.HORIZONTAL_CENTER, this);
		
		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(100, 23));
		clear.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, clear, 0, SpringLayout.NORTH, submit);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, clear, 50, SpringLayout.HORIZONTAL_CENTER, this);
		
		
		
		add(firstName);
		add(fnText);
		add(submit);
		add(clear);
		add(countOfPeople);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(submit == source) {  // if user selects submit
			
			String fn = fnText.getText();
			
			try {	
				int num = Integer.parseInt(fn);
			
				dbms.readStudents(num);;
				
			} catch (SQLDataException s) {
				JOptionPane.showMessageDialog(null, "Enter value that is in range...");
			} catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Enter correct value...");
			} catch (Exception e1) { 
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			
		}
		
	
		
		if(clear == source) {
			
			 fnText.setText("");  // if user hits clear, set text to blank
			
			
		}
		
		
		
	}
}

