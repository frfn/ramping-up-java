package programmingProjects;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
public class ChapterThreeProgrammingProjects {

	public static void main(String[] args) {
		
		distanceFormula();
		//surfaceVolumeAndArea();
		//heronsTriangle();
		//phoneNumber();
		//pictureStuffAndGUI();
		
	}
	
	public static void distanceFormula() {
		//---------------------
		// 3.1
		//
		// Distance Formula = sqRt ( (x2 - x1)^2 + (y2 - y1)^2 ) 
		// Write an application that will output the distance formula.
		//---------------------
		Scanner scan = new Scanner(System.in);
		DecimalFormat fmt = new DecimalFormat("0.##");
		
		System.out.println("The Distance Formula...");
		System.out.print("Press Enter to start or input \"quit\" anytime to quit: ");
		String userInput = scan.nextLine();
		
		/**
		 * When user enters "quit" in any form (qUIT , qUiT, Quit) it will still work
		 */
		while(!userInput.equalsIgnoreCase("quit")) {
			
			double x1, x2, y1, y2, distance;
			
			System.out.print("x2: ");
			userInput = scan.nextLine();
			while(userInput.matches("[a-zA-Z_]+")) { //this is the RegEx (regular expression – a pattern) 
													// so any letters, a through z and A through Z
												   /**
												    * VALIDATION: used for all the variables being taken in
												    */
				System.out.print("Input correct value for x2: ");
				userInput = scan.nextLine();
			}
			x2 = Double.parseDouble(userInput);
			
			System.out.print("x1: ");
			userInput = scan.nextLine();
			while(userInput.matches("[a-zA-Z_]+")) {
				System.out.print("Input correct value for x1: ");
				userInput = scan.nextLine();
			}
			x1 = Double.parseDouble(userInput);
						
			System.out.print("y2: ");
			userInput = scan.nextLine();
			while(userInput.matches("[a-zA-Z_]+")) {
				System.out.print("Input correct value for y2: ");
				userInput = scan.nextLine();
			}
			y2 = Double.parseDouble(userInput);
			
			System.out.print("y1: ");
			userInput = scan.nextLine();
			while(userInput.matches("[a-zA-Z_]+")) {
				System.out.print("Input correct value for y1: ");
				userInput = scan.nextLine();
			}
			y1 = Double.parseDouble(userInput);
			
			System.out.println("Values inputted... ");
			System.out.println("x1: " + x1);
			System.out.println("x2: " + x2);
			System.out.println("y1: " + y1);
			System.out.println("y2: " + y2);
			
			distance = Math.sqrt(Math.pow(x2-x1, 2) - Math.pow(y2-y1, 2));
			
			System.out.println("Distance calculated using values given: " + fmt.format(distance));
			
			System.out.print("Press Enter or \"quit\" to quit: ");
			userInput = scan.nextLine();
			
		}
		
		System.out.println("Thanks for using the program!");
		
	}
	
	public static void surfaceVolumeAndArea() {
		
		DecimalFormat fmt = new DecimalFormat("0.##");
		double volume, surfaceArea, userInput;
		Scanner input = new Scanner(System.in);
		final double fractionValue = 4/3d;
		
		System.out.print("Enter radius: ");
		userInput = input.nextDouble();
		
		volume = fractionValue * Math.PI * Math.pow(userInput, 3);
		surfaceArea = 4 * Math.PI * Math.pow(userInput, 2);
		
		System.out.println("Volume: "+fmt.format(volume));
		System.out.println("Surface Area: "+fmt.format(surfaceArea));
		
	}
	
	public static void heronsTriangle() {
		
		DecimalFormat fmt = new DecimalFormat("0.##");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Heron's Triangle...");
		
		double side1, side2, side3, perimeter, halfPerimeter, area;
		
		System.out.print("Side 1: ");
		side1 = scan.nextDouble();
		
		System.out.print("Side 2: ");
		side2 = scan.nextDouble();
		
		System.out.print("Side 3: ");
		side3 = scan.nextDouble();
		
		perimeter = side1+side2+side3;
		System.out.println("The perimeter of all three: "+perimeter);
		
		halfPerimeter = perimeter/2;
		
		area = Math.sqrt(halfPerimeter * (halfPerimeter-side1) * (halfPerimeter-side2) * (halfPerimeter-side3));
		System.out.println("Perimeter: " + fmt.format(perimeter) +"\nHalf Perimeter: " + fmt.format(halfPerimeter));
		System.out.println("The area using the Heron's Triangle Forumla: " + fmt.format(area));
		
	}
	
	public static void phoneNumber() {
		
		Random random = new Random();
		DecimalFormat fmt = new DecimalFormat("000");
		
		int num = random.nextInt(8);
		int num2 = random.nextInt(8);
		int num3 = random.nextInt(8);
		int num4 = random.nextInt(743);
		int num5 = random.nextInt(9999);
		
		System.out.println(num + "" + num2 + "" + num3 + "-" + fmt.format(num4) + "-" + fmt.format(num5));
		
	}
	
	public static void pictureStuffAndGUI() {
		
		JFrame frame = new JFrame("Section 3.5");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon himawari = new ImageIcon("/Users/flexer/Documents/Anime Pictures/himawari.png");
		//image.setSize(155, 457); DOES NOT WORK!
		/**
		 * Resizing an imageIcon
		 * It is an 
		 * easy task, a few 
		 * lines of code will 
		 * have to be implemented
		 */
		
		Image newHimawari = himawari.getImage();
		newHimawari = newHimawari.getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
		himawari = new ImageIcon(newHimawari);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.orange);
		
		//The label will always print out to the left
		JLabel imageLabel = new JLabel("This is Himawari", himawari, SwingConstants.CENTER); 
		//this .CENTER is needed solely for the purpose of placing the text
		// it is NOT for positioning
		
		imageLabel.setToolTipText("Naruto's Daughter"); //when hovering over the photo this TEXT will APPEAR
		
		/**
		 * Here it will have the necessary changes for the text to get on the bottom, top, and the left and their
		 * varieties
		 */
		
		//imageLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		//imageLabel.setHorizontalTextPosition(SwingConstants.LEFT);
	    //imageLabel.setVerticalTextPosition(SwingConstants.TOP);
		//imageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		imageLabel.setForeground(Color.WHITE);
	
		
		
		
		
		panel.add(imageLabel);
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
