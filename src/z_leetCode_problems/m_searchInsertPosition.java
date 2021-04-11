package z_leetCode_problems;

public class m_searchInsertPosition {

    // returns the index of where the target SHOULD be in, example below will be two

    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        System.out.println(searchInsert(arr, 4));
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

    // binary search approach
    public static int binarySearchInsert(int[] nums, int target) {
        int left, right;
        left = 0; // start
        right = nums.length - 1; // end of array | off by one

        while (left <= right) {

            // 1 2 4 5 | target = 3
            int middle = (left + right) / 2; // 3 / 2 = 1.5 = index 1
            if(nums[middle] == target) { // index 1 == 2
                return middle;
            }
            else if(nums[middle] < target) {
                left = middle + 1; // left after middle + 1 == 2
            }
            else if(nums[middle] > target) {
                right = middle; // in this case, right shall not have '-1', it usually does
            }
        }
        return nums[left] < target ? left + 1 : left; // 4 < 3 ? (target[2]) + 1 : (target[2]);
    }

}
