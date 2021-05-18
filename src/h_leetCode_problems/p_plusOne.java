package h_leetCode_problems;

import java.util.Arrays;

public class p_plusOne {

    public static void main(String[] args) {
        // if 9, 9 should give 1, 0, 0
        // if 9, 4 should give 9, 5
        System.out.println(Arrays.toString(plusOne(new int[] {9,9})));
    }

    public static int[] plusOne(int[] digits) {
        if(digits.length == 0) throw new IllegalArgumentException();

        /*

        99 -> 00, -> you create the 100

         */

        for(int i = digits.length-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                // to terminate and return the array, this is the important part, must return else, all digits are 9's
                return digits;
            }
            digits[i] = 0;
        }

        // accounting that all the digits are 0's
        int[] sumOfTens = new int[digits.length + 1];
        sumOfTens[0] = 1;

        return sumOfTens;
    }

}
