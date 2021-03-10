package chapter3ProgrammingProjects;

/*
 * "How my thought process went" experiment:
 * 		Detailed explanation of what goes on my mind
 */

/*
 * Write an application that reads (x, y) coordinates for two points, 
 * and calculate using Distance Formula
 * 
 */

/* Explanation starts now:
 * 
 * I looked at the book, pg 153 and understood the formula
 * 
 * distance = sqrt(((x2-x1)^2) + ((y2-y1)^2))
 */

import java.util.Scanner;	//1. importing the scanner from package


public class ThreePoint1 {
	
	//2. public static...
		public static void main(String[] distanceFormula) {	//3. gave argument the name distance formula
			
			//4. think of what variables that needs to be declared
			
			double x1, x2, y1, y2, distance;
			
			//5. Open to adding more variables if needed
			
			//6. Thinking about what the user will see, so I will make it user friendly
			
			System.out.println("Please enter the X and Y values to calculate the distance!");
			System.out.println("Start off with the first (x, y) coordinates...");
			System.out.print("x1 coordinate: ");
			
			//7. We need to create Scanner variable! I forgot to do it up top in the beginning
			
			Scanner object = new Scanner(System.in);
			
			x1 = object.nextDouble();	//8. giving the variables user input data!
			
			System.out.print("y1 coordinate: ");
			y1 = object.nextDouble();
			
			//9. Giving it a separator so it would look nice, I did this by imagining what it will look
			//	 like inside my head
			
			System.out.println("");
			System.out.println("Now enter the second (x, y) coordinates...");
			
			System.out.print("x2 coordinate: ");
			x2 = object.nextDouble();
			
			System.out.print("y2 coordinate: ");
			y2 = object.nextDouble();
			
			//10. Now the distance part, fitting all this in one line of code
			//	  Seemed daunting at first, but try and see how it goes!
			
			//11. I remembered to use Math class functions!
			//	  They are so useful
			
			//12. I was figuring out what goes in as I tackled the one line code!
			
			distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
			
			//13. This looks mathematically, and common sense-lly correct! :)
			
			System.out.println();
			System.out.println("The distance between the coordinate is: " + distance);
			
			//14. I thought it would be a nice touch to add the (x, y) format to both coordinates
			
			System.out.println("First X and Y coordinates: (" + x1 + ", " + y1 + ")");
			System.out.println("Second X and Y coordinates: (" + x2 + ", " + y2 + ")");
			
			//15. After seeing how the program ran, I gave it some additional white spaces to look clean
			
			//16. Calculated this as well on paper, this is accurate and correct
			
			//17. Congratulate myself!
			
			object.close();
			
			//18. Closing the scanner object
		}

}
