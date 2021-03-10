package CatchingExceptionsAtDifferentLevels;

public class ExceptionScope {
	
public static void main(String[] args) {
		runningTheMethods();
	}
	
	public static void runningTheMethods() {
		try {
			System.out.println("Calling willProduceError Method...");
			willProduceError();
		}catch(ArithmeticException e){
			System.out.print("The error is: " + e.getMessage());
			System.out.println();
			System.out.println("The stack trace: ");
			System.out.println("----------------");
			e.printStackTrace();			
		}
		System.out.println();
		System.out.println("runningTheMethod has ended...");  // THIS WILL PRINT BECAUSE this is where the exception was caught
	}
	
	public static void willProduceError() {
		System.out.println("willProduceError Method beginning...");
		//try {
		imTheError();
	//	} catch(ArithmeticException a) {
		//	System.out.print("The error is: " + a.getMessage());
		//	System.out.println();
		//}
		System.out.println("Method wPE is done...");  // THIS WILL NOT PRINT.
	}
	
	public static void imTheError() {
		System.out.println("imTheError Method beginning...");
		int zero = 1/0;
		System.out.println(zero);
		System.out.println("Method iTE is done...");  // THIS WILL NOT PRINT, if it was caught here, it will print "Method iTE is done" then "Method wPE is done"
	}
	
}
