package h_leetCode_problems;

import java.util.Arrays;

public class x_twoSumII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 10, 11}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while(left <= right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[] {left, right};
            }

            else if(numbers[left] + numbers[right] < target) {
                left++;
            }

            else {
                right--;
            }
        }

        return new int[] {-1, -1};

    }

}
