package App;
import java.sql.*;

import javax.swing.JOptionPane;
public class DatabaseManager {
	
	/**  HOW to clean used resources
				 * import java.sql.*;
			
			public class JDBCExample {
			   // JDBC driver name and database URL
			   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   static final String DB_URL = "jdbc:mysql://localhost/EMP";
			
			   //  Database credentials
			   static final String USER = "username";
			   static final String PASS = "password";
			   
			   public static void main(String[] args) {
			   Connection conn = null;
			   PreparedStatement stmt = null;
			   try{
			   
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
			
			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String sql = "UPDATE Employees set age=? WHERE id=?";
			      stmt = conn.prepareStatement(sql);
			      
			      //Bind values into the parameters.
			      stmt.setInt(1, 35);  // This would set age
			      stmt.setInt(2, 102); // This would set ID
			      
			      // Let us update age of the record with ID = 102;
			      int rows = stmt.executeUpdate();
			      System.out.println("Rows impacted : " + rows );
			
			      // Let us select all the records and display them.
			      sql = "SELECT id, first, last, age FROM Employees";
			      ResultSet rs = stmt.executeQuery(sql);
			
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int id  = rs.getInt("id");
			         int age = rs.getInt("age");
			         String first = rs.getString("first");
			         String last = rs.getString("last");
			
			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", Age: " + age);
			         System.out.print(", First: " + first);
			         System.out.println(", Last: " + last);
			      }
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();
			      
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			      
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			      
			   }finally{
			      //finally block used to close resources
			       
			      try{
			         if(stmt!=null)
			            stmt.close();
			            
			      }catch(SQLException se2){ }// nothing we can do
			      
			      try{
			         if(conn!=null)
			            conn.close();
			            
			      }catch(SQLException se){
			         se.printStackTrace();
			         
			      }//end finally try
			   }//end try
			   
			   System.out.println("Goodbye!");
			}//end main
			}//end JDBCExample
	 */
	
	/**
	 * Notes on the database language:
	   
	   Statement	Use this for general-purpose access to your database. Useful when you are using static SQL statements at runtime. 
	   				The Statement interface cannot accept parameters.
	  
PreparedStatement	Use this when you plan to use the SQL statements many times. 
					The PreparedStatement interface accepts input parameters at runtime.
					
CallableStatement	Use this when you want to access the database stored procedures. 
					The CallableStatement interface can also accept runtime input parameters.
					
		------------------------------------------------------------------
		
		boolean execute (String SQL): Returns a boolean value of true if a ResultSet object can be retrieved; 
		otherwise, it returns false. Use this method to execute SQL DDL statements or when you need to use truly dynamic SQL.

		int executeUpdate (String SQL): Returns the number of rows affected by the execution of the SQL statement. 
		Use this method to execute SQL statements for which you expect to get a number of rows affected - for example, an INSERT, UPDATE, or DELETE statement.

		ResultSet executeQuery (String SQL): Returns a ResultSet object. 
		Use this method when you expect to get a result set, as you would with a SELECT statement.
		
		------------------------------------------------------------------
		
		
		
	 */
	
	/**
	 * You will need to throws Exception in each method
	 */
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	/**
	 * ConnectToDB
	 *  - This connects to the database
	 *  - Connection connect = DriverManager.getConnection
	 *  - Any time interacting with Database, must try/catch
	 *  - I can write inside constructor so that when I initialize it, it connects to the database
	 *  
	 */
	public void connectToDB() throws Exception {
		try {
			// Class.forName("org.mariadb.jdbc.driver");  // it's org! and not com.mariadb.jdbc.driver, but does not work anymore
			// Setup the connection with the DB && Because of JDBC 4.0, we don't have to manually register and load drivers
			// hence, a legacy way to connect
			connect = DriverManager.getConnection("jdbc:mariadb://localhost:3306/addressbookdb?user=root&password=maria123");
			
		} catch (Exception e) {
			//throw e;
			System.out.println("fool... Unknown database 'addressbokdb'");
		}
	
	}
	
