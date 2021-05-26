package h_leetCode_problems;

import java.util.HashSet;

public class k_removeElementFromUnsortedArray {

    public static void main(String[] args) {
        int[] arr = {2,3,4,1,2,3,4,1,2}; // 2,3,4,1
        int length = removeElement(arr, 1);
        System.out.println(length);

        int counter = 0;
        for(int num: arr) {
            if(counter == length) break;

            System.out.print(num + ", ");
            counter++;
        }

    }

    // remove one element
    public static int removeElement(int[] nums, int value) {
        int pointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != value) {
                nums[pointer++] = nums[i];
            }

        }
        return pointer;
    }

    // remove all dupes
    public static int removeDupesFromUnsortedArray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int pointer = 0;

        for(int i = 0; i < nums.length; i++) {
            // if set contains it... don't do anything, if set does NOT contain it do this! Same strategy as above.
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                nums[pointer++] = nums[i];
            }
        }

        return pointer;
    }

}
