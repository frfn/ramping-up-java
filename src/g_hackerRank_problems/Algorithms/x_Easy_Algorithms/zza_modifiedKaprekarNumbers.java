package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class zza_modifiedKaprekarNumbers {

    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }

    public static void kaprekarNumbers(int p, int q) {
        /*
        p and q is the range inclusive, for(int i = p; i <= q; i++)

        num = 2

        Kaprekar =
        if you square it ... 2 x 2 = 4
        then you split it ... 4 / 2 = 2
        do we have the same value from where we started 2? Yes ... 2 == 2

        2 is a Kaprekar Number

         */

        // p is lower than q

        List<Long> list = new ArrayList<>();

        for(int i = p; i <= q; i++) {
            long squared = (long)Math.pow(i, 2); // 25
            String squaredNum = Long.toString(squared);
            int endIndex = squaredNum.length() / 2;

            String l, r;
            l = squaredNum.substring(0, endIndex);
            if(l.equals("")) l = "0";

            r = squaredNum.substring(endIndex);

            if(Integer.parseInt(l) + Integer.parseInt(r) == i) {
                list.add((long) i);
            }
        }

        if(list.size() == 0) {
            System.out.println("INVALID RANGE");
        }
        else {
            for(long num: list) System.out.print(num + " ");
        }

    }

}
