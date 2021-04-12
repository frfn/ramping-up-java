package z_leetCode_problems;

public class o_maximumSubArray {

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
