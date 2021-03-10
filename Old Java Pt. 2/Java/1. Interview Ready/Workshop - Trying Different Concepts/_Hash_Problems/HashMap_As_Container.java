package _Hash_Problems;
import java.util.HashMap;import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Flexer
 * 
 *  Mark Reynolds question:
 *  
 *  Using a container to hold Perosn object:
 *  	- Can modify!
 *
 */

public class HashMap_As_Container {
	
	// Person object
	public static class Person {
		private String name;
		private int age;
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		// Use StringBuilder...!
		public String toString() {
			String str = "";
			str += "Name: " + this.name + "\nAge: " + this.age;
			return str;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
	
	// Main
	public static void main(String[] args) {
	
		// HashMap
		HashMap<String, Person> map = new HashMap<String, Person>();
		
		// Scanner
		Scanner scan = new Scanner(System.in);
		
		// Created some Person objects
		Person flex = new Person("Flexer", 23);		
		Person mark = new Person("Mark", 26);		
		Person melvin = new Person("Melvin", 25);		
		
		// Adding Person objects into map container (data structure)
		map.put("Flexer", flex);
		map.put("Mark", mark);
		map.put("Melvin", melvin);
		
//		for(String key : map.keySet()) {
//			System.out.println(key);
//		}
//		
//		for(Person value : map.values()) {
//			System.out.println(value);
//		}
		
		// Note: look at the way we print HashMap keys and values!
		for(Map.Entry<String, Person> entry : map.entrySet()) {
			
			// Can be one lined!
			System.out.println(entry.getKey() + "\n" + entry.getValue() + "\n");
			
//			String key = entry.getKey();
//		    Person value = entry.getValue();
//		    System.out.println(key + "\n" + value + "\n");
		   
		}
		
		System.out.println("Change name for or -1 to quit: ");
		
		// Change will be the KEY
		String change = scan.next();
		
		// if input is not -1, keep looping!
		while(!change.equals("-1")) {
			
			// if map contains the KEY, then do the code block, else print can't find key!
			if(map.containsKey(change)) {
				
				// Two lines that ask for new name!
				System.out.println("Change name to: ");
				String newChange = scan.next();
				
				// map.get(change) returns the person object!
//				Person person = map.get(change);
//				person.setName(newChange);
				
				// One lined
				map.get(change).setName(newChange);
				
				System.out.println("Success! Updated list... \n");
				
				for(Map.Entry<String, Person> entry : map.entrySet()) {
					System.out.println(entry.getKey() + "\n" + entry.getValue() + "\n");
				}
				
			}
			else {
				System.out.println("Can't find key...");
			}
			
			System.out.println("Change name for: ");
			change = scan.next();
			
		}
		
		System.out.println("Thanks! \n\n");
		
		for(Map.Entry<String, Person> entry : map.entrySet()) {
			String key = entry.getKey();
		    Person value = entry.getValue();
		    System.out.println(key + "\n" + value + "\n");
		   
		}
		scan.close();
	}
	
//	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//	
//		Person flex = new Person("Flexer", 23);		
//		Person mark = new Person("Mark", 26);		
//		Person melvin = new Person("Melvin", 25);		
//		
//		ArrayList<Person> list = new ArrayList<Person>();
//		
//		list.add(flex);
//		list.add(mark);
//		list.add(melvin);
//		
//		for(Person p: list) {
//			System.out.println(p);
//		}
//		
//		System.out.println("Change name of: ");
//		String name = scan.next();
//		
//		while(!name.equals("-1")) {
//			
//			for(Person p: list) {
//				if(p.getName().equals(name)) {
//					System.out.println("Change name to: ");
//					String newChange = scan.next();
//					
//					p.setName(newChange);
//					break;
//				}else {
//					System.out.println("Not in list...");
//				}
//			}
//			
//			System.out.println("Change name of: ");
//			name = scan.next();
//			
//		}
//		
//		for(Person p: list) {
//			System.out.println(p);
//		}
//		
//		
//		
//	}
	
}
