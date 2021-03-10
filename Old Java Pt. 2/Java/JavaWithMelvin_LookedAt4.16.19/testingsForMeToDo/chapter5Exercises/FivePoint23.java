package chapter5Exercises;

public class FivePoint23 {
	//power of 2
	
	public static void main(String[] args) {
		
		
		powersOfTwo();
		
		String yo = reverse("hello!");
		
		System.out.println(yo);
		
		boolean hello = evenlyDivisible(3, 0);
		
		System.out.println(hello);
		
	}
	
	public static void powersOfTwo() {
		
		double base = 2;
		double supscr = 10;
		
		int applied = (int)Math.pow(base, supscr);
		
		System.out.println(applied);
		
		
	}
	
	public static String reverse (String str) {
		
		String reverse = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		
		return reverse;
		
		
	}
	
	public static boolean evenlyDivisible(int a, int b) {
		
		if(a == 0 || b ==0) {
			System.out.println("Error. Dividing by 0");
			return false;
		}
		else {
		
		if(a % b == 0) {
			return true;
		}else 
			return false;
		
		}
		
	}

}
