package rationalNumber;

public class RationalMain {
	
	public static void main(String[] args) {
	
		RationalNumber r1 = new RationalNumber(2, 4);
		RationalNumber r2 = new RationalNumber(2, 9);
		
		RationalNumber r3, r4, r5, r6, r7;
		
		//System.out.println(r1);
		//System.out.println(r2);
		
		r3 = r1.reciprocal(); //returning an Object back, will have to use RationalNumber object (r3)
		
		System.out.println(r3);
		
		
		
	}

}
