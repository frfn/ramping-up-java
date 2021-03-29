package z_leetCode_problems;

import java.util.HashMap;

// Use HashMap
public class a_twoSum {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {

        // [1, 3, 5, 7] | target = 6 | return [0, 2]

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

}
