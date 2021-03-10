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

public class Delete extends JFrame implements ActionListener{

	AddressRecord information = null;
	JPanel panel;
	JLabel heading;
	JComboBox select;
	JButton delete;
	Font font = new Font("Helvetica", Font.PLAIN, 12);  // for ease of use, font has been made
	TitledBorder tb = BorderFactory.createTitledBorder("Update Information");  // for ease of use, Titled Border has been made
	Dimension d = new Dimension(150,30);
	
	/**
	 * Ask to close and reopen to refresh Database!
	 */
	
	public Delete() {
	// Reset auto increment to 1
		Main.dbms.resetAutoIncrement();
		
	// Turn off Button once clicked!
		InsertUpdateDelete.delete.setEnabled(false);
		
		Main.dbms.connectToDatabase();
		
		tb.setTitleColor(Color.white);
		panel = new JPanel(); SpringLayout sl = new SpringLayout();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(sl);
		panel.setBorder(tb);
		
		heading = new JLabel("Select from drop down menu to select");
		heading.setFont(new Font("Helvetica Light", Font.PLAIN, 18)); 
		heading.setForeground(Color.white);
		
		sl.putConstraint(SpringLayout.NORTH, heading, 40, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, heading, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		select = new JComboBox(Main.dbms.fillJComboBoxDelete().toArray());
		
		sl.putConstraint(SpringLayout.NORTH, select, 80, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, select, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		delete = new JButton("Delete");
		delete.setPreferredSize(d);
		delete.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, delete, 130, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, delete, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		panel.add(heading);
		panel.add(select);
		panel.add(delete);
		
		this.add(panel);
		
		this.setSize(450, 250);
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter() {  // turn on Update button once window is closed!
			public void windowClosing(WindowEvent we) {
				InsertUpdateDelete.delete.setEnabled(true);  // setting the update button to be clickable again!
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if(delete == source) {
			
			String name2;
			String name = String.valueOf(select.getSelectedItem());  // avoids null values
			String[] edit = name.split(" ");
			name = edit[0];
			name2 = edit[1];
			
			Main.dbms.delete(name, name2);
		
		}
	}

}
