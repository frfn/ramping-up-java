package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.text.DecimalFormat;

public class q_plusMinus {

    public static void main(String[] args) {
        printRatios(new int[] {-4, 3, -9, 0, 4, 1});
    }

    /*

    New relearn DecimalFormat!

     */

    public static void printRatios(int[] nums) {
        float zeros = 0, pos = 0, neg = 0;

        for(int num : nums) {
            if(num == 0) zeros++;
            else if(num > 0) pos++;
            else neg++;
        }

        DecimalFormat df = new DecimalFormat(".000000");

        System.out.println(df.format(pos / nums.length));
        System.out.println(df.format(neg / nums.length));
        System.out.println(df.format(zeros / nums.length));
    }

}
