package chapter5Exercises;

public class FIvePoint20 {
	
	public static void main(String[] args) {
		
		String name = "Flexer Fadrigalan";
		int counter = 0;
		
		for(int i = 0; i < name.length(); i ++) {
			
			if(name.charAt(i) == 'a') {
				counter++;
			}
			
		}
		
		System.out.print(counter);
		
		
		
	}

}
