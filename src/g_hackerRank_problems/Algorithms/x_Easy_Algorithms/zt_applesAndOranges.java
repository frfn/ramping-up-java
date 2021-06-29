package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

import java.util.ArrayList;
import java.util.List;

public class zt_applesAndOranges {

    public static void main(String[] args) {
        List<Integer> apples = new ArrayList<>();
        List<Integer> oranges = new ArrayList<>();

        apples.add(2); apples.add(3); apples.add(-4);
        oranges.add(3); oranges.add(-2); oranges.add(-4);

        countApplesAndOranges(7, 10,4,12, apples, oranges);
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        /*
        s: integer, starting point of Sam's house location.
        t: integer, ending location of Sam's house location.

        a: integer, location of the Apple tree.
        b: integer, location of the Orange tree.

        apples: integer array, distances at which each apple falls from the tree.
        oranges: integer array, distances at which each orange falls from the tree.
         */
        int applesInBound = 0, orangesInBound = 0;

        for(int appleDistance : apples) {
            int calculatedDistance = a + appleDistance;
            if(calculatedDistance >= s && calculatedDistance <= t) applesInBound++;
        }

        for(int orangeDistance : oranges) {
            int calculatedDistance = b + orangeDistance;
            if(calculatedDistance >= s && calculatedDistance <= t) orangesInBound++;
        }

        System.out.println(applesInBound);
        System.out.println(orangesInBound);

    }

}
