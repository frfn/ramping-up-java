package _String_Problems;

/**
 * Given a string: 11373
 * Find how many times the, in order, the prime numbers
 * 11, 3, 73
 * 113, 7, 3
 * ... etc.
 */

//import java.util.ArrayList;

public class Incomplete_PrimeString {
	
	public static void main(String[] args) {

		int val = countPrimeString("3175");
		System.out.println(val);
	
	}
	
	public static int countPrimeString(String s) {
		
		int count = 0;
		
		StringBuilder build = new StringBuilder();

		char[] charArray = s.toCharArray();
		
		for(int i = 2; i < charArray.length; i++) {
			build.append(charArray[i]);
			int val = Integer.valueOf(build.toString());
			
			if(isPrime(val)) {
				count++;
				build.setLength(0);
			}
			
		}
		
		return count;
		
	}
	 
	public static boolean isPrime(int n){
        boolean isPrime = true;

        int i = 2;
        while(i <= n / 2){
            if(n % i == 0){
                isPrime = false;
                break;
            }
            i++;
        }

        return isPrime;
    }

}
