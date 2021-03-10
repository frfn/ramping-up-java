package DifferentTypesOfLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GridPanel extends JPanel{

	String number = "";
	
	JTextField text = new JTextField();
	JButton clear = new JButton("C");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	
	
	
	public GridPanel() {
		
		text.setText("");
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setColumns(12);
		
		//** Looks like it sizes the buttons too so that it will look uniform
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(0,2));
		/**
		 * GridLayout argument
		 * 0, 2 
		 * 0 - rows –––
		 * 2 - items in row before moving down a row!
		 * 
		 * if 5  items ---  ||1||    ||2||
		 * 		        	||3||    ||4||
		 * 		         	||5||
		 * 
		 * 
		 */
		
		p1.add(text);
		
		clear.addActionListener(new ButtonPush());
		p1.add(clear);
		
		JSeparator sep = new JSeparator();
		
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 3));
		
		b1.addActionListener(new ButtonPush());
		p2.add(b1);
		
		b2.addActionListener(new ButtonPush());
		p2.add(b2);
		
		b3.addActionListener(new ButtonPush());
		p2.add(b3);
		
		b4.addActionListener(new ButtonPush());
		p2.add(b4);
		
		b5.addActionListener(new ButtonPush());
		p2.add(b5);
		
		b6.addActionListener(new ButtonPush());
		p2.add(b6);
		
		b7.addActionListener(new ButtonPush());
		p2.add(b7);
		
		b8.addActionListener(new ButtonPush());
		p2.add(b8);
		
		b9.addActionListener(new ButtonPush());
		p2.add(b9);
		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		main.add(p1, BorderLayout.NORTH);
		main.add(sep);
		main.add(p2, BorderLayout.SOUTH);
		
		add(main);
		
	}
	
	private class ButtonPush implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//reference testingsForMeToDo/Chapter4PushButton
			
			
			Object source = e.getSource();
			
			if(source == clear) {
				
				number = "";
				text.setText(number);
			}
			
			if(source == b1) {
				number += b1.getText();
				text.setText(number);
				//JOptionPane.showMessageDialog(null, "You chose button 1!", "Button 1", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b2) {
				number += b2.getText();
				text.setText(number);
				//JOptionPane.showMessageDialog(null, "You chose button 2!", "Button 2", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b3) {
				number += b3.getText();
				text.setText(number);
				//JOptionPane.showMessageDialog(null, "You chose button 3!", "Button 3", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b4) {
				number += b4.getText();
				text.setText(number);
				//JOptionPane.showMessageDialog(null, "You chose button 4!", "Button 4", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b5) {
				number += b5.getText();
				text.setText(number);
				//JOptionPane.showMessageDialog(null, "You chose button 5!", "Button 5", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b6) {
				number += b6.getText();
				text.setText(number);
				//JOptionPane.showMessageDialog(null, "You chose button 6!", "Button 6", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b7) {
				text.setText("");
				text.setText("I love you :)");
			}
			
			if(source == b8) {
				text.setText("");
				text.setText("Oh hey you!");
			}
			
			if(source == b9) {
				text.setText("");
				text.setText("Have a great day!");
			}
			
			
		}
		
	}
	
}
