package ExploreExceptions;

public class TryCatchFinally {
	
	public static void main(String[] args) {
		
		
		try {
			
		int num = 10/0;  // can't divide by zero
		
		}catch(ArithmeticException a) {
			
			System.out.println("Can't divide by zero");
			System.out.println(a.getMessage());
			a.printStackTrace();
			
		}finally {
			System.out.println("Exiting out...");
		}
		
		
	}
}
