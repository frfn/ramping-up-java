package g_hackerRank_problems.Algorithms.x_Easy_Algorithms;

/*

By far the hardest Easy Question that I completed

I had to whiteboard to find the solution
    - I needed a visualization
    - I came up with the algorithm by doing that

Lots of debugging, I did submit three times to see what cases were failing

...

if starting from 0, no need to subtract - 1 ( this is for index reasoning! )

if starting from n - last element of array, then subtract 1 ( n-1 for index reasoning )

This had to be in a sorted array for my algorithm to work

I want to start from a 0 to N


NOT NEEDED, it is accounted for with the last two statements
 if(c.length == 1) {
            int end = n - 1;
            int start = 0;

            maxDistance = Math.max(maxDistance, Math.abs(end - c[0]));
            maxDistance = Math.max(maxDistance, Math.abs(start - c[0]));

            return maxDistance;

        }

 */

import java.util.Arrays;

public class zzg_flatlandSpaceStations {

    public static void main(String[] args) {
        System.out.println(flatlandSpaceStations(95, new int[] {68, 81, 46, 54, 30,11, 19, 23, 22, 12, 38, 91, 48, 75, 26, 86, 29, 83, 62,}));
    }

    public static int flatlandSpaceStations(int n, int[] c) {
        if(n == c.length) return 0;

        int maxDistance = Integer.MIN_VALUE;

        Arrays.sort(c);

        for(int i = 1; i < c.length; i++) {
            int difference = Math.abs((c[i] - c[i-1]) / 2);
            maxDistance = Math.max(difference, maxDistance);
        }

        // this is for the gaps
        maxDistance = Math.max(maxDistance, (n-1) - c[c.length-1]);

        int start = 0;
        maxDistance = Math.max(maxDistance, Math.abs(start-c[0]));

        return maxDistance;
    }
}
