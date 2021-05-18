package h_leetCode_problems;

public class m_searchInsertPosition {

    // returns the index of where the target SHOULD be in, example below will be two

    public static void main(String[] args) {
        int[] arr = {1,7,9};
        System.out.println(binarySearchInsert(arr, 6));
    }


    // we return the index in the array
    public static int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0; // base case, given to us
        int pointer = 0;
        for (int num : nums) {
            if (num < target) {
                pointer++;
            }
        }
        return pointer;
    }

    /*

    Easy to understand explanation

    1. Approach is Binary Search

    2. Left = 0 , Right = nums.length - 1 --> these numbers are important bc they are the indices

    3. we return middle because middle will be the index!

    4. we return left when we exit out of the while loop bc right is the indicator that we have broken the loop, it became greater than left value

     */

    // binary search approach
    public static int binarySearchInsert(int[] nums, int target) {
        int left, right;

        left = 0;
        right = nums.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;

            } else if (nums[middle] < target) {
                left = middle + 1;

            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return left;
    }

}
