package arrayTests;
import java.util.Scanner;
public class PP3 {
	
	/**
	 * Not my code, using it to learn.
	 *  - Very interesting stuff.
	 *   - Please take notes!
	 */
	
	/**
	 * Just take in what you can
	 *  - Do not be pressured BECAUSE THIS IS NOT your code. :)
	 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int MAXRANGE = 10;
		final int RANGE = 10;
		
		int[] list = new int[MAXRANGE];
		
		
		
		/* index - value
		 * ------
		 * 0	 - 0
		 * 1     - 0
		 * 2   	 - 0
		 * 3 	 - 0
		 * 4 	 - 0
		 * 5 	 - 0
		 * 6 	 - 0
		 * 7 	 - 0
		 * 8 	 - 0
		 * 9 	 - 0
		 */
		
		//initializing all index values to be 0
		//by default it already is
		for(int i = 0; i < list.length; i++) {
			list[i] = 0;
		}
		
		System.out.print("Enter value from 1-100: ");
		int value = scan.nextInt();
		
		//While loop seems to be a better iterator for this kind of problem
		
		while(value >= 0 && value <= (MAXRANGE*RANGE)) { // ... && value <= 100)
			
			
			list[(value-1)/RANGE] = list[(value-1)/RANGE] + 1;
			
			/**
			 * Code above is so out of the box thinking
			 *  - I NEED THIS.
			 *  	- HOW IT WORKS:
			 *  		user inputs: 99
			 *  		99-1 / 10 =
			 *  		98 / 10 =
			 *  		= (INT) 9
			 *  
			 *  		At index 9, increase 0 to 1.
			 */
			
			
			
			System.out.print("Enter value from 1-100: ");
			value = scan.nextInt();
			
		}
		
		//7.4 edit!!
		for(int i = 0; i<list.length; i++) {
			list[i] /= 5;
			
			/**
			 * If user inputs 7 of the same values
			 *  - Increase 0 value at index ONLY by 1.
			 *  
			 *  - This code for mass data, if there were 1000 values inputed it will help 
			 *    in viewing purposes
			 */
		}
		
		for(int i = 0; i<list.length; i++) {
			System.out.print(i*RANGE+1 + "-" + (i+1)*RANGE + "\t|");
			
			for(int j = 0; j<list[i]; j++) {
				
					System.out.print("*");
				
			}
			
			System.out.println();
		}
		
		/*
		//printing out for test
		for(int i = 1; i < list.length; i++) {
			System.out.println(i + " : " + list[i]);
		}
		*/
		
