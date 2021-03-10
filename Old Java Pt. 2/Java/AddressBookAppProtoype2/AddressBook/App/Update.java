package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 * 
 * @author Flexer
 *	Will prompt user to enter information to edit information
 *  Will utilize JComboBox to getSelectedIndex
 *  
 *  the JComboBox will use SQL command WHERE address_id = ?, prepared statement = pstmt
 *  
 *  Connection conn= DriverManager.getConnection("jdbc:odbc:driverName");  
	Statement st = conn.createStatement();

 	ResultSet r=st.executeQuery("select * from tableName");

 	while (r.next()) {  

     	JComboBox.addItem(r.getString("Key_Coloumn_Name"));  
 	}
 *  
 *  pstmt.setInt(1, .getSelectedIndex());
 *  
 *  First Name: 	Flexer				| flex		|  submit
 *  Last  Name:	 	Fadrigalan			|			|  submit
 *  
 *  ...
 */

public class Update extends JFrame implements ActionListener, ItemListener {
	
	AddressRecord information = null;  // this is for the object being returned with all the information
	JPanel panel;
	static JComboBox<String> select;   // will need to refresh
	JLabel heading, fn, ln, pn, email;
	static JLabel currentFn, currentLn, currentPn, currentEmail;  // made static so it changes real time, used in the DBManager
	JTextField fnField, lnField, pnField, emailField;
	JButton submitFn, submitLn, submitPn, submitEmail; 
	Font font = new Font("Helvetica", Font.PLAIN, 12);  // for ease of use, font has been made
	TitledBorder tb = BorderFactory.createTitledBorder("Update Information");  // for ease of use, Titled Border has been made
	Dimension d = new Dimension(150,30);
	
