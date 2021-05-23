package g_hackerRank_problems.Easy;

import java.util.Arrays;

public class n_minimumAbsoluteDifference {

    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(new int[] {1, -3, 71, 68, 17}));

    }

    public static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr); // by sorting this array, we will tackle all possible values

        int minimum = Integer.MAX_VALUE;

        // -3, 1, 17, 68, 71

        for(int i = 0; i < arr.length - 1; i++) {
            minimum = Math.min(Math.abs(arr[i] - arr[i+1]), minimum);
        }

        return minimum;
    }

    public static int minimumAbsoluteDifferenceNonGreedy(int[] arr) {

        // works, but not greedy

        int minimum = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {

            for(int j = i + 1; j < arr.length; j++) {

                int absoluteCalculation = Math.abs(arr[j] - arr[i]);

                System.out.println(arr[i] + " " + arr[j] + " : " + absoluteCalculation);

                minimum = Math.min(absoluteCalculation, minimum);

            }

        }
        return minimum;

    }

}
