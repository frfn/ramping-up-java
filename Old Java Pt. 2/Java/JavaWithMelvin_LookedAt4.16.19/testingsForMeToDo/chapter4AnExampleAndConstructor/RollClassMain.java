package chapter4AnExampleAndConstructor;

public class RollClassMain {
	
	public static void main(String[] rollTest) {
		
		RollClassConstructor die;	//declared that die will be used as the object
		
		die = new RollClassConstructor();	//instantiating it with the class
		
		RollClassConstructor die2 = new RollClassConstructor();
		
		
		die.roll();
		die2.setFaceValue(6);
	
		System.out.println(die.toString());
		System.out.println(die2.getFaceValue());
		
		//.toString and .getFaceValue returns the same value, BUT different data type.
		//.toString can only be String related
		//.getFaceValue can be used Mathematically and used as a integral data type
		
		
		
		
		
		
	}

}
