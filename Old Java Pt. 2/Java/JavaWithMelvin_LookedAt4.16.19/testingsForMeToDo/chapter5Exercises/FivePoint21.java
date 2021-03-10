package chapter5Exercises;
import java.util.Scanner;
public class FivePoint21 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		String str = scan.nextLine();
		
		String reverse = "";
		
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		
		System.out.println(str);
		System.out.println(reverse);
		
		
		
	}

}
