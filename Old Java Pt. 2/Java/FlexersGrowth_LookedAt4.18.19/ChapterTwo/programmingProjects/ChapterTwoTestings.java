//---------------------------
// In this test class, the goals were:
// 1. input multiple values in a single line
// 2. use arrays and get familiar with it
// 3. 'char' experiments
// 4. casting experiments 
//---------------------------

/* Test results:
 * 1. By using arrays and the scanner method, .hasNextInt(); it is possible!
 * 2. Using arrays and understanding how it works, such as the index and etc. (BASIC UNDERSTANDING)
 * 3. char will only take in ONE letter, digit, symbol, etc
 * 4. Casting such as (int), or (double), etc to narrow or widen data type
 * 
 */

package programmingProjects;
import java.util.Scanner;
public class ChapterTwoTestings {
	
	public static void main(String[] tests) {
		
			//Calling methods instead of one big code! 
		// More versatile like that so I can just call on the methods
		
		multipleInputs();
		
	}
	
	public static void multipleInputUsingArray() {
		
		Scanner scan = new Scanner(System.in); //scanner
		
		String[] arrayValues; //two arrays
		int[] intArray;
		
		System.out.print("Enter values: "); //read values from user
		String values = scan.nextLine();
		
		arrayValues = values.split("\\s+"); //each space, new token
		intArray = new int[arrayValues.length]; //size of intArray is size of array values
		
		for(int i = 0; i < arrayValues.length; i++) {
			intArray[i] = Integer.parseInt(arrayValues[i]); //adding values to array index
		}
		
		
		//enhanced for loop for Arrays
		for(int newArray: intArray) {
			System.out.print(newArray + " ");
		}
		
		
		System.out.println();
		System.out.println("---");
		System.out.println();
		
		
		//normal way to output values in Arrays
		for(int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		
		
		
		
	}
	
	public static void charTesting() {
		/*///////////////////////////
		 * Test: Char Eligibility
		 * In this test, I wanted to find out if I can use to digits/letters in a 'char' data type
		 * And the test shows that YOU CAN NOT do it, will give ERROR
		/ *////////////////////////////
		
		System.out.println();
		char six = '6';
		char zero = '0';
		//char sixty = '60'; gives ERROR, will only work with ONE character
		
		System.out.println(six+zero); 
		/*
		 * This will print out 102, this is the Unicode value being added together, 
		 * to print it out properly, program below is shown.
		 */
		System.out.print(six);
		System.out.print(zero);
	}
	
	public static void castingWithMultipleInputs() {
		//-------------------------
			// Test: Casting
				//-------------------------
				
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter values: ");
				
			scan.hasNextDouble();

			double a = scan.nextDouble();
			double b = scan.nextDouble();
				
			int lol = (int)a + (int)b;
				
			System.out.println(lol);
			System.out.println(a + ", " + b);
				/*
				 * This approach works, but may need more information from Satish/Online resource
				 */
	}
	
	public static void multipleInputs() {
		/*/////////////////////////// 
		 * Test: Multiple Inputs
		 * I want to see if I can input multiple values with one line!!
		 * Success!!
		 * OH MY GOODNESS. This is literally a breakthrough! OMG.
		/*////////////////////////////
		
		//EDIT. using array would be better.
		
		int[] Array = new int[5];
		//int one, two, three, four, five;
		
		//System.out.println();
		Scanner object = new Scanner(System.in);
		System.out.print("Inputing multiple values: ");
		//object.hasNextInt();
		
		/*
		int one = object.nextInt();
		int two = object.nextInt();
		int three = object.nextInt();
		int four = object.nextInt();
		int five = object.nextInt();
		*/
		
		for(int i = 0; i < Array.length; i++) {
			Array[i] = object.nextInt();
		}
		
	
		//one = Array[0]; 
		//two = Array[1];
		//three = Array[2];
		//four = Array[3];
		//five = Array[4];
		
		//System.out.println("Array: " + Array[5]);
	
		for(int newArray : Array) {
			System.out.print(newArray + " ");
		}
		
		//System.out.println("1: " + one + "\n2: " + two + "\n3: " + three + "\n4: " + four + "\n5: " + five);
		
		//int sum = one + two + three;
		//int sumTwice = sum + four + five;
		
		System.out.println();
		//System.out.println("Sum through 1-3: " + sum +"\nSum plus 4-5: " + sumTwice);
		
	}

}
