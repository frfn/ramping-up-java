package arrayTests;
import java.io.*;
public class PP1edit {
	
	/**
	 * --NOT MY CODE--
	 * 		- This is for learning
	 * 		- Note and take skills from here
	 */
	/*Question 6.23
	 =============

	 Design and implement an application that reads an arbitrary number of
	 integers that are in the range 0 to 50 inclusive and counts how many
	 occurences of each is entered.  After all input has been processed,
	 print all of the values (with the number of occurences) that were
	 entered one or more times.
	*/
	 // Question 6.23, page 246
	 // Read in integers between 0 and 50 and report how many
	 // of each number there were.
	 //
	 // Assumption: program stops reading numbers when an integer value
		//	             that is not in the range of 0 to 50 is entered.
	    // Main method to read the integers, store counts for each in an
	    // array, and to report how many of each number there was.
	
	
	
	    public static void main(java.lang.String[] args) throws IOException {

	    	//IOException is thrown because of DataInputStream, a type of Scanner
	    	
	       DataInputStream stdin = new DataInputStream (System.in);
	       final int MAXINT = 50;           // Largest integer considered
	       final int MININT = 0;            // Smallest integer considered

	       
	       /**
	        * Because index starts at 0
	        *  - Range is from 0–49
	        *  - Since increasing +1, it will be 0–50
	        */
	       int[] list = new int[10];  // Array has counters for each int
	       

	       
	       // Initialize all locations in the array to zero
	       
	       /**
	        * By default, the array is already filled with 0's
	        *  - This is initializing all values in the array to be 0.
	        *  - Very neat.
	        */
	       for (int i=0; i<list.length; i++) {  
	          list[i] = 0;
	       }   
	       
	       

	       // Prompt user to enter a list of integers
	       System.out.println ("Enter a list of integers between 0 and 50.");
	       System.out.println ("To stop, enter an integer not in this range.");

	       // Enter first integer value before loop
	       System.out.print ("Enter Integer: ");
	       int value = Integer.parseInt (stdin.readLine());

	       // As long as the integers entered are within the desired range,
	       // keep entering integers and increasing the appropriate index
	       // in the 'list' array.
	       while (value >= MININT && value <= MAXINT) {
	          list[value] = list[value] + 1;

	          // Enter next integer value
	          System.out.print ("Enter Integer: ");
	          value = Integer.parseInt (stdin.readLine());
	       }   
	       
	       // Print the summary.
	       System.out.println("\nHere are how many of each value was entered:");
	       for (int i=0; i<list.length; i++) {  
	          if (list[i] > 0)
	             System.out.println (i+": "+list[i]);
	       }   
	    }
	 }
