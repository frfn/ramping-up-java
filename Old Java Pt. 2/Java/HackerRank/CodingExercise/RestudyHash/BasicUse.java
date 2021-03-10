package RestudyHash;

import java.util.HashMap;
import java.util.Scanner;

public class BasicUse {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> data = new HashMap();
		
		data.put("Software Engineer", 150000);
		data.put("Food Engineer", 89000);
		data.put("Mechanical Engineer", 80000);
		data.put("QA", 65000);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Type role or \'quit\' to escape: ");
		String choice = scan.nextLine();
		
		while(!choice.equals("quit")) {
			
			Integer value = data.get(choice);
			
			if(value == null) {
				System.out.println("Position does not exist, or not typed correctly.");
			}
			else {
				System.out.println(choice + " makes " + value);
			}
			choice = scan.nextLine();
		}
		System.out.println("Thanks.");
	}

}
