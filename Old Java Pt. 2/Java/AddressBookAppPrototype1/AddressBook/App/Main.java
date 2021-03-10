package App;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 * 
 * @author Flexer
 * 
 * 
 *         Will be setting up the Main window
 */

public class Main {

	/*
	 * private static Connection connect = null; private static Statement statement
	 * = null; private static PreparedStatement preparedStatement = null; private
	 * static ResultSet resultSet = null;
	 * 
	 * private static final String userName = "root"; private static final String
	 * password = "maria123";
	 */

	public static void main(String[] args) throws Exception {

		/*
		 * try { connect = DriverManager.getConnection(
		 * "jdbc:mariadb://localhost:3306/bookstoredb?user=root&password=" + password);
		 * 
		 * statement = connect.createStatement(); // statement allows to issue SQL
		 * queries to the database
		 * 
		 * resultSet = statement.executeQuery("select * from authorstbl"); // result
		 * set, shows all info on table
		 * 
		 * 
		 * 
		 * | address_id | first_name | last_name | phone_number | email_address |
		 * +------------+------------+------------+----------------+--------------------
		 * --+ | 1 | Flexer | Fadrigalan | (323) 898-xxxx | ffadrigalan@fake.com |
		 * 
		 * //System.out.println("address_id\t" + "first_name\t" + "last_name\t" +
		 * "phone_number\t" + "email_address"); System.out.println("AuthorID\t" +
		 * "AuthorName");
		 * 
		 * while(resultSet.next()) { int id = resultSet.getInt(1); String name =
		 * resultSet.getString(2);
		 * 
		 * int id = resultSet.getInt("address_id"); String fname =
		 * resultSet.getString("first_name"); String lname =
		 * resultSet.getString("last_name"); String pnum =
		 * resultSet.getString("phone_number"); String email =
		 * resultSet.getString("email_address"); System.out.println("\t " + id +
		 * "\t    "+ fname +"\t"+ lname +"\t"+ pnum +"\t"+ email);
		 * 
		 * 
		 * System.out.println("\t" + id + "\t" + name);
		 * 
		 * 
		 * }
		 * 
		 * 
		 * try { if (resultSet != null) { resultSet.close(); }
		 * 
		 * if (statement != null) { statement.close(); }
		 * 
		 * if (connect != null) { connect.close(); } } catch (Exception e) {
		 * 
		 * }
		 * 
		 * 
		 * }catch(Exception e) { System.out.println("No database exist...");
		 * e.printStackTrace(); }
		 */

		JFrame window = new JFrame("Address Book");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new InformationPanel());
		window.setSize(new Dimension(450, 400));
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		

	}

}
