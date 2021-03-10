package PizzaGUIChapter6forFunSCRAPPED;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PizzaPanel extends JPanel implements ItemListener, ActionListener {

	/**
	 * Two JButtons:
	 *  - Reset
	 *  - Submit
	 */
	JButton reset, submit;

	/**
	 * 6 JCheckBoxes:
	 *  - Pepperoni
	 *  - Sausage
	 *  - Bacon
	 *  - Chicken
	 *  - Ham
	 *  - Pulled Pork
	 */
	JCheckBox topping1 = new JCheckBox("Pepperoni");
	JCheckBox topping2 = new JCheckBox("Sausage");
	JCheckBox topping3 = new JCheckBox("Bacon");
	JCheckBox topping4 = new JCheckBox("Chicken");
	JCheckBox topping5 = new JCheckBox("Ham");
	JCheckBox topping6 = new JCheckBox("Pulled Pork");
	
	/** 
	 * 3 Sauces:
	 *  - Tomato
	 *  - White
	 *  - Cheese
	 */
	String sauceDown[] = {"Tomato Sauce", "White Sauce", "Cheese Sauce"};
	JComboBox sauces = new JComboBox(sauceDown);
	
	/** 
	 * 3 Sizes:
	 *  - Small
	 *  - Medium
	 *  - Large
	 */
	String sizeDown[] = {"Small", "Medium", "Large"};
	JComboBox sizes = new JComboBox(sizeDown);
				
	/** 
	 * 3 Crusts:
	 *  - Normal
	 *  - Garlic
	 *  - Cheese
	 */
	String crustDown[] = {"Normal", "Garlic", "Cheese"};
	JComboBox crust = new JComboBox(crustDown);
	
	
	/**
	 * Pizza Panel:
	 * ----------------
	 * The creation of the panel
	 */
			
	PizzaPanel(){
		
		/**
		 * Border Layout 
		 *  
		 *  /////N//////
		 *  ||--------||
		 *   W---C----E
		 *  ||--------||
		 *  /////S/////
		 */
		
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);
		
		/////////////////////////
			//   Toppings  //
		/////////////////////////
		
		JPanel center = new JPanel();
		center.setBorder(BorderFactory.createTitledBorder("Toppings"));
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(topping1);
		center.add(topping2);
		center.add(topping3);
		center.add(topping4);
		center.add(topping5);
		center.add(topping6);
		
		/////////////////////////
			//   Sauces  //
		/////////////////////////
		
		JPanel east = new JPanel();
		east.setBorder(BorderFactory.createTitledBorder("Sauces"));
		JLabel sauceLabel = new JLabel("Choose sauce: ");
		sauceLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		/**
		 * The Alignment is all fucked up here initially.
		 * By doing the setAlignmentX, it will center the JLabel
		 */
		
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		sauces.setEditable(false);
		east.add(sauceLabel);
		east.add(sauces);
		//Formatting
		east.add(Box.createRigidArea(new Dimension(0, 90)));
		
		/**
		 * Formatting pushes the drop down up next to the label
		 */
		
		///////////////////////////////
			//   Size and Crust  //
		///////////////////////////////
		
		JPanel west = new JPanel();
		west.setBorder(BorderFactory.createTitledBorder("Sizes"));
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		JLabel label = new JLabel("Choose Size: ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel label2 = new JLabel("Choose Crust: ");
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		crust.setEditable(false);
		sizes.setEditable(false);
		west.add(label);
		west.add(sizes);
		west.add(Box.createRigidArea(new Dimension(0, 32)));
		west.add(label2);
		west.add(crust);	
		
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
		add(center, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);		
	}
	
	/**
	 * ActionListeners and ItemListeners
	 *  - Implement the actions
	 */

	String toppings[] = new String[6];
	int toppingCount = 0;
	
	@Override
	public void itemStateChanged(ItemEvent e) {
	
		if(topping1.isSelected()) {
			toppings[toppingCount] += topping1.getText();
			toppingCount++;
		}
		
		if(topping2.isSelected()) {
			toppings[toppingCount] += topping2.getText();
			toppingCount++;
		}
		
	}
	
	FoodCollection pizzaCollection = new FoodCollection();
	
	Pizza[] pizza = new Pizza[5];
	int pizzaCount = 0;
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(submit == e.getSource()) {
			
			int intSize = sizes.getSelectedIndex();
			String sizeSelected = sizeDown[intSize];
			
			int intSauce = sauces.getSelectedIndex();
			String sauceSelected = sauceDown[intSauce];
			
			int intCrust = crust.getSelectedIndex();
			String crustSelected = crustDown[intCrust];
			
			pizza[pizzaCount] = new Pizza(sizeSelected, sauceSelected, crustSelected, toppings);
			
			pizzaCount++;
			
			//pizzaCollection.addPizza(pizza[pizzaCount]);
			
			sauces.setSelectedIndex(0);
			crust.setSelectedIndex(0);
			sizes.setSelectedIndex(0);
			
			topping1.setSelected(false);
			topping2.setSelected(false);
			topping3.setSelected(false);
			topping4.setSelected(false);
			topping5.setSelected(false);
			topping6.setSelected(false);
			
		}
		
		if(reset == e.getSource()) {
			
		for(int i=0; i<pizzaCount; i++) {
			System.out.println(pizza[i]);
		}
			
			sauces.setSelectedIndex(0);
			crust.setSelectedIndex(0);
			sizes.setSelectedIndex(0);
			
			topping1.setSelected(false);
			topping2.setSelected(false);
			topping3.setSelected(false);
			topping4.setSelected(false);
			topping5.setSelected(false);
			topping6.setSelected(false);
			
		}
	
		
	}
	
	//NOTES FOR LISTENER
	
	/*
	if(topping1.isSelected()) {
		toppingArray[count] += topping1.getText();
		count++;
	}
	
	if(topping2.isSelected()) {
		toppingArray[count] += topping2.getText();
		count++;
	}
	 */	
	
	/**
	 * Code below is accurate!!
	 */
	
	/*
	if(submit == e.getSource()) {
		
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
	
	*/

}
