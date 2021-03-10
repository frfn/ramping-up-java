package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Flexer
 * Will display all records on the DB
 */

public class View extends JFrame implements ActionListener {
	
	JPanel panel;
	JTextArea list, heading;
	JButton close;
	Font font = new Font("Helvetica", Font.PLAIN, 18);  // for ease of use, font has been made
	Font smallerFont = new Font("Helvetica", Font.PLAIN, 12);
	TitledBorder tb = BorderFactory.createTitledBorder("Information");  // for ease of use, Titled Border has been made
	Dimension d = new Dimension(100,30);
	
	public View() {
		Main.dbms.resetAutoIncrement();  // reset auto increment
		
		InsertUpdateDelete.view.setEnabled(false);  // when opened, set to button to false
		
		tb.setTitleColor(Color.white);
		panel = new JPanel(); SpringLayout sl = new SpringLayout();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(sl);
		panel.setBorder(tb);
		
		heading = new JTextArea("Full list of records");
		heading.setBackground(Color.DARK_GRAY);
		heading.setForeground(Color.white);
		heading.setFont(font);
		heading.setLineWrap(false);
		heading.setWrapStyleWord(true);
		heading.setEditable(false);
		
		sl.putConstraint(SpringLayout.NORTH, heading, 40, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, heading, 0, SpringLayout.HORIZONTAL_CENTER, panel);
	

		list = new JTextArea(Main.dbms.displayRecords());
		list.setMargin(new Insets(10, 10, 10, 10));
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.white);
		list.setFont(smallerFont);
		list.setLineWrap(false);
		list.setEditable(false);		 

		JScrollPane scroller = new JScrollPane(list);
		scroller.setAutoscrolls(true);
		scroller.setBackground(Color.DARK_GRAY);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		sl.putConstraint(SpringLayout.NORTH, scroller, 70, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.EAST, scroller, -50, SpringLayout.EAST, panel);	
		sl.putConstraint(SpringLayout.WEST, scroller, 50, SpringLayout.WEST, panel);	
		sl.putConstraint(SpringLayout.SOUTH, scroller, -100, SpringLayout.SOUTH, panel);
		
		close = new JButton("Close");
		close.setPreferredSize(d);
		close.addActionListener(this);
		
		sl.putConstraint(SpringLayout.NORTH, close, 370, SpringLayout.NORTH, panel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, close, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		
		
		panel.add(heading);
		panel.add(scroller);
		panel.add(close);
		
		this.add(panel);
		
		this.setSize(new Dimension(400, 500));
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowAdapter() {  // turn on Update button once window is closed!
			public void windowClosing(WindowEvent we) {
				InsertUpdateDelete.view.setEnabled(true);  // setting the update button to be clickable again!
			}
		});
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		InsertUpdateDelete.view.setEnabled(true);
	}

}
