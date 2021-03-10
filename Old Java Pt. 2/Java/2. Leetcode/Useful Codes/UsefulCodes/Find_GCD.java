package UsefulCodes;

public class Find_GCD {
	
	public static int gcd(int num, int num2) {
		return num2 > 0 ? gcd(num2, num % num2) : num;
	}

}

// 10, 45