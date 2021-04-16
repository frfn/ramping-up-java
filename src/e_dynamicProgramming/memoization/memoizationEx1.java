package e_dynamicProgramming.memoization;

import java.util.Arrays;

public class memoizationEx1 {

    public static void main(String[] args) {
        int num = 6;
        int[] memo = new int[num+1]; // arrays will be init with alll 0s

        System.out.println(fibonacciMemoization(6, memo));
    }

    public static int fibonacciMemoization(int num, int[] memo) {
        int fibonacciValue;

        // base cases
        if (num <= 2) return num;
        if (memo[num] != 0) {
            return memo[num];
        }

        fibonacciValue = fibonacciMemoization(num - 1, memo) + fibonacciMemoization(num - 2, memo);
        memo[num] = fibonacciValue;
        System.out.println(Arrays.toString(memo));
        return fibonacciValue; // ** WHERE IS THE RETURNS GOING TO? practically it returns somewhere, but we don't use that value

    }

}
