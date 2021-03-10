package chapter5ProgrammingProjects;
import java.util.Scanner;
public class FivePoint7BottlesOfBeer {
	
	static String str1 = " bottles of beer on the wall";
	static String str2 = " bottles of beer";
	static String str3 = "If one of those bottles should happen to fall";
	static int bottlesOfBeer;
	static int totalBeers;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter how many bottles of beer you will drink!: ");
		bottlesOfBeer = scan.nextInt();
		
		//for(totalBeers = 100; totalBeers >= bottlesOfBeer; totalBeers-- ) {
		for(int totalBeers = 100; totalBeers > bottlesOfBeer; totalBeers--) {
		// ( int i = 100 ; i >= userInput ; i -- )
		// ( int i = 0; i < userInput; i ++ )
			
			System.out.println(totalBeers + str1);
			System.out.println(totalBeers + str2);
			System.out.println(str3);
			System.out.println((totalBeers - 1) + str1);
			System.out.println();
			
		}
		
	}

}
