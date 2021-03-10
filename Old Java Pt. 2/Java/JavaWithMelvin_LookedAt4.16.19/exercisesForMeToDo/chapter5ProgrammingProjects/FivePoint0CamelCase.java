package chapter5ProgrammingProjects;
/*
 In this project, you will turn this String object Hello_all-friends --> helloAllFriends
 Understanding –
 The dash symbol ( - ) and underscore symbol ( _ ) should be replaced or canceled
 */
public class FivePoint0CamelCase {
	
	public static void main(String[] args) {
		
		
		String hello = "Hello_all-friends";
		
		String revisedHello = "";
		
		
		
		/*
		 I made this because thinking of how the string should be,
		 it will need to be revised, into a new one
		 */
		
			if(Character.isUpperCase(hello.charAt(0))) {
				char letter = Character.toLowerCase(hello.charAt(0));
				revisedHello = revisedHello + letter;
		}
			
			for(int i = 1; i <= hello.length() - 1; i++) {
				
				if(hello.charAt(i) == '-') {
					
					char letter = Character.toUpperCase(hello.charAt(i + 1)); //it will capitalize letter
					
					
					//Hello_all-friends
					//         ^ – skip the hyphen   
					
					
					revisedHello += letter; //In revisedHello, the hyphen is not registered
					
				
					i++; //skips to the next iteration skipping the letter 'f' so it doesnt get added to the new helloRevised
					
					//	string     = hello_world
					//    			       ^ = i + 1
					
					//revisedHello = helloW --> add on
					
					//AVOID ALL CONFUSION BY READING LINES
					//54 AND DOWN!!
					
					
				}
				else if(hello.charAt(i) == '_') {
					
					/**
					 * Here is the revision 
					 * edit: 4/16/19
					 */
					
					i++;
					char letter = Character.toUpperCase(hello.charAt(i));
					
					revisedHello += letter;
					
				
				}
				else {
					revisedHello = revisedHello + hello.charAt(i);
				}
				
				
			}
			
			System.out.print(revisedHello);
		
	}

}
