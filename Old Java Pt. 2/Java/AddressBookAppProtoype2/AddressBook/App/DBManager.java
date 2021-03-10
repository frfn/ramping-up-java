package App;

/**
 * Anything DML 
 *  - MUST set to First Name and Last Name validation
 *  - If the same name, they both get chosen, and both will be altered.
 *  - A bug, fix later, and keep on coding, Test Driven Development.
 *  - GET IT DONE.
 */

import java.sql.*;  // Step 1. import all of the SQL packages
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DBManager {
	
	private Connection connect = null;  // the connection between database and app
	private PreparedStatement pstmt = null;  // 'prepared statement', better than 'statement', more dynamic
	private ResultSet rs = null;  // the result set, from executeQuery
	
	public DBManager() {
		// Step 2. connect DB with DriverManager
		try {
			
			  connect = DriverManager.getConnection("jdbc:mariadb://localhost:3306/abdb" + "?user=root&password=maria123");
			 
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);  // close the program, failed connection, 
							// will cause NullPointerException errors if 
						   // program keeps running
		}
		resetAutoIncrement();	
	}  // end of DBManager
	
	/**
	 * Assuming that I have already a created database and tables.
	 *  - Will only have DML, data manipulation language, (insert, update, delete)
	 *    methods
	 *  - View information as well
	 */
	
	/**
	 * If any other class needs to connect to database
	 */
	public void connectToDatabase() {
		try {
			connect = DriverManager.getConnection("jdbc:mariadb://"
					+ "localhost:3306/abdb?"
					+ "user=root&password=maria123");
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Reset auto_increment
	 */
	
	public void resetAutoIncrement() {
		try {
			if(size() == 0) {
				String sqlString = "alter table addressbook auto_increment=1";
				pstmt = connect.prepareStatement(sqlString);
				pstmt.executeUpdate();
			}
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	
	/**
	 * LoginValidation
	 *  - Follow closely.
	 *  - Step by step below.
	 *  - Returns false/true
	 */
	public boolean loginValidation(String user, String pass) throws SQLException {  // 1. Returns a boolean (has user and pass as parameters)
		
		String sqlString;  // 2. Declared sqlString so we can make some SQL commands
		
		try {  // 3. Every DB operation MUST be in a try/catch
			
			sqlString = "select user from login where user=?";  // 4. First SQL command, if user exists in login table
			pstmt = connect.prepareStatement(sqlString);  // setting pstmt to connect to DB
			pstmt.setString(1, user);	// utilizing the setString method to pass into the '?' in the SQL command
			rs = pstmt.executeQuery();  // executing, returns a ResultSet object
			
			if(rs.next()) {  // if user exists, if the result set exists, then move on to next part
				
				sqlString = "select pass from login where pass=?";
				pstmt = connect.prepareStatement(sqlString);
				pstmt.setString(1, pass); 
				rs = pstmt.executeQuery();
				
				if(rs.next()) {  // if password exists then the USERNAME and PASSWORD are correct
					
					rs.close();  // close ResultSet
					return true;  // return true, account is validated
					
				} else {  // else password incorrect
					
					JOptionPane.showMessageDialog(null, "Incorrect Password");
					return false;  // returning false, not validated
				}
				
			} else {  // else username does not exist
				
				JOptionPane.showMessageDialog(null, "Username does not exist");
				return false;  // returning false, not validated
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;  // if gets here, something went wrong, and method MUST return a boolean value
	}
	
	/**
	 * 
	 * @returns the size of database elements
	 * @throws SQLException
	 */
	public int size() {
		
		int size = 0;  // declared size and initialized to zero
		String sqlString;  // declared sqlString
		
		try {
			
			sqlString = "select count(*) from addressbook";  // SQL Command, counts all and returns total 
			pstmt = connect.prepareStatement(sqlString);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {  // if result set exist
				size = rs.getInt(1);  // size = the total number of addressbook information
			}
			else {
				size = 0;
				JOptionPane.showMessageDialog(null, "Empty set");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return size;  // return size;
	}
	
	/**
	 * Update information below!!
	 *  - Use prepared statement
	 *  - Look at previous database!!
	 *  - any functions should NOT be confused here!!
	 */
	
	/**
	 * 
	 * @return
	 * 
	 * I first did array w/ increase method, but was not dynamic enough.
	 * ArrayList works amazingly for this 
	 */
	
	/**
	 * Edit: fillJComboBox is DEPRECATED, use fillJComboBoxDelete
	 * @return
	 */
	public ArrayList<String> fillJComboBox() {  // filling in JComboBox for class Update

		String sqlString;  // SQL command will be assigned to this variable
		ArrayList<String> list = new ArrayList<String>();  // ArrayList list is made
		list.add("Default");  // Added 'Default' so that it will fix the NullPointerException that was STUPIDLY happening
		try {
			sqlString = "select * from addressbook";
			pstmt = connect.prepareStatement(sqlString);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {  // if it exists
			
				list.add(rs.getString(1));  // add on to list. Keep repeating till filled
					// there will be a bug if I set to Names, will not update when name is updated unless exited out of window
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}
	
	public ArrayList<String> fillJComboBoxDelete() {  // filling in JComboBox for class Update

		String sqlString;  // SQL command will be assigned to this variable
		ArrayList<String> list = new ArrayList<String>();  // ArrayList list is made
		/**
		 * This is why 'Default' option is ALWAYS showing up, good for us because we don't want NPException
		 */
		list.add("Default");  // Added 'Default' so that it will fix the NullPointerException that was STUPIDLY happening
		try {
			sqlString = "select * from addressbook";
			pstmt = connect.prepareStatement(sqlString);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {  // if it exists
			
				list.add(rs.getString(2) + " " + rs.getString(3));  // add on to list. Keep repeating till filled
					// there will be a bug if I set to Names, will not update when name is updated unless exited out of window
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}
	
	/**
	 * 
	 * @param index
	 * @return
	 * 
	 * Method below will return an AdressRecord variable,
	 * will be populated inside the while loop.
	 * 
	 */
	
	/**
	 * Altering from int to String,
	 * I want to get the record from the database 
	 * BY THEIR NAME
	 * @return
	 */
	
	public AddressRecord getInformation(String fn, String ln) {
		
		AddressRecord record = null;
		String sqlString = "";
		
		try {
			sqlString = "select * from addressbook where first_name=? and last_name=?;";
			pstmt = connect.prepareStatement(sqlString);
			pstmt.setString(1, fn);
			pstmt.setString(2, ln);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				record = new AddressRecord(rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
				rs.close();					// 2. first		// 3. last		 // 5. phone	  // 4. email
				return record;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;   // returning if something happened
		
	}
	
	// SCRAPPED BECAUSE USING THE DROP DOWN ALREADY GAVE ME THE TEXT!!
	/*
	 * public ArrayList<String> returnFirstNameInformation() { ArrayList<String>
	 * list = new ArrayList<String>(); String sqlString = ""; try { sqlString =
	 * "select first_name from addressbook"; pstmt =
	 * connect.prepareStatement(sqlString); rs = pstmt.executeQuery();
	 * 
	 * while(rs.next()) { list.add(rs.getString(1)); }
	 * 
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * return null;
	 * 
	 * }
	 */
	
	public void updateFirstName(String newFirst, String firstName, String lastName) {
		
		String sqlString;
		
		try {
			sqlString = "update addressbook set first_name=? where first_name=? and last_name=?";
			pstmt = connect.prepareStatement(sqlString);
			pstmt.setString(1, newFirst);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				JOptionPane.showMessageDialog(null, "Success! First name has been changed. \nAffected Rows: " + status);
				Update.currentFn.setText(newFirst);  // static variable, currentFn
				fillJComboBoxDelete();
			}else {
				JOptionPane.showMessageDialog(null, "No changes has been made. \nAffected Rows: " + status);
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "First name too long!");
		}
		
	}
	
	public void updateLastName(int address_id, String newName) {
		
		String sqlString;
		
		try {
			sqlString = "update addressbook set last_name=? where address_id=?";
			pstmt = connect.prepareStatement(sqlString);
			pstmt.setInt(2, address_id);
			pstmt.setString(1, newName);
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				JOptionPane.showMessageDialog(null, "Success! Last name has been changed. \nPlease close window to refresh. \nAffected Rows: " + status);
				Update.currentLn.setText(newName);
			}else {
				JOptionPane.showMessageDialog(null, "No changes has been made. \nAffected Rows: " + status);
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Last name too long!");
		}
		
	}
	
	public void updatePhoneNumber(int address_id, String newPhone) {
		
		String sqlString;
		
		try {
			sqlString = "update addressbook set phone_number=? where address_id=?";
			pstmt = connect.prepareStatement(sqlString);
			pstmt.setInt(2, address_id);
			pstmt.setString(1, newPhone);
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				JOptionPane.showMessageDialog(null, "Success! Phone Number has been changed. \nAffected Rows: " + status);
				Update.currentPn.setText(newPhone);
			}else {
				JOptionPane.showMessageDialog(null, "No changes has been made. \nAffected Rows: " + status);
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Phone Number too long!");
		}
		
	}
	
	public void updateEmail(int address_id, String newEmail) {
		
		String sqlString;
		
		try {
			sqlString = "update addressbook set email=? where address_id=?";
			pstmt = connect.prepareStatement(sqlString);
			pstmt.setInt(2, address_id);
			pstmt.setString(1, newEmail);
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				JOptionPane.showMessageDialog(null, "Success! Email has been changed. \nAffected Rows: " + status);
				Update.currentEmail.setText(newEmail);
			}else {
				JOptionPane.showMessageDialog(null, "No changes has been made. \nAffected Rows: " + status);
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Email too long!");  // fix this, maybe
		}
		
	}
	
	public void insertInto(AddressRecord record) {
		
		String sqlString = "";
		
		try {
			sqlString = "insert into addressbook(first_name, last_name, email, phone_number) values (?, ?, ?, ?)";
			pstmt = connect.prepareStatement(sqlString);
			pstmt.setString(1, record.getFirstName());
			pstmt.setString(2, record.getLastName());
			pstmt.setString(3, record.getEmailAddress());
			pstmt.setString(4, record.getPhoneNumber());
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				JOptionPane.showMessageDialog(null, "Success! " + record.getFirstName() + 
						" has been added to the database. \nAffected Rows: " + status);
			}else {
				JOptionPane.showMessageDialog(null, "No changes has been made. \nAffected Rows: " + status);
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error, please try again");
			e.printStackTrace();
		}
		
	}
	

	
	public void delete(String name, String name2) {
		String sqlString = "";
		
		try {
			sqlString = "delete from addressbook where first_name=? and last_name=?";
			pstmt = connect.prepareStatement(sqlString);
			pstmt.setString(1, name);
			pstmt.setString(2, name2);
			int status = pstmt.executeUpdate();
			
			if(status > 0) {
				JOptionPane.showMessageDialog(null, "Success, deleted element: "
			+ name + "\nPlease close and reopen window to see updates!" + "\nAffected Rows: " + status);
			}else {
				JOptionPane.showMessageDialog(null, "No changes has been made. \nAffected Rows: " + status);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error, element not deleted");
		}
	}
	
	public String displayRecords() {
		String sqlString = "";
		String records = "";
		
		String f, l, p, e;
		
		try {
			sqlString = "select * from addressbook";
			pstmt = connect.prepareStatement(sqlString);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				f = rs.getString(2);
				l = rs.getString(3);
				p = rs.getString(5);
				e = rs.getString(4);
				
				records += "First Name: " + f +
						 "\nLast Name: " + l +
						 "\nPhone Number: " + p +
						 "\nEmail: " + e + "\n\n";
				
			}
			
			return records;  // break out of loop and return records
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error, can't complete process");
			ex.printStackTrace();
		}
		
		
		return null;  // exiting and returning null if anything happens
		
	}
	
}
