package DifferentTypesOfLayout;

import javax.swing.*;
import java.awt.*;

public class LayoutManagers {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Layout Manager");
		
		/**
		 * Tabbed Pane
		 * 	- Displays buttons on header, will show different panels.
		 *  - Similar to CardLayout, but card CardLayout, you cannot choose to go back.
		 */
		
		JTabbedPane tp = new JTabbedPane();
		tp.add("Intro", new IntroPanel());
		tp.add("Flow", new FlowPanel());
		tp.add("Border", new BorderPanel());
		tp.add("Grid", new GridPanel());
		tp.add("Box", new BoxPanel());
		
		/**
		 * - 1. Close operation
		 * - 2. Adding to content pane
		 * - 3. Setting size
		 * - 4. where the location of the window will appear
		 * - 5. enables to see window
		 */
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(tp);
		window.setSize(500, 300);;
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
