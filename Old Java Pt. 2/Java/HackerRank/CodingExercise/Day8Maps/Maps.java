package Day8Maps;

import java.util.HashMap;

public class Maps {
	
	public static void main(String[] args) {
		
		HashMap<String, String> dictionary = new HashMap<String, String>();
		
		dictionary.put("Monday", "Lunes");
		dictionary.put("Tueday", "Martes");
		dictionary.put("Wednesday", "Miercoles");
		dictionary.put("Thursday", "Jueves");
		dictionary.put("Friday", "Viernes");
		dictionary.put("Saturday", "Sabado");
		dictionary.put("Sunday", "Lingo");
		
		System.out.println(dictionary.get("Monday"));  // prints 'Lunes'
		
		String print = dictionary.get("Sunday");  // assigns print to the value of key 'Sunday'
		System.out.println(print);
		
		/**
		 * Notice: When printed, there is NO order. 
		 * 
		 * This is because of the 'hashing' method.
		 */
		
		System.out.println(dictionary);  // prints keys AND values
		
		System.out.println(dictionary.keySet());  // prints the keys
		
		System.out.println(dictionary.values());  // prints the values
		
	}

}
