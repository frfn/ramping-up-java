package chapter5Exercises;

public class FivePoint22 {
	
	public static void main(String[] args) {
		
		String name = "Flexer Fadrigalan";
		char otherLetter;
		String newString = "";
		
		for(int i = 0; i < name.length(); i += 2) {
			
			otherLetter = name.charAt(i);
			
			newString = newString + otherLetter;
		}
		
		System.out.println(newString);
		
	}

}
