package oneClassMain;

public class Stars {
	static int horizontal = 10;
	static int vertical = 10;
	public static void main(String[] args) {
		
		/*
		 * Making stars,
		 * 10 stars through column and row
		 */
		
		for(int i=0; i<=vertical; i++) {
			for(int j = i; j<=horizontal; j++) {
				//j=0 , 0<=10 , so print 10 stars!
				//j=1 , 1<=10 , so print  9 stars!
				//and keep going!
				System.out.print("*");
			}
			System.out.println();
		}//end of for block
		
		System.out.println();
		
		for(int i=0; i<=vertical; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
