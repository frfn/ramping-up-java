package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.*;

public class zzj_manasaAndStones {

    public static void main(String[] args) {
        for(int num : stones(4,100,10)) System.out.println(num);
    }

    public static List<Integer> stones(int n, int a, int b) {
        Set<Integer> container = new HashSet<>();

        for(int i=0; i<n; i++){
            int temp = (n-1-i)*a + i*b;
            /*
            i
            0   (3-1-0) == (2 * 1) == 2   +   (0*2) == 0        =   2
            1   (3-1-1) == (1 * 1) == 1   +   (1*2) == 2        =   3
            2   (3-1-2) == (0 * 1) == 0   +   (2*2) == 4        =   4
             */

            container.add(temp);
        }

        List<Integer> possibleValues = new ArrayList<>(container);
        Collections.sort(possibleValues);
        return possibleValues;

        /*

        a = 1, b = 2, n = 3

        1,1 - 0 1 2

        1,2 - 0 1 3

        2,1 - 0 2 3

        2,2 = 0 2 4






        ---

        a = 10, b = 100, n = 4



        10,10,10        - 0 10 20 30

        10,10,100       - 0 10 20 120

        10,100,10       - 0 10 110 120

        10,100,100      - 0 10 110 210



        100,10,10       - 0 100 110 120

        100,10,100      - 0 100 110 210

        100,100,10      - 100 200 210

        100,100,100     - 100 200 300




         */


    }

}
