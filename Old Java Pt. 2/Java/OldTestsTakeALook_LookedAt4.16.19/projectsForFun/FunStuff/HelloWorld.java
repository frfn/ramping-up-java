package FunStuff;
import java.util.*;


public class HelloWorld {

	public static void main(String flex[]) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Hello World -- We will be inputing two numbers and suming them up. \n");
		
		System.out.print("Number 1: ");
		int num1 = in.nextInt();
		
		System.out.print("Number 2: ");
		int num2 = in.nextInt();
		
		System.out.print("Sum: " + add(num1, num2));
		
	}
	
	public static int add(int a, int b) {
		
		return a + b;
		
	}
	
}
