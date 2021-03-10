package chapter4Exercises;
import java.util.Random;
import java.util.Scanner;

/*
 * Truth be told, this stumped me! This question had me thinking of logic, which is good.
 * 
 * It challenged me, it made me think! Do more like these!
 */

/*
 * Task:
 * 
 * Creating a method that accepts two integers
 * Parameter should signify range
 * Method should return a value in specified range
 * return 0 if first parameter is greater than second
 */

public class FourPointOne {
	
	public static void main(String[] randomNum) {
		
		Scanner object = new Scanner(System.in); //Creating scanner object 
		
		System.out.print("Enter the range of first number: ");	//user input
		int origin = object.nextInt();	
		
		System.out.print("Enter the range of second number: ");	//user input
		int bound = object.nextInt();
		
		//System.out.print("Number in between that range is: " + randomInRange(origin, bound));	//Printing as well as calling the method "randomInRange"
		boolean go = true;
		boolean stop = false;
		
		
		
		
		while(go) {
			
			int range = randomInRange(origin, bound);
			System.out.println(range);
			
			if(range == 15) {
				
				System.out.print("\n15");
				go = stop;
			}
		}
		
		object.close();
	}
	
	public static int randomInRange(int origin, int bound) {
		/*
		 * Method had to be static so I could call it in the "main" method
		 */
		
		/*Experimentation:
		 * 
		 * int 15,  int 40
		 * 
		 * range =  40  -  15  // = 25
		 * 
		 * int random = gen.next(range) + numx
		 * 
		 * 			  = gen.next(25) + 15 , since index is at 0, add 1!
		 * 				
		 * 			  = gen.next((25) + 1) + 15.
		 */
		
		Random generator = new Random(); //Random generator
	
		int range = bound - origin; //Getting the range
		
		if(range < 0) {
			System.out.println("First number is greater, error! Returning 0."); //Validator – if range is less than 0, return 0!
			
			return 0;
		}
		
		int randomNumInRange = generator.nextInt((range) + 1) + origin; //returning a number in range!
		
		/*
		 * the logic behind this is in the experimentation!
		 * Again, this stumped me, but I had an idea
		 * testingsForMeToDo --> chapterThree --> TestRandomGenerator
		 * that had the solution, I was rushing and overlooking things.
		 * 
		 * Reminder to self. 
		 * There are NO shortcuts in life, especially in coding! 
		 * Take it slow, experiment.
		 */
		
		return randomNumInRange;
		
	}

}
