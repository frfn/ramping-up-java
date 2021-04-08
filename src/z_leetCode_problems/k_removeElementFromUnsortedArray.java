package z_leetCode_problems;

public class k_removeElementFromUnsortedArray {

    // [ 2, 1, 2, 3, 4, 1, 2 ] | val = 2
    // [ 1, 3, 4, 1, 4, 1, 2 ]

    public static int removeElement(int[] nums, int value) {
        int pointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != value) {
                nums[pointer++] = nums[i];
            }

        }
        return pointer;
    }
}
