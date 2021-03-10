package chapter4AnExampleAndConstructor;
import java.util.Scanner;
public class InstantiatingObjects {
	public static void main(String[] objects) {
		
		Scanner scan; //= new Scanner(System.in);
		
		scan = new Scanner(System.in);
		
		int a;
		
		a = scan.nextInt();
		
		//that is giving us error because we have not initialized "scan" object
		//all we did is declare it
		
	}
}