	public void deleteAll() throws Exception {
		
		
		String deleteSQL = "delete from addressbookdb.information";
		preparedStatement = connect.prepareStatement(deleteSQL);
		preparedStatement.execute();
		
		String resetCount = "alter table information auto_increment = 1";
		preparedStatement = connect.prepareStatement(resetCount);
		preparedStatement.execute();
		
		//statement = connect.createStatement();
		//statement.executeUpdate("delete from addressbookdb.information");
		

		
	}
	
	public void updateFirstName(int num, String str) throws Exception {
		try {
			
			
			/*
			 * statement = connect.createStatement();
			 * 
			 * int update = statement.executeUpdate("update information set first_name = '"
			 * + str + "' where first_name = '" + str2 + "'");
			 * 
			 * System.out.println(update);
			 * 
			 * if(update > 0) { JOptionPane.showMessageDialog(null,
			 * "Success, name changed...");
			 * 
			 * } else { JOptionPane.showMessageDialog(null, "Name does not exist..."); }
			 */
			 
			
			
			
			
			/*
			 * String updateSQL = "update information set first_name = '" + str +
			 * "' where first_name = '" + str2 + "'";
			 */
			  
			  String updateSQL = "update information set first_name=? where address_id=?"; 
			  
			  preparedStatement = connect.prepareStatement(updateSQL); 
			  
			  preparedStatement.setString(1, str);
			  preparedStatement.setInt(2, num);
			  
			  /**
			   * Notes about executeUpdate:
			   * Will return an integer number if successful update
			   */
			
			  int rs = preparedStatement.executeUpdate();
			  
			  if(rs > 0) { JOptionPane.showMessageDialog(null,
					  "Success, name changed... \n" + rs + " row affected");
			  			
					  
					  } else if(rs == 0) {
						  JOptionPane.showMessageDialog(null, "Enter correct range...");
					  }
			  
			  else { JOptionPane.showMessageDialog(null, "Name does not exist...\n" + rs + " row affected"); }
			  
			 
			
		}catch(NullPointerException | SQLException e) {  // multiple catch
			e.printStackTrace();
		}
		
	}
	
