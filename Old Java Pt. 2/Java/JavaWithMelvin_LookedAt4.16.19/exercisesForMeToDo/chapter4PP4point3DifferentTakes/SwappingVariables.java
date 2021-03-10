package chapter4PP4point3DifferentTakes;

/*
 * 
 * A lesson in swapping variables
 * 
 */

public class SwappingVariables {
	
	static int a = 5, b = 10;
	static int temp;
	///////////////////////////////////////////
	// Goal here is to swap variables		 //
	// You will need three variables to do   //
	// One being a temporary holder			 //
	///////////////////////////////////////////
	
	public static void main(String[] args) {
		
		System.out.println(a + " : " + b);
		
		temp = a; // putting 'a' value in 'temp' !
		
		a = b;	  // since 'a' is now in 'temp' we can go ahead and overwrite value for 'a'
		
		b = temp; // 'b' now has the value of 'a'
		
				  // 'temp' is now the new 'a' !
		
		/*
		 * looking at this code is confusing
		 * BUT overcome this
		 */
		
		System.out.println(a + " : " + b);
		
		System.out.println();
		
		
		swap(a, b);
		
		
	}
	
	public static void swap(int a, int b) {

	int temp;
	
	temp = a;
	
	a = b;
	
	b = temp;
		
	System.out.println("A variable: " + a);
	System.out.println("B variable: " + b);
		
	}

}
