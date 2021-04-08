package z_leetCode_problems;
public class i_removeDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDupes(new int[] {0,0,0,1,1,1,2,2}));
    }

    // compares current value and current value + 1 as it iterates

    // 0,0,0,1,1,1,2,2
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int length = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[length++] = nums[i];
            }
        }
        // the reason why the end of the array, "2", does not get added, is because in the for loop, we didn't do anything with it
        nums[length++] = nums[nums.length - 1]; // so we manually added it!
        return length;
    }

    // my code is more understandable, less hand wave-y!
    public static int removeDupes(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 0;

        // compares at index[length] and current value as it iterates
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[length]) {
                // prefix ++ = add 1 before execution
                // postfix ++ = add 1 after execution
                // in this case, length = length + 1 first, then nums[length] = nums[i]

                // if [length++], it would be nums[length] = nums[i], then length = length + 1!
                nums[++length] = nums[i];
            }
        }
        return length + 1;
    }
}
