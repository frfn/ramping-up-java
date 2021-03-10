package chapter3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

/*
 * Things to research:
 * 
 * Different types of Listeners (right now, MouseListeners, FocusListeners, ActionListener)
 * Different types of Layouts (SpringLayout and other layouts)
 */

/*
 * – There are things that I want happen –
 *  ... This will be done in one file, no other class panels. ...
 *  
 *  1. I want to use an image
 *  2. I want to use the Spring Layout
 *  3. Nested Panels – what happens when I have spring layout on?
 *  4. Messing with Label parameters
 *  5. Adding a scroll bar
 * 
 * Formula:
 * a = P(1 + r/n) ^ nt
 * 
 * After fully understanding the formula, it made perfect sense
 * 
 * n = compound nth times /compound per month, quarterly, whatever
 * t = time
 * p = principal
 * r = rate
 * a = accrued value
 * 
 * principal = userInput – the amount of money
 * 
 * 
 * 
 */

public class ThreePoint5HavingFunWithGUI {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Projected Compound Interest"); //here we created a window!
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//when we close the application, it will terminate
		
		/*
		 * Panel size will form the size of the window UNLESS you do ———— window.size(new Dimension(0,0)); and not .pack!
		 */
		
		/*
		 * Focus of today:
		 * SpringLayout is a layout that will be talked about
		 * in the later chapter.
		 * 
		 * I will play around with it now.
		 * 
		 */
		SpringLayout layout = new SpringLayout(); 
		//creating new SpringLayout object to use on the JPanel
		
		//PANEL
		
		JPanel addOnMe = new JPanel();
		addOnMe.setLayout(layout); //giving our panel a nice layout manager
		addOnMe.setBackground(Color.WHITE); //white mode! :D
		addOnMe.setPreferredSize(new Dimension(450, 1200)); //size of panel!
		
		//DECLARED JLABELS
		
		JLabel label1, label2, pictureLabel, pictureLabel2;
		
		//LABELS ARE INITIALIZED
		
		label1 = new JLabel("Enter Initial Prinicipal: "); 
		
		label1.setFont(new Font("Helvetica", Font.PLAIN, 12)); //this is how you set a font!
		//font name, font style, font size
		
		label1.setForeground(Color.BLACK); //the color of the the text
		
		label2 = new JLabel("Enter estimated years: ");
		label2.setFont(new Font("Helvetica", Font.PLAIN, 12));
		label2.setForeground(Color.BLACK);
		
		/*
		 * In good practice, visualizing what it will look like is recommended
		 */
		
		//PICTURES ARE IN LABEL
		
		/*
		 * I had a problem here because my "file" was not really a JPG file.
		 * Double check your files!
		 * 
		 * The path name is the properly written, if it does NOT show up,
		 * it may be a file issue
		 */
		
		ImageIcon picture = new ImageIcon("bank.jpg"); //I had to drag it into eclipse into the actual folder
		pictureLabel = new JLabel(picture); //JLabel is a way to produce pictures on the panel
		//the parameter is picture, to one line this
		
		//pictureLabel = new JLabel(new ImageIcon("bank.jpg"));
		
		/*
		 * Note that the arguments in the parameter in JLabel can be three
		 * 
		 * ( A String, followed by the picture, followed by the alignment of the text )
		 * 
		 * Do not be confused, the third cannot be changed and will be .CENTER,
		 * it is NOT the alignment of the WHERE the text is, I believe it is
		 * where the text is produced.
		 * 
		 * .setVerticalTextPosition and .setHorizontalTextPosition is WHERE the text will
		 * be outputted
		 * 
		 */
		
		
		ImageIcon picture2 = new ImageIcon("/Users/flexer/Downloads/HimawariHD.png");
		pictureLabel2 = new JLabel("Secret Himawari found!", picture2, SwingConstants.CENTER);
		pictureLabel2.setVerticalTextPosition(SwingConstants.BOTTOM);
		pictureLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//TEXTBOX ARE NOW MADE – initialized
		JTextField textbox1, textbox2;
		
		textbox1 = new JTextField(); //initialized text field
		
		textbox1.setColumns(10); //this is the size and length of the text box
		
		/*
		 * I commented code out below, it was for testing to see if it would go inside the text box
		 * which it does!
		 * 
		 * UPDATE: SOOOO... I had to uncomment, these are needed to show! ~ because by default it highlights first textfield, 
		 * 					and YOU the user does not see it, but programming, it is NEEDED.
		 */
		
