package programmingProjects;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Chapter5ProgrammingProjects {
	
	static Scanner scan;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//multiple();
		palindrome1();
		//palindrome2();
		//minAndMax();
		//readFile();
		//stars();
		//ternaryOperator();
		compareTextFiles();
	}

	public static void multiple() {
		scan = new Scanner(System.in);
		int integer;
		int limit;
		final int divider = 5;
		int count = 0;
		System.out.print("Enter integer value – will out put multiples: ");
		integer = scan.nextInt();
		System.out.print("Print up to: ");
		limit = scan.nextInt();
		for(int i=integer; i<=limit; i+=integer) {
			System.out.print(i + "\t");
			count++;
			if(count%divider==0) {
				System.out.println();
			}
		}
	}
	
	public static void palindrome1() {
		scan = new Scanner(System.in);
		String str;
		System.out.print("Enter possible palindrome: ");
		str = scan.nextLine();
		
		String reverse = "";
		
		for(int i=str.length()-1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		
		System.out.println(reverse);
		System.out.println(str);
		
		if(str.equalsIgnoreCase(reverse)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not palindrome");
		}
		
	}
	
	public static void palindrome2() {
		
		String str;
		int leftIndex, rightIndex;
		scan = new Scanner(System.in);
		System.out.println("Enter possible palindrome: ");
		str = scan.nextLine();
		leftIndex = 0;
		rightIndex = str.length() - 1; //bounding issues arise
		while(str.charAt(leftIndex) == str.charAt(rightIndex)
				&& leftIndex <= rightIndex) {
			//&& is there so that there will be NO index out of range
			//hello
			//r a c e c a r
			leftIndex++;
			rightIndex--;
		}
		if(leftIndex < rightIndex) {
			System.out.println("Not palindrome");
		}else {
			System.out.println("Palindrome");
		}
	}
	
	public static void minAndMax() {
		
		scan = new Scanner(System.in);
		
		System.out.println("Enter 5 numbers, will find min and max...");
		
		int number = scan.nextInt();
		int max = number;
		int min = number;
		
		
		for(int i = 0; i<=3; i++) {
			number = scan.nextInt();
			//replaces the variable values of max and min!!
			
			/**
			 * Though it is initialzied with the same value as number,
			 * THEY ARE ONLY PLACE HOLDERS 
			 * and they can change with this if statements!
			 */
			if(number > max) {
				max = number;
			}
			if(number < min) {
				min = number;
			}
		}
		
		System.out.println("Max: " + max + "\nMin: " + min);
		
		
		
	}
	
	public static void readFile() throws FileNotFoundException {
		String str;
		File file = new File("ChapterFive/readme");
		scan = new Scanner(file);
		while(scan.hasNext()) {
			str = scan.nextLine();
			Scanner scanStr = new Scanner(str);
			scanStr.useDelimiter("oracle");
			while(scanStr.hasNext()) {
				System.out.print(scanStr.next());
				System.out.println();
			}	
		}
	}
	
	public static void stars() {
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public static void ternaryOperator() {
		
		int max = 10;
		int possibleMax = 2;
		
		int newMax = (possibleMax > max) ? possibleMax=max : possibleMax*2;
		
		System.out.println(newMax);
		
		
		int test = 10;
		int tesT = 0;
		
		int Test = (tesT > test) ? test - 10 : test + 10;
		
		System.out.println(Test);
		
	}
	
	public static void compareTextFiles() throws FileNotFoundException {
		
		String str="", str2="";
		File file1 = new File("ChapterFive/readme");
		File file2 = new File("ChapterFive/testMe");
		Scanner scan2;
	
		scan = new Scanner(file1);
		scan2 = new Scanner(file2);
		int count = 0;
		
		while(scan.hasNext() && scan2.hasNext()) {
			
			count++;
			
			str = scan.nextLine();
			//System.out.println(str);
			
			str2 = scan2.nextLine();
			//System.out.println(str2);
			
			//if(str.equals(str2)) {
			//	System.out.println("File is equal.");
			//}
			//else 
				
				if(!str.equals(str2)){
				System.out.println("Line "+count+" is different: "+ str + "--" + str2);
				}
			//}
			//else {
			//	System.out.println("Error");
			//}
		}
		scan2.close();
		
	}
	
}
