package Day10Binary;

import java.util.ArrayList;

public class CodingExercise {

	public static void main(String[] args) {
		binaryToDecimal(10110);  // will not work with 0110, it will produce different output because of 0 being in front
		decimalToBinary(65535);
	}
	
	public static void binaryToDecimal(int num) {
		
		int number = num;  // assigns the passed argument
		
		int total = 0;  // total will be the value that the conversion will go to
		
		int base = 1;  // base is 1 because 2^0 = 1
		
		int temp = number;  // assigns temp as passed argument
		
		while(temp > 0) {  // while temp is 0
			
			int lastDigit = temp % 10;  // this gives us the last digit.  For example, 1001 0110, it will give us 0
			
			temp = temp / 10;  // this line divides the binary 1001 0110 by 10, it will give us 1001 011 ... 1001 011 / 10 = 1001 01 .. and so on.
			
			// temp = temp / 10 : deducts the end because we're using INTS, and INTS reduce it properly
			
			total += lastDigit * base;  // if last digit is 1, then there will be value because (1 * base), if none, add none.
			
			base = base * 2; // as we move up... 1 , 2 , 4 , 8 , 16 , 32 , 64 , 128
			
			
		}

		System.out.println(total);
		
	}
	
	public static void decimalToBinary(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = num;
		while(n > 0) {
			int remainder = n % 2;
			n = n / 2;
			list.add(0, remainder);  // treating it like a queue
		}
		
		Object[] arr = list.toArray();
		///////////////////////////////////////
		int finalCount = 0;
		int counter = 0; 
		for(Object view : arr) {
			if(view.equals(1)) {
				counter++;	
				if(counter > finalCount) {
				finalCount = counter;
				}
			}
			else {
					counter = 0;
			}
		}
		//System.out.println(list);
		System.out.println(finalCount);
		
		
		// instead of list, skipping the user created list
		
		char[] binary = Integer.toBinaryString(num).toCharArray();  // the .toBinaryString is the list
		 int tmpCount = 0;
	        int maxCount = 0;
	        for(int i = 0; i < binary.length; i++){
	            tmpCount = (binary[i] == '0') ? 0 : tmpCount + 1; // tmpCount will = 0 if 0, if not, tmpCount + 1
	            if(tmpCount > maxCount){
	                maxCount = tmpCount;
	            }
	        }
		
		
	}
	
	
	

}
