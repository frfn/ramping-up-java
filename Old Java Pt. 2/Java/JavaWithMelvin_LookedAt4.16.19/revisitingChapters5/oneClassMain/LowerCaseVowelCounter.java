package oneClassMain;
import java.util.Scanner;
public class LowerCaseVowelCounter {
	
	private static Scanner scan = new Scanner(System.in);
	private static String str = "";
	private static int a = 0;
	private static int e = 0;
	private static int i = 0;
	private static int o = 0;
	private static int u = 0;
	
	public static void main(String[] args) {
		
		System.out.print("Hello, please input phrase and I will count the lower case vowels: ");
		str = scan.nextLine();
		
		for(int l=0; l<=str.length()-1; l++) {
			
			if(str.charAt(l) == 'a') {
				a++;
			}
			if(str.charAt(l) == 'e') {
				e++;
			}
			if(str.charAt(l) == 'i') {
				i++;
			}
			if(str.charAt(l) == 'o') {
				o++;
			}
			if(str.charAt(l) == 'u') {
				u++;
			}
		}
		
		System.out.println("Your phrase: " + str);
		System.out.println("a: " + a);
		System.out.println("e: " + e);
		System.out.println("i: " + i);
		System.out.println("o: " + o);
		System.out.println("u: " + u);
		
	}
}
