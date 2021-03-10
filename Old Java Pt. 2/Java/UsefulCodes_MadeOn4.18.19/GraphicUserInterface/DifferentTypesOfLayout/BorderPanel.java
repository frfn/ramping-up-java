package DifferentTypesOfLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BorderPanel extends JPanel{

	/**
	 * This is the border layout constructor!
	 * Will be utilizing BORDER LAYOUTS
	 * 
	 * ////////////////NORTH//////////////////
	 * |||||-----------------------------|||||  Key: --- Center space
	 * |||||-----------------------------|||||       ||| West or east space
	 * West ----------Center-------------East        /// North or south space
	 * |||||-----------------------------|||||
	 * |||||-----------------------------|||||
	 * ////////////////SOUTH//////////////////
	 * 
	 * 
	 * 
	 * 
	 */
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	
	/**
	 * JButtons are initialized!
	 */
	
	public BorderPanel() {
		
		setLayout(new BorderLayout()); //this panel will have border layout! BY DEFAULT it is FLOWLAYOUT.
		
		setBackground(Color.DARK_GRAY);
		
		b1 = new JButton("BUTTON 1");
		b1.addActionListener(new ButtonPush());
		
		b2 = new JButton("BUTTON 2");
		b2.addActionListener(new ButtonPush());
		
		b3 = new JButton("BUTTON 3");
		b3.addActionListener(new ButtonPush());
		
		b4 = new JButton("BUTTON 4");
		b4.addActionListener(new ButtonPush());
		b4.setPreferredSize(new Dimension(100, 90));
		
		b5 = new JButton("BUTTON 5");
		b5.addActionListener(new ButtonPush());
		
		b6 = new JButton("BUTTON 6");
		b6.addActionListener(new ButtonPush());
		b6.setPreferredSize(new Dimension(100, 90));
		
		
		/*
		 * Experiment:
		 * To have to buttons on the panel, you will have to create another panel to put in
		 * the region!
		 */
		JPanel panelForB4andB6 = new JPanel();
		panelForB4andB6.setLayout(new BorderLayout());
		panelForB4andB6.add(b4, BorderLayout.NORTH);
		panelForB4andB6.add(b6, BorderLayout.SOUTH);
		
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.WEST);
		add(b3, BorderLayout.CENTER);
		add(panelForB4andB6, BorderLayout.EAST);
		//created a panel so I can have TWO BUTTONS on EAST side of BorderLayout!
		add(b5, BorderLayout.SOUTH);
	
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
			
			if(source == b6) {
				JOptionPane.showMessageDialog(null, "You chose button 6!", "Button 6", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
