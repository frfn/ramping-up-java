package h_leetCode_problems;

public class o_maximumSubArray {

    /*

    Easy to understand

    1. first approach goes through each of the values and adds them up. Keeps track of the largest sum

    2. Kadane's approach: uses a runningSum variable, tests to see if the current value is bigger than current value + sum
        - current value + sum could have gone through some negative numbers and lessen the iterated value! that is why!

     */

    public static void main(String[] args) {
        System.out.println(kadanesMaxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    // O(n^2)
    public static int maxSubArray(int[] nums ){
        int largestSum = nums[0];

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;

            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                largestSum = Math.max(largestSum, sum);

            }
        }
        return largestSum;
    }

    // Kadane's
    public static int kadanesMaxSubArray(int[] nums){
        int largestSum = nums[0];
        int sum = 0;
        for (int currentValue : nums) {
            // if currentValue is bigger than currentValue PLUS sum ... then use that currentValue instead.
            sum = Math.max(currentValue, currentValue + sum);

            // is largestSum bigger than sum? if it is, then that will be the new largest sum.
            largestSum = Math.max(sum, largestSum);
        }
        return largestSum;
    }


}