		textbox1.setText("Enter here..."); //testing this out, no idea
		/*
		 * UPDATE: so this is cool!, inside the textbox, there will be a preset
		 * 		   text!
		 */
		textbox1.setForeground(Color.gray);
		
		
		//Methods in which the text will disappear and reappear, I MADE IT. :'D
		/*
		 * This is pretty cool, I never knew how these work, 
		 * two listeners I found useful were the
		 * 
		 * ~MOUSE LISTENER~
		 * and the
		 * ~FOCUS LISTENER~
		 */
		
		//Research into different listeners! — noted above.
		
		/*
		 * MOUSE LISTENER
		 */
		
		/*
		textbox1.addMouseListener((MouseListener) new MouseAdapter(){
           // @Override
            public void mouseClicked(MouseEvent e){
                textbox1.setText("");
            }
        });
        *
        *Here it looks like once the mouse is clicked
        *it will do the following inside the function,
        *but it will not reappear, maybe possible to
        *program something if I click out
        *
        *in this case, focus listener is a better listener, considering it does
        *what I want.
		*/
		
		/*
		 * FOCUS LISTENER
		 */
		
		/*
		 * BETTER suited for my needs
		 * 
		 * for a focus listener
		 * you WILL NEED to implement 
		 * focusGained and focusLost
		 */
		textbox1.addFocusListener((FocusListener) new FocusListener(){
	        //@Override
	        public void focusGained(FocusEvent e){
	        	
	            textbox1.setText("");
	            textbox1.setForeground(Color.black);
	            
	        }

			//@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textbox1.getText().isEmpty()) {
				textbox1.setText("Enter here...");
				textbox1.setForeground(Color.GRAY);
				}
			}
	    });
		
		textbox2 = new JTextField();
		textbox2.setColumns(10);
		textbox2.setText("Enter here...");
		textbox2.setForeground(Color.gray);
		//I had no idea if the "foreground" actually works, but it does!
		
		/*
		 * These are needed, the text inside so you can
		 * The listeners produce the wanted effects after
		 */
		
		textbox2.addFocusListener((FocusListener) new FocusListener(){
	        //@Override
	        public void focusGained(FocusEvent e){
	        	
	            textbox2.setText("");
	            textbox2.setForeground(Color.black);
	            
	        }

			//@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textbox2.getText().isEmpty()) {
				textbox2.setText("Enter here...");
				textbox2.setForeground(Color.GRAY);
				}
			}
	    });
		
		//SUBMIT BUTTON is declared and made!
		
		JButton submit;
		
		submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension (200, 40));
		
		
		//Putting constraints on the panel!
		
		//applying constraint on label1
		layout.putConstraint(SpringLayout.NORTH, label1, 140, SpringLayout.NORTH, addOnMe);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label1, -70, SpringLayout.HORIZONTAL_CENTER, addOnMe);
		
		
		/**
		  Parameters:
			e1 the edge of the dependent - the edge of the object you're placing
			c1 the component of the dependent - the object you're placing
			pad the fixed distance between dependent and anchor - padding between object and panel/object
			e2 the edge of the anchor - the edge of the panel
			c2 the component of the anchor - the panel you're placing th4e object on
		 */
		
		//applying constraint on textbox1
		layout.putConstraint(SpringLayout.NORTH, textbox1, 135, SpringLayout.NORTH, addOnMe);
		layout.putConstraint(SpringLayout.WEST, textbox1, 5, SpringLayout.EAST, label1);
		
		//applying constraint on label2
		layout.putConstraint(SpringLayout.NORTH, label2, 25, SpringLayout.SOUTH, label1);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label2, -72, SpringLayout.HORIZONTAL_CENTER, addOnMe);
		
		//applying constraint on textbox2
		layout.putConstraint(SpringLayout.NORTH, textbox2, -7, SpringLayout.NORTH, label2);
		layout.putConstraint(SpringLayout.WEST, textbox2, 5, SpringLayout.EAST, label2);
		
		//applying constraint on submit button
		layout.putConstraint(SpringLayout.NORTH, submit, 25, SpringLayout.SOUTH, label2);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, submit, 0, SpringLayout.HORIZONTAL_CENTER, addOnMe);
		
		//applying constraint on picture
		layout.putConstraint(SpringLayout.NORTH, pictureLabel, 10, SpringLayout.NORTH, addOnMe);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, pictureLabel, 0, SpringLayout.HORIZONTAL_CENTER, addOnMe);
		
		//applying constraint on picture2
		layout.putConstraint(SpringLayout.NORTH, pictureLabel2, 800, SpringLayout.NORTH, addOnMe);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, pictureLabel2, 0, SpringLayout.HORIZONTAL_CENTER, addOnMe);
		
		
		//adding components to panel
		addOnMe.add(pictureLabel);
		addOnMe.add(pictureLabel2);
		addOnMe.add(label1);
		addOnMe.add(textbox1);
		addOnMe.add(label2);
		addOnMe.add(textbox2);
		addOnMe.add(submit);
		
		/**
		 * ERROR.
		 * I can not get the input validation to work,
		 * when pressing enter with no values in the field
		 * it is suppose to pop up with the information message
		 * "Enter values"
		 */
		
		submit.addActionListener((ActionListener) new ActionListener() {    // add functionality to new user button
			//looks like (ActionListener) can be removed!
			public void actionPerformed(ActionEvent e) { 
	        	 
				
				
	        	 /*
	        	  * ActionListener, I know what it does but, 
	        	  * what is it really.
	        	  * 
	        	  * Add on to the research of the different type of listeners
	        	  */
	         
	            /*    
	        	 Formula:
	        		 * a = P(1 + r/n) ^ nt
	        		 * 
	        		 * n = compound nth times
	        		 * t = time
	        		 * p = principal
	        		 * r = rate
	        		 * a = accured value
	             */
	        	 
	        	 double a = 0, r = 0, n = 0, P = 0, t = 0;
	        	 
	        	 
	        	 String strP, strT; //delcared some strings so I can use them to get the value of the text box
	        	 
	        	 String invalid = "Enter Here...";
	        	 if(textbox1.getText().equals(invalid)) {
	        		 JOptionPane.showMessageDialog(null, "Input Value for 1", "Enter Value...", JOptionPane.INFORMATION_MESSAGE);
	        	 }
	        	 if(textbox2.getText().equals(invalid)) {
	        		 JOptionPane.showMessageDialog(null, "Input Value for 2", "Enter Value...", JOptionPane.INFORMATION_MESSAGE);
	        	 }
	        	 if(textbox2.getText().equals(invalid) && textbox1.getText().equals(invalid)){
	        		 JOptionPane.showMessageDialog(null, "Input Value for 1 and 2", "Enter Value...", JOptionPane.INFORMATION_MESSAGE);
	        	 }
	        	 
	        	 strP = textbox1.getText();
	        	 
	        	 if(strP.contains(invalid)) {
	        		 JOptionPane.showMessageDialog(null, "Input Value for 1", "Enter Value...", JOptionPane.INFORMATION_MESSAGE);
	        	 }
	        	 else {
	        		 P = Double.parseDouble(strP); //I had to parse them because I want to use it as an integral value
	        	 }
	        	 
	        	 
	        	 strT = textbox2.getText();
	        	 
	        	 if(strT.contains(invalid)) {
	        		 JOptionPane.showMessageDialog(null, "Input Value for 1", "Enter Value...", JOptionPane.INFORMATION_MESSAGE);
	        	 }
	        	 else{
	        		 t = Double.parseDouble(strT);
	        	 }
	        	 
	        	 n = 12; //monthly compounded = 12, quarterly compounded = 4, half a year = 2, etc
	        	 
	        	 r = 0.05; //rate is 5%
	        	 
	        	 a = P * Math.pow((1 + (r/n)), (n*t)); // the formula
	        	 
	        	 /*
	        	  * I had to rewrite this because this kind of confused me.
	        	  * LMAO, but I finally got.
	        	  */
	        	 
	        	 NumberFormat nf = NumberFormat.getCurrencyInstance(); //formatting, the getCurrencyInstance does a perfect format to output dollar
	        	 JOptionPane.showMessageDialog(null,     "In " + t + " year/s, you will have " + nf.format(a), "Estimated value...", JOptionPane.INFORMATION_MESSAGE);
	             //BUILD OF showMessageDialog: position, string,                                                title of window,     information on the window or whatever!
	         }
	         });
		
		JScrollPane panelWithScroll = new JScrollPane(addOnMe); 
		//adding a scroll to the panel is getting easier! It is EASY :) 
		//literally just add the panel you want in the argument, done :D
		
		
		panelWithScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelWithScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//you can set the policy to show or not, there are many services
		
		
		window.getContentPane().add(panelWithScroll);
		//window.pack();  									– Packing will fit everything on the PANEL and will DISPLAY ALL!
		window.setSize(new Dimension( 450, 400 )); 		//  – So by having Size we can have preferred dimensions and not care if we show or not!
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}

}
