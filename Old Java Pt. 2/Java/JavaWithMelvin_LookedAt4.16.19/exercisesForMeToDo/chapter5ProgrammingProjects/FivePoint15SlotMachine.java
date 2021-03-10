package chapter5ProgrammingProjects;
import java.util.Random;
public class FivePoint15SlotMachine {
	
	static int num, num2, num3;
	
	public static void main(String[] args) {
		
		Random gen = new Random();
		
		int count = 0;
		boolean end = false;
		boolean keepGoing = true;
		
		while(keepGoing) {
			
			num = gen.nextInt(9);
			num2 = gen.nextInt(9);
			num3 = gen.nextInt(9);
			
		System.out.println("Printing three different numbers: " + num + num2 + num3);
		
		if(num == num2) {
			if(num == num3) {
				System.out.println("All three numbers are the same!");
				keepGoing = end;
			}
		}
		else if(num == num2) {
			System.out.println("At least two numbers are the same!");
			//keepGoing = end;
		}
		else if(num2 == num3) {
			System.out.println("At least two numbers are the same!");
			//keepGoing = end;
		}
		else if(num == num3) {
			System.out.println("At least two numbers are the same!");
			//keepGoing = end;
		}
		else {
			System.out.println("They are not the same!");
		}
		
		count++;
		
	}
		System.out.println("It took " + count + " times to get three exact values. :)");
	}

}
