package die;
/*
 * These are edits from previous examples
 * They WILL be fully documented and commented
 * for maximum understanding.
 */

public class Die {
	
	private int faceValue; //declaring a private variable
	private final int maxNum = 6;
	/*
	 * I was NOT going to declare maxNum,
	 * but something changed my mind, maybe the reason
	 * that it may be important?
	 */
	
	//----------------------------------
	
	/* Here, I am now making a constructor,
	   constructors WILL have the same name as
	   the class
	*/
	public Die() {
		
		//in the example we are given a "default" value.
		
		/*
		 * If Die is created it will have a
		 * faceValue of 1
		 */
		//faceValue = 1;
		roll();
	}
	
	//----------------------------------
	
	/*
	 * Creating a getter called roll(), a service
	 */
	
	public int roll() { //getter, since no void(setter)
		/*
		 * Right away, it is giving us an error
		 * It is asking that we shall return something
		 */
		
		faceValue=(int)(Math.random()*maxNum)+1;
		/*
		 * faceValue will receive new value from
		 * 1 through 6
		 * 
		 * Code explained:
		 * (int) – casting, used because Math.random()
		 * of type double
		 * (maxNum) = 6
		 * We are adding one at the end BECAUSE the range
		 * will start from 1
		 */
		
		/*
		 * when invoked, it will generate a random number
		 * from 1-6! return the new number!
		 */
		return faceValue; //returning the value faceValue
	}
	
	public void setFaceValue(int faceValue) {
		/*
		 * in the RollClassConstructor
		 * it was my first time meeting the
		 * "this" key word again and I wanted to
		 * practice it. I will do so again.
		 */
		
		/*
		 * manually sets the face value
		 */
		
		this.faceValue = faceValue;
		//in dark mode, it is colored differently!
		//you can see that they are different variables
		
	}
	
	public int getFaceValue() {
		return faceValue;
		/*
		 * Basic getter – returns the face value when called
		 */
	}
	
	public String toString() {
		/*
		 * I conducted multiple experiments on this
		 * and found out that this ACTUALLY has meaning.
		 * 
		 * toString is like a reserved word because it
		 * overrides some things and will actually
		 * PRINT values out
		 */
		String result = Integer.toString(faceValue);
		/*
		 * Parsing the integer to a string so
		 * I can return it and fulfill the 
		 * required String return.
		 */
		return result;
	}

}
