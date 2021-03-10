package chapter4AnExampleAndConstructor;

public class RollClassConstructor {
	
	private final int maxNum = 6;
	
	private int faceValue;
	
	//-------------------------------------------------------------------------------
	//Constructor
	//-------------------------------------------------------------------------------
	
	public RollClassConstructor() {	
	/*
	 * Side note, if I were to put RollClass(String argument),
	 * when I call for the service, it will ask for the string as an argumemt	
	 */
		
		faceValue = 1;	//the value of the dice when not rolled, 1
		
	}
	
	//-------------------------------------------------------------------------------
	//Rolls the dice and returns the value
	//-------------------------------------------------------------------------------
	
	public int roll() {
		
		faceValue = (int)(Math.random() * maxNum) + 1;
		/*
		 * This has the " + 1" because it is similar to the Random generator
		 * (because it is part of Random) 
		 * Usually it is instantiated as follows:
		 * 
		 * 		Random gen = new Random();
		 * 		int a;
		 * 		a = gen.nextInt(8);
		 * 			**this will print 0-7,
		 * 			  to print 1-8, add one
		 * 			  a = gen.nextInt(8) + 1;
		 * 
		 * the code above is similar
		 * 1. (int) the value when Math.random() is called, returns an "int" value
		 * 	  so we need to type cast, or cast, incompatible if double to int
		 * 
		 * 2. (Math.random() * maxNum) by instantiating this, this will give the random 
		 *    generator a value, so since maxNum is 6, the generator will be 0-5
		 *    
		 * 3.  "  + 1 " so that the range will be from 1-6
		 */
		
		
		
		return faceValue;
		
	}
	
	//-------------------------------------------------------------------------------
	//Setting the value manually, value mutator
	//-------------------------------------------------------------------------------
	
	public void setFaceValue(int faceValue) {
		
		//faceValue = faceValue; //if you uncomment this, it will say that this code is pretty much useless as it is redundant!
		
		this.faceValue = faceValue; //by having the reserved word "this", it qualifies that the faceValue global variable will equal the argument
		
		/*
		 * I was confused about what the reserved word, "this" means
		 * "this" refers to the variable in the class
		 * (int faceValue) is just an argument and not really a variable
		 */
		
	}
	
	//-------------------------------------------------------------------------------
	//Accessing the faceValue value
	//-------------------------------------------------------------------------------
	
	public int getFaceValue() {
		
		return faceValue;	//method name getFaceValue, this service returns the value of faceValue
		
	}
	
	//-------------------------------------------------------------------------------
	//Returning a string representation of faceValue
	//-------------------------------------------------------------------------------
	
	public String toString() {
		
		String result = Integer.toString(faceValue);	//Integer.toString(); straightforward, turning the integer to a String
		
		return result; //returns the String, hence the String data type
		
	}

}
