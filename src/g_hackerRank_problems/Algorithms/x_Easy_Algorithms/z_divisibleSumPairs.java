package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class z_divisibleSumPairs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        // 1, 3, 2, 6, 1, 2
        for(int i = 0; i < 100; i++) {
            list.add(scan.nextInt());
        }

        System.out.println(divisibleSumPairs(100, 22, list));
    }


    /*

    Jot down mistakes:

    - the mistake in my approach was that ar.get(j) was modding k, ... so I put in parethesis and it worked.
    - the other was the i < j, not ar.get(i) < ar.get(j)!!
    - the approach was right, it was the syntax

     */
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        if(n == 0 || n == 1) return 0;

        int count = 0;

        for(int i = 0; i < ar.size(); i++) {
            for(int j = 0; j < ar.size(); j++) {

                if(i == j) continue;


                if (((ar.get(i) + ar.get(j)) % k == 0) && i < j)  {
                    count++;
                }
            }
        }
        return count;

    }
}