	public void readStudents(int num) throws Exception {
		
		/**
		 * 
		 *  Notes about ResultSet:
		  
		   - Navigational methods: Used to move the cursor around.

		   - Get methods: Used to view the data in the columns of the current row being pointed by the cursor.

	  	   - Update methods: Used to update the data in the columns of the current row. 
	  	     The updates can then be updated in the underlying database as well.
	  	     
	  	     ----------------------------------------------------
	  	     
	  	    - createStatement(int RSType, int RSConcurrency);

			- prepareStatement(String SQL, int RSType, int RSConcurrency);

			- prepareCall(String sql, int RSType, int RSConcurrency);
	  	   
	  	    ----------------------------------------------------
	  	    RSTYPES
	  	    
	  	   - ResultSet.TYPE_FORWARD_ONLY	The cursor can only move forward in the result set.
	  	   
		   - ResultSet.TYPE_SCROLL_INSENSITIVE	The cursor can scroll forward and backward, and the result set is not sensitive to 
		   										changes made by others to the database that occur after the result set was created.
		   										
		   - ResultSet.TYPE_SCROLL_SENSITIVE.	The cursor can scroll forward and backward, and the result set is sensitive to changes 
		   										made by others to the database that occur after the result set was created.
		   										
		   	----------------------------------------------------
		   	RSConcurrency
		   	
		   	- ResultSet.CONCUR_READ_ONLY	Creates a read-only result set. This is the default
		   	 
			- ResultSet.CONCUR_UPDATABLE	Creates an updateable result set.
			
			----------------------------------------------------
			
			S.N.	Methods & Description
			1	- public void beforeFirst() throws SQLException
					Moves the cursor just before the first row.
			

			2	- public void afterLast() throws SQLException
					Moves the cursor just after the last row.
			
			3	- public boolean first() throws SQLException
					Moves the cursor to the first row.
			
			4	- public void last() throws SQLException
					Moves the cursor to the last row.
			
			5	- public boolean absolute(int row) throws SQLException
					Moves the cursor to the specified row.
			
			6	- public boolean relative(int row) throws SQLException
					Moves the cursor the given number of rows forward or backward, from where it is currently pointing.
			
			7	- public boolean previous() throws SQLException
					Moves the cursor to the previous row. This method returns false if the previous row is off the result set.
			
			8	- public boolean next() throws SQLException
					Moves the cursor to the next row. This method returns false if there are no more rows in the result set.
			
			9	- public int getRow() throws SQLException
					Returns the row number that the cursor is pointing to.
			
			10	- public void moveToInsertRow() throws SQLException
					Moves the cursor to a special row in the result set that can be used to insert a new row into the database. 
					The current cursor location is remembered.
			
			11	- public void moveToCurrentRow() throws SQLException
					Moves the cursor back to the current row if the cursor is currently at the insert row; otherwise, this method does nothing
				  	   
			----------------------------------------------------
			
			S.N.	Methods & Description
			1	- public int getInt(String columnName) throws SQLException
				  	Returns the int in the current row in the column named columnName.
			
			2	- public int getInt(int columnIndex) throws SQLException
				  Returns the int in the current row in the specified column index. 
				  	The column index starts at 1, meaning the first column of a row is 1, the second column of a row is 2, and so on.
				  	
				  	there are methods for each eight primitive types, strings, floats, doubles, chars, etc.
				 
			----------------------------------------------------
			
			S.N.	Methods & Description
			1  - public void updateString(int columnIndex, String s) throws SQLException
				 	Changes the String in the specified column to the value of s.
			
			2	- public void updateString(String columnName, String s) throws SQLException
				 	Similar to the previous method, except that the column is specified by its name instead of its index.
				 
			----------------------------------------------------
			
			S.N.	Methods & Description
			1	- public void updateRow()
				Updates the current row by updating the corresponding row in the database.
			
			2	- public void deleteRow()
				Deletes the current row from the database
			
			3	- public void refreshRow()
				Refreshes the data in the result set to reflect any recent changes in the database.
			
			4	- public void cancelRowUpdates()
				Cancels any updates made on the current row.
			
			5	- public void insertRow()
				Inserts a row into the database. This method can only be invoked when the cursor is pointing to the insert row.
				
				----------------------------------------------------
			Example
			
			//STEP 1. Import required packages
				import java.sql.*;
				
				public class JDBCExample {
				   // JDBC driver name and database URL
				   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
				   static final String DB_URL = "jdbc:mysql://localhost/EMP";
				
				   //  Database credentials
				   static final String USER = "username";
				   static final String PASS = "password";
				   
				 public static void main(String[] args) {
				   Connection conn = null;
				   try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");
				
				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				      //STEP 4: Execute a query to create statement with
				      // required arguments for RS example.
				      System.out.println("Creating statement...");
				      Statement stmt = conn.createStatement(
				                           ResultSet.TYPE_SCROLL_INSENSITIVE,
				                           ResultSet.CONCUR_UPDATABLE);
				     //STEP 5: Execute a query
				      String sql = "SELECT id, first, last, age FROM Employees";
				      ResultSet rs = stmt.executeQuery(sql);
				
				      System.out.println("List result set for reference....");
				      printRs(rs);
				
				      //STEP 6: Loop through result set and add 5 in age
				      //Move to BFR postion so while-loop works properly
				      rs.beforeFirst();
				      //STEP 7: Extract data from result set
				      while(rs.next()){
				         //Retrieve by column name
				         int newAge = rs.getInt("age") + 5;
				         rs.updateDouble( "age", newAge );
				         rs.updateRow();
				      }
				      System.out.println("List result set showing new ages...");
				      printRs(rs);
				      // Insert a record into the table.
				      //Move to insert row and add column data with updateXXX()
				      System.out.println("Inserting a new record...");
				      rs.moveToInsertRow();
				      rs.updateInt("id",104);
				      rs.updateString("first","John");
				      rs.updateString("last","Paul");
				      rs.updateInt("age",40);
				      //Commit row
				      rs.insertRow();
				
				      System.out.println("List result set showing new set...");
				      printRs(rs);
				      
				      // Delete second record from the table.
				      // Set position to second record first
				      rs.absolute( 2 );
				      System.out.println("List the record before deleting...");
				      //Retrieve by column name
				      int id  = rs.getInt("id");
				      int age = rs.getInt("age");
				      String first = rs.getString("first");
				      String last = rs.getString("last");
				
				      //Display values
				      System.out.print("ID: " + id);
				      System.out.print(", Age: " + age);
				      System.out.print(", First: " + first);
				      System.out.println(", Last: " + last);
				
				     //Delete row
				      rs.deleteRow();
				      System.out.println("List result set after \
				                                 deleting one records...");
				      printRs(rs);
				
				      //STEP 8: Clean-up environment
				      rs.close();
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try
				   System.out.println("Goodbye!");
				}//end main
				
				   public static void printRs(ResultSet rs) throws SQLException{
				      //Ensure we start with first row
				      rs.beforeFirst();
				      while(rs.next()){
				         //Retrieve by column name
				         int id  = rs.getInt("id");
				         int age = rs.getInt("age");
				         String first = rs.getString("first");
				         String last = rs.getString("last");
				
				         //Display values
				         System.out.print("ID: " + id);
				         System.out.print(", Age: " + age);
				         System.out.print(", First: " + first);
				         System.out.println(", Last: " + last);
				     }
				     System.out.println();
				   }//end printRs()
				}//end JDBCExample
								 
		 */
		
		try {
			statement = connect.createStatement();
			
			resultSet = statement.executeQuery("select * from addressbookdb.information");
			//resultSet.absolute(num-1);
			
			System.out.println();
			
			
			resultSet.absolute(num);
				
				int id = resultSet.getInt("address_id"); 
				String fname = resultSet.getString("first_name"); 
				String lname = resultSet.getString("last_name"); 
				String pnum = resultSet.getString("phone_number"); 
				String email = resultSet.getString("email_address"); 
				
				
				JOptionPane.showMessageDialog(null, "AddressID: " + id + "\n" + 
								   "First Name: " + fname + "\n" + 
								   "Last Name: " + lname + "\n" + 
								   "Phone Number: " + pnum + "\n" +
								   "Email: " + email, "Information", JOptionPane.INFORMATION_MESSAGE);
			
				
				
			/*
			 * System.out.println("AddressID: " + id + "\n" + "First Name: " + fname + "\n"
			 * + "Last Name: " + lname + "\n" + "Phone Number: " + pnum + "\n" + "Email: " +
			 * email);
			 */
			
				
				
			
			
			/*
			 * resultSet.close(); statement.close();
			 */
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int size() throws SQLException {
		
		int size = 0;
		
		try {
			String count = "select count(*) from information";
			preparedStatement = connect.prepareStatement(count);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				size = resultSet.getInt(1);
			}
		}catch(Exception e) {
			
		}
		
		
		return size;
	}
	
	public void readStudents() throws Exception {
		
		String str = "";
		
		try {
			statement = connect.createStatement();
			
			resultSet = statement.executeQuery("select * from addressbookdb.information");
			
			while (resultSet.next()) {
				
				int id = resultSet.getInt("address_id"); 
				String fname = resultSet.getString("first_name"); 
				String lname = resultSet.getString("last_name"); 
				String pnum = resultSet.getString("phone_number"); 
				String email = resultSet.getString("email_address"); 
				
				
				
				str += "AddressID: " + id + "\n" + 
								   "First Name: " + fname + "\n" + 
								   "Last Name: " + lname + "\n" + 
								   "Phone Number: " + pnum + "\n" +
								   "Email: " + email + "\n\n";
			}
			
			
		} catch (Exception e) {
			throw e;
		}
		
		JOptionPane.showMessageDialog(null, str);
	}
	
	
	
	public void addStudent(String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception {
		
		/*
		 * String qString = String.
		 * format("INSERT INTO addressbookdb.information VALUES('%d', '%s','%s','%s', '%s')"
		 * , //query for insertion count, firstName, lastName, phoneNumber,
		 * emailAddress);
		 */
		
		String qString = "INSERT INTO addressbookdb.information(first_name, last_name, phone_number, email_address)"
				+ " VALUES (?, ?, ?, ?)";
		
	
    
        try{
        	
            PreparedStatement statement = connect.prepareStatement(qString);
            //statement.setInt(1, count);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phoneNumber);
            statement.setString(4, emailAddress);
            statement.executeUpdate();  // add to database
    
        }catch(Exception e){e.printStackTrace();}
		
	}
	
}
