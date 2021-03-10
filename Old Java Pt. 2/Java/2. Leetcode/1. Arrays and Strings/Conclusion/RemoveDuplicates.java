package Conclusion;

import java.util.HashSet;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 2};
		
		int length = removeDuplicates(arr);
		
		for(int i = 0; i < length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	public static int removeDuplicates(int[] nums) {
		
		if(nums.length == 0) {
			return 0;
		}
		else if(nums.length == 1) { 
			return 1;
		}
        
		// 1, 1, 2
		
        int i = 0;
        
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
               
            }
        }

        return i+1;
        
    }

}
