package chapter5LeftRight;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LeftRightPanel extends JPanel {
	
	private JButton labelLeft = new JButton("Left");
	private JButton labelRight = new JButton("Right");
	private JLabel prompt = new JLabel("Please press a button...");
	
			
	
	public LeftRightPanel() {
		
		prompt.setForeground(Color.white);
		
		//setting the color and size of the panel
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(245, 80));
		
		//buttonListner, it is an ActionListener!
		ButtonListener listener = new ButtonListener();
		labelLeft.addActionListener(listener);
		labelRight.addActionListener(listener);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.cyan);
		buttonPanel.setPreferredSize(new Dimension(245, 50));
		buttonPanel.add(labelLeft);
		buttonPanel.add(labelRight);
		
		add(prompt);
		add(buttonPanel);
		
		
		
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == labelLeft) {
				prompt.setText("Left");
			}else {
				prompt.setText("Right");
			}
			
		}
	
	}
	

}
