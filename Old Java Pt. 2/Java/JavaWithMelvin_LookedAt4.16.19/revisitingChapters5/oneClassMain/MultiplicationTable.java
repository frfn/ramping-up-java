package oneClassMain;

public class MultiplicationTable {
	
	private static int vertical = 12;
	private static int horizontal = 12;
	private static int multiple;
	
	
	public static void main(String[] args) {
		
		for(int i=1; i<=vertical; i++) {
			
			for(int j=1; j<=horizontal; j++) {
				
				multiple=i*j;
				
				System.out.print(multiple + "\t");
				
				
			}
			
			System.out.println();
			
		}
		
	}

}
