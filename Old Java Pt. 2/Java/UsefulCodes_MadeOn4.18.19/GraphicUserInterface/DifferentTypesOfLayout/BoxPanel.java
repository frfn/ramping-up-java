package DifferentTypesOfLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author flexer
 *
 * In this class, we will be utilizing the Box Layout
 * Box layout can only be either
 * 
 * VERTICAL or HORIZONTAL ~ so this is the easy layout! 
 * also a very strong one.
 * 
 * 
 *
 */
public class BoxPanel extends JPanel{
	
	JButton button = new JButton("Button 1");
	JButton button2 = new JButton("Button 2");
	JButton button3 = new JButton("Button 3");
	JButton button4 = new JButton("Button 4");
	JButton button5 = new JButton("Button 5");
	
	BoxPanel(){
		
		setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
		
		setBackground(Color.DARK_GRAY);
		
		button.addActionListener(new ButtonPush());
		add(button);
		
		add(Box.createRigidArea(new Dimension(0, 10)));
		
		//Rigid area is fixed
		//0, is width | 10, is height
		
		button2.addActionListener(new ButtonPush());
		add(button2);
		
		add(Box.createVerticalGlue());
		
		//Glue moves with the size of window
		
		button3.addActionListener(new ButtonPush());
		add(button3);
		
		
		button4.addActionListener(new ButtonPush());
		add(button4);
		
		add(Box.createRigidArea(new Dimension(0, 30)));
		
		
		button5.addActionListener(new ButtonPush());
		add(button5);
		
	}
	
	private class ButtonPush implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Object obj = e.getSource();
			
			if(obj == button) {
				JOptionPane.showMessageDialog(null, "You chose button 1...", "Button 1", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(obj == button2) {
				JOptionPane.showMessageDialog(null, "You chose button 2...", "Button 2", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(obj == button3) {
				JOptionPane.showMessageDialog(null, "You chose button 3...", "Button 3", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(obj == button4) {
				JOptionPane.showMessageDialog(null, "You chose button 4...", "Button 4", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(obj == button5) {
				JOptionPane.showMessageDialog(null, "You chose button 5...", "Button 5", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}

}