		/*
Tutorial 6    Lecturer: Ken Jackson      Tutor: Andria Hunter
==========            Friday Tutorial Section: 980213 @1pm (MP102)
                     Tuesday Tutorial Section: 980224 @6pm (RW142)

CSC 108, Spring 1998                           Tutorial notes,  T6
==================================================================


NOTICE THAT THE DAY SECTION (FRIDAY) AND EVENING SECTION
(TUESDAY) WILL HAVE DIFFERENT TUTORIALS FOR TUTORIAL 6.

THERE ARE NO TUTORIALS DURING THE WEEK OF FEBRUARY 16TH
(READING WEEK).


Friday Afternoon Tutorial Topics:  (February 13)
--------------------------------
   - submit assignment 2
   - problems 6.23, 6.24, 6.26 (pages 246-247)
   - answer any questions

Tuesday Evening Tutorial Topics:  (February 24)
-------------------------------
   - submit assignment 2
   - midterm test


Question 6.23
=============

Design and implement an application that reads an arbitrary number of
integers that are in the range 0 to 50 inclusive and counts how many
occurences of each is entered.  After all input has been processed,
print all of the values (with the number of occurences) that were
entered one or more times.

// Question 6.23, page 246
// Read in integers between 0 and 50 and report how many
// of each number there were.
//
// Assumption: program stops reading numbers when an integer value
//            that is not in the range of 0 to 50 is entered.

import java.io.*;
public class q23 {

   // Main method to read the integers, store counts for each in an
   // array, and to report how many of each number there was.
   public static void main(java.lang.String[] args) throws IOException {

      DataInputStream stdin = new DataInputStream (System.in);
      final int MAXINT = 50;           // Largest integer considered
      final int MININT = 0;            // Smallest integer considered

      int[] list = new int[MAXINT+1];  // Array has counters for each int

      // Initialize all locations in the array to zero
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
            System.out.print (i+": "+list[i]);
      }   
   }
}

Sample Execution
----------------

Enter a list of integers between 0 and 50.
To stop, enter an integer not in this range.
Enter Integer: 23
Enter Integer: 18
Enter Integer: 23
Enter Integer: 42
Enter Integer: 18
Enter Integer: 23
Enter Integer: 5
Enter Integer: 50
Enter Integer: 50
Enter Integer: 0
Enter Integer: 0
Enter Integer: 0
Enter Integer: -40

Here are how many of each value was entered:
0: 3
5: 1
18: 2
23: 3
42: 1
50: 2

Question 6.24
=============

Modify the program in Problem 6.23 so that it works for
numbers in the range between -25 and 25.

// Question 6.24, page 246
// Read in integers between -25 and 25 and report how many
// of each number there were.
//
// Assumption: program stops reading numbers when an integer value
//            that is not in the range of -25 to 25 is entered.

import java.io.*;
public class q24 {

   // Main method to read the integers, store counts for each in an
   // array, and to report how many of each number there was.
   public static void main(java.lang.String[] args) throws IOException {

      DataInputStream stdin = new DataInputStream (System.in);
      final int MAXINT = 50;           // Largest integer considered
      final int MININT = 0;            // Smallest integer considered
      final int OFFSET = 25;           // offset from index zero

      int[] list = new int[MAXINT+1];  // Array has counters for each int

      // Initialize all locations in the array to zero
      for (int i=0; i<list.length; i++) {
         list[i] = 0;
      }

      // Prompt user to enter a list of integers
      System.out.println ("Enter a list of integers between -25 and 25.");
      System.out.println ("To stop, enter an integer not in this range.");

      // Enter first integer value before loop
      System.out.print ("Enter Integer: ");
      int value = Integer.parseInt (stdin.readLine());

      // As long as the integers entered are within the desired range,
      // keep entering integers and increasing the appropriate index
      // in the 'list' array.
      while (value >= (MININT-OFFSET) && value <= (MAXINT-OFFSET)) {
         list[value+OFFSET] = list[value+OFFSET] + 1;

         // Enter next integer value
         System.out.print ("Enter Integer: ");
         value = Integer.parseInt (stdin.readLine());
      }

      // Print the summary.
      System.out.println("\nHere are how many of each value was entered:");
      for (int i=0; i<list.length; i++) {
         if (list[i] > 0)
            System.out.println ( i-OFFSET +": "+list[i]);
      }
   }
}

Sample Execution
----------------

Enter a list of integers between -25 and 25.
To stop, enter an integer not in this range.
Enter Integer: -10
Enter Integer: 3
Enter Integer: -10
Enter Integer: 15
Enter Integer: 3
Enter Integer: -10
Enter Integer: -25
Enter Integer: -25
Enter Integer: 0
Enter Integer: 0
Enter Integer: 0
Enter Integer: 25
Enter Integer: 25
Enter Integer: 26

Here are how many of each value was entered:
-25: 2
-10: 3
0: 3
3: 2
15: 1
25: 2

Question 6.26
=============

Design and implement an application that creates a histogram,
which allows you to visually inspect the frequency distribution
of a set of values.  The program should read in an arbitrary
number of integers that are in the range 1 to 100 inclusive;
then produce a chart similar to the one below that indicates
how many input values fell in the range 1-10, 11-20, and so on.
Print one asterisk for each value entered.
        1 - 10   | *****
        11 - 20  | **
        21 - 30  | *******************
        31 - 40  | 
        41 - 50  | ***
        51 - 60  | ********
        61 - 70  | **
        71 - 80  | *****
        81 - 90  | ********
        91 - 100 | ***********

// Question 6.26, pages 246-247
// Read in integers between 1 and 100 and use a histogram to
// report how many numbers were in each range of 10.
//
// Assumption: program stops reading numbers when an integer value
//            that is not in the range of 1 to 100 is entered.

import java.io.*;
public class q26 {

   // Main method to read the integers, store counts for each in an
   // array, and to report how many of each number there was.
   public static void main(java.lang.String[] args) throws IOException {

      DataInputStream stdin = new DataInputStream (System.in);
      final int MAXRANGE = 10;        // Largest range (times 10)
      final int MINRANGE = 1;         // Smallest range
      final int RANGE    = 10;        // 10 values in each interval

      int[] list = new int[MAXRANGE]; // Array has counters for each range

      // Initialize all locations in the array to zero
      for (int i=0; i<list.length; i++) {
         list[i] = 0;
      }

      // Prompt user to enter a list of integers
      System.out.println ("Enter a list of integers between 1 and 100.");
      System.out.println ("To stop, enter an integer not in this range.");

      // Enter first integer value before loop
      System.out.print ("Enter Integer: ");
      int value = Integer.parseInt (stdin.readLine());

      // As long as the integers entered are within the desired range,
      // keep entering integers and increasing the appropriate histogram
      // range index in the 'list' array.
      while (value >= MINRANGE && value <= (MAXRANGE*RANGE)) {

         // Divide by range to determine which range to increment
         list[(value-1)/RANGE] = list[(value-1)/RANGE] + 1;

         // Enter next integer value
         System.out.print ("Enter Integer: ");
         value = Integer.parseInt (stdin.readLine());
      }

      // Print the histogram
      System.out.println ("\nHere is your histogram:");
      for (int i=0; i<list.length; i++) {
         // Print histogram labels
         System.out.print ("   " + (i*RANGE+1) + " - " + (i+1)*RANGE + "\t| ");

         // Print as many asterisks as the value in list[i]
         for (int j=0 ; j<list[i] ; j++) {
            System.out.print ("*");
         }
         System.out.println ();   // starts new histogram line
      }
   }
}

Sample Execution
----------------

Enter a list of integers between 1 and 100.
To stop, enter an integer not in this range.
Enter Integer: 1
Enter Integer: 2
Enter Integer: 3
Enter Integer: 4
Enter Integer: 5
Enter Integer: 6
Enter Integer: 7
Enter Integer: 8
Enter Integer: 9
Enter Integer: 10
Enter Integer: 11
Enter Integer: 40
Enter Integer: 41
Enter Integer: 75
Enter Integer: 75
Enter Integer: 75
Enter Integer: 75
Enter Integer: 75
Enter Integer: 82
Enter Integer: 83
Enter Integer: 84
Enter Integer: 85
Enter Integer: 86
Enter Integer: 90
Enter Integer: 90
Enter Integer: 90
Enter Integer: 99
Enter Integer: 100
Enter Integer: 101

Here is your histogram:
   1 - 10       | **********
   11 - 20      | *
   21 - 30      |
   31 - 40      | *
   41 - 50      | *
   51 - 60      |
   61 - 70      |
   71 - 80      | *****
   81 - 90      | ********
   91 - 100     | **
		 * 
		 * 
		 */
		
		
	}

}
