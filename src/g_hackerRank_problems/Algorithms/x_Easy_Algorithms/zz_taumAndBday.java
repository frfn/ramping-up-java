package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

public class zz_taumAndBday {

    public static void main(String[] args) {
        System.out.println(taumBday(3,6,9,1,1));
    }

    /*

    That was easy... I fucking didn't know what it was asking ...
    more so, i was using the wrong values, I was using B and W instead of bc and wc to calculate...

    b = 3
    w = 6

    ---
    these 3 are the more important ones, I was looking at the B and W thinking that they mean something more than quantity

    bc = 9
    wc = 1
    z = 1

    bc + z = 10 to
    9 + 1 = 10 ... 10 < 1? No 1 is min

    priceW = 1;

    wc + z = 2 to convert to black gift
     1 + 1 = 2 ... 2 < 9? Yes 2 is min

    priceB = 2;

      1 * 6 = 6
    + 2 * 3 = 6
      ---------
            12
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long priceB = Math.min(bc, wc + z); // conversion price
        long priceW = Math.min(wc, bc + z); // conversion price

        long totalB = priceB * b;
        long totalW = priceW * w;

        return totalB + totalW;

    }

}
