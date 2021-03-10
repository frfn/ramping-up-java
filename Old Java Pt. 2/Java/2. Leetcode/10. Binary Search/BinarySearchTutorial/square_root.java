package BinarySearchTutorial;

public class square_root {
	
	public static void main(String[] args) {
		
		int sqrt = mySqrt2(25);
		
		System.out.println(sqrt);
	}
	
	public static int mySqrt2(int x) {
        long left = 0;
        long right = x - 1;
        
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int)mid;
                
            } else if (mid * mid < x) {
            	left = mid ;
            } else {
            	right = mid;
            }
        }
        
        if(right * right == x) {
        	return (int)right;
        }
        
        return (int)left;
    }
	
}
