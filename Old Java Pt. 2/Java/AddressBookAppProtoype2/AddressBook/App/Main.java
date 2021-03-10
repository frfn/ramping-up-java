package App;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class Main {

	public static DBManager dbms = new DBManager();  // a static variable, because it is ONE instance, ONE object, a static object
	
	static private Dimension screenPosition = new Dimension(100, Toolkit.getDefaultToolkit().getScreenSize().width/3 ); // Placement
	
	public static void main(String[] args) {
		Login start = new Login();
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
