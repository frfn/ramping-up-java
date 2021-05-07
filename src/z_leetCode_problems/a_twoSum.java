package z_leetCode_problems;

import java.util.Arrays;
import java.util.HashMap;

// Use HashMap
public class a_twoSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[] {1, 3, 5, 7}, 8);
        System.out.println(Arrays.toString(result));

    }

    /*
    Easy to understand explanation:

    Create a hashmap
    - Put the number value as the key
    - Put the index value as the value

    The reason you need the complement is because if you try to do nums[i] + map.containsKey(key) ...
    this will not work. How would you know the value? By subtracting from the target, we FIND that value.

    The reason for adding all the values in the map is to keep track of the index.

    You must do complement. See if complement is in the map. If it is, you found the pair.

     */

    public static int[] twoSum(int[] nums, int target) {
        // [1, 3, 5, 7] | target = 6 | return [0, 2]
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            // Important to keep track
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            // Important to note, add all of the numbers
            map.put(nums[i], i);


        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
