/**
 * 
 */
package DifferentTypesOfLayout;
import javax.swing.*;

import java.awt.Color;
import java.util.*;
/**
 * @author flexer
 *
 */
public class IntroPanel extends JPanel {
	
	public IntroPanel() {
		
		setBackground(Color.DARK_GRAY);
		
		JLabel l1 = new JLabel("Layout Manager Demonstration");
		l1.setForeground(Color.white);
		JLabel l2 = new JLabel("Choose a tab to see the difference in layouts.");
		l2.setForeground(Color.white);
		JLabel l3 = new JLabel("Default: Flow Layout – Not Shown: Card Layout.");
		l3.setForeground(Color.white);
		JLabel l4 = new JLabel("Card Layout: similar to Tabbed Pane but user programs it accordingly");
		l4.setForeground(Color.white);
		//card layout is used so that lets say I do not want a tabbed pane
		//i just want it to go to next page, do card layout.
		
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
	}

}




