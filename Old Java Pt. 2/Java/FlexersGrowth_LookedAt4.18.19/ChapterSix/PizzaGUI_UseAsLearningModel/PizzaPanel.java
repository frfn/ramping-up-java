package PizzaGUI_UseAsLearningModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
public class PizzaPanel extends JPanel implements ItemListener, ActionListener {
	
	//PizzaCollection
	PizzaCollection pizza = new PizzaCollection();
	
	//topping array placeholder
	String[] toppingArray = new String[6];
	int count = 0;

	//JButtons
	JButton reset, submit;

	// 6 Toppings
	JCheckBox topping1 = new JCheckBox("Pepperoni");
	JCheckBox topping2 = new JCheckBox("Sausage");
	JCheckBox topping3 = new JCheckBox("Bacon");
	JCheckBox topping4 = new JCheckBox("Chicken");
	JCheckBox topping5 = new JCheckBox("Ham");
	JCheckBox topping6 = new JCheckBox("Pulled Pork");
	
	// 3 Sauces
	String sauceDown[] = {"Tomato Sauce", "White Sauce", "Cheese Sauce"};
	JComboBox sauces = new JComboBox(sauceDown);
	
	// 3 Sizes
	String sizeDown[] = {"Small", "Medium", "Large"};
	JComboBox sizes = new JComboBox(sizeDown);
				
	// 3 Crust
	String crustDown[] = {"Normal", "Garlic", "Cheese"};
	JComboBox crust = new JComboBox(crustDown);
			
	PizzaPanel(){
		
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);
		
		/////////////////////////
			//   Toppings  //
		/////////////////////////
		
		JPanel topping = new JPanel();
		topping.setBorder(BorderFactory.createTitledBorder("Toppings"));
		topping.setLayout(new BoxLayout(topping, BoxLayout.Y_AXIS));
		topping.add(topping1);
		topping.add(topping2);
		topping.add(topping3);
		topping.add(topping4);
		topping.add(topping5);
		topping.add(topping6);
		
		/////////////////////////
			//   Sauces  //
		/////////////////////////
		
		JPanel sauce = new JPanel();
		sauce.setBorder(BorderFactory.createTitledBorder("Sauces"));
		JLabel sauceLabel = new JLabel("Choose sauce: ");
		sauceLabel.setAlignmentX(CENTER_ALIGNMENT);
		sauce.setLayout(new BoxLayout(sauce, BoxLayout.Y_AXIS));
		sauces.setEditable(false);
		sauce.add(sauceLabel);
		sauce.add(sauces);
		//Formatting
		sauce.add(Box.createRigidArea(new Dimension(0, 90)));
		
		///////////////////////////////
			//   Size and Crust  //
		///////////////////////////////
		
		JPanel size = new JPanel();
		size.setBorder(BorderFactory.createTitledBorder("Sizes"));
		size.setLayout(new BoxLayout(size, BoxLayout.Y_AXIS));
		JLabel label = new JLabel("Choose Size: ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel label2 = new JLabel("Choose Crust: ");
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		crust.setEditable(false);
		sizes.setEditable(false);
		size.add(label);
		size.add(sizes);
		size.add(Box.createRigidArea(new Dimension(0, 32)));
		size.add(label2);
		size.add(crust);	
		
		/////////////////////////////
			//   North Labels  //
		/////////////////////////////
	
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		JLabel l1 = new JLabel("Please Select Pizza Options Below");
		l1.setAlignmentX(CENTER_ALIGNMENT);
		JLabel l2 = new JLabel("Press Submit When Done");
		l2.setAlignmentX(CENTER_ALIGNMENT);
		north.add(Box.createRigidArea(new Dimension(0, 20)));
		north.add(l1);
		north.add(l2);
		north.add(Box.createRigidArea(new Dimension(0, 20)));
		
		/////////////////////////////
			//   South Buttons //
		/////////////////////////////
		
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(0, 50));
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		reset = new JButton("Reset");
		submit = new JButton("Submit");
		south.add(Box.createRigidArea(new Dimension(100, 0)));
		south.add(reset);
		south.add(submit);
		
		////////////////////////////////
			//   Button Function  //
		////////////////////////////////
		
		reset.addActionListener(this);
		submit.addActionListener(this);
		
		////////////////////////////////
			//   Item Function  //
		////////////////////////////////
		
		topping1.addItemListener(this);
		topping2.addItemListener(this);
		topping3.addItemListener(this);
		topping4.addItemListener(this);
		topping5.addItemListener(this);
		topping6.addItemListener(this);
		
		///////////////////////////////////////////
		//  Adding created panels to MAIN PANEL  //
		///////////////////////////////////////////
		
		add(north, BorderLayout.NORTH);
		add(topping, BorderLayout.CENTER);
		add(sauce, BorderLayout.EAST);
		add(size, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	
		if(topping1.isSelected()) {
			toppingArray[count] += topping1.getText();
			count++;
		}
		
		if(topping2.isSelected()) {
			toppingArray[count] += topping2.getText();
			count++;
		}
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(submit == e.getSource()) {
			
			/**
			 * Code below is accurate!!
			 */
			
			int intSize = sizes.getSelectedIndex();
			String size = sizeDown[intSize];
			
			int intSauce = sauces.getSelectedIndex();
			String sauce = sauceDown[intSauce];
			
			int intCrust = crust.getSelectedIndex();
			String crust = crustDown[intCrust];
			
			pizza.addPizza(size, sauce, crust, toppingArray);
			
		}
		
		if(reset == e.getSource()) {
			System.out.println(pizza);
			System.out.println();
			pizza.printSpecificPizza(4);
		}
		
		
	}
	
	
	
}
