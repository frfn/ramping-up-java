package checkbox;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Check this out! I seen this during my find – extends JPanel implements ItemListener
 * 
 * This Panel will also has a listener, so using "this" panel as an ItemListener, WORKS!
 * 
 * This is an experiment, including the SpringLayout layout, the vertical scroll, and extends...implements
 * 
 * 
 * 
 * 1.) My comment will go line by line!
 */

public class ThingsToLearn extends JPanel implements ItemListener {
	/*
	 * These were not all here at first,
	 * they were put in after or thinking of what is needed
	 */
	//Global Variables/Components/Fields
	private JLabel label;
	private JCheckBox html;
	private JCheckBox css;
	private JCheckBox js;
	private JCheckBox java;
	
	//SpringLayout layout
	SpringLayout layout = new SpringLayout();
	
	public ThingsToLearn() {
		
		
		//I think these should be initialized first
		setPreferredSize(new Dimension(400, 600));
		setBackground(Color.DARK_GRAY);
		
		//setting the panel's layout
		setLayout(layout);
		
		
		//LABELS positioning and fonts
		label = new JLabel("Please select languages you would want to learn...");
		label.setFont(new Font("Helvetica", Font.PLAIN, 12));
		label.setForeground(Color.white);
		layout.putConstraint(SpringLayout.NORTH, label, 40, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		//positioning and color of the text of HTML
		html = new JCheckBox("HTML");
		html.setForeground(Color.white);
		layout.putConstraint(SpringLayout.NORTH, html, 35, SpringLayout.NORTH, label);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		//positioning and color of the text of CSS
		css = new JCheckBox("CSS");
		css.setForeground(Color.white);
		layout.putConstraint(SpringLayout.NORTH, css, 35, SpringLayout.NORTH, html);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		//positioning and color of the text of JS
		js = new JCheckBox("JavaScript");
		js.setForeground(Color.white);
		layout.putConstraint(SpringLayout.NORTH, js, 35, SpringLayout.NORTH, css);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		//positioning and color of the text of Java
		java = new JCheckBox("Java");
		java.setForeground(Color.white);
		layout.putConstraint(SpringLayout.NORTH, java, 35, SpringLayout.NORTH, js);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		//THIS IS NEW
		/*
		 * Using "this" as the listener since the panel implements ItemListener! That is sick!
		 * So cool. Fuuuck! Hahaha :D
		 */
		html.addItemListener(this);
		css.addItemListener(this);
		js.addItemListener(this);
		java.addItemListener(this);
		
		//Add these muffuckers up in this muffuckin panel
		add(label);
		add(html);
		add(css);
		add(js);
		add(java);
		
		
	}
	//SHIT i left @override there
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 * 
	 * @Override just means that I had **implemented method thats needed,
	 * so ... public void itemStateChanged(ItemEvent e) { ... } was created
	 * 
	 * then that's it! It is part of the class, and no need to create and instantiate the object!
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		label.setText("Please select languages you would want to learn...");
		
		if(html.isSelected()) {
			label.setText("You will learn HTML.");	
		}
		
		if(css.isSelected()) {
			label.setText("You will learn CSS.");
		}

		if(js.isSelected()) {
			label.setText("You will learn JavaScript.");
		}

		if(java.isSelected()) {
			label.setText("You will learn Java.");
		}
		
		/*
		 * I WILL NOT make the other cases.
		 * But it is similar to the ones below.
		 */
		if(html.isSelected() && css.isSelected()) {
			label.setText("You will learn HTML + CSS.");
		}

		if(html.isSelected() && css.isSelected() && js.isSelected()) {
			label.setText("You will learn HTML + CSS + JavaScript.");
		}

		if(html.isSelected() && css.isSelected() && js.isSelected() && java.isSelected()) {
			label.setText("You will learn HTML + CSS + JavaScript + Java.");
		}
		
	}
	
}
