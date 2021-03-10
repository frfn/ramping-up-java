package guiMnemonics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Panel extends JPanel{
	
	JButton btn1 = new JButton("Button 1");
	JButton btn2 = new JButton("Button 2");
	JButton btn3 = new JButton("Button 3");


	public Panel() {
		
		this.setBackground(Color.DARK_GRAY);
		
		/**
		 * All buttons are clickable until clicked on
		 */
		
		/**
		 * Button 1
		 *  - Mnemonic to 'b'
		 */
		btn1.setMnemonic('b');
		btn1.setToolTipText("This is button 1!");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn1.setEnabled(false);
				JOptionPane.showMessageDialog(null, "You have chose Button 1",
												"Button 1", JOptionPane.PLAIN_MESSAGE);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				
			}
		});
		
		/**
		 * Button 2 
		 * - Mnemonic to 'u'
		 */
		btn2.setMnemonic('u');
		btn2.setToolTipText("This is button 2!");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn2.setEnabled(false);
				JOptionPane.showMessageDialog(null, "You have chose Button 2",
												"Button 2", JOptionPane.PLAIN_MESSAGE);
				btn1.setEnabled(true);
				btn3.setEnabled(true);
				
			}
		});
		
		/**
		 * Button 3
		 * - Mnemonic to 't'
		 */
		btn3.setMnemonic('t');
		btn3.setToolTipText("This is button 3!");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btn3.setEnabled(false);
				JOptionPane.showMessageDialog(null, "You have chose Button 3",
												"Button 3", JOptionPane.PLAIN_MESSAGE);
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				
			}
		});
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		
		
		
	}
	
	
}
