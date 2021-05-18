package h_leetCode_problems;
public class i_removeDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDupes(new int[] {0,0,0,1,1,1,2,2}));
    }

    // compares current value and current value + 1 as it iterates

    // 0,0,0,1,1,1,2,2
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int length = 0;

        /*

        Easy to understand explanation

        1. iterate and have nums.length - 1
            - off by one since you want to compare with i+1

        2. here you compare the numbers next to each other, if they arent the same
            - at current value, that becomes the value at nums[length++] = nums[i]



         */

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[length++] = nums[i];
            }
        }
        // the reason why the end of the array, "2", does not get added, is because in the for loop, we didn't do anything with it
        nums[length++] = nums[nums.length - 1]; // so we manually added it!
        return length;
    }

    // further investigation, they both iterate as they go, practically the same code, this one starts at index 0 first
    public static int removeDupes(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 0;

        /*

        Easy to understand explanation

        1. start at index 1

        2. iterate with for loop
            - here you compare value at nums[i] and at nums[length]

        3. if they are not the same, nums[++length] = nums[i]
            - this bit is important because it increases from the 0, so at index 1, should be 1.

        4. Snazzy.

         */

        // compares at index[length] and current value as it iterates
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[length]) {
                // prefix ++ = add 1 before execution
                // postfix ++ = add 1 after execution
                // in this case, length = length + 1 first, then nums[length] = nums[i]

                // if [length++], it would be nums[length] = nums[i], then length = length + 1!
                nums[++length] = nums[i];

                // 3 3 4 5 6 6 7 7 7 8
                // 3 4 5 6 7 8 7 7 7 8
                // l = 0
                // i = 1
            }
        }
        return length + 1;
    }
}