	public Update() {
	// Reset auto increment to 1
		Main.dbms.resetAutoIncrement();
			
	// Turn off Button once clicked!
		InsertUpdateDelete.update.setEnabled(false);
		
	// Accessing DB
		Main.dbms.connectToDatabase();
		
	// Panel Formatting
		tb.setTitleColor(Color.white);
		panel = new JPanel(); SpringLayout sl = new SpringLayout();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(sl);
		panel.setBorder(tb);
		
	// Heading
		heading = new JLabel("Update Current Record");
		heading.setFont(new Font("Helvetica Light", Font.PLAIN, 18)); 
		heading.setForeground(Color.white);
		
		// Placement for Heading
		sl.putConstraint(SpringLayout.NORTH, heading, 40, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, heading, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Drop Down
		select = new JComboBox(Main.dbms.fillJComboBoxDelete().toArray());  // to array, it will make the elements in the arrayList into an Array object
		select.addActionListener(this);  // when user selects from DropDown, it will change accordingly
		select.addItemListener(this);  // when there is a change of Selection, this will set the textfield to empty, or setText("");
		
		//Placement for Drop Down
		sl.putConstraint(SpringLayout.NORTH, select, 80, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, select, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// First Name
		fn = new JLabel("First Name:");
		fn.setFont(font); 
		fn.setForeground(Color.white);
	// Current First Name
		currentFn = new JLabel("");  // currently setting text to no text
		currentFn.setForeground(Color.white);
		currentFn.setFont(font);
	// Text Field
		fnField = new JTextField();
		fnField.setColumns(12);
		fnField.setEnabled(false);
		fnField.addActionListener(this);
	// Submit Button
		submitFn = new JButton("Submit");
		submitFn.setPreferredSize(d);
		submitFn.setEnabled(false);
		submitFn.addActionListener(this);
	// Placement for Components
		// First Row Components
		sl.putConstraint(SpringLayout.NORTH, fn, 160, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, fn, -262, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, currentFn, 160, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentFn, -120, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, fnField, 153, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, fnField, 60, SpringLayout.HORIZONTAL_CENTER, panel);
		
		sl.putConstraint(SpringLayout.NORTH, submitFn, 153, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitFn, 220, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Last Name
		ln = new JLabel("Last Name:");
		ln.setFont(font); 
		ln.setForeground(Color.white);
		
		currentLn = new JLabel("");  // currently setting text to no text
		currentLn.setForeground(Color.white);
		currentLn.setFont(font);
		
		lnField = new JTextField();
		lnField.setColumns(12);
		lnField.setEnabled(false);
		lnField.addActionListener(this);
		
		submitLn = new JButton("Submit");
		submitLn.setPreferredSize(d);
		submitLn.setEnabled(false);
		submitLn.addActionListener(this);
		
	// Placement for Components
		// Second Row Components
		sl.putConstraint(SpringLayout.NORTH, ln, 200, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, ln, -262, SpringLayout.HORIZONTAL_CENTER, panel);
			
		sl.putConstraint(SpringLayout.NORTH, currentLn, 200, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentLn, -120, SpringLayout.HORIZONTAL_CENTER, panel);
			
		sl.putConstraint(SpringLayout.NORTH, lnField, 193, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, lnField, 60, SpringLayout.HORIZONTAL_CENTER, panel);
			
		sl.putConstraint(SpringLayout.NORTH, submitLn, 193, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitLn, 220, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Phone Number
		pn = new JLabel("Phone Number:");
		pn.setFont(font); 
		pn.setForeground(Color.white);
	
		currentPn = new JLabel("");  // currently setting text to no text
		currentPn.setForeground(Color.white);
		currentPn.setFont(font);
		
		pnField = new JTextField();
		pnField.setColumns(12);
		pnField.setEnabled(false);
		pnField.addActionListener(this);
		
		submitPn = new JButton("Submit");
		submitPn.setPreferredSize(d);
		submitPn.setEnabled(false);
		submitPn.addActionListener(this);
	
	// Placement for Components
		// Third Row Components
		sl.putConstraint(SpringLayout.NORTH, pn, 240, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, pn, -250, SpringLayout.HORIZONTAL_CENTER, panel);
					
		sl.putConstraint(SpringLayout.NORTH, currentPn, 240, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentPn, -120, SpringLayout.HORIZONTAL_CENTER, panel);
					
		sl.putConstraint(SpringLayout.NORTH, pnField, 233, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, pnField, 60, SpringLayout.HORIZONTAL_CENTER, panel);
					
		sl.putConstraint(SpringLayout.NORTH, submitPn, 233, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitPn, 220, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Email 
		email = new JLabel("Email:");
		email.setFont(font); 
		email.setForeground(Color.white);
		
		currentEmail = new JLabel("");  // currently setting text to no text
		currentEmail.setForeground(Color.white);
		currentEmail.setFont(font);
		
		emailField = new JTextField();
		emailField.setColumns(12);
		emailField.setEnabled(false);
		emailField.addActionListener(this);
		
		submitEmail = new JButton("Submit");
		submitEmail.setPreferredSize(d);
		submitEmail.setEnabled(false);
		submitEmail.addActionListener(this);
		
	// Placement for Components
		// Fourth Row Components
		sl.putConstraint(SpringLayout.NORTH, email, 280, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, email, -275, SpringLayout.HORIZONTAL_CENTER, panel);
							
		sl.putConstraint(SpringLayout.NORTH, currentEmail, 280, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentEmail, -120, SpringLayout.HORIZONTAL_CENTER, panel);
							
		sl.putConstraint(SpringLayout.NORTH, emailField, 273, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, emailField, 60, SpringLayout.HORIZONTAL_CENTER, panel);
							
		sl.putConstraint(SpringLayout.NORTH, submitEmail, 273, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, submitEmail, 220, SpringLayout.HORIZONTAL_CENTER, panel);
		
	// Adding components
		panel.add(heading);
		
		panel.add(select);
		
		panel.add(fn);
		panel.add(currentFn);
		panel.add(fnField);
		panel.add(submitFn);
		
		panel.add(ln);
		panel.add(currentLn);
		panel.add(lnField);
		panel.add(submitLn);
		
		panel.add(pn);
		panel.add(currentPn);
		panel.add(pnField);
		panel.add(submitPn);
		
		panel.add(email);
		panel.add(currentEmail);
		panel.add(emailField);
		panel.add(submitEmail);
		
		this.add(panel);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(750, 450));
		this.setLocationRelativeTo(null);
		//this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {  // turn on Update button once window is closed!
			public void windowClosing(WindowEvent we) {
				InsertUpdateDelete.update.setEnabled(true);  // setting the update button to be clickable again!
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();  // source event, so I can use in my 'if' statements
		
		Main.dbms.connectToDatabase();  // connecting to DB, I don't think it's needed, but connecting to DB anyways
		
		
		
		/**
		 * Big block of code that sets this panel if it can be usable or not
		 */
		if(select.getSelectedIndex() == 0) {  // if user chooses 'default'. it will prompt up 'Choose other option'
			/**
			 * Set text to nothing
			 */
			currentFn.setText("");
			currentLn.setText("");
			currentPn.setText("");
			currentEmail.setText("");
			
			/**
			 * And set all the interactive components off
			 */
			fnField.setEnabled(false);
			submitFn.setEnabled(false);		
			lnField.setEnabled(false);
			submitLn.setEnabled(false);		
			pnField.setEnabled(false);
			submitPn.setEnabled(false);
			emailField.setEnabled(false);
			submitEmail.setEnabled(false);
		} else {
			fnField.setEnabled(true);
			submitFn.setEnabled(true);
			lnField.setEnabled(true);
			submitLn.setEnabled(true);
			pnField.setEnabled(true);
			submitPn.setEnabled(true);
			emailField.setEnabled(true);
			submitEmail.setEnabled(true);
		}
		
		// As the creator, only First and Last name MUST be the only input
				String name = String.valueOf(select.getSelectedItem());
				String[] nameArray = name.split(" ", 2);
				String firstName = "", lastName = "";
				if(nameArray.length == 2) {
				firstName = nameArray[0];
				lastName = nameArray[1];
				}
				
				
				information = Main.dbms.getInformation(firstName, lastName);  
				// returns an AddressRecord variable and assigns to information with given index
		
		try {  // setting the text to the information that is inside the variable that is being passed
		/**
		 * This is HOW the text changes.
		 */
		currentFn.setText(information.getFirstName());
		currentLn.setText(information.getLastName());
		currentPn.setText(information.getPhoneNumber());
		currentEmail.setText(information.getEmailAddress());
		
		}catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Please choose other options...");  // It will give us NPE, so I just said choose other option
			
		}
		
		
		
		/**
		 * Changing the first name!
		 */
		
		/**
		 * Edit: Error, Bug
		 *
		 * With this implementation of select.getSelectedIndex(),
		 * if the address_id is 38, the selectedIndex will be 2!
		 * It will not change anything, error!
		 * 
		 * To fix, get the address_id of object, and not selected index of JComboBox
		    ------------------------------------------
		    MariaDB [abdb]> select * from addressbook;
			+------------+------------+------------+--------------------+--------------+
			| address_id | first_name | last_name  | email              | phone_number |
			+------------+------------+------------+--------------------+--------------+
			|          1 | Flexer     | Fadrigalan | fnf@gmail.com      | 323 898 7247 |
			|         38 | Nicole     | S          | nstanton@gmail.com | 781 664      |
			+------------+------------+------------+--------------------+--------------+

		 * 
		 */
		
		if(fnField == source || submitFn == source) {  // if user wants to change first name
			String newFn = fnField.getText();
			String[] arrayFn = newFn.split(" ");
			
			if(newFn.isEmpty()) {  // if string is empty, show this dialog
				JOptionPane.showMessageDialog(null, "Please fill textbox in");
			}
		
			else if(arrayFn.length > 1) {
				JOptionPane.showMessageDialog(null, "Enter one name");
				fnField.setText("");
			}
			
			else {
			
				int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to change first name?");
				if(userChoice == JOptionPane.OK_OPTION) {
					Main.dbms.updateFirstName(newFn, firstName, lastName);
				} 
				if(userChoice == JOptionPane.NO_OPTION)  {
					JOptionPane.showMessageDialog(null, "No alterations has been made");
				}
			
				fnField.setText("");
				
			}  // if textbox is not empty
		}
		
		/**
		 * Changing the last name!
		 */
		
		if(lnField == source || submitLn == source) {
			String newLn = lnField.getText();
			
			if(newLn.isEmpty()) {  // if string is empty, show this dialog
				JOptionPane.showMessageDialog(null, "Please fill textbox in");
			}

			else {
			
				int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to change last name?");
				if(userChoice == JOptionPane.OK_OPTION) {
					Main.dbms.updateLastName(select.getSelectedIndex(), newLn);
				} 
				if(userChoice == JOptionPane.NO_OPTION)  {
					JOptionPane.showMessageDialog(null, "No alterations has been made");
				}
				
				lnField.setText("");
			
			}  // if textbox is not empty	
		}

		/**
		 * Changing the phone number!
		 */
		
		if(pnField == source || submitPn == source) {
			String newPhone = pnField.getText();
			
			if(newPhone.isEmpty()) {  // if string is empty, show this dialog
				JOptionPane.showMessageDialog(null, "Please fill textbox in");
			}

			else {
			
				int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to change phone number?");
				if(userChoice == JOptionPane.OK_OPTION) {
					Main.dbms.updatePhoneNumber(select.getSelectedIndex(), newPhone);
				} 
				if(userChoice == JOptionPane.NO_OPTION)  {
					JOptionPane.showMessageDialog(null, "No alterations has been made");
				}
				
				pnField.setText("");
			
			}  // if textbox is not empty
		}
		
		/**
		 * Changing the email address!
		 */

		if(emailField == source || submitEmail == source) {
			String newEmail = emailField.getText();
			
			if(newEmail.isEmpty()) {  // if string is empty, show this dialog
				JOptionPane.showMessageDialog(null, "Please fill textbox in");
			}

			else {
			
				int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to change email address?");
				if(userChoice == JOptionPane.OK_OPTION) {
					Main.dbms.updateEmail(select.getSelectedIndex(), newEmail);
				} 
				if(userChoice == JOptionPane.NO_OPTION)  {
					JOptionPane.showMessageDialog(null, "No alterations has been made");
				}
				
				emailField.setText("");
			
			}  // if textbox is not empty
		}
		
	}

	@Override
	/**
	 * Item state changed for one reason,
	 * if user clicks on different element on select box, set text to empty.
	 * 
	 * It resets the text fields essentially, setting them to empty string.
	 */
	public void itemStateChanged(ItemEvent e) {
		fnField.setText("");
		lnField.setText("");
		pnField.setText("");
		emailField.setText("");
	}

}
