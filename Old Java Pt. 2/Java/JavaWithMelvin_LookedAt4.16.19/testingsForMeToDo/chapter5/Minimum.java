package chapter5;
import java.util.Scanner;
public class Minimum {
public static void main(String[] args) {
	
	int num1, num2, num3;
	int min = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter three integers... ");
	num1 = scan.nextInt();
	num2 = scan.nextInt();
	num3 = scan.nextInt();
	
	if(num1 < num2) {
		if(num1 < num3) {
			min = num1;
		}
		else {
			min = num3;
		}
	}
	else {
		if(num2 < num3) {
			min = num2;
		}
		else {
			min = num3;
		}
	}
	
	System.out.println("Your minimum is: " + min);
	
}
}
