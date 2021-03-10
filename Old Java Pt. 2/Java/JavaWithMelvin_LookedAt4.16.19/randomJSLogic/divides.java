
public class divides {

	public static void main(String[] args) {
		
		
		System.out.println(divide(81,9));
		
		
		
	}
	
	public static int divide(int x, int y) {
		
		int quotient = 0;
		
		for(int i = x; i > 0; i =  i - y) {
			
			quotient++;
			
		}
		
		return quotient;
	}

}
