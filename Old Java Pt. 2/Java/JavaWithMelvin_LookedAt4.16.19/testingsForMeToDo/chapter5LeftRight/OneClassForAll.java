package chapter5LeftRight;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OneClassForAll {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Left or Right?");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setPreferredSize(new Dimension(245, 70));
		
		JLabel promptLabel = new JLabel("Please click left or right...");
		promptLabel.setForeground(Color.white);
		
		JButton leftLabel = new JButton("Left");
		leftLabel.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent left) {
				
				promptLabel.setText("Left");
				
			}
		});
		
		JButton rightLabel = new JButton("Right");
		
		rightLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent right) {
				
				promptLabel.setText("Right");
				
			}
		});
		
		panel.add(promptLabel);
		panel.add(leftLabel);
		panel.add(rightLabel);
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}

}
