package App;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UpdateInformationPanel extends JFrame implements ActionListener {
	
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
	
	
	// 4 text fields
	JTextField fnText;
	JTextField lnText;

	
	// 1 submit button
	JButton submit;
	JButton clear;
	
	public UpdateInformationPanel() {
		
		this.setVisible(true);
		this.setSize(new Dimension(450, 300));
		this.setLocationRelativeTo(null);
	
		
		try {
		dbms.connectToDB();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		
		SpringLayout sl = new SpringLayout();  // layout for panel
		
		panel.setLayout(sl);
		panel.setBackground(Color.DARK_GRAY);
		
		firstName = new JLabel("ID Number: ");
		firstName.setFont(new Font("Helvetica", Font.PLAIN, 12));
		firstName.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, firstName, 90, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, firstName, -80, SpringLayout.HORIZONTAL_CENTER, panel);
		
		lastName = new JLabel("Set To: ");
		lastName.setFont(new Font("Helvetica", Font.PLAIN, 12));
		lastName.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, lastName, 20, SpringLayout.SOUTH, firstName);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, lastName, -80, SpringLayout.HORIZONTAL_CENTER, panel);
		
		
		
		
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
		

		
		submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension(100, 23));	
		submit.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, submit, 30, SpringLayout.SOUTH, lnText);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submit, -50, SpringLayout.HORIZONTAL_CENTER, panel);
		
		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(100, 23));
		clear.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, clear, 0, SpringLayout.NORTH, submit);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, clear, 50, SpringLayout.HORIZONTAL_CENTER, panel);
		
		
		
		panel.add(firstName);
		panel.add(lastName);
		panel.add(fnText);
		panel.add(lnText);
		panel.add(submit);
		panel.add(clear);
		
		add(panel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(submit == source) {  // if user selects submit
			
			String ffn = fnText.getText();
			
			try {
			int fn = Integer.parseInt(ffn);
			
			String ln = lnText.getText();
			
			
			if(fn > dbms.size() || fn < 0) {
				JOptionPane.showMessageDialog(null, "Enter ID in range...");
			} else {
				dbms.updateFirstName(fn, ln);
			}
		
				
			} catch (NumberFormatException n) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Please enter number...");
			}
			
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			this.dispose();
		
		}
		
	
		
		if(clear == source) {
			
			 fnText.setText(""); lnText.setText("");   // if user hits clear, set text to blank
			
			
		}
		
		
		
		
		
	}
}
