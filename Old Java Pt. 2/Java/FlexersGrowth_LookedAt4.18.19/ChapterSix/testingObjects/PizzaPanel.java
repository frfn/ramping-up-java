package testingObjects;
import javax.swing.*;


/*
 * EDIT:
 * 
 * I do not know how to use check boxes fully.
 * Please research and watch videos on how to create a menu with checkboxes.
 * Thank you.
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class PizzaPanel extends JPanel implements ActionListener, ItemListener {

	JButton submit = new JButton("Submit");
	
	String[] sauceArray = {"Tomato", "Cheese"};
	JComboBox sauce = new JComboBox(sauceArray);
	
	String[] crustArray = {"Cheese", "Garlic"};
	JComboBox crust = new JComboBox(crustArray);
	
	JCheckBox pepperoni = new JCheckBox("Pepperoni");
	JCheckBox sausage = new JCheckBox("Sausage");
	ArrayList<String> topping = new ArrayList<String>();
	
	public PizzaPanel() {
		
		submit.addActionListener(this);
		
		pepperoni.addActionListener(this);
		sausage.addActionListener(this);
		
		sauce.setEditable(false);
		crust.setEditable(false);
		
		this.add(sauce);
		this.add(crust);
		this.add(pepperoni);
		this.add(sausage);
		this.add(submit);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		
		if(pepperoni.isSelected()) {
			topping.add(pepperoni.getText());
		}
		else {
			topping.remove(pepperoni.getText());
		}
		
		
		if(sausage.isSelected()) {
			topping.add(sausage.getText());
		}
		else {
			topping.remove(sausage.getText());
		}
		
		int intSauce = sauce.getSelectedIndex();
		String sauce = sauceArray[intSauce];
		
		int intCrust = crust.getSelectedIndex();
		String crust = crustArray[intCrust];
		
		Pizza pizza = new Pizza(sauce, crust, topping);
		
		System.out.println(pizza);
		
		
	}
	
}
