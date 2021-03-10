package chapter4TempConverterGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempPanel extends JPanel {
	
	private JLabel inputLabel, outputLabel, resultLabel;
	private JTextField fahrenheit;
	private JButton pushButton;
	
	public TempPanel() {
		
		inputLabel = new JLabel("Fahrenheit to be converted: ");
		
		outputLabel = new JLabel ("Converted temperature: ");
		
		resultLabel = new JLabel ("---");
		
		pushButton = new JButton ("Submit");
		
		
		fahrenheit = new JTextField(5);
		//fahrenheit.addActionListener(new TempListener());
		
		pushButton.addActionListener(new TempListener());
		
		add (inputLabel);
		add (fahrenheit);
		add (outputLabel);
		add (resultLabel);
		add (pushButton);
		
		
		setPreferredSize(new Dimension (400, 70));
		
	
	}
	
	private class TempListener implements ActionListener  {
		
		public void actionPerformed(ActionEvent event) {
			
			double fahrenheitTemp, celsiusTemp;
			
			String userInput = fahrenheit.getText();
			
			fahrenheitTemp = Double.parseDouble(userInput);
			
			celsiusTemp = (fahrenheitTemp-32) * 5/9;
			
			resultLabel.setText(Double.toString(celsiusTemp));
			
			
		}

	}

}
