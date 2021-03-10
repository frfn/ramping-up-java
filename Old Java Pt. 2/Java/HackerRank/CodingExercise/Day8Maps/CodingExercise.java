package Day8Maps;

import java.util.HashMap;
import java.util.Scanner;

public class CodingExercise {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> phonebook = new HashMap<String, Integer>();
		
		int n = scan.nextInt();
		
		for(int i = 0; i < n; i++) {
			String name = scan.next();
			int phone = scan.nextInt();
			phonebook.put(name, phone);
		}
		
		while(scan.hasNext()) {
			String str = scan.next();
			/*
			 * if(phonebook.get(str) != null) { System.out.println(str + "=" +
			 * phonebook.get(str)); } else { System.out.println("Not found"); }
			 */
			
			Integer phone = phonebook.get(str);
			
			System.out.println( (phone != null) ? str + " = " + phone : "Not found" );
			
			
		}
		scan.close();
		
	}

}
