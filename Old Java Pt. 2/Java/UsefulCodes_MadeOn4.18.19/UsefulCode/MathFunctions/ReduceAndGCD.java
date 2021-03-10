package MathFunctions;

public class ReduceAndGCD {

	int numerator, denominator;
	
	public void reduce() {
		if(numerator != 0) {
			int common = gcd (numerator, denominator);
			
			numerator = numerator / common;
			denominator = denominator / common;
		}
		
	}
	public int gcd(int num1, int num2) {
		//this is NOT related to the numerator and denominator
		//well it is, but it is just finding the GCD of it
		
		while(num1 != num2) {
			if(num1 > num2) {
				num1 = num1 - num2;
			}else {
				num2 = num2 - num1;
			}
		}
		return num1;
	}
	
}


