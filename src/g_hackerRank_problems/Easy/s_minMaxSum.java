package g_hackerRank_problems.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s_minMaxSum {

    // n log n
    public static void minMaxSumSort(List<Integer> arr) {

        long[] longArr = new long[arr.size()];
        int index = 0;
        for(long num: arr) {
            longArr[index++] = num;
        }

        long runningMinSum = 0;
        long runningMaxSum = 0;

        Arrays.sort(longArr);

        for(int i = 0; i < 4; i++) {
            runningMinSum += longArr[i];
        }

        for(int i = 1; i < 5; i++) {
            runningMaxSum += longArr[i];
        }

        System.out.println(runningMinSum + " " + runningMaxSum);
    }

    // n ^ 2
    public static void minMaxSum(List<Integer> arr) {

        // [9, 2, 1, 4, 8]
        // max = 9, 8, 4, 1
        // min = 2, 1, 4, 8

        long[] intArr = new long[arr.size()];
        int index = 0;
        for(long num: arr) {
            intArr[index++] = num;
        }

        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;

        long runningSum = 0;

        for(int i = 0; i < intArr.length; i++) {

            int indexToSkip = i;

            for(int j = 0; j < intArr.length; j++) {
                if(j == indexToSkip) continue;
                runningSum += intArr[j];
            }

            System.out.println("Index = " + i + " | Value = " + runningSum);

            maxSum = Math.max(maxSum, runningSum);
            minSum = Math.min(minSum, runningSum);

            runningSum = 0;

        }

        System.out.println(minSum); System.out.println(maxSum);

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        // 942381765 627450398 954173620 583762094 236817490
        arr.add(942381765);
        arr.add(627450398);
        arr.add(954173620);
        arr.add(583762094);
        arr.add(236817490);

        minMaxSumSort(arr);

    }

}
