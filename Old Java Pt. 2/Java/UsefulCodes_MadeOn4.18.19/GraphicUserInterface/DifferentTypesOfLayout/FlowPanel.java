package DifferentTypesOfLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FlowPanel extends JPanel{
	
	/**
	 * FlowLayout is the default layout of GUI's
	 * 	- Components change accordingly to size of window
	 *  - Adds component by order of user
	 */
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	
	public FlowPanel() {
		
		Dimension size = new Dimension(150, 60);
		
		//setLayout(new FlowLayout());
		
		setBackground(Color.DARK_GRAY);
		
		b1 = new JButton("BUTTON 1"); b1.setPreferredSize(size); b1.addActionListener(new ButtonPush());
		
		b2 = new JButton("BUTTON 2"); b2.setPreferredSize(size); b2.addActionListener(new ButtonPush());
		
		b3 = new JButton("BUTTON 3"); b3.setPreferredSize(size); b3.addActionListener(new ButtonPush());
		
		b4 = new JButton("BUTTON 4"); b4.setPreferredSize(size); b4.addActionListener(new ButtonPush());
		
		b5 = new JButton("BUTTON 5"); b5.setPreferredSize(size); b5.addActionListener(new ButtonPush());
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		
	}  
	
	private class ButtonPush implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//reference testingsForMeToDo/Chapter4PushButton
			Object source = e.getSource();
			
			if(source == b1) {
				JOptionPane.showMessageDialog(null, "You chose button 1!", "Button 1", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b2) {
				JOptionPane.showMessageDialog(null, "You chose button 2!", "Button 2", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b3) {
				JOptionPane.showMessageDialog(null, "You chose button 3!", "Button 3", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b4) {
				JOptionPane.showMessageDialog(null, "You chose button 4!", "Button 4", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(source == b5) {
				JOptionPane.showMessageDialog(null, "You chose button 5!", "Button 5", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		
	}

}
