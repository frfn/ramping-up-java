package App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

/**
 * 
 * @author Flexer
 * Class will show three buttons to choose from to update DB
 */

public class InsertUpdateDelete extends JFrame implements ActionListener {
	/**
	 * Setting up components
	 */
	static JButton insert, update, delete, view;  // buttons are static so that i can change their status(if clickable) in other classes!
	JLabel heading, underline;
	JPanel panel;
	Dimension d = new Dimension(150,30);
	Font font = new Font("Helvetica", Font.PLAIN, 12);  // for ease of use, font has been made
	TitledBorder tb = BorderFactory.createTitledBorder("Insert/Update/Delete Page");  // for ease of use, Titled Border has been made

	public InsertUpdateDelete() {
	// Reset auto increment to 1
		Main.dbms.resetAutoIncrement();
			
	// Panel formatting	
		tb.setTitleColor(Color.white);
		panel = new JPanel(); SpringLayout sl = new SpringLayout();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(sl);
		panel.setBorder(tb);
	
	// Heading
		heading = new JLabel("Please select an option");
		heading.setFont(new Font("Helvetica Light", Font.PLAIN, 18)); 
		heading.setForeground(Color.white);
	
	// Underline
		underline = new JLabel("_______________________");
		underline.setFont(new Font("Helvetica Light", Font.PLAIN, 18)); 
		underline.setForeground(Color.white);
		
	// Insert button	
		insert = new JButton("Insert New Record");
		insert.setFont(font);
		insert.setPreferredSize(new Dimension(d));
		insert.addActionListener(this);
		
	// Update button	
		update = new JButton("Update Record");
		update.setFont(font);
		update.setPreferredSize(new Dimension(d));
		update.addActionListener(this);
		
	// Delete	
		delete = new JButton("Delete Record");
		delete.setFont(font);
		delete.setPreferredSize(new Dimension(d));
		delete.addActionListener(this);
		
	// View
		view = new JButton("View Records");
		view.setFont(font);
		view.setPreferredSize(new Dimension(d));
		view.addActionListener(this);
		
	// Setting components constraints
		// Heading
		sl.putConstraint(SpringLayout.NORTH, heading, 40, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, heading, 0, SpringLayout.HORIZONTAL_CENTER, panel);
	
		// Underline
		sl.putConstraint(SpringLayout.NORTH, underline, 15, SpringLayout.NORTH, heading);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, underline, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// Insert Button
		sl.putConstraint(SpringLayout.NORTH, insert, 70, SpringLayout.NORTH, heading);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, insert, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// Update Button
		sl.putConstraint(SpringLayout.NORTH, update, 50, SpringLayout.NORTH, insert);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, update, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// Delete button
		sl.putConstraint(SpringLayout.NORTH, delete, 50, SpringLayout.NORTH, update);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, delete, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		// View Button
		sl.putConstraint(SpringLayout.NORTH, view, 50, SpringLayout.NORTH, delete);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, view, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
	//Adding to Panel
		panel.add(heading);
		panel.add(underline);
		panel.add(insert);
		panel.add(update);
		panel.add(delete);
		panel.add(view);
		this.add(panel);
		
		// Frame operations	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(300, 450));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(insert == source) {
			Insert insertWindow = new Insert();
			insertWindow.setVisible(true);
		}
		else if(update == source) {
			Update updateWindow = new Update();
			updateWindow.setVisible(true);
		}
		else if(delete == source) {
			Delete deleteWindow = new Delete();
			deleteWindow.setVisible(true);
		}
		else if(view == source) {
			View viewWindow = new View();
			viewWindow.setVisible(true);
		}
		
	}

}
