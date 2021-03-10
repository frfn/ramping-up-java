package chapter3;

public class TestStringsAreCool {
	
	public static void main(String[] coolThingsWithStrings) {
		
		//created a string object
		String nosebleed = "Hey, I will get a nosebleed if you keep talking in English!";
		
		//these will be string objects that will mutate our created string
		String mutation1, mutation2, mutation3, mutation4;
		
		System.out.println("Original string: " + nosebleed);
		System.out.println("Original string number count: " + nosebleed.length()); //.length will return the value and length of string in form of int
		
		mutation1 = nosebleed.concat(" So please, talk in my language!"); //adding on to String
		mutation2 = nosebleed.replace('e', 'o'); //replacing every 'e' in string to 'o'
		mutation3 = nosebleed.toUpperCase(); //uppercasing the whole String
		mutation4 = nosebleed.substring(5, 30); //starting at index 5, ending at index 30 from string
		
		System.out.println();
		
		System.out.println("Mutation 1: " + mutation1);
		System.out.println("Mutation 2: " + mutation2);
		System.out.println("Mutation 3: " + mutation3);
		System.out.println("Mutation 4: " + mutation4);
		System.out.println("Mutation 4 number count: " + mutation4.length());
		
		
	}

}
