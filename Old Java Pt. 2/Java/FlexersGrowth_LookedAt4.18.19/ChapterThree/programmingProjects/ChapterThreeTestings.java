package programmingProjects;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
public class ChapterThreeTestings {
	
	//---------
	// Enumeration Type:
	// enums are the creation of your own data type.
	// These are type safe because you will NEED to
	// use the values inside the created enums
	// 
	// Demonstration: 
	// Can be declared at global level!
	enum Feelings {happy, sad, mad, overjoyed};
	//---------
	
	public static void main(String[] testings) {
		
		FramesAndPanels();
		
	}
	
	public static void usingDecimalFormat() {
		//--------------------------
		// The Decimal Format: 
		//
		// Very useful for outputting results.
		// To use:
		// Import java.text.DecimalFormat;
		// Create an object by instantiating Decimal Format:
		// DecimalFormat fmt1 = new DecimalFormat("00.##");
		// 
		//--------------------------
		
		/* Testing some formats with the DecimalFormat package
		 * This will be very useful if I need to use it for time, etc.
		 */ 
		
		DecimalFormat fmt1 = new DecimalFormat("0.#");
		DecimalFormat fmt2 = new DecimalFormat("00.####");
		DecimalFormat fmt3 = new DecimalFormat("000.##");
		
		double pi = Math.PI;
		
		System.out.println(fmt1.format(pi));
		System.out.println(fmt2.format(pi));
		System.out.println(fmt3.format(pi));
		
	}
	
	public static void usingNumberFormat() {
		//--------------------------
		// The NumberFormat:
		// 
		// Beneficial for getting the percentage output/currency output
		// To use: 
		// import java.text.NumberFormat;
		// Create an object –
		// NumberFormat fmt = NumberFormat.getCurrencyInstance
		// Edit: I thought code was stupid, but it is actually smart,
		// Instead of creating a specific object, it is ALREADY made
		// such as the getCurrencyInstance
		//--------------------------
		
		/* Using the format is also beneficial, for percentages and bank applications
		 * getInstance and getNumberInstance output, pretty much the same thing
		 */
		
		NumberFormat fmt1 = NumberFormat.getInstance();
		NumberFormat fmt2 = NumberFormat.getNumberInstance();
		NumberFormat fmt3 = NumberFormat.getCurrencyInstance();
		NumberFormat fmt4 = NumberFormat.getPercentInstance();
		
		double testValue = 0.32532;
		
		System.out.println(fmt1.format(testValue));
		System.out.println(fmt2.format(testValue));
		System.out.println(fmt3.format(testValue));
		System.out.println(fmt4.format(testValue));
		
	}

	public static void randomGenerator() {
		
		//--------------------------
		// The Random Generator: 
		// 
		// Based on algorithms that will print out random number
		// To use:
		// import java.util.Random;
		// Random gen = new Random();
		// Instantiating an object...
		// int num;
		// num = gen.nextInt();
		// 
		// Below it is shown how it is used to get a number
		// a range!
		//--------------------------
		
		Random gen = new Random();
		
		int randomNumber;
		
		randomNumber= gen.nextInt(); //this gives out LITERALLY a RANDOM number
		System.out.println(randomNumber);
		
		randomNumber= gen.nextInt(10) - 50; //-50 to -41
		System.out.println(randomNumber);
		
		randomNumber= gen.nextInt(10); //0 to 9
		System.out.println(randomNumber);
		
		//-------------------------
		// While Loop Test: 
		//
		// I guess I did this just to see if I understood how while loop works!
		// Using the while loop and using 199 as the sentinal value
		// Works flawlessly! Also added a counter to see how much
		// Loops will be needed!!
		//-------------------------
		
		int count = 0;
		while(randomNumber != 199) {
		randomNumber= gen.nextInt(150) + 50; //50 to 199
		System.out.println(randomNumber);
		count++;
		}
		count--;
		System.out.println("Count: " + count);
		
	}
	
	public static void quadraticFormula() {
		
		//--------------------------
		// The Quadratic Formula: 
		// 
		// In the book, it shows the the quadratic formula
		// and how you get the roots and discriminant
		// by using the formula!
		//--------------------------
		
		Scanner scan = new Scanner(System.in);
		
		int a, b, c;
		double discriminant, root1, root2;
		
		System.out.println("The Quadratic Formula: ax^2 + bx + c");
		System.out.print("Enter the coefficient of a: ");
		a = scan.nextInt();
		
		System.out.print("Enter the coefficient of b: ");
		b = scan.nextInt();
		
		System.out.print("Enter the constant, c: ");
		c = scan.nextInt();
		
		discriminant = Math.pow(b, 2) - (4*a*c);
		root1 = ((-1 * b) + Math.sqrt(discriminant)) / (2*a);
		root2 = ((-1 * b) - Math.sqrt(discriminant)) / (2*a);
		
		System.out.println("Discriminant: " + discriminant);
		System.out.println("Root 1: " + root1);
		System.out.println("Root 2: " + root2);
		scan.close();
	}

	public static void enumTesting() {
		//---------------------------
		// Enumeration tests. I feel like these are good to learn
		// just to learn, I feel like I won't be using them anytime soon.
		//---------------------------
		Feelings myMood = Feelings.happy;
		System.out.println("My mood: " + myMood);
		System.out.println("Ordinal of Mood: " + myMood.ordinal());
		
	}
	
	public static void FramesAndPanels() {
		
		JFrame frame = new JFrame("FrameAndPanels"); //frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x to close
		
		ImageIcon NarutoSasuke = new ImageIcon("/Users/flexer/Documents/Anime Pictures/Naruto.jpg");
		//The image will not be in iCloud Drive, it will be in /Users/flexer...
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		
		
		JLabel image = new JLabel("Naruto And Sasuke", NarutoSasuke, SwingConstants.CENTER);
		image.setForeground(Color.WHITE);
		image.setVerticalAlignment(SwingConstants.BOTTOM);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(image);
		
		JScrollPane panelWithScroll = new JScrollPane(panel);
		panelWithScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelWithScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		frame.getContentPane().add(panelWithScroll);
		frame.setSize(735, 500); 
		frame.setLocationRelativeTo(null); //this is NEEDED to be under the setSize() or pack(), messes with the positioning because of the sizing
		frame.setVisible(true);
		
	}
	
}
