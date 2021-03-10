package Introduction_To_Array;

public class PlusOne {
	
	public static void main(String[] args) {
		
		int[] nums = {1, 9};
		
		int[] po = plusOne(nums);
		
		for(int val: po) {
			System.out.print(val + ", ");
		}
		
	}
	
	public static int[] plusOne(int[] digits) {
        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}

}
