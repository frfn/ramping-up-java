package programmingTests;

//Using the Trick class to use example methods WITHOUT the construction of an object!!

public class TrickMain {
	
	public static void main(String[] args) {
		
		//Trick useMe = new Trick();
		//String strr = useMe.palindromeReversed("LOL");
		//System.out.println(strr);
		//three lines above is testing to see if I can use by creating object 
		// YOU CAN but call in a static way
		
		//Trick.tricking(); //OH SHIT. 
		
		//Trick.specificTrick("TDR");
		
		//System.out.print(whatTrick);
		
		//String isIt = Trick.palindrome("racecarr");
		//System.out.println();
		//System.out.println(isIt);
		
		System.out.println(Trick.palindromeReversed("racecar"));
		
		//for(int i = 1; i<=12; i++) {
			//for(int j = 1; j<=12; j++) {   
				//System.out.print(i*j + "\t");
			//}
			//System.out.println();
		//}
	}

}
