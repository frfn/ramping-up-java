package RestudyHash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapYoutube {
	
	public static class Student {
		
		String birthday, lastName;
		
		public Student(String n, String l) {
			lastName = n; lastName = l;
		}

	

		
		
		
		
	}
	
	static Map<Student, String> loadingCache(){
		
		Student ns = new Student("012397", "Stanton");
		Student ff = new Student("061696", "Fadrigalan");
		Student cf = new Student("032094", "Fadrigalan");
		
		Map<Student, String> cache = new HashMap<>();
		cache.put(ns, "NS");
		cache.put(ff, "FF");
		cache.put(cf, "CF");
		
		return cache;
		
	}
	
	public static void main(String[] args) {
		
		Map<String, Integer> list = new HashMap<>();
		
		list.put("Flex", 1);
		list.put("Cole", 2);
		list.put("Cyro", 3);
		list.put("Jeje", 4);
		list.put("Will", 5);
		list.put("Hann", 6);
		
		for(String keys : list.keySet()) {
			System.out.println(keys);
		}
		
		Iterator<String> userItr = list.keySet().iterator();
		
		while(userItr.hasNext()) {
			System.out.println(userItr.next());
			
			//list.put("Nana", 7);		
			
			/**
			 * Above will throw -- concurrency issues
			 */
			
			System.gc();
			
			/**
			 * Strong reference VS Weak reference
			 * 
			 * - Weak: list.put(new Trick("TDR"), 5);  if you run .gc , it will become garbage collected
			 * - Strong: 
			 * 
			 * 		Trick newTrick = new Trick("TDR");
			 * 		list.put(newTrick, 5);	if you run .gc, it will NOT be garbage collected
			 * 
			 */
			
		}
		
	}

}
