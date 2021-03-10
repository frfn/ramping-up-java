package Alg;

public class aVeryBigSum {
	
	static int[] set = {10, 12, 54, 13, 623, 673};
	
	public static void main(String[] args) {
		
		int i = set.length;
		int sum = 0;
		
		while(i-- > 0) {
			sum+=set[i];
		}
		
		System.out.println(sum);
	}

}
