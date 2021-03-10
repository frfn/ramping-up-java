package chapter4ReturnDoubleObjects;

public class DoubleObjects {
	
	private String Melvin;
	
	private String Flexer;
	
	public DoubleObjects(int num) {
		/*
		if(num == 1) {
			doWork();
		}
		
		If parameter in main is passed with 1, it will run the doWork() method, giving us value for Flexer and Melvin
		*/
		
		//doWork();
		
		
		/*
		 * You do not need to put anything in this constructor, no formal parameter needed, no body needed!
		 */
		
	}
	
	public void doWork() {
		/*
		 * If you are not going to return anything, just put void
		 */
		
		Melvin = "Hello, I'm Melvin!";
		
		Flexer = "Hello, I'm Flexer!";
		
	}
	
	public String getMelvin() {
		return Melvin;
	}
	
	public String getFlexer() {
		return Flexer;
	}
	
	public String toString() {
		return Flexer + " and " + Melvin;
	}
	
	public String returnBothWithValidation() {
		if(Flexer == null && Melvin == null) {
			return "Flexer and Melvin is null!";
			
		}else if(Flexer == null || Melvin == null) {
			return "Flexer or Melvin is null!";
			
		}else {
		return ("Two friends with a mission: " + Flexer + " and " + Melvin);
		
		}
	}

}
